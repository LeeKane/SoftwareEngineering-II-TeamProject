package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import vo.WareVO;
import blservice.listblservice.ordersInputBLService;




public class OrdersInputView extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ordersInputBLService bl;
	
	private JComboBox packagBox;
	private JComboBox typeBox;
	private DefaultTableModel ordersInputModel;
	private JTable ordersInputTable;

	private JTextField weightField;
	private JTextField amountField;
	private JTextField volumeField;
	private JTextField nameField;
	private JLabel totalPrice;
	private String packag;
	private String type;
	
	public OrdersInputView(ordersInputBLService bl){
		this.bl = bl;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//初始化包装类型和快递类型选择
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
		JButton submitButton = new JButton("提交");
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
		JLabel totalPriceLabel = new JLabel("总价:");

		totalPrice = new JLabel("0.0");

		submitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		submitPanel.add(totalPriceLabel);
		submitPanel.add(totalPrice);

		submitPanel.add(submitButton);
		this.add(submitPanel);
	}

	private void initBoxSelecter() {
		packagBox = new JComboBox();
		packagBox.addItem("纸箱");
		packagBox.addItem("木箱");
		packagBox.addItem("快递袋");
		typeBox = new JComboBox();
		typeBox.addItem("经济快递");
		typeBox.addItem("标准快递");
		typeBox.addItem("特快专递");
		packag="纸箱";
		type="经济快递";
		
//		初始化下拉框选项1
//		设置选择事件
		packagBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					packag=(String) packagBox.getSelectedItem();
				}
			}
		});
		
		typeBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					type=(String) typeBox.getSelectedItem();
				}
			}
		});
		
		//添加下拉框
		JPanel boxPanel = new JPanel();
		boxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel packagLabel = new JLabel("包装类型：");
		JLabel typeLabel = new JLabel("快递类型：");
		boxPanel.add(packagLabel);
		boxPanel.add(packagBox);
		boxPanel.add(typeLabel);
		boxPanel.add(typeBox);
		this.add(boxPanel);
	}
	
	
	private void initImportItemField() {
		JLabel amountLabel = new JLabel("原件数：");
		amountField = new JTextField(5);
		JLabel weightLabel = new JLabel("实际重量：");
		weightField = new JTextField(5);
		JLabel volumeLabel = new JLabel("体积：");
		volumeField = new JTextField(5);
		JLabel nameLabel = new JLabel("内件品名：");
		nameField = new JTextField(10);
		
		JButton addItemButton = new JButton("添加");
		addItemButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			}
		});
		
//		JButton deleteItemButton = new JButton("删除");
//		deleteItemButton.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent arg0) {
//				deleteItem();
//			}
//		});
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(weightLabel);
		inputPanel.add(weightField);
		inputPanel.add(amountLabel);
		inputPanel.add(amountField);
		inputPanel.add(volumeLabel);
		inputPanel.add(volumeField);
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(addItemButton);
//		inputPanel.add(deleteItemButton);
		
		this.add(inputPanel);
	}

	private void initWareListTable(){
		JScrollPane scrollPane = new JScrollPane();
		
		//表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("实际重量");
			vColumns.add("原件数");
		vColumns.add("体积");
		vColumns.add("包装类型");
		vColumns.add("内件品名");
		vColumns.add("快递类型");
		vColumns.add("运费");
		vColumns.add("预计时间");
		vColumns.add("订单条形码号");

		   Vector<WareVO> vData = new Vector<WareVO>();
//		//模型
		   ordersInputModel = new DefaultTableModel(vData, vColumns);
//		//表格
		   ordersInputTable = new JTable(ordersInputModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		ordersInputTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.getViewport().add(ordersInputTable);
		ordersInputTable.setFillsViewportHeight(true);
		this.add(scrollPane);
		
	}
	
	private void addItem(){
		//获取输入
		double weight=0.0;
		int amount = 0;
		double volume=0.0;
		try{
			amount = Integer.parseInt(amountField.getText());
			weight =Double.parseDouble(weightField.getText());
			volume =Double.parseDouble(volumeField.getText());
		}catch(NumberFormatException e){
			//输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String name = nameField.getText();
		//添加进货项
		WareVO ware = bl.addware(weight, amount, volume,packag,name,type);
		//查无商品
//		if(item == null){
//			JOptionPane.showMessageDialog(null, "查无此商品！","", JOptionPane.ERROR_MESSAGE);
//			return;
//		}
		//清空输入
		weightField.setText("");
		amountField.setText("");
		volumeField.setText("");
		nameField.setText("");
		//进货列表添加行
		ordersInputModel.addRow(ware);
		totalPrice.setText("$" + bl.getCost());
		OrdersInputView.this.validate();
	}
	
//	protected void deleteItem() {
//		int index = importListTable.getSelectedRow();
//		if(index == -1){
//			JOptionPane.showMessageDialog(null, "请选中一个商品！","", JOptionPane.ERROR_MESSAGE);
//			return;
//		}
//		boolean result = bl.deleteItem(index);
//		if(result == true){
//			importListModel.removeRow(index);
//			totalPrice.setText(""+bl.getTotalPrice());
//		}else{
//			JOptionPane.showMessageDialog(null, "删除失败！","", JOptionPane.ERROR_MESSAGE);
//		}
//	}
}
