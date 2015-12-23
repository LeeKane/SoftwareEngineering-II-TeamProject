package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import bl.warehouse.WareInBLserviceImpl;
import blservice.warehouseblservice.WareInBLservice;
import dataimpl.datafactory.DataFactory;
import dataservice.listdataservice.OrderListDataService;
import dataservice.listdataservice.WareInListDataService;
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
import util.Vehicle;
import vo.GaragePlaceVO;
import vo.GaragePlaceVehicleVO;
import vo.WareInInputVO;
import vo.list.WareInListVO;

public class WareInView extends JPanel {
	private static final long serialVersionUID = 1L;
	private WareInBLservice bl;
	private WareInListDataService wd;
    private OrderListDataService od;
	private JTextField dataField;// 修改
	private JTextField idField;
	private JTextField nameField;
	private XLabel transidField;
	private XLabel maxplace;
	private XLabel car;
	private XLabel train;
	private XLabel plane;
	private JTextField idField77;
	private JTextField idField11;
	private JTextField idField22;
	private JTextField idField33;
	private JTextField idField44;
	private JTextField idField55;
   private JTextField transField;
	private JTextField percentField;

	private JTextField maxField;
	private XTimeChooser ser;
	DefaultTableModel deliveryInputModel2;
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
	private String vehicle="汽车";
	private JComboBox destinationBox;

