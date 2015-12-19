package ui.page;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.rmi.RemoteException;
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

import bl.warehouse.WareOutBLserviceImpl;
import blservice.warehouseblservice.WareInBLservice;
import blservice.warehouseblservice.WareOutBLservice;
import dataimpl.datafactory.DataFactory;
import dataservice.warehousedataservice.GarageDataSeriaService;
import po.AccountPO;
import po.GaragePlacePO;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import util.City;
import util.ListType;
import util.Vehicle;
import vo.list.WareOutListVO;

public class WareOutView extends JPanel{
	private static final long serialVersionUID = 1L;
	private AccountPO po;
	private WareOutBLservice bl;
	private GarageDataSeriaService gd;
	private JTextField dataField;//修改
	private JTextField idField;
	private JTextField nameField;
    private XLabel transidField;
    private XLabel maxplace;
    private JTextField idField77;
    private JTextField idField11;
    private JTextField idField22;
    private JTextField idField33;
    private JTextField idField44;
    private JTextField maxField;
    private long transcenterid;
	private XTimeChooser ser;
	private DefaultTableModel deliveryInputModel2;
	
	private TimePO timePO;
	private long id;
    private City city;
    private long transid;
    private String vehicle;
    private String place="北京";
    int qu;
    int pai;
    int jia;
    int wei;
    private JComboBox	destinationBox;
    private Vehicle v;
   
    public WareOutView( WareOutBLservice bl ){
		this.setName("出库单输入");
		this.bl=bl;
		this.gd=DataFactory.getGarageData();
		transcenterid=Long.parseLong(bl.getPo().getStaff().getOrgid());
//		transcenterid=Long.parseLong(bl.getPo().getStaff().getOrgid());
		//初始化快件信息输入界面
		initImportItemField();
		initTable();
		//初始化快件列表界面
		
		
		//初始化

		this.validate();
	}
	private void initImportItemField(){
		// TODO Auto-generated method stub
		XLabel transidLabel=new XLabel("中转中心编号：");
	
		transidField=new XLabel(" 4");
		transidLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		transidField.setPreferredSize(new Dimension(100,10));
		
		maxField=new JTextField();
		maxField.setPreferredSize(new Dimension(100,26));
			maxplace=new XLabel("中转单编号");
		XLabel idLabel = new XLabel("快递编号：");
		idField =new  JTextField();
		idLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField.setPreferredSize(new Dimension(100,26));
		XLabel dataLabel = new XLabel("出库日期：");
		dataField =new  JTextField();
		dataLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dataField.setPreferredSize(new Dimension(100,26));
		ser = XTimeChooser.getInstance();
		ser.register(dataField);
		timePO=ser.getTimePO();
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
		
		
		vehicle="火车";
		XLabel destinationLabel3 = new XLabel("装运方式：");
		destinationLabel3.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		JComboBox destinationBox3 = new JComboBox();
        destinationBox3.addItem("火车");
		destinationBox3.addItem("汽车");
		destinationBox3.addItem("飞机");
		destinationBox3.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		destinationBox3.addItemListener(new ItemListener(){
		public void actionPerformed2(ActionEvent arg0) {
			
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getStateChange()==ItemEvent.SELECTED){
				vehicle=(String)destinationBox3.getSelectedItem();
			}
		}
	});
	
	destinationBox.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent evt) {
			if (evt.getStateChange() == ItemEvent.SELECTED) {
				place = (String) destinationBox.getSelectedItem();
			}
			
		}
	});
		
		
		XButton addItemButton = new XButton("提交");
		addItemButton.addActionListener(new ActionListener(){
		
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					submit();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		destinationBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					place = (String) destinationBox.getSelectedItem();
				}
				
			}
		});
		
			JPanel inputPanel = new JPanel();
		JPanel inputPanel2=new JPanel();
		//inputPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(dataLabel);
		inputPanel.add(dataField);
		inputPanel.add(idLabel);
		inputPanel.add(idField);
		inputPanel.add(destinationLabel);
		inputPanel.add(destinationBox);
		inputPanel.add(destinationLabel3);
		inputPanel.add(destinationBox3);
		inputPanel.add(maxplace);
		inputPanel.add(maxField);
	
		inputPanel.add(addItemButton);
		add(inputPanel,BorderLayout.NORTH);
	
		
		
	}
	
	private void initTable(){
		JScrollPane scrollPane2 = new JScrollPane();
		Vector<String> vColumns2 = new Vector<String>();
	    
		
	    vColumns2.add("快递编号");
		vColumns2.add("出库日期");
		vColumns2.add("装运形式");
		vColumns2.add("目的地");
		vColumns2.add("中转单编号");

		   Vector<String> vData2 = new Vector<String>();
		
		   
//			//模型
		    deliveryInputModel2 = new DefaultTableModel(vData2, vColumns2);
//		//表格
		   JTable deliveryInputTable2 = new JTable(deliveryInputModel2){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		 JTableHeader tableH2=deliveryInputTable2.getTableHeader();

//		 tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		 tableH2.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		 tableH2.setFont(XContorlUtil.FONT_14_BOLD);
		 deliveryInputTable2.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 deliveryInputTable2.setShowVerticalLines(false);
		 deliveryInputTable2.setShowHorizontalLines(false);
		scrollPane2.getViewport().add(deliveryInputTable2);
		deliveryInputTable2.setFillsViewportHeight(true);
		this.add(scrollPane2);
		
}
	
	public void deletefromGarage(long ID) throws RemoteException, ClassNotFoundException, IOException{
		String address="TxtData/"+transcenterid+""+".txt";
		gd.delete(address, ID);
	}
	
	public GaragePlacePO getplacefromGarage(long ID)throws RemoteException, ClassNotFoundException, IOException{
		String address="TxtData/"+transcenterid+""+".txt";
		GaragePlacePO p=gd.find(address, ID);
		return p;
	}
	
	public void submit() throws RemoteException, ClassNotFoundException, IOException{
		
		try
		{
			id=Long.parseLong(idField.getText());
		}
		catch(NumberFormatException e){
			//输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
//		System.out.println(place);
		city=City.toCity(place);
//		System.out.println(id);
		v=Vehicle.toVehicle(vehicle);
//		System.out.println(maxField.getText());
		try
		{
			transid=Long.parseLong(maxField.getText());
		}
		catch(NumberFormatException e){
			//输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
	if(bl.findWareIn(id)==true){
		
//	TimePO	time =new TimePO(1,2,3,4,5,6);
		GaragePlacePO place=getplacefromGarage(id);
		bl.addWareOut(id,timePO,city,v,transid,place);
		WareOutListVO vo;
		vo=bl.getWareOut().get(bl.getWareOut().size()-1);
		deletefromGarage(id);
		idField.setText(" ");
		maxField.setText(" ");
		
		deliveryInputModel2.addRow(vo);
		WareOutView.this.validate();
	}
	else{
		JOptionPane.showMessageDialog(null, "对应入库单不存在或已出库","", JOptionPane.ERROR_MESSAGE);
		idField.setText(" ");
		maxField.setText(" ");
	}

		
	}
//public static void main(String[] args) throws InterruptedException{
//	WareOutView wv=new WareOutView();
//	TimePO	time =new TimePO(1,2,3,4,5,6);
//wv.test();
//}
	 
	
	}

