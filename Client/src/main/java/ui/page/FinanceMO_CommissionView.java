package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import bl.finance.Reward;
import blservice.financeblservice.FinanceMOBLService;
import blservice.listblservice.MoneyInListBLService;
import po.AccountPO;
import po.StaffPO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import util.City;
import util.OrgType;
import util.Permission;
import vo.AccountVO;
import vo.list.MoneyInListVO;

public class FinanceMO_CommissionView extends FinanceMOView {
	private int selectedRow;
	private ArrayList<AccountVO> accountvoList;
	private JTable accountTable;
	private MoneyInListBLService mbl;
	private XLabel countLabel1;
	private XLabel costLabel1;

	public FinanceMO_CommissionView(FinanceMOBLService bl, MoneyInListBLService mbl) {
		super(bl);
		this.mbl = mbl;
		this.type = "快递员提成";
		this.setName("快递员提成");
		initImportItemField();
		// TODO Auto-generated constructor stub
	}

	private void initImportItemField() {
		// TODO Auto-generated method stub
		XLabel timeLabel = new XLabel("日期：");
		dataField = new JTextField();
		timeLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dataField.setPreferredSize(new Dimension(200, 26));
		ser = XTimeChooser.getInstance();
		ser.register(dataField);
		timePO = ser.getTimePO();
		dataField.setText(ser.getCurrentTime());
		dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		XLabel nameLabel = new XLabel("付款人：");
		nameField = new JTextField();
		nameLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		nameField.setPreferredSize(new Dimension(100, 26));

		XLabel accountLabel = new XLabel("付款账户：");
		accountField = new JComboBox();
		account = polist.get(0).getName();
		for (int i = 0; i < polist.size(); i++) {
			accountField.addItem(polist.get(i).getName());
		}
		accountField.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					account = (String) accountField.getSelectedItem();
				}
			}
		});
		accountLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		accountField.setPreferredSize(new Dimension(150, 26));
		XLabel costLabel = new XLabel("金额：");
		costLabel1 = new XLabel(cost + "");
		costLabel1.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		costLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		XLabel jobLabel = new XLabel("付款账号：");
		jobLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		XLabel countLabel = new XLabel("快递员：");
		countLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		countLabel1 = new XLabel("                        ");
		countLabel1.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		XLabel notesLabel = new XLabel("备注：");
		notesField = new JTextField();
		notesLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		notesField.setPreferredSize(new Dimension(200, 26));

		XButton chooseItemButton = new XButton("添加");
		chooseItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timePO = ser.getTimePO();
				addItem();
			}
		});

		XButton addItemButton = new XButton("确定");
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAccount();
			}
		});
		JPanel inputPanel0 = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel inputPanel2 = new JPanel();
		JPanel inputPanel3 = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		inputPanel0.setLayout(new FlowLayout(FlowLayout.RIGHT));
		inputPanel.add(timeLabel);
		inputPanel.add(dataField);
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(accountLabel);
		inputPanel.add(accountField);
		inputPanel2.add(countLabel);
		inputPanel2.add(countLabel1);
		inputPanel2.add(costLabel);
		inputPanel2.add(costLabel1);
		inputPanel2.add(notesLabel);
		inputPanel2.add(notesField);
		inputPanel3.add(chooseItemButton);
		inputPanel0.add(addItemButton);
		initTable1();
		this.add(inputPanel0);
		this.add(inputPanel);
		this.add(inputPanel2);
		this.add(inputPanel3);

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
		DefaultTableModel accountModel = new DefaultTableModel(vData, vColumns);
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
		accountvoList = new ArrayList<AccountVO>();
		accountvoList = mbl.findAllCourier();

		for (int i = 0; i < accountvoList.size(); i++) {
			AccountVO vo = accountvoList.get(i);
			accountModel.addRow(vo);
		}

	}

	protected void showAccount() {
		// TODO Auto-generated method stub
		cost = 0.0;
		AccountVO accountvo = accountvoList.get(accountTable.getSelectedRow());
		String idStr[] = accountvo.getStaffid().split("-");
		AccountPO accountpo = null;
		if (idStr[0].equals("1100")) {
			accountpo = new AccountPO(accountvo.getId(), accountvo.getPermission1(), accountvo.getUsername(),
					accountvo.getPassword(),
					new StaffPO(idStr[0], idStr[1], City.BEIJING, OrgType.HALL, Permission.COURIER));
		} else if (idStr[0].equals("1250")) {
			accountpo = new AccountPO(accountvo.getId(), accountvo.getPermission1(), accountvo.getUsername(),
					accountvo.getPassword(),
					new StaffPO(idStr[0], idStr[1], City.NANJING, OrgType.HALL, Permission.COURIER));
		} else if (idStr[0].equals("1210")) {
			accountpo = new AccountPO(accountvo.getId(), accountvo.getPermission1(), accountvo.getUsername(),
					accountvo.getPassword(),
					new StaffPO(idStr[0], idStr[1], City.SHANGHAI, OrgType.HALL, Permission.COURIER));
		} else if (idStr[0].equals("1200")) {
			accountpo = new AccountPO(accountvo.getId(), accountvo.getPermission1(), accountvo.getUsername(),
					accountvo.getPassword(),
					new StaffPO(idStr[0], idStr[1], City.GUANGZHOU, OrgType.HALL, Permission.COURIER));
		}
		countLabel1.setText(accountpo.getUsername());
		ArrayList<MoneyInListVO> voList = new ArrayList<MoneyInListVO>();
		voList = mbl.findAllExist(accountpo);
		for (int i = 0; i < voList.size(); i++) {
			MoneyInListVO vo = voList.get(i);
			cost += vo.getMoney();
		}
		Reward r = new Reward();
		cost *= r.getCommissionOfMailer();
		BigDecimal b = new BigDecimal(cost);
		cost = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		costLabel1.setText(cost + "");
	}
}
