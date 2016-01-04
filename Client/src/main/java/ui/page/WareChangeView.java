package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
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

import blservice.reviewblservice.LogBLService;
import blservice.warehouseblservice.WareInBLservice;
import dataimpl.datafactory.DataFactory;
import dataservice.listdataservice.OrderListDataService;
import dataservice.listdataservice.WareInListDataService;
import dataservice.warehousedataservice.GarageDataSeriaService;
import po.Garage;
import po.GarageBodyPO;
import po.GaragePlacePO;
import po.TimePO;
import po.list.OrderListPO;
import po.list.WareInListPO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import util.City;
import util.DeliverType;
import util.ListState;
import util.Vehicle;
import vo.list.WareInListVO;

public class WareChangeView extends JPanel {
	private static final long serialVersionUID = 1L;
	private WareInBLservice bl;
	private WareInListDataService wd;
	private OrderListDataService od;
	private GarageDataSeriaService gd;
	private JTextField dataField;// 修改
	private JTextField idField;
	private JTextField nameField;
	private XLabel transidField;
	private XLabel maxplace;
	private JTextField idField77;
	private JTextField idField11;
	private JTextField idField22;
	private JTextField idField33;
	private JTextField idField44;
	private JTextField idField55;
	private JTextField transField;
	private JTextField percentField;
	private JTextField max;
	private JTextField maxField;
	private XTimeChooser ser;
	private DefaultTableModel deliveryInputModel;
	private JTable deliveryInputTable;
	private TimePO timePO;
	private long id;
	private City city;
	private long transid;
	private XLabel TransBox;
	private String place = "北京";
	int qu;
	int pai;
	int jia;
	int wei;
	private String vehicle = "汽车";
	private JComboBox destinationBox;

	public WareChangeView(WareInBLservice bl) {
		this.setName("库存调整");
		this.od = DataFactory.getWareData2();
		this.wd = DataFactory.getWareInData();
		this.gd = DataFactory.getGarageData();
		this.bl = bl;
		transid = Long.parseLong(bl.getPo().getStaff().getOrgid());
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// 初始化快件信息输入界面
		initImportItemField();

		// 初始化快件列表界面
		initWareListTable();

		// 初始化
		init();
		this.validate();
	}

