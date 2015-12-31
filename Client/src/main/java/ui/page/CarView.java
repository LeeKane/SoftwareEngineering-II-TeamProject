package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
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
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import bl.trans.CarBL;
import blservice.reviewblservice.CarBLservice;
import dataservice.reviewdataservice.LogDataService;
import po.LogPO;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import util.Vehicle;
import vo.CarVO;

public class CarView extends JPanel {
	private DefaultTableModel carModel;
	private JTable carTable;
	private CarBLservice bl;
	private ArrayList<CarVO> voList;
	private ArrayList<CarVO> voUpdateList;
	private JTextField carNumField;// 车牌号
	private JTextField basenumberField;// 底盘号
	private JTextField engineField;// 引擎号
	private JTextField buytimeField;// 购买时间
	private JTextField usetimeField;// 服役时间

	private XTimeChooser ser;
	private int selectedRow;

	private TimePO buytime;
	private TimePO usetime;

	public CarView(CarBLservice cbl) {
		this.setName("车辆信息管理");

		this.bl = cbl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		voList = new ArrayList<CarVO>();
		voUpdateList = new ArrayList<CarVO>();
		initInputField();
		// 初始化账号列表界面
		initWareListTable();

		// 初始化按钮
		initButton();

		this.validate();
	}

	private void initInputField() {
		// TODO Auto-generated method stub
		XLabel carNumLabel = new XLabel("车牌号：");
		XLabel basenumberLabel = new XLabel("底盘号：");
		XLabel engineLabel = new XLabel("发动机号：");
		XLabel buytimeLabel = new XLabel("购买时间：");
		XLabel usetimeLabel = new XLabel("服役时间：");
		carNumField = new JTextField();
		carNumLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		carNumField.setPreferredSize(new Dimension(100, 26));
		basenumberField = new JTextField();
		basenumberLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		basenumberField.setPreferredSize(new Dimension(100, 26));
		engineField = new JTextField();
		engineLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		engineField.setPreferredSize(new Dimension(100, 26));

		buytimeField = new JTextField();
		buytimeLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		buytimeField.setPreferredSize(new Dimension(200, 26));
		ser = XTimeChooser.getInstance();
		ser.register(buytimeField);
		buytime = ser.getTimePO();
		buytimeField.setText(ser.getCurrentTime());
		buytimeField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		usetimeField = new JTextField();
		usetimeLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		usetimeField.setPreferredSize(new Dimension(200, 26));
		ser = XTimeChooser.getInstance();
		ser.register(usetimeField);
		usetime = ser.getTimePO();
		usetimeField.setText(ser.getCurrentTime());
		usetimeField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		XButton addItemButton = new XButton("添加");
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			}
		});

		JPanel inputPanel = new JPanel();
		JPanel inputPanel1 = new JPanel();
		JPanel inputPanel2 = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(carNumLabel);
		inputPanel.add(carNumField);
		inputPanel.add(basenumberLabel);
		inputPanel.add(basenumberField);
		inputPanel.add(engineLabel);
		inputPanel.add(engineField);
		inputPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel1.add(buytimeLabel);
		inputPanel1.add(buytimeField);
		inputPanel1.add(usetimeLabel);
		inputPanel1.add(usetimeField);
		inputPanel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		inputPanel2.add(addItemButton);

		this.add(inputPanel);
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
				int col = carModel.getColumnCount();
				int row = carModel.getRowCount();
				for (int i = 0; i < row; i++) {
					CarVO vo = null;
					String[] inf = new String[6];
					for (int j = 0; j < col; j++) {
						inf[j] = (String) carModel.getValueAt(i, j);
					}
					vo = new CarVO(Vehicle.CAR, inf[0], Long.parseLong(inf[1]), inf[2], Long.parseLong(inf[3]),
							TimePO.toTime(inf[4]), TimePO.toTime(inf[5]));
					voUpdateList.add(vo);

				}

				boolean result = bl.Upate(voUpdateList);
				if (result == true) {
					try {
						LogDataService.insert(new LogPO(TimePO.getNowTimePO(),bl.getPo().getPermission().toString()+bl.getPo().getUsername()
								+"修改了车辆信息"));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
		vColumns.add("车辆代号");
		vColumns.add("发动机号");
		vColumns.add("车牌号");
		vColumns.add("底盘号");
		vColumns.add("购买时间");
		vColumns.add("使用时间");

		Vector<CarVO> vData = new Vector<CarVO>();
		// //模型
		carModel = new DefaultTableModel(vData, vColumns);
		// //表格
		carTable = new JTable(carModel) {
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
		TableColumn buyTimeColumn = carTable.getColumnModel().getColumn(4);
		buyTimeColumn.setPreferredWidth(200);

		TableColumn useTimeColumn = carTable.getColumnModel().getColumn(5);
		useTimeColumn.setPreferredWidth(200);

		JTableHeader tableH = carTable.getTableHeader();
		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		carTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		carTable.setShowVerticalLines(false);
		carTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(carTable);
		carTable.setFillsViewportHeight(true);
		carTable.addMouseListener(new MouseAdapter() { // 鼠标事件
			public void mouseClicked(MouseEvent e) {
				selectedRow = carTable.getSelectedRow(); // 获得选中行索引
			}
		});
		this.add(scrollPane);
		voList = bl.findAll();
		for (int i = 0; i < voList.size(); i++) {
			CarVO vo = voList.get(i);
			carModel.addRow(vo);
		}

	}

	protected void addItem() {
		try {
			CarVO car = bl.addCar(Vehicle.CAR, "1111111111", Long.parseLong(engineField.getText()),
					carNumField.getText(), Long.parseLong(basenumberField.getText()), buytime, usetime);
			carModel.addRow(car);
			try {
				LogDataService.insert(new LogPO(TimePO.getNowTimePO(),"中转中心仓库管理人员"+bl.getPo().getUsername()
						+"增加了车辆："+carNumField.getText()));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
		}

		engineField.setText("");
		carNumField.setText("");
		basenumberField.setText("");

		CarView.this.validate();
	}

	protected void deleteItem() {
		// TODO Auto-generated method stub
		String id = (String) carModel.getValueAt(selectedRow, 0);
		bl.deleteCar(id);
		carModel.removeRow(selectedRow);
		CarView.this.validate();
		try {
			LogDataService.insert(new LogPO(TimePO.getNowTimePO(),"中转中心仓库管理人员"+bl.getPo().getUsername()
					+"删除了车辆："+id));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
