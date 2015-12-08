package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import bl.list.OrdersInputBL;
import blservice.listblservice.OrdersInputBLService;
import blservice.listblservice.delivery_HallBLService;
import po.AccountPO;
import po.TimePO;
import po.WarePO;
import po.list.OrderListPO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import vo.list.DeliveryListVO;



public class deliveryview_Hall extends JPanel{
private static final long serialVersionUID = 1L;
private delivery_HallBLService bl;

private JTextField dataField;//修改
private JTextField idField;
private JTextField nameField;

private XTimeChooser ser;

private DefaultTableModel deliveryInputModel;
private JTable deliveryInputTable;
private TimePO timePO;
private long id;
private AccountPO po;

public deliveryview_Hall(delivery_HallBLService bl){
	this.setName("派件");
	this.po=bl.getPo();
	this.bl = bl;
	this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	
	//初始化快件信息输入界面
	initImportItemField();
	
	//初始化快件列表界面
	initWareListTable();
	
	//初始化提交进货单按钮
	initSubmitButton();
	
	this.validate();
}
private void initSubmitButton() {
	// TODO Auto-generated method stub
	XButton submitButton = new XButton("提交");
	submitButton.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			boolean result = bl.submit();
			if(result == true){
				JOptionPane.showMessageDialog(null, "提交成功！","", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "提交失败！","", JOptionPane.ERROR_MESSAGE);
			}
		}			
	});
	JPanel submitPanel = new JPanel();
	//submitPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
	submitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
	submitPanel.add(submitButton);
	this.add(submitPanel);
}
private void initWareListTable() {
	// TODO Auto-generated method stub
	JScrollPane scrollPane = new JScrollPane();
	Vector<String> vColumns = new Vector<String>();
	vColumns.add("到达日期");
	vColumns.add("订单条形码号");
	vColumns.add("派送员");

	   Vector<DeliveryListVO> vData = new Vector<DeliveryListVO>();
	   
//		//模型
	   deliveryInputModel = new DefaultTableModel(vData, vColumns);
//	//表格
	   deliveryInputTable = new JTable(deliveryInputModel){
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column){
			return false;
		}
	};
	 JTableHeader tableH=deliveryInputTable.getTableHeader();

//	 tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
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
	XLabel idLabel = new XLabel("订单条形码号：");
	idField =new  JTextField();
	idLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
	idField.setPreferredSize(new Dimension(100,26));
	XLabel dataLabel = new XLabel("达到日期：");
	dataField =new  JTextField();
	dataLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
	dataField.setPreferredSize(new Dimension(200,26));
	ser = XTimeChooser.getInstance();
	ser.register(dataField);
	timePO=ser.getTimePO();
	dataField.setText(ser.getCurrentTime());
	dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
	XLabel nameLabel = new XLabel("派送员：");
	nameField =new  JTextField();
	nameLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
	nameField.setPreferredSize(new Dimension(50,26));
	XButton addItemButton = new XButton("添加");
	addItemButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			addItem();
		}
	});

	
	
	JPanel inputPanel = new JPanel();
	JPanel inputPanel1 = new JPanel();
	//inputPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
	inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	inputPanel.add(dataLabel);
	inputPanel.add(dataField);
	inputPanel.add(idLabel);
	inputPanel.add(idField);
	inputPanel.add(nameLabel);
	inputPanel.add(nameField);
	inputPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
	
	inputPanel1.add(addItemButton);
	
	this.add(inputPanel);
	this.add(inputPanel1);
	
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
	String name=nameField.getText();
	OrdersInputBLService obl=new OrdersInputBL(po);
	OrderListPO order=obl.find(id+"");
	WarePO ware=order.getWare();
	DeliveryListVO DeliveryList = bl.addware(timePO,id, name);
	
	idField.setText("");
	dataField.setText(ser.getCurrentTime());
	dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
	nameField.setText("");
	deliveryInputModel.addRow(DeliveryList);
	deliveryview_Hall.this.validate();
}
	
	
}
