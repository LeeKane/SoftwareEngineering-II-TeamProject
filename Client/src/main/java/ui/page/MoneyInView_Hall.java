package ui.page;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
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
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import blservice.listblservice.MoneyInListBLService;
import blservice.reviewblservice.LogBLService;
import po.AccountPO;
import po.StaffPO;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import util.OrgType;
import util.Permission;
import vo.AccountVO;
import vo.list.MoneyInListVO;

public class MoneyInView_Hall extends JPanel {
	private DefaultTableModel accountModel;
	private JTable accountTable;
	private DefaultTableModel moneyInModel;
	private JTable moneyInTable;
	private MoneyInListBLService bl;
	private ArrayList<AccountVO> accountvoList;
	private ArrayList<MoneyInListVO> voUpdateList;

	private ArrayList<MoneyInListVO> voList;

	private JComboBox ApproveCombobox;
	private JComboBox BAccountCombobox;
	private JComboBox CityInCombobox;
	private JComboBox OrgCombobox;
	private JComboBox OrgInCombobox;
	private JTextField accountField;
	private JTextField IDField;

	private AccountPO po;
	private String org;
	private int selectedRow;

	public MoneyInView_Hall(MoneyInListBLService bl) {
		this.setName("收款单生成");

		this.bl = bl;
		po = bl.getPo();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		accountvoList = new ArrayList<AccountVO>();
		voUpdateList = new ArrayList<MoneyInListVO>();
		ApproveCombobox = new JComboBox();
		ApproveCombobox.addItem("未核对");
		ApproveCombobox.addItem("已核对");

		ApproveCombobox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		// 初始化账号列表界面
		initTable1();

		initInputField();

		initTable2();

		// 初始化按钮
		initButton();

		this.validate();
	}

	private void initInputField() {
		// TODO Auto-generated method stub
		XButton addItemButton = new XButton("确定");
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAccount();
			}
		});
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		inputPanel.add(addItemButton);
		this.add(inputPanel);
	}

	private void initButton() {
		// TODO Auto-generated method stub
		XButton submitButton = new XButton("提交");
		submitButton.addActionListener(new ActionListener() {
			// //修改选中表格的数据
			public void actionPerformed(ActionEvent e) {
				int col = moneyInModel.getColumnCount();
				int row = moneyInModel.getRowCount();

				ArrayList<Integer> numList = new ArrayList<Integer>();

				for (int i = row - 1; i >= 0; i--) {
					MoneyInListVO vo = null;
					String inf = (String) moneyInModel.getValueAt(i, 4);
					if (inf.equals("已核对")) {
						vo = voList.get(i);
						MoneyInListVO voUpdate = new MoneyInListVO(vo.getTime(),
								Double.parseDouble((String) moneyInModel.getValueAt(i, 3)), vo.getAccount(), vo.getId(),
								true, BAccountCombobox.getSelectedItem().toString());
						voUpdateList.add(voUpdate);
						voList.remove(vo);
						numList.add(i);
					}
				}

				for (int i : numList) {
					moneyInModel.removeRow(i);
				}

				try {
					bl.MoneyInListUpdate(voUpdateList);
					LogBLService.insert(TimePO.getNowTimePO(),
							bl.getPo().getPermission().toString() + bl.getPo().getUsername() + "生成了新的收款单");
					JOptionPane.showMessageDialog(null, "提交成功！", "", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				voUpdateList = new ArrayList<MoneyInListVO>();
			}
		});

		XLabel BAccountLabel = new XLabel("收款账户");
		BAccountCombobox = new JComboBox();
		ArrayList<String> baccountArray = new ArrayList<String>();
		baccountArray = bl.findAllBaccount();
		for (String baccount : baccountArray) {
			BAccountCombobox.addItem(baccount);
		}

		JPanel submitPanel = new JPanel();
		submitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		submitPanel.add(BAccountLabel);
		submitPanel.add(BAccountCombobox);
		submitPanel.add(submitButton);
		this.add(submitPanel);
	}

	private void initTable1() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();

		// 表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("ID");
		vColumns.add("身份");
		vColumns.add("账号");

		Vector<AccountVO> vData = new Vector<AccountVO>();
		// //模型
		accountModel = new DefaultTableModel(vData, vColumns);
		// //表格
		accountTable = new JTable(accountModel) {
			private static final long serialVersionUID = 1L;

			// //设置第一行第一列不可编辑
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};

		JTableHeader tableH = accountTable.getTableHeader();

		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		accountTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		accountTable.setShowVerticalLines(false);
		accountTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(accountTable);
		accountTable.setFillsViewportHeight(true);
		accountTable.addMouseListener(new MouseAdapter() { // 鼠标事件
			public void mouseClicked(MouseEvent e) {
				selectedRow = accountTable.getSelectedRow(); // 获得选中行索引
			}
		});
		this.add(scrollPane);
		accountvoList = bl.findAllCourier();
		for (int i = 0; i < accountvoList.size(); i++) {
			AccountVO vo = accountvoList.get(i);
			accountModel.addRow(vo);
		}

	}

	private void initTable2() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();

		// 表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("快递员");
		vColumns.add("日期");
		vColumns.add("ID");
		vColumns.add("金额");
		vColumns.add("核对状态");

		Vector<AccountVO> vData = new Vector<AccountVO>();
		// //模型
		moneyInModel = new DefaultTableModel(vData, vColumns);
		// //表格
		moneyInTable = new JTable(moneyInModel) {
			private int myRow = -1;
			TableCellEditor myEditor;
			private static final long serialVersionUID = 1L;

			// //设置第一行第一列不可编辑
			public boolean isCellEditable(int row, int column) {
				if (column < 3) {
					return false;
				}
				return true;
			}

		};

		JTableHeader tableH = moneyInTable.getTableHeader();
		TableColumn tableColumn1 = moneyInTable.getColumn("核对状态");
		tableColumn1.setCellEditor(new DefaultCellEditor(ApproveCombobox));

		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		moneyInTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		moneyInTable.setShowVerticalLines(false);
		moneyInTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(moneyInTable);
		moneyInTable.setFillsViewportHeight(true);
		moneyInTable.addMouseListener(new MouseAdapter() { // 鼠标事件
			public void mouseClicked(MouseEvent e) {
				selectedRow = moneyInTable.getSelectedRow(); // 获得选中行索引
			}
		});
		this.add(scrollPane);
	}

	protected void addItem() {
		// TODO Auto-generated method stub
		// InstituteVO account =
		// bl.addAccount(City.toCity(city),OrgType.toOrgType(org));
		// accountField.setText("");
		// IDField.setText("");
		// accountModel.addRow(account);
		validate();
	}

	protected void deleteItem() {
		// TODO Auto-generated method stub
		// String id=(String) accountModel.getValueAt(selectedRow,0 );
		// bl.deleteAccount(id);
		// accountModel.removeRow(selectedRow);
		validate();
	}

	protected void showAccount() {
		moneyInModel.setRowCount(0);

		AccountVO accountvo = accountvoList.get(accountTable.getSelectedRow());
		String idStr[] = accountvo.getStaffid().split("-");
		AccountPO courierPo = new AccountPO(accountvo.getId(), accountvo.getPermission1(), accountvo.getUsername(),
				accountvo.getPassword(),
				new StaffPO(idStr[0], idStr[1], po.getStaff().getCity(), OrgType.HALL, Permission.COURIER));
		voList = bl.findAll(courierPo);
		for (int i = 0; i < voList.size(); i++) {
			MoneyInListVO vo = voList.get(i);
			moneyInModel.addRow(vo);
		}
	}
}
