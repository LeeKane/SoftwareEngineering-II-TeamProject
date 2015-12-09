package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
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

import bl.review.DriverBL;
import blservice.reviewblservice.DriverBLservice;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import util.Vehicle;
import vo.DriverVO;

public class DriverView extends JPanel {
	private DefaultTableModel DriverModel;
	private JTable DriverTable;
	private DriverBLservice bl;
	private ArrayList<DriverVO> voList;
	private ArrayList<DriverVO> voUpdateList;
	private JTextField nameField;// 司机姓名
	private JTextField idField;// 身份证号
	private JTextField telField;// 手机号
	private JTextField birthdayField;// 购买时间
	private JTextField licensedateField;// 行驶证期限

	private JComboBox cityBox;
	private JComboBox carunitBox;// 车辆单位
	private JComboBox sexBox;// 性别

	private XTimeChooser ser;
	private int selectedRow;

	private TimePO birthday;
	private TimePO licensedate;
	private String sex;
	private String city;
	private String unit;

	public DriverView() {
		this.setName("司机信息管理");
		
		this.bl = new DriverBL();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		voList = new ArrayList<DriverVO>();
		voUpdateList = new ArrayList<DriverVO>();
		initInputField();
		// 初始化账号列表界面
		initWareListTable();

		// 初始化按钮
		initButton();

		this.validate();
	}

