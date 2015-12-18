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
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import blservice.warehouseblservice.WareInBLservice;
import blservice.warehouseblservice.WareOutBLservice;
import dataimpl.datafactory.DataFactory;
import dataservice.warehousedataservice.GarageDataSeriaService;
import po.AccountPO;
import po.GarageBodyPO;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import util.City;
import util.Vehicle;
import vo.WareShowVO;
import vo.list.WareOutListVO;

public class WareShowView extends JPanel{
	private static final long serialVersionUID = 1L;
	private AccountPO po;

	private WareOutBLservice bl;
	private GarageDataSeriaService gd;
	private JTextField dataField;//修改
	private JTextField dataField2;
	private JTextField idField;
	private JTextField nameField;
    private XLabel transidField;
    private XLabel maxplace;
  private XLabel InNums;
  private JTextField Inshow;
  private XLabel OutNums;
  private JTextField Outshow;
    private JTextField maxField;
    private long transcenterid;
	private XTimeChooser ser;
	private XTimeChooser ser2;
	private DefaultTableModel deliveryInputModel2;
	
	private TimePO timePO;
	private TimePO timePO2;
	private long id;
    private City city;
    private long transid;
    private String vehicle;
    private String place="北京";
    int qu;
    int pai;
    int jia;
    int wei;
    private int num1;
    private ArrayList<GarageBodyPO>list;
    private Vehicle v;
   
    public WareShowView( WareOutBLservice bl ){
		this.setName("库存查看");
		this.bl=bl;
		
		this.gd=DataFactory.getGarageData();
		this.list=new ArrayList<GarageBodyPO>();
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
		
		XLabel dataLabel = new XLabel("开始时间：");
		dataField =new  JTextField();
		dataLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dataField.setPreferredSize(new Dimension(100,26));
		ser = XTimeChooser.getInstance();
		ser.register(dataField);
		timePO=ser.getTimePO();
		dataField.setText(ser.getCurrentTime());
		dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		
	
		XLabel dataLabel2 = new XLabel("结束时间：");
		dataField2 =new  JTextField();
		dataLabel2.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dataField2.setPreferredSize(new Dimension(100,26));
		ser2 = XTimeChooser.getInstance();
		ser2.register(dataField);
		timePO2=ser.getTimePO();
		dataField2.setText(ser.getCurrentTime());
		dataField2.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		
	InNums= new XLabel("入库数量：");
		 Inshow = new  JTextField();
		InNums.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		Inshow.setPreferredSize(new Dimension(50,26));
		 OutNums = new XLabel("出库数量：");
		 Outshow = new  JTextField();
		OutNums.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		Outshow.setPreferredSize(new Dimension(50,26));
		
		
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
		
		
		
			JPanel inputPanel = new JPanel();
		JPanel inputPanel2=new JPanel();
		//inputPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(dataLabel);
		inputPanel.add(dataField);
		inputPanel.add(dataLabel2);
		inputPanel.add(dataField2);

	inputPanel.add(addItemButton);
		add(inputPanel,BorderLayout.NORTH);
		inputPanel.add(InNums);
		inputPanel.add(Inshow);
		inputPanel.add(OutNums);
		inputPanel.add(Outshow);
		
		
	}
	
	private void initTable(){
		JScrollPane scrollPane2 = new JScrollPane();
		Vector<String> vColumns2 = new Vector<String>();
	    
		
	    vColumns2.add("快递编号");
		vColumns2.add("入库日期");
		vColumns2.add("区号");
		vColumns2.add("排号");
		vColumns2.add("位号");
		vColumns2.add("架号");

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
	
	public void submit() throws RemoteException, ClassNotFoundException, IOException{
		
//		3:2015-12-17-17-57-55:北京:1-1-1-3:未审批:1100
		TimePO start=new TimePO(2015,12,17,17,0,0);
		TimePO end=new TimePO(2015,12,17,20,0,0);
		
		WareShowVO show;
	list=bl.getWareIn(start, end);
		for(int i=0;i<list.size();i++){
			show=new WareShowVO(list.get(i).getItem().getId(),list.get(i).getItem().getTime(),list.get(i).getPlace().getQu(),list.get(i).getPlace().getPai(),list.get(i).getPlace().getJia(),list.get(i).getPlace().getWei());
			deliveryInputModel2.addRow(show);
			WareShowView.this.validate();
		}
	
		
//	TimePO	time =new TimePO(1,2,3,4,5,6);
		
		
	
	

		
	}
//public static void main(String[] args) throws InterruptedException{
//	WareOutView wv=new WareOutView();
//	TimePO	time =new TimePO(1,2,3,4,5,6);
//wv.test();
//}
	 
}
