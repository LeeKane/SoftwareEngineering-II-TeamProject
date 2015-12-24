package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import blservice.financeblservice.BAccountBLService;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import vo.BaccountVO;
import vo.InstituteVO;
import vo.LoadingVO;

public class BAccountManageView extends JPanel {
	private JTextField textField;// 唯一的输入框
	private JTextField bAccountField;
	private DefaultTableModel bAccountManageModel;
	private JTable bAccountTable;
	private JComboBox CityCombobox;
	private JComboBox CityCombobox2;

	private ArrayList<BaccountVO> voList;
	private BAccountBLService bl;
	private String text;

	public BAccountManageView(BAccountBLService bl) {
		this.setName("账户管理");

		this.bl = bl;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initInputField();
		initListTable();
		
	}

	private void initListTable() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("账户");
		vColumns.add("名称");
		vColumns.add("金额");
		Vector<LoadingVO> vData = new Vector<LoadingVO>();
		// //模型
		bAccountManageModel = new DefaultTableModel(vData, vColumns);
		// //表格
		bAccountTable = new JTable(bAccountManageModel) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				if (column == 0) {
					return true;
				}else if (row != 0 && column == 1)
					return true;
				return false;
			}
		};

		JTableHeader tableH = bAccountTable.getTableHeader();
		TableColumn tableColumn1 = bAccountTable.getColumn("名称");
		
		CityCombobox2 = new JComboBox();
		CityCombobox2.addItem("北京");
		CityCombobox2.addItem("上海");
		CityCombobox2.addItem("南京");
		CityCombobox2.addItem("广州");
		
		tableColumn1.setCellEditor(new DefaultCellEditor(CityCombobox2));
		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		bAccountTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bAccountTable.setShowVerticalLines(false);
		bAccountTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(bAccountTable);
		bAccountTable.setFillsViewportHeight(true);
		this.add(scrollPane);
		voList = bl.findAll();
		for (int i = 0; i < voList.size(); i++) {
			BaccountVO vo = voList.get(i);
			bAccountManageModel.addRow(vo);
		}
	}

	private void initInputField() {
		// TODO Auto-generated method stub
		XLabel idLabel = new XLabel("账户信息：");
		textField = new JTextField();
		idLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		textField.setPreferredSize(new Dimension(150, 26));

		XButton inquireButton = new XButton("查询");
		inquireButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//inquire();
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		XLabel bAccountLabel = new XLabel("账户账号：");
		bAccountField = new JTextField();
		bAccountLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		bAccountField.setPreferredSize(new Dimension(150, 26));
		XLabel cityLabel = new XLabel("账户城市：");
		CityCombobox = new JComboBox();
		CityCombobox.addItem("北京");
		CityCombobox.addItem("上海");
		CityCombobox.addItem("南京");
		CityCombobox.addItem("广州");
		XButton addItemButton = new XButton("添加");
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// addItem();
			}
		});

		JPanel idInputPanel = new JPanel();
		idInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		idInputPanel.add(idLabel);
		idInputPanel.add(textField);
		idInputPanel.add(inquireButton);

		JPanel idInputPanel2 = new JPanel();
		idInputPanel2.add(bAccountLabel);
		idInputPanel2.add(bAccountField);
		idInputPanel2.add(cityLabel);
		idInputPanel2.add(CityCombobox);
		idInputPanel2.add(addItemButton);

		this.add(idInputPanel);
		this.add(idInputPanel2);
	}

	// protected void inquire() {
	// // TODO Auto-generated method stub
	// bAccountManageModel.setRowCount(0);
	// id = textField.getText();
	// voList = bl.inquire(id);
	// if (!voList.isEmpty()) {
	// for (int i = 0; i < voList.size(); i++) {
	// TransVO vo = voList.get(i);
	// bAccountManageModel.addRow(vo);
	// }
	// } else {
	// JOptionPane.showMessageDialog(null, "无此订单信息", "",
	// JOptionPane.ERROR_MESSAGE);
	// }
	// textField.setText("");
	// }
}
