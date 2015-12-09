package ui.page;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;

import blservice.reviewblservice.StaffBLService;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import util.City;
import util.OrgType;
import util.Permission;
import vo.AccountVO;
import vo.StaffVO;

public class StaffManageView extends JPanel {
	private DefaultTableModel instituteModel;
	private JTable instituteTable;
	private StaffBLService bl;
	private ArrayList<StaffVO> voList;
	private ArrayList<StaffVO> voUpdateList;
	private JComboBox CityInCombobox;
	private JComboBox OrgInCombobox;
	private JComboBox IdInCombobox;
	private JComboBox PermissionInCombobox;

	private String city;
	private String org;
	private String orgID;
	private String permission;

	private int selectedRow;

	public StaffManageView(StaffBLService bl) {
		this.setName("职员管理");

		this.bl = bl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		voList = new ArrayList<StaffVO>();
		voUpdateList = new ArrayList<StaffVO>();

		IdInCombobox = new JComboBox();
		IdInCombobox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		ArrayList<String> instituteToAdd = null;
		try {
			instituteToAdd = bl.findInstitute(City.toCity("北京"), OrgType.toOrgType("营业厅"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String instituteId : instituteToAdd) {
			IdInCombobox.addItem(instituteId);
		}
		orgID = instituteToAdd.get(0);

		IdInCombobox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					orgID = (String) IdInCombobox.getSelectedItem();
				}
			}
		});

		CityInCombobox = new JComboBox();
		CityInCombobox.addItem("北京");
		CityInCombobox.addItem("上海");
		CityInCombobox.addItem("南京");
		CityInCombobox.addItem("广州");
		CityInCombobox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		PermissionInCombobox = new JComboBox();
		PermissionInCombobox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		permission = "快递员";
		PermissionInCombobox.addItem("快递员");
		PermissionInCombobox.addItem("营业厅业务员");
		PermissionInCombobox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					permission = (String) PermissionInCombobox.getSelectedItem();
				}
			}
		});

		OrgInCombobox = new JComboBox();
		OrgInCombobox.addItem("营业厅");
		OrgInCombobox.addItem("中转中心");

		OrgInCombobox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		initInputField();
		// 初始化账号列表界面
		initWareListTable();

		// 初始化按钮
		initButton();

		this.validate();
	}

	private void initInputField() {
		// TODO Auto-generated method stub
		city = "北京";
		CityInCombobox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					city = (String) CityInCombobox.getSelectedItem();

					ArrayList<String> instituteToAdd = null;
					try {
						instituteToAdd = bl.findInstitute(City.toCity(CityInCombobox.getSelectedItem().toString()),
								OrgType.toOrgType(OrgInCombobox.getSelectedItem().toString()));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					IdInCombobox.removeAllItems();
					for (String instituteId : instituteToAdd) {
						IdInCombobox.addItem(instituteId);
					}

					validate();
				}
			}
		});

		org = "营业厅";
		OrgInCombobox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					org = (String) OrgInCombobox.getSelectedItem();
					if (org.equals("营业厅")) {
						PermissionInCombobox.removeAllItems();
						PermissionInCombobox.addItem("快递员");
						PermissionInCombobox.addItem("营业厅业务员");
					} else {
						PermissionInCombobox.removeAllItems();
						PermissionInCombobox.addItem("中转中心业务员");
						PermissionInCombobox.addItem("中转中心仓库管理人员");
					}

					ArrayList<String> instituteToAdd = null;
					try {
						instituteToAdd = bl.findInstitute(City.toCity(CityInCombobox.getSelectedItem().toString()),
								OrgType.toOrgType(OrgInCombobox.getSelectedItem().toString()));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					IdInCombobox.removeAllItems();
					for (String instituteId : instituteToAdd) {
						IdInCombobox.addItem(instituteId);
					}

					validate();
				}
			}
		});

		XLabel permissionLabel = new XLabel("城市：");
		XLabel instituteLabel = new XLabel("机构：");
		XLabel idLabel = new XLabel("机构编号：");
		XLabel accountLabel = new XLabel("职员身份：");

		permissionLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		accountLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		XButton addItemButton = new XButton("添加");
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			}
		});

		JPanel inputPanel = new JPanel();
		JPanel inputPanel1 = new JPanel();
		// inputPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(permissionLabel);
		inputPanel.add(CityInCombobox);

		inputPanel.add(instituteLabel);
		inputPanel.add(OrgInCombobox);

		inputPanel.add(idLabel);
		inputPanel.add(IdInCombobox);
		inputPanel.add(accountLabel);
		inputPanel.add(PermissionInCombobox);

		XButton confirmButton = new XButton("添加");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem();
			}
		});

		inputPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		inputPanel1.add(confirmButton);

		add(inputPanel);
		add(inputPanel1);
	}

	private void initButton() {
		// TODO Auto-generated method stub
		XButton submitButton = new XButton("提交");
		submitButton.addActionListener(new ActionListener() {
			// //修改选中表格的数据
			public void actionPerformed(ActionEvent e) {
				voUpdateList = new ArrayList<StaffVO>();
				int col = instituteModel.getColumnCount();
				int row = instituteModel.getRowCount();
				for (int i = 0; i < row; i++) {
					StaffVO vo = null;
					String[] inf = new String[4];
					for (int j = 0; j < col; j++) {
						inf[j] = (String) instituteModel.getValueAt(i, j);
					}
					String idStr[] = inf[0].split("-");
					vo = new StaffVO(idStr[0], idStr[1], City.toCity(inf[1]), OrgType.toOrgType(inf[2]),
							Permission.toPermission(inf[3]));
					voUpdateList.add(vo);
				}
				bl.staffUpdate(voUpdateList);
			}
		});

		XButton deleteButton = new XButton("删除");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteItem();
			}
		});

		JPanel submitPanel = new JPanel();
		submitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		submitPanel.add(deleteButton);
		submitPanel.add(submitButton);
		this.add(submitPanel);
	}

	private void initWareListTable() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();

		// 表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("职员编号");
		vColumns.add("城市");
		vColumns.add("机构");
		vColumns.add("职员身份");

		Vector<AccountVO> vData = new Vector<AccountVO>();
		// //模型
		instituteModel = new DefaultTableModel(vData, vColumns);
		// //表格
		instituteTable = new JTable(instituteModel) {
			private int myRow = -1;
			TableCellEditor myEditor;
			private static final long serialVersionUID = 1L;

			// //设置第一行第一列不可编辑
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JTableHeader tableH = instituteTable.getTableHeader();

		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		instituteTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		instituteTable.setShowVerticalLines(false);
		instituteTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(instituteTable);
		instituteTable.setFillsViewportHeight(true);
		instituteTable.addMouseListener(new MouseAdapter() { // 鼠标事件
			public void mouseClicked(MouseEvent e) {
				selectedRow = instituteTable.getSelectedRow(); // 获得选中行索引
			}
		});
		this.add(scrollPane);
		voList = bl.findAll();
		for (int i = 0; i < voList.size(); i++) {
			StaffVO vo = voList.get(i);
			instituteModel.addRow(vo);
		}
	}

	protected void addItem() {
		// TODO Auto-generated method stub
		StaffVO staff = bl.addStaff(City.toCity(city), OrgType.toOrgType(org), orgID,
				Permission.toPermission(permission));
		instituteModel.addRow(staff);
		this.validate();
	}

	protected void deleteItem() {
		// TODO Auto-generated method stub
		String id = (String) instituteModel.getValueAt(selectedRow, 0);
		String cityToDelete = (String) instituteModel.getValueAt(selectedRow, 1);
		String orgToDelete = (String) instituteModel.getValueAt(selectedRow, 2);
		String permissionToDelete = (String) instituteModel.getValueAt(selectedRow, 3);
		String idStr[] = id.split("-");
		bl.deleteStaff(idStr[0], idStr[1]);
		voUpdateList.remove(new StaffVO(idStr[0], idStr[1], City.toCity(cityToDelete), OrgType.toOrgType(orgToDelete),
				Permission.toPermission(permissionToDelete)));

		instituteModel.removeRow(selectedRow);

		this.validate();
	}

}
