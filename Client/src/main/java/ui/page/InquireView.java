package ui.page;

import java.awt.Dimension;
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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import blservice.inquireblservice.InquireBLService;
import blservice.reviewblservice.LogBLService;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import vo.LoadingVO;
import vo.TransVO;

public class InquireView extends JPanel {
	private JTextField idField;// 订单条形码号
	private DefaultTableModel inquireModel;
	private JTable inquireTable;

	private InquireBLService bl;
	private String id;
	private ArrayList<TransVO> voList;

	public InquireView(InquireBLService bl) {
		this.setName("物流查询");

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.bl = bl;
		voList = new ArrayList<TransVO>();
		initIdInputField();
		initListTable();

	}

	private void initListTable() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("条形码");
		vColumns.add("时间");
		vColumns.add("到达地");
		vColumns.add("状态");
		Vector<LoadingVO> vData = new Vector<LoadingVO>();
		// //模型
		inquireModel = new DefaultTableModel(vData, vColumns);
		// //表格
		inquireTable = new JTable(inquireModel) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JTableHeader tableH = inquireTable.getTableHeader();
		TableColumn firsetColumn = inquireTable.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(200);
		firsetColumn.setMaxWidth(200);
		firsetColumn.setMinWidth(200);
		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		inquireTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		inquireTable.setShowVerticalLines(false);
		inquireTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(inquireTable);
		inquireTable.setFillsViewportHeight(true);
		this.add(scrollPane);

	}

	private void initIdInputField() {
		// TODO Auto-generated method stub
		XLabel idLabel = new XLabel("订单条形码：");
		idField = new JTextField();
		idLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField.setPreferredSize(new Dimension(150, 26));

		XButton addItemButton = new XButton("查询");
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					inquire();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "输入错误或找不到此订单信息", "", JOptionPane.ERROR_MESSAGE);
					//e.printStackTrace();
				}
			}
		});

		JPanel idInputPanel = new JPanel();
		idInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		idInputPanel.add(idLabel);
		idInputPanel.add(idField);
		idInputPanel.add(addItemButton);

		this.add(idInputPanel);
	}

	protected void inquire() {
		// TODO Auto-generated method stub
		inquireModel.setRowCount(0);
		id = idField.getText();
		voList = bl.inquire(id);
		if (!voList.isEmpty()) {
			for (int i = 0; i < voList.size(); i++) {
				TransVO vo = voList.get(i);
				inquireModel.addRow(vo);
			}
			LogBLService.insert(TimePO.getNowTimePO(),
					"寄件人查询了订单：" + id + "的订单信息");
		} else {
			JOptionPane.showMessageDialog(null, "无此订单信息", "", JOptionPane.ERROR_MESSAGE);
		}
		idField.setText("");
	}
}
