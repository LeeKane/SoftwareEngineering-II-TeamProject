package ui.page;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.IOException;
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

import bl.warehouse.WareInBLserviceImpl;
import blservice.warehouseblservice.WareInBLservice;
import po.GaragePlacePO;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import util.City;
import vo.GaragePlaceVO;
import vo.WareInInputVO;
import vo.list.WareInListVO;

public class WareInView extends JPanel {
	private static final long serialVersionUID = 1L;
	private WareInBLservice bl;

	private JTextField dataField;//修改
	private JTextField idField;
	private JTextField nameField;
    private JTextField transidField;
    private JTextField idField77;
    private JTextField idField11;
    private JTextField idField22;
    private JTextField idField33;
    private JTextField idField44;
	private XTimeChooser ser;
	 DefaultTableModel deliveryInputModel2 ;
	private DefaultTableModel deliveryInputModel;
	private JTable deliveryInputTable;
	private TimePO timePO;
	private long id;
    private City city;
    private long transid;
    private String place="北京";
    int qu;
    int pai;
    int jia;
    int wei;
    private JComboBox	destinationBox;
	public WareInView(){
	WareInBLservice	 bl=new WareInBLserviceImpl();
		this.setName("入库单输入");
		
		this.bl = bl;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//初始化快件信息输入界面
		initImportItemField();
		
		//初始化快件列表界面
		initWareListTable();
		initNullListTable();
		
		//初始化提交进货单按钮
		initSubmitButton();
		
		this.validate();
	}
	private void initSubmitButton() {
	
	}
	
