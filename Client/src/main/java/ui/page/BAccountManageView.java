package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import blservice.financeblservice.BAccountBLService;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import vo.LoadingVO;

public class BAccountManageView extends JPanel{
	private JTextField textField;// 唯一的输入框
	private DefaultTableModel bAccountManageModel;
	private JTable bAccountTable;

	private BAccountBLService bl;
	private String text;

	public BAccountManageView(BAccountBLService bl) {
		this.setName("账户管理");
		
		this.bl=bl;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initInputField();
		initListTable();
	}

	private void initListTable() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("账户");
		vColumns.add("城市");
		vColumns.add("金额");
		Vector<LoadingVO> vData = new Vector<LoadingVO>();
		// //模型
		bAccountManageModel = new DefaultTableModel(vData, vColumns);
		// //表格
		bAccountTable = new JTable(bAccountManageModel) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JTableHeader tableH = bAccountTable.getTableHeader();
		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		bAccountTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bAccountTable.setShowVerticalLines(false);
		bAccountTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(bAccountTable);
		bAccountTable.setFillsViewportHeight(true);
		this.add(scrollPane);
	}

	private void initInputField() {
		// TODO Auto-generated method stub
		XLabel idLabel = new XLabel("账户信息：");
		textField = new JTextField();
		idLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		textField.setPreferredSize(new Dimension(150, 26));

		XButton addItemButton = new XButton("查询");
//		addItemButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					inquire();
//				} catch (NumberFormatException e) {
//					JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		});

		JPanel idInputPanel = new JPanel();
		idInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		idInputPanel.add(idLabel);
		idInputPanel.add(textField);
		idInputPanel.add(addItemButton);

		this.add(idInputPanel);

	}

//	protected void inquire() {
//		// TODO Auto-generated method stub
//		bAccountManageModel.setRowCount(0);
//		id = textField.getText();
//		voList = bl.inquire(id);
//		if (!voList.isEmpty()) {
//			for (int i = 0; i < voList.size(); i++) {
//				TransVO vo = voList.get(i);
//				bAccountManageModel.addRow(vo);
//			}
//		} else {
//			JOptionPane.showMessageDialog(null, "无此订单信息", "", JOptionPane.ERROR_MESSAGE);
//		}
//		textField.setText("");
//	}
}