	private void init() {
		try {
			showEmpty();
			showmax();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initWareListTable() {// 快递编号、入库日期、目的地、区号、排号、架号、位号
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("快递编号");
		vColumns.add("入库日期");
		vColumns.add("目的地");
		vColumns.add("区号");
		vColumns.add("排号");
		vColumns.add("架号");
		vColumns.add("位号");

		Vector<String> vData = new Vector<String>();

		// //模型
		deliveryInputModel = new DefaultTableModel(vData, vColumns);
		// //表格
		deliveryInputTable = new JTable(deliveryInputModel) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTableHeader tableH = deliveryInputTable.getTableHeader();

		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		deliveryInputTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		deliveryInputTable.setShowVerticalLines(false);
		deliveryInputTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(deliveryInputTable);
		deliveryInputTable.setFillsViewportHeight(true);
		this.add(scrollPane);
	}

	private void initImportItemField() {
		// TODO Auto-generated method stub

		transField = new JTextField();
		transField.setPreferredSize(new Dimension(40, 26));

		XLabel idLabel = new XLabel("快递编号：");
		idField = new JTextField();
		idLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField.setPreferredSize(new Dimension(100, 26));
		XLabel dataLabel = new XLabel("入库日期：");
		dataField = new JTextField();
		dataLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dataField.setPreferredSize(new Dimension(100, 26));
		ser = XTimeChooser.getInstance();
		ser.register(dataField);
		timePO = ser.getTimePO();
		dataField.setText(ser.getCurrentTime());
		dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		XLabel idLabelmax = new XLabel("机动区已排到：");
		max = new JTextField();
		idLabelmax.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		max.setPreferredSize(new Dimension(100, 26));

		XButton TransLabel = new XButton("装运方式：");

		XLabel TransBox = new XLabel("");
		TransBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		TransLabel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					showTrans();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		XLabel idLabel4 = new XLabel("区号：");
		idField11 = new JTextField();
		idLabel4.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField11.setPreferredSize(new Dimension(50, 26));
		XLabel idLabel5 = new XLabel("排号：");
		idField22 = new JTextField();
		idLabel5.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField22.setPreferredSize(new Dimension(50, 26));
		XLabel idLabel6 = new XLabel("架号：");
		idField33 = new JTextField();
		idLabel6.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField33.setPreferredSize(new Dimension(50, 26));
		XLabel idLabel7 = new XLabel("位号：");
		idField44 = new JTextField();
		idLabel7.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField44.setPreferredSize(new Dimension(50, 26));

		// XButton addItemButton = new XButton("自动添加");
		// addItemButton.addActionListener(new ActionListener(){
		//
		//
		// public void actionPerformed(ActionEvent arg0) {
		//
		// try {
		// addItem();
		// showEmpty();
		// showmax();
		// } catch (ClassNotFoundException | IOException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// }
		// });

		XButton addItemButton2 = new XButton("添加");
		addItemButton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					addByhand();
					// showEmpty();
					showmax();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		JPanel inputPanel = new JPanel();

		// inputPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(dataLabel);
		inputPanel.add(dataField);
		inputPanel.add(idLabel);
		inputPanel.add(idField);

		inputPanel.add(TransLabel);
		inputPanel.add(transField);
		inputPanel.add(idLabelmax);
		inputPanel.add(max);
		// inputPanel.add(addItemButton);

		JPanel inputPanel1 = new JPanel();
		inputPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel1.add(idLabel4);
		inputPanel1.add(idField11);
		inputPanel1.add(idLabel5);
		inputPanel1.add(idField22);
		inputPanel1.add(idLabel6);
		inputPanel1.add(idField33);
		inputPanel1.add(idLabel7);
		inputPanel1.add(idField44);
		inputPanel1.add(addItemButton2);

		// inputPanel.add(inputPanel2);
		// inputPanel.add(inputPanel1);

		this.add(inputPanel);
		this.add(inputPanel1);

	}

	public void showTrans() throws RemoteException, FileNotFoundException, ClassNotFoundException, IOException {

		try {
			id = Long.parseLong(idField.getText());
		} catch (NumberFormatException e) {
			// 输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		OrderListPO order = null;
		order = od.find(String.valueOf(id));
		WareInListPO pp = wd.find(id);
		if (order == null) {
			JOptionPane.showMessageDialog(null, "快递单号不存在！", "", JOptionPane.ERROR_MESSAGE);

		} else {
			DeliverType type;
			type = order.getWare().gettype();
			if (type.equals(DeliverType.FAST)) {
				transField.setText("飞机");
			}
			if (type.equals(DeliverType.ECO)) {
				transField.setText("火车");
			}
			if (type.equals(DeliverType.STAND)) {
				transField.setText("汽车");
			}
		}

	}

	public void showEmpty() throws ClassNotFoundException, IOException {

	}

	// 手动添加方法实现
	public void addByhand() throws RemoteException, FileNotFoundException, ClassNotFoundException, IOException {

		try {
			id = Long.parseLong(idField.getText());
		} catch (NumberFormatException e) {
			// 输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			qu = Integer.parseInt(idField11.getText());
		} catch (NumberFormatException e) {
			// 输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (qu > 4) {
			JOptionPane.showMessageDialog(null, "超过区最大范围4", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			pai = Integer.parseInt(idField22.getText());
		} catch (NumberFormatException e) {
			// 输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (pai > 4) {
			JOptionPane.showMessageDialog(null, "超过排最大范围4", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			jia = Integer.parseInt(idField33.getText());
		} catch (NumberFormatException e) {
			// 输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (jia > 4) {
			JOptionPane.showMessageDialog(null, "超过架最大范围4", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			wei = Integer.parseInt(idField44.getText());
		} catch (NumberFormatException e) {
			// 输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (wei > 4) {
			JOptionPane.showMessageDialog(null, "超过位最大范围4", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		city = City.toCity(place);

		GaragePlacePO p = new GaragePlacePO(qu, pai, jia, wei);

		// bl.addbyplace(id, timePO, city, transid,p);
		OrderListPO order = null;
		order = od.find(String.valueOf(id));
		WareInListPO pp = wd.find(id);
		if (pp == null) {
			JOptionPane.showMessageDialog(null, "该编号仓库中不存在！", "", JOptionPane.ERROR_MESSAGE);
		}
		if (order != null && pp != null && pp.getState().equals(ListState.SUBMITTED)
				&& !pp.getState().equals(ListState.DRAFT)) {
			Vehicle vehicle1 = null;
			DeliverType type;
			type = order.getWare().gettype();
			if (type.equals(DeliverType.FAST)) {
				vehicle1 = Vehicle.PLANE;
			}
			if (type.equals(DeliverType.ECO)) {
				vehicle1 = Vehicle.TRAIN;
			}
			if (type.equals(DeliverType.STAND)) {
				vehicle1 = Vehicle.CAR;
			}
			boolean contain = bl.addtomotor(id, timePO, city, transid, p, vehicle1);

			// if(!contain){
			// WareInInputVO WareIn = bl.addWareIn(id,timePO, city,transid);
			// }

			// for(int i=0;i<bl.getWareInList().size();i++){
			// WareInListVO list=bl.getWareInList().get(i);
			// deliveryInputModel.addRow(list);
			// WareInView.this.validate();
			// }
			if (contain == false) {
				Garage g = gd.getGarage("TxtData/" + transid + "_motor.txt");
				if (vehicle1.equals(Vehicle.CAR)) {
					String c = ("TxtData/" + transid + ".txt");
					gd.delete(c, id);
				}
				if (vehicle1.equals(Vehicle.TRAIN)) {
					String c = ("TxtData/" + transid + "_train.txt");
					gd.delete(c, id);
				}
				if (vehicle1.equals(Vehicle.PLANE)) {
					String c = ("TxtData/" + transid + "_plane.txt");
					gd.delete(c, id);
				}
				ArrayList<GarageBodyPO> ppp = g.list;
				GarageBodyPO show = ppp.get(ppp.size() - 1);
				WareInListVO list = new WareInListVO(id, timePO, city, p, ListState.SUBMITTED, vehicle1);
				// bl=new WareInBLserviceImpl();

				idField.setText("");
				idField33.setText("");
				idField11.setText("");
				idField22.setText("");
				idField44.setText("");
				dataField.setText(ser.getCurrentTime());
				dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

				deliveryInputModel.addRow(list);
				LogBLService.insert(TimePO.getNowTimePO(),
						bl.getPo().getPermission().toString() + bl.getPo().getUsername() + "进行了库存调整");
			}

			idField.setText("");
			idField33.setText("");
			idField11.setText("");
			idField22.setText("");
			idField44.setText("");
			dataField.setText(ser.getCurrentTime());
			dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

			if (contain == true) {
				JOptionPane.showMessageDialog(null, "当前位置已有货物！", "", JOptionPane.ERROR_MESSAGE);

			}
		}
		if (order == null) {
			JOptionPane.showMessageDialog(null, "快递单号不存在！", "", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void showmax() throws RemoteException, ClassNotFoundException, IOException {// 展示当前仓库最大位置
		ArrayList<GarageBodyPO> list = bl.getMotorplace(transid);
		String output = "";
		if (list.size() != 0) {
			GaragePlacePO place = list.get(list.size() - 1).getPlace();
			output = place.getQu() + "区" + place.getPai() + "排" + place.getJia() + "架" + place.getWei() + "位";
		}
		max.setText(output);

	}

}
