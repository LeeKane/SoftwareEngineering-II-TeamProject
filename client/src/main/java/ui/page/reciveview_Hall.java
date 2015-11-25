package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import util.City;
import vo.WareVO;
import vo.list.ArrivaListVO;
import blservice.listblservice.OrdersInputBLService;

public class reciveview_Hall  extends JPanel{
	private OrdersInputBLService bl;
	
   private JTextField dataField;//修改
  
  
	private JComboBox departPlaceBox;
	private JComboBox statusBox;
	private JTextField idField;
	private DefaultTableModel reciveInputModel;
	private JTable reciveInputTable;
	
	private String departPlace;
	private String status;
	public reciveview_Hall(OrdersInputBLService bl){
		this.bl = bl;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//初始化出发地和达到状态选择
		initBoxSelecter();
		
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
		vColumns.add("中转单编号");
		vColumns.add("出发地");
		vColumns.add("货物到达状态");
		   Vector<ArrivaListVO> vData = new Vector<ArrivaListVO>();
		   
//			//模型
		   reciveInputModel = new DefaultTableModel(vData, vColumns);
//		//表格
		   reciveInputTable = new JTable(reciveInputModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		 JTableHeader tableH=reciveInputTable.getTableHeader();
	
//		 tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		 tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		 tableH.setFont(XContorlUtil.FONT_14_BOLD);
		 reciveInputTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reciveInputTable.setShowVerticalLines(false);
		reciveInputTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(reciveInputTable);
		reciveInputTable.setFillsViewportHeight(true);
		this.add(scrollPane);
		
	
	}

	private void initImportItemField() {
		// TODO Auto-generated method stub
		XLabel idLabel = new XLabel("中转编号：");
		idField =new  JTextField();
		idLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField.setPreferredSize(new Dimension(100,26));
		XLabel dataLabel = new XLabel("达到日期：");
		dataField =new  JTextField();
		dataLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dataField.setPreferredSize(new Dimension(50,26));
		
		XButton addItemButton = new XButton("添加");
		addItemButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			}
		});

		JLabel white=new JLabel("                             ");
		
		JPanel inputPanel = new JPanel();
	
		//inputPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(dataLabel);
		inputPanel.add(dataField);
		inputPanel.add(idLabel);
		inputPanel.add(idField);
		inputPanel.add(white);
		inputPanel.add(addItemButton);
		
		this.add(inputPanel);
		
	}

	private void initBoxSelecter() {
		// TODO Auto-generated method stub
        departPlaceBox =new JComboBox();
		
		departPlaceBox.addItem("北京");
		departPlaceBox.addItem("南京");
		departPlaceBox.addItem("广州");
		departPlaceBox.addItem("上海");
		departPlaceBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		departPlaceBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					departPlace=(String) departPlaceBox.getSelectedItem();
				}
			}
		});
		
		statusBox =new JComboBox();
		
		statusBox.addItem("完整");
		statusBox.addItem("损坏");
		statusBox.addItem("丢失");
		
		statusBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		statusBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					status=(String) statusBox.getSelectedItem();
				}
			}
		});
		
		status="完整";
		departPlace="北京";
		
		JPanel boxPanel = new JPanel();
		//boxPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		boxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		XLabel departPlaceLabel = new XLabel("出发地：");
		departPlaceLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		XLabel statusLabel = new XLabel("到达状态：");
		statusLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		boxPanel.add(departPlaceLabel);
		boxPanel.add(departPlaceBox);
		boxPanel.add(statusLabel);
		boxPanel.add(statusBox);
		this.add(boxPanel);
		
	}
	private void addItem(){
		//获取输入
		long id=1111111111;
		try
		{
			id=Long.parseLong(idField.getText());
		}
		catch(NumberFormatException e){
			//输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String data = dataField.getText();
		City departPlace1=City.BEIJING;
		if(departPlace=="南京")
			departPlace1=City.NANJING;
		if(departPlace=="上海")
			departPlace1=City.SHANGHAI;
		if(departPlace=="广州")
			departPlace1=City.GUANGZHOU;
		
//		ArrivaListVO ArrivaList = bl.addware(weight, amount, volume,packag,name,type,departPlace1,destination1);//添加监听
	
		idField.setText("");
		dataField.setText("");
//		reciveInputModel.addRow(ArrivaList);
		reciveview_Hall.this.validate();
	}
}