	public WareInView(WareInBLservice bl) {
		this.setName("入库单输入");
this.od=DataFactory.getWareData2();
this.wd=DataFactory.getWareInData();
		this.bl = bl;
		transid = Long.parseLong(bl.getPo().getStaff().getOrgid());
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// 初始化快件信息输入界面
		initImportItemField();

		// 初始化快件列表界面
		initWareListTable();
		initNullListTable();

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

	private void initNullListTable() {
		JScrollPane scrollPane2 = new JScrollPane();
		Vector<String> vColumns2 = new Vector<String>();

		vColumns2.add("区号");
		vColumns2.add("排号");
		vColumns2.add("架号");
		vColumns2.add("位号");
		vColumns2.add("货运区");
		Vector<String> vData2 = new Vector<String>();

		// //模型
		deliveryInputModel2 = new DefaultTableModel(vData2, vColumns2);
		// //表格
		JTable deliveryInputTable2 = new JTable(deliveryInputModel2) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JTableHeader tableH2 = deliveryInputTable2.getTableHeader();

		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH2.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH2.setFont(XContorlUtil.FONT_14_BOLD);
		deliveryInputTable2.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		deliveryInputTable2.setShowVerticalLines(false);
		deliveryInputTable2.setShowHorizontalLines(false);
		scrollPane2.getViewport().add(deliveryInputTable2);
		deliveryInputTable2.setFillsViewportHeight(true);
		this.add(scrollPane2);

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
		vColumns.add("货运区");
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
		XLabel transidLabel = new XLabel("中转中心编号：");
		System.out.println(bl.getPo().getStaff().getOrgid());
		transidField = new XLabel(bl.getPo().getStaff().getOrgid());
		transidLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		transidField.setPreferredSize(new Dimension(100, 10));

		maxField = new JTextField();
		maxField.setPreferredSize(new Dimension(500, 26));
		maxplace = new XLabel("库末位置：");
		maxplace.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		
		transField = new JTextField();
		transField.setPreferredSize(new Dimension(40, 26));
		
		XLabel car = new XLabel("");
	car.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
	XLabel train = new XLabel("");
	train.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
	XLabel plane = new XLabel("");
	plane.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		
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

		XLabel destinationLabel = new XLabel("目的地：");
		destinationLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		destinationBox = new JComboBox();
		destinationBox.addItem("北京");
		destinationBox.addItem("南京");
		destinationBox.addItem("广州");
		destinationBox.addItem("上海");
		destinationBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		
		
		XButton TransLabel = new XButton("装运方式");
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
		XLabel idLabel2 = new XLabel("快递编号：");
		JTextField idField2 = new JTextField();
		idLabel2.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField2.setPreferredSize(new Dimension(100, 26));

		XLabel percent = new XLabel("库存比例：");
		JTextField percentField = new JTextField();
		percent.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		percentField.setPreferredSize(new Dimension(50, 26));

		XLabel dataLabel2 = new XLabel("入库日期：");
		JTextField dataField2 = new JTextField();
		dataLabel2.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dataField2.setPreferredSize(new Dimension(100, 26));
		ser = XTimeChooser.getInstance();
		ser.register(dataField2);
		TimePO timePO2 = ser.getTimePO();
		dataField2.setText(ser.getCurrentTime());
		dataField2.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		XLabel destinationLabel2 = new XLabel("目的地：");
		destinationLabel2.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		JComboBox destinationBox2 = new JComboBox();
		destinationBox2.addItem("北京");
		destinationBox2.addItem("南京");
		destinationBox2.addItem("广州");
		destinationBox2.addItem("上海");
		destinationBox2.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

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

		XLabel idLabel55 = new XLabel("库存比例：");
		idField55 = new JTextField();
		idLabel55.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField55.setPreferredSize(new Dimension(200, 26));

		XLabel idLabel10 = new XLabel("中转中心编号：");// 展示空位的中转中心编号输入
		idField77 = new JTextField();
		idLabel10.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField77.setPreferredSize(new Dimension(100, 26));

		destinationBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					place = (String) destinationBox.getSelectedItem();
				}

			}
		});

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
					showEmpty();
					showmax();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		JPanel inputPanel = new JPanel();
		JPanel inputPanel1 = new JPanel();

		// inputPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(dataLabel);
		inputPanel.add(dataField);
		inputPanel.add(idLabel);
		inputPanel.add(idField);
		inputPanel.add(destinationLabel);
		inputPanel.add(destinationBox);
		inputPanel.add(TransLabel);
		inputPanel.add(transField);
		inputPanel.add(idLabel55);
		inputPanel.add(idField55);
		// inputPanel.add(addItemButton);

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
		inputPanel1.add(maxplace);
		inputPanel1.add(maxField);
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
		OrderListPO order=null;
		order=od.find(String.valueOf(id));
		WareInListPO pp=wd.find(id);
		if(order==null){
			JOptionPane.showMessageDialog(null, "快递单号不存在！", "", JOptionPane.ERROR_MESSAGE);

		}else{
			DeliverType type;
			type=order.getWare().gettype();
			if(type.equals(DeliverType.FAST)){
				transField.setText("飞机");
			}if(type.equals(DeliverType.ECO)){
				transField.setText("火车");
			}if(type.equals(DeliverType.STAND)){
				transField.setText("汽车");
			}
		}
		
	}

	public void showEmpty() throws ClassNotFoundException, IOException {
		while (deliveryInputModel2.getRowCount() > 0) {
			deliveryInputModel2.removeRow(deliveryInputModel2.getRowCount() - 1);
		}

		ArrayList<GaragePlacePO> po = bl.getnullplace(transid);
		ArrayList<GaragePlacePO>poplane=bl.getnullplaceplane(transid);
ArrayList<GaragePlacePO> potrain=bl.getnullplacetrain(transid);
for (int i = 0; i < po.size(); i++) {
			GaragePlacePO p = po.get(i);
			GaragePlaceVehicleVO v = new GaragePlaceVehicleVO(p.getQu(), p.getPai(), p.getJia(), p.getWei(),Vehicle.CAR);

			deliveryInputModel2.addRow(v);
			WareInView.this.validate();
		}
for(int i=0;i<potrain.size();i++){
	GaragePlacePO p = potrain.get(i);
	GaragePlaceVehicleVO v = new GaragePlaceVehicleVO(p.getQu(), p.getPai(), p.getJia(), p.getWei(),Vehicle.TRAIN);

	deliveryInputModel2.addRow(v);
	WareInView.this.validate();
}
for(int i=0;i<poplane.size();i++){
	GaragePlacePO p = poplane.get(i);
	GaragePlaceVehicleVO v = new GaragePlaceVehicleVO(p.getQu(), p.getPai(), p.getJia(), p.getWei(),Vehicle.PLANE);

	deliveryInputModel2.addRow(v);
	WareInView.this.validate();
}

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
		if(qu>4){
			JOptionPane.showMessageDialog(null, "超过区最大范围4", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			pai = Integer.parseInt(idField22.getText());
		} catch (NumberFormatException e) {
			// 输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
			return;
		}if(pai>4){
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
		if(jia>4){
			JOptionPane.showMessageDialog(null, "超过架最大范围4", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			wei = Integer.parseInt(idField44.getText());
		} catch (NumberFormatException e) {
			// 输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
			return;
		}if(wei>4){
			JOptionPane.showMessageDialog(null, "超过位最大范围4", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		city = City.toCity(place);
        
        
		GaragePlacePO p = new GaragePlacePO(qu, pai, jia, wei);
	
		// bl.addbyplace(id, timePO, city, transid,p);
		OrderListPO order=null;
		order=od.find(String.valueOf(id));
		WareInListPO pp=wd.find(id);
		if(pp!=null){
			JOptionPane.showMessageDialog(null, "该编号已入库！", "", JOptionPane.ERROR_MESSAGE);
		}
		if(order!=null&&pp==null){
			Vehicle vehicle1 = null;
			DeliverType type;
			type=order.getWare().gettype();
			if(type.equals(DeliverType.FAST)){
				vehicle1=Vehicle.PLANE;
			}if(type.equals(DeliverType.ECO)){
				vehicle1=Vehicle.TRAIN;
			}if(type.equals(DeliverType.STAND)){
				vehicle1=Vehicle.CAR;
			}
		boolean contain = bl.addbyplace(id, timePO, city, transid, p,vehicle1);

		// if(!contain){
		// WareInInputVO WareIn = bl.addWareIn(id,timePO, city,transid);
		// }

		// for(int i=0;i<bl.getWareInList().size();i++){
		// WareInListVO list=bl.getWareInList().get(i);
		// deliveryInputModel.addRow(list);
		// WareInView.this.validate();
		// }
		if (contain == false && bl.getWareInList().size() >= 1&&vehicle1.equals(Vehicle.CAR)) {
			WareInListVO list = bl.getWareInList().get(bl.getWareInList().size() - 1);
           
			// bl=new WareInBLserviceImpl();

			idField.setText("");
			idField33.setText("");
			idField11.setText("");
			idField22.setText("");
			idField44.setText("");
			dataField.setText(ser.getCurrentTime());
			dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
			destinationBox.setToolTipText("");
			deliveryInputModel.addRow(list);
			WareInView.this.validate();
		}
		if (contain == false && bl.getPlaneInList().size() >= 1&&vehicle1.equals(Vehicle.PLANE)) {
			WareInListVO list = bl.getPlaneInList().get(bl.getPlaneInList().size() - 1);
           
			// bl=new WareInBLserviceImpl();

			idField.setText("");
			idField33.setText("");
			idField11.setText("");
			idField22.setText("");
			idField44.setText("");
			dataField.setText(ser.getCurrentTime());
			dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
			destinationBox.setToolTipText("");
			deliveryInputModel.addRow(list);
			WareInView.this.validate();
		}
		
		
		
		if (contain == false && bl.getTrainInList().size() >= 1&&vehicle1.equals(Vehicle.TRAIN)) {
			WareInListVO list = bl.getTrainInList().get(bl.getTrainInList().size() - 1);
           
			// bl=new WareInBLserviceImpl();

			idField.setText("");
			idField33.setText("");
			idField11.setText("");
			idField22.setText("");
			idField44.setText("");
			dataField.setText(ser.getCurrentTime());
			dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
			destinationBox.setToolTipText("");
			deliveryInputModel.addRow(list);
			WareInView.this.validate();
		}
		
		

		idField.setText("");
		idField33.setText("");
		idField11.setText("");
		idField22.setText("");
		idField44.setText("");
		dataField.setText(ser.getCurrentTime());
		dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		destinationBox.setToolTipText("");
		if (contain == true) {
			JOptionPane.showMessageDialog(null, "当前位置已有货物！", "", JOptionPane.ERROR_MESSAGE);

		}
		}
		if(order==null){
			JOptionPane.showMessageDialog(null, "快递单号不存在！", "", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void showmax() throws RemoteException, ClassNotFoundException, IOException {// 展示当前仓库最大位置
		ArrayList<GarageBodyPO> list = bl.getPlace(transid);
		ArrayList<GarageBodyPO> trainlist=bl.getTrainPlace(transid);
		ArrayList<GarageBodyPO>planelist=bl.getPlanePlace(transid);
		String output="";
		String output2="";
		String output3="";
		
		if (list.size() != 0) {
			GaragePlacePO place = list.get(list.size() - 1).getPlace();
			 output = "当前汽运区库末位置" + place.getQu() + "区" + place.getPai() + "排" + place.getJia() + "架"
					+ place.getWei() + "位";
		}
		if(trainlist.size()!=0){
				GaragePlacePO place2 = trainlist.get(trainlist.size() - 1).getPlace();
				 output2= "当前火车区库末位置" + place2.getQu() + "区" + place2.getPai() + "排" + place2.getJia() + "架"
						+ place2.getWei() + "位";
				
			}
			if(planelist.size()!=0){
				GaragePlacePO place2 = planelist.get(planelist.size() - 1).getPlace();
				 output3= "当前飞机区库末位置" + place2.getQu() + "区" + place2.getPai() + "排" + place2.getJia() + "架"
						+ place2.getWei() + "位";
			}
			output=output+output2+output3;
			System.out.println(output);
			maxField.setText(output);

			String outpu = bl.getPercent(transid);
			String outpu1=bl.getTrainPercent(transid);
			String outpu2=bl.getPlanePercent(transid);
			String result=outpu+outpu1+outpu2;
			idField55.setText(result);
			System.out.println(result);
			if(outpu==null){
				JOptionPane.showMessageDialog(null, "汽运区库存高于警戒比例", "", JOptionPane.ERROR_MESSAGE);
			}
			if(outpu1==null){
				JOptionPane.showMessageDialog(null, "火车区库存高于警戒比例", "", JOptionPane.ERROR_MESSAGE);
			}
			if(outpu2==null){
				JOptionPane.showMessageDialog(null, "航运库存高于警戒比例", "", JOptionPane.ERROR_MESSAGE);
			}
			
			
			
		}

	


}
