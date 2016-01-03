package ui.page;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;

import blservice.reviewblservice.ConstantBLService;
import blservice.reviewblservice.LogBLService;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import vo.ConstantVO;

public class PriceConstantView extends JPanel {
	private static final long serialVersionUID = 1L;
	private DefaultTableModel logModel;
	private JTable logTable;
	private ConstantBLService bl;
	private ArrayList<ConstantVO> voList;
	private ArrayList<ConstantVO> voUpdateList;

	public PriceConstantView(ConstantBLService bl) {
		this.setName("价格调整");

		this.bl = bl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		voList = new ArrayList<ConstantVO>();
		voUpdateList = new ArrayList<ConstantVO>();

		// 初始化账号列表界面
		initWareListTable();
		initInfField();
		this.validate();
	}

	private void initWareListTable() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();

		// 表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("常量名");
		vColumns.add("价格");

		Vector<ConstantVO> vData = new Vector<ConstantVO>();
		// //模型
		logModel = new DefaultTableModel(vData, vColumns);
		// //表格
		logTable = new JTable(logModel) {
			private int myRow = -1;
			TableCellEditor myEditor;
			private static final long serialVersionUID = 1L;

			// //设置第一行第一列不可编辑
			public boolean isCellEditable(int row, int column) {
				if (column == 0)
					return false;
				else
					return true;
			}
		};

		JTableHeader tableH = logTable.getTableHeader();

		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		logTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		logTable.setShowVerticalLines(false);
		logTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(logTable);
		logTable.setFillsViewportHeight(true);
		this.add(scrollPane);
		voList = bl.findAllPriceConstant();
		for (int i = 0; i < voList.size(); i++) {
			ConstantVO vo = voList.get(i);
			logModel.addRow(vo);
		}
	}

	private void initInfField() {
		// TODO Auto-generated method stub
		JPanel infField = new JPanel();
		voUpdateList.clear();
		XButton submitButton = new XButton("保存修改");
		submitButton.addActionListener(new ActionListener() {
			// //修改选中表格的数据
			public void actionPerformed(ActionEvent e) {
				int col = logModel.getColumnCount();
				int row = logModel.getRowCount();
				for (int i = 0; i < row; i++) {
					ConstantVO vo = null;
					String[] inf = new String[2];
					for (int j = 0; j < col; j++) {
						inf[j] = (String) logModel.getValueAt(i, j);
					}
					vo = new ConstantVO(inf[0], Double.parseDouble(inf[1]));
					voUpdateList.add(vo);
				}

				boolean result = bl.addPriceConstant(voUpdateList);
				if (result == true) {
					JOptionPane.showMessageDialog(null, "修改成功！", "", JOptionPane.INFORMATION_MESSAGE);
					LogBLService.insert(TimePO.getNowTimePO(),
							bl.getPo().getPermission().toString() + bl.getPo().getUsername() + "修改了价格常量");
				} else {
					JOptionPane.showMessageDialog(null, "修改失败！", "", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		infField.setLayout(new FlowLayout(FlowLayout.RIGHT));
		infField.add(submitButton);
		this.add(infField);
	}
}
