package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
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

import bl.list.ReceiveCourierListBL;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;

public class ReceiveInputView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ReceiveCourierListBL bl;
	
	private JTextField receiveOrderNumField;
	private JTextField receiverNameField;
	private JTextField receiverPhoneField;
	private JTextField dateField;
	private XTimeChooser ser;
	
	private DefaultTableModel receiveInputModel;
	private JTable receiveInputTable;

	public ReceiveInputView(){
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		init();
		
		this.validate();
	}
	
	
	private void init(){
		//第一行
		XLabel receiveOrderNumLabel = new XLabel("收件编号   ：");
		receiveOrderNumField=new JTextField();
		receiveOrderNumLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		receiveOrderNumField.setPreferredSize(new Dimension(400,26));
		JPanel receiveOrderNumPanel = new JPanel();
		receiveOrderNumPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		receiveOrderNumPanel.add(receiveOrderNumLabel);
		receiveOrderNumPanel.add(receiveOrderNumField);
		
		this.add(receiveOrderNumPanel);
		//第二行
		XLabel receiverNameLabel = new XLabel("收件人姓名：");
		receiverNameField=new JTextField();
		receiverNameLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		receiverNameField.setPreferredSize(new Dimension(100,26));
		
		XLabel receiverPhoneLabel = new XLabel("收件人手机：");
		receiverPhoneField=new JTextField();
		receiverPhoneLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		receiverPhoneField.setPreferredSize(new Dimension(100,26));
		
		JPanel receiverPhonePanel = new JPanel();
		receiverPhonePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		receiverPhonePanel.add(receiverNameLabel);
		receiverPhonePanel.add(receiverNameField);
		receiverPhonePanel.add(receiverPhoneLabel);
		receiverPhonePanel.add(receiverPhoneField);
		
		this.add(receiverPhonePanel);
		//第三行
		XLabel dateLabel = new XLabel("收件日期   ：");
		dateField=new JTextField();
		dateLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dateField.setPreferredSize(new Dimension(400,26));
		ser = XTimeChooser.getInstance();
		ser.register(dateField);
		JPanel datePanel = new JPanel();
		datePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		datePanel.add(dateLabel);
		datePanel.add(dateField);
		
		this.add(datePanel);
		//添加按钮
		XButton addButton = new XButton("添加");
		JPanel addButtonPanel = new JPanel();
		addButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		addButtonPanel.add(addButton);
		this.add(addButtonPanel);
		
		initWareListTable();
		
		//确定按钮
		XButton confirmButton = new XButton("确定");
		JPanel confirmButtonPanel = new JPanel();
		confirmButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		confirmButtonPanel.add(confirmButton);
		this.add(confirmButtonPanel);
	}
	
	private void initWareListTable(){
		JScrollPane scrollPane = new JScrollPane();
		
		//表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("收件编号");
		vColumns.add("收件人姓名");
		vColumns.add("收件人手机");
		vColumns.add("收件日期");
		
//		//模型
		   receiveInputModel = new DefaultTableModel(null, vColumns);
//		//表格
		   receiveInputTable = new JTable(receiveInputModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		 JTableHeader tableH=receiveInputTable.getTableHeader();
	
//		 tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		 tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		 tableH.setFont(XContorlUtil.FONT_14_BOLD);
		 receiveInputTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 receiveInputTable.setShowVerticalLines(false);
		 receiveInputTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(receiveInputTable);
		receiveInputTable.setFillsViewportHeight(true);
		this.add(scrollPane);	
	}	
	
	public void addItem(){
		long id;
		String name;
		String cellphoneNum;
		TimePO time;
		
		try {
			id=Long.parseLong(receiveOrderNumField.getText());
		} catch (NumberFormatException e) {
			// 输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		name=receiverNameField.getText();
		cellphoneNum=receiverPhoneField.getText();
		time
		
	}
}

