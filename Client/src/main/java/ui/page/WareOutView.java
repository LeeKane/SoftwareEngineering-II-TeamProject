package ui.page;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import blservice.warehouseblservice.WareInBLservice;
import blservice.warehouseblservice.WareOutBLservice;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import util.City;
import util.ListType;
import util.Vehicle;

public class WareOutView extends JPanel{
	private static final long serialVersionUID = 1L;
	private WareInBLservice bl;

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
	private XTimeChooser ser;
	 DefaultTableModel deliveryInputModel2 ;
	private DefaultTableModel deliveryInputModel;
	private JTable deliveryInputTable;
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
    private WareOutBLservice wl;
    private Vehicle v;
   
    public WareOutView(  ){
		this.setName("出库单输入");
		this.wl=wl;
		
		//初始化快件信息输入界面
		initImportItemField();
		
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
				submit();
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
	
	  
		inputPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel2.add(maxplace);
		inputPanel2.add(maxField);
		inputPanel2.add(addItemButton);
		add(inputPanel,BorderLayout.NORTH);
		add(inputPanel2);
		
		
	}
	
	public void submit(){
		id=Long.parseLong(idField.getText());
		System.out.println(place);
		city=City.toCity(place);
		System.out.println(id);
//		v=Vehicle.toVehicle(vehicle);
		System.out.println(maxField.getText());
		transid=Long.parseLong(maxField.getText());
		wl.addWareOut(746413,timePO,city,Vehicle.PLANE,4567);
		
	}

	 
	
	}