	private void initNullListTable(){
		JScrollPane scrollPane2 = new JScrollPane();
		Vector<String> vColumns2 = new Vector<String>();
	
		
		
		vColumns2.add("区号");
		vColumns2.add("排号");
		vColumns2.add("架号");
		vColumns2.add("位号");

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
	private void initWareListTable() {//快递编号、入库日期、目的地、区号、排号、架号、位号
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
		  
		   
//			//模型
		   deliveryInputModel = new DefaultTableModel(vData, vColumns);
//		//表格
		   deliveryInputTable = new JTable(deliveryInputModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		 JTableHeader tableH=deliveryInputTable.getTableHeader();

//		 tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		 tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		 tableH.setFont(XContorlUtil.FONT_14_BOLD);
		 deliveryInputTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 deliveryInputTable.setShowVerticalLines(false);
		 deliveryInputTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(deliveryInputTable);
		deliveryInputTable.setFillsViewportHeight(true);
		this.add(scrollPane);
	}
	private void initImportItemField(){
		// TODO Auto-generated method stub
		XLabel transidLabel=new XLabel("中转中心编号：");
		transidField=new JTextField();
		transidLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		transidField.setPreferredSize(new Dimension(100,10));
		
		XLabel idLabel = new XLabel("快递编号：");
		idField =new  JTextField();
		idLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField.setPreferredSize(new Dimension(100,26));
		XLabel dataLabel = new XLabel("入库日期：");
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
		
		
		XLabel transidLabel2=new XLabel("中转中心编号：");
		transidField=new JTextField();
		transidLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		transidField.setPreferredSize(new Dimension(100,26));
		
		
		
		XLabel idLabel2 = new XLabel("快递编号：");
		JTextField idField2 = new  JTextField();
		idLabel2.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField2.setPreferredSize(new Dimension(100,26));
		
		
		XLabel dataLabel2 = new XLabel("入库日期：");
		JTextField dataField2 = new  JTextField();
		dataLabel2.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dataField2.setPreferredSize(new Dimension(100,26));
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
		XLabel transidLabel3=new XLabel("中转中心编号：");
		JTextField transidField2 = new JTextField();
		transidLabel3.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		transidField2.setPreferredSize(new Dimension(100,26));
		XLabel idLabel4= new XLabel("区号：");
		 idField11 = new  JTextField();
		idLabel4.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField11.setPreferredSize(new Dimension(50,26));
		XLabel idLabel5 = new XLabel("排号：");
		 idField22 = new  JTextField();
		idLabel5.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField22.setPreferredSize(new Dimension(50,26));
		XLabel idLabel6 = new XLabel("架号：");
		 idField33 = new  JTextField();
		idLabel6.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField33.setPreferredSize(new Dimension(50,26));
		XLabel idLabel7 = new XLabel("位号：");
		 idField44 = new  JTextField();
		idLabel7.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField44.setPreferredSize(new Dimension(50,26));
		
		XLabel idLabel10= new XLabel("中转中心编号：");//展示空位的中转中心编号输入
		 idField77 = new  JTextField();
		idLabel10.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField77.setPreferredSize(new Dimension(100,26));
		
		destinationBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					place = (String) destinationBox.getSelectedItem();
				}
				
			}
		});
		
		XButton addItemButton = new XButton("自动添加");
		addItemButton.addActionListener(new ActionListener(){
		
			
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			
			}
		});
		
		XButton addItemButton2 = new XButton("手动添加");
		addItemButton2.addActionListener(new ActionListener(){
		
			
			public void actionPerformed(ActionEvent arg0) {
			try {
				addByhand();
				showEmpty();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		});

		XButton addItemButton3 = new XButton("空位展示");
		addItemButton3.addActionListener(new ActionListener(){
		
			
			public void actionPerformed(ActionEvent arg0) {
			try {
				showEmpty();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		});
		
		
		JPanel inputPanel = new JPanel();
		JPanel inputPanel1 = new JPanel();
	     
		//inputPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(dataLabel);
		inputPanel.add(dataField);
		inputPanel.add(transidLabel);
		inputPanel.add(transidField);
		inputPanel.add(idLabel);
		inputPanel.add(idField);
		inputPanel.add(destinationLabel);
		inputPanel.add(destinationBox);
		inputPanel.add(addItemButton);

		inputPanel.add(dataLabel2);
		inputPanel.add(dataField2);
		inputPanel.add(transidLabel3);
		inputPanel.add(transidField2);
		inputPanel.add(idLabel2);
		inputPanel.add(idField2);
		inputPanel.add(destinationLabel2);
		inputPanel.add(destinationBox2);
        inputPanel1.add(idLabel10);
        inputPanel1.add(idField77);
		inputPanel1.add(addItemButton3);
		
		inputPanel1.add(idLabel4);
		inputPanel1.add(idField11);
		inputPanel1.add(idLabel5);
		inputPanel1.add(idField22);
		inputPanel1.add(idLabel6);
		inputPanel1.add(idField33);
		inputPanel1.add(idLabel7);
		inputPanel1.add(idField44);
		inputPanel1.add(addItemButton2);
		//inputPanel.add(inputPanel2);
		//inputPanel.add(inputPanel1);
		
		this.add(inputPanel);
		this.add(inputPanel1);
		
	}
	
	
	public void showEmpty() throws ClassNotFoundException, IOException{
		while(deliveryInputModel2.getRowCount()>0){
			deliveryInputModel2.removeRow(deliveryInputModel2.getRowCount()-1);
			}
		long id2=Long.parseLong(idField77.getText());
	ArrayList<GaragePlacePO> po=bl.getnullplace(10086);
System.out.println(po.size());

	for(int i=0;i<po.size();i++){
		GaragePlacePO p=po.get(i);
		GaragePlaceVO v=new GaragePlaceVO(p.getQu(),p.getPai(),p.getJia(),p.getWei());
		p.showplace();
		deliveryInputModel2.addRow(v);
		WareInView.this.validate();
	}
		
	}
	//手动添加方法实现
	public void addByhand() throws FileNotFoundException, ClassNotFoundException, IOException{
		try
		{
			id=Long.parseLong(idField.getText());
		}
		catch(NumberFormatException e){
			//输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try
		{
			 transid=Long.parseLong(transidField.getText());
		}
		catch(NumberFormatException e){
			//输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try
		{
			 qu=Integer.parseInt(idField11.getText());
		}
		catch(NumberFormatException e){
			//输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try
		{
			 pai=Integer.parseInt(idField22.getText());
		}
		catch(NumberFormatException e){
			//输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try
		{
			 jia=Integer.parseInt(idField33.getText());
		}
		catch(NumberFormatException e){
			//输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try
		{
			 wei=Integer.parseInt(idField44.getText());
		}
		catch(NumberFormatException e){
			//输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		city=City.toCity(place);
		WareInInputVO WareIn = bl.addWareIn(id,timePO, city,transid);
	
	
		GaragePlacePO p=new GaragePlacePO(qu,pai,jia,wei);
		System.out.println(qu+pai+jia+wei);
		bl.addbyplace(id, timePO, city, transid,p);
		WareInListVO list=bl.getWareInList().get(bl.getWareInList().size()-1);
	
		bl=new WareInBLserviceImpl();
		
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
	
	
	protected void addItem() {
		// TODO Auto-generated method stub
		try
		{
			id=Long.parseLong(idField.getText());
		}
		catch(NumberFormatException e){
			//输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try
		{
			 transid=Long.parseLong(transidField.getText());
		}
		catch(NumberFormatException e){
			//输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入","", JOptionPane.ERROR_MESSAGE);
			return;
		}
	city=City.toCity(place);
	
		
		WareInInputVO WareIn = bl.addWareIn(id,timePO, city,transid);//提交
		try {
			bl.submitWareIn();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WareInListVO list=bl.getWareInList().get(bl.getWareInList().size()-1);
		bl=new WareInBLserviceImpl();
		
		idField.setText("");
		dataField.setText(ser.getCurrentTime());
		dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		destinationBox.setToolTipText("");
		deliveryInputModel.addRow(list);
		
		WareInView.this.validate();
	}
}