	private void initInputField() {
		// TODO Auto-generated method stub
		XLabel nameLabel = new XLabel("司机姓名：");
		XLabel idLabel = new XLabel("身份证号：");
		XLabel telLabel = new XLabel("手机号：");
		XLabel sexLabel = new XLabel("性别");
		XLabel carunitLable = new XLabel("车辆单位:   ");
		XLabel birthdayLabel = new XLabel("出生日期：");
		XLabel licensedateLabel = new XLabel("行驶证期限：");
		nameField = new JTextField();
		nameLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		nameField.setPreferredSize(new Dimension(70, 26));
		idField = new JTextField();
		idLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField.setPreferredSize(new Dimension(100, 26));
		telField = new JTextField();
		telLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		telField.setPreferredSize(new Dimension(100, 26));
		carunitLable.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		birthdayLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		licensedateLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		sex="男";
		sexBox = new JComboBox();
		sexBox.addItem("男");
		sexBox.addItem("女");
		sexBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		sexBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					sex = (String) sexBox.getSelectedItem();
				}
			}
		});
		unit="营业厅";
		carunitBox = new JComboBox();
		carunitBox.addItem("营业厅");
		carunitBox.addItem("中转中心");
		carunitBox.addItem("仓库");
		carunitBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		carunitBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					unit = (String) carunitBox.getSelectedItem();
				}
			}
		});
		city="北京";
		cityBox = new JComboBox();
		cityBox.addItem("北京");
		cityBox.addItem("上海");
		cityBox.addItem("南京");
		cityBox.addItem("广州");
		cityBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		cityBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					city = (String) cityBox.getSelectedItem();
				}
			}
		});
		birthdayField = new JTextField();
		birthdayLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		birthdayField.setPreferredSize(new Dimension(200, 26));
		ser = XTimeChooser.getInstance();
		ser.register(birthdayField);
		birthday = ser.getTimePO();
		birthdayField.setText(ser.getCurrentTime());
		birthdayField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		licensedateField = new JTextField();
		licensedateLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		licensedateField.setPreferredSize(new Dimension(200, 26));
		ser = XTimeChooser.getInstance();
		ser.register(licensedateField);
		licensedate = ser.getTimePO();
		licensedateField.setText(ser.getCurrentTime());
		licensedateField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		XButton addItemButton = new XButton("添加");
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			}
		});

		JPanel inputPanel = new JPanel();
		JPanel inputPanel4 = new JPanel();
		JPanel inputPanel1 = new JPanel();
		JPanel inputPanel2 = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(idLabel);
		inputPanel.add(idField);
		inputPanel.add(telLabel);
		inputPanel.add(telField);
		inputPanel.add(sexLabel);
		inputPanel.add(sexBox);
		inputPanel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel4.add(carunitLable);
		inputPanel4.add(cityBox);
		inputPanel4.add(carunitBox);
		inputPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel1.add(birthdayLabel);
		inputPanel1.add(birthdayField);
		inputPanel1.add(licensedateLabel);
		inputPanel1.add(licensedateField);
		inputPanel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		inputPanel2.add(addItemButton);

		this.add(inputPanel);
		this.add(inputPanel4);
		this.add(inputPanel1);
		this.add(inputPanel2);

	}

	private void initButton() {
		// TODO Auto-generated method stub
		XButton submitButton = new XButton("修改");
		submitButton.addActionListener(new ActionListener() {
			// //修改选中表格的数据
			public void actionPerformed(ActionEvent e) {
				voUpdateList.clear();
				int col = DriverModel.getColumnCount();
				int row = DriverModel.getRowCount();
				for (int i = 0; i < row; i++) {
					DriverVO vo = null;
					String[] inf = new String[8];
					for (int j = 0; j < col; j++) {
						inf[j] = (String) DriverModel.getValueAt(i, j);
					}
					vo = new DriverVO(Long.parseLong(inf[0]), inf[1], TimePO.toSpeccialTime(inf[2]), inf[3], inf[4], inf[5],
							inf[6], TimePO.toSpeccialTime(inf[7]));
					voUpdateList.add(vo);
				}

				boolean result = bl.Upate(voUpdateList);
				if (result == true) {
					JOptionPane.showMessageDialog(null, "修改成功！", "", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "修改失败！", "", JOptionPane.ERROR_MESSAGE);
				}
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
		vColumns.add("司机编号");
		vColumns.add("司机姓名");
		vColumns.add("出生日期");
		vColumns.add("身份证号");
		vColumns.add("手机号");
		vColumns.add("车辆单位");
		vColumns.add("性别");
		vColumns.add("行驶证期限");

		Vector<DriverVO> vData = new Vector<DriverVO>();
		// //模型
		DriverModel = new DefaultTableModel(vData, vColumns);
		// //表格
		DriverTable = new JTable(DriverModel) {
			private int myRow = -1;
			TableCellEditor myEditor;
			private static final long serialVersionUID = 1L;

			// //设置第一行不可编辑
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {
					return false;
				}
				return true;
			}

		};
		TableColumn birthdayColumn = DriverTable.getColumnModel().getColumn(2);
		birthdayColumn.setPreferredWidth(150);
		TableColumn idColumn = DriverTable.getColumnModel().getColumn(3);
		idColumn.setPreferredWidth(150);
		TableColumn telColumn = DriverTable.getColumnModel().getColumn(4);
		telColumn.setPreferredWidth(150);
		TableColumn licensedateColumn = DriverTable.getColumnModel().getColumn(7);
		licensedateColumn.setPreferredWidth(150);


		TableColumn unitColumn = DriverTable.getColumnModel().getColumn(5);
		unitColumn.setPreferredWidth(150);

		JTableHeader tableH = DriverTable.getTableHeader();
		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		DriverTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DriverTable.setShowVerticalLines(false);
		DriverTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(DriverTable);
		DriverTable.setFillsViewportHeight(true);
		DriverTable.addMouseListener(new MouseAdapter() { // 鼠标事件
			public void mouseClicked(MouseEvent e) {
				selectedRow = DriverTable.getSelectedRow(); // 获得选中行索引
			}
		});
		this.add(scrollPane);
		voList = bl.findAll();
		for (int i = 0; i < voList.size(); i++) {
			DriverVO vo = voList.get(i);
			DriverModel.addRow(vo);
		}

	}

	protected void addItem() {
		try{
			if(nameField.getText().equals(""))
				JOptionPane.showMessageDialog(null, "请输入未输入项","", JOptionPane.ERROR_MESSAGE);
			else{
				DriverVO Driver = bl.addDriver(1111111111, nameField.getText(), birthday, Long.parseLong(idField.getText())+""
						, Long.parseLong(telField.getText())+"",city + unit, sex, licensedate);
				DriverModel.addRow(Driver);
			}		
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "请正确输入","", JOptionPane.ERROR_MESSAGE);
		}
		telField.setText("");
		nameField.setText("");
		idField.setText("");
		DriverView.this.validate();
	}

	protected void deleteItem() {
		// TODO Auto-generated method stub
		String id = (String) DriverModel.getValueAt(selectedRow, 0);
		bl.deleteDriver(Long.parseLong(id));
		DriverModel.removeRow(selectedRow);
		DriverView.this.validate();
	}
}
