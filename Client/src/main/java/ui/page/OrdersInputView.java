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

import blservice.listblservice.OrdersInputBLService;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import util.City;
import util.ListType;
import vo.WareVO;

public class OrdersInputView extends JPanel {
	private static final long serialVersionUID = 1L;

	private OrdersInputBLService bl;
	private JTextField dataField;
	private JComboBox packagBox;
	private JComboBox typeBox;
	private JComboBox departPlaceBox;
	private JComboBox destinationBox;
	private DefaultTableModel ordersInputModel;
	private JTable ordersInputTable;
	private XTimeChooser ser;
	private JTextField weightField;
	private JTextField amountField;
	private JTextField volumeField;
	private JTextField nameField;

	private JTextField senderNameField;
	private JTextField senaderAddressField;
	private JTextField senderOrganizationField;
	private JTextField senderCphoneField;
	private JTextField senderTphoneField;
	private JTextField receiverNameField;
	private JTextField receiverAddressField;
	private JTextField receiverOrganizationField;
	private JTextField receiverCphoneField;
	private JTextField receiverTphoneField;

	private XLabel totalPrice;
	private String departPlace;
	private String destination;
	private String packag;
	private String type;
	private TimePO timePO;

	public OrdersInputView(OrdersInputBLService bl) {
		this.setName("订单输入");

		this.bl = bl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// 初始化包装类型和快递类型选择
		initBoxSelecter();

		// 初始化快件信息输入界面
		initImportItemField();
		initOrderListFiled();
		// 初始化快件列表界面
		initWareListTable();

		// 初始化提交进货单按钮
		initSubmitButton();

		this.validate();
	}

	private void initOrderListFiled() {
		// TODO Auto-generated method stub
		XLabel senderNameLabel = new XLabel("寄件人：");
		senderNameField = new JTextField();
		senderNameLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		senderNameField.setPreferredSize(new Dimension(65, 26));
		XLabel departPlaceLabel = new XLabel("寄件人城市：");
		departPlaceLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		departPlaceBox = new JComboBox();

		departPlaceBox.addItem("北京");
		departPlaceBox.addItem("南京");
		departPlaceBox.addItem("广州");
		departPlaceBox.addItem("上海");
		departPlaceBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		departPlaceBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					departPlace = (String) departPlaceBox.getSelectedItem();
				}
			}
		});

		XLabel senaderAddressLabel = new XLabel("具体地址：");
		senaderAddressField = new JTextField();
		senaderAddressLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		senaderAddressField.setPreferredSize(new Dimension(190, 26));

		XLabel senderOrganizationLabel = new XLabel("寄件人单位：");
		senderOrganizationField = new JTextField();
		senderOrganizationLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		senderOrganizationField.setPreferredSize(new Dimension(90, 26));
		XLabel senderCphoneLabel = new XLabel("寄件人手机：");
		senderCphoneField = new JTextField();
		senderCphoneLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		senderCphoneField.setPreferredSize(new Dimension(100, 26));
		XLabel senderTphoneLabel = new XLabel("寄件人电话：");
		senderTphoneField = new JTextField();
		senderTphoneLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		senderTphoneField.setPreferredSize(new Dimension(100, 26));

		XLabel receiverNameLabel = new XLabel("收件人：");
		receiverNameField = new JTextField();
		receiverNameLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		receiverNameField.setPreferredSize(new Dimension(65, 26));
		XLabel destinationLabel = new XLabel("收件人城市：");
		destinationLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		destinationBox = new JComboBox();

		destinationBox.addItem("北京");
		destinationBox.addItem("南京");
		destinationBox.addItem("广州");
		destinationBox.addItem("上海");
		destinationBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		destinationBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					destination = (String) destinationBox.getSelectedItem();
				}
			}
		});

		XLabel receiverAddressLabel = new XLabel("具体地址：");
		receiverAddressField = new JTextField();
		receiverAddressLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		receiverAddressField.setPreferredSize(new Dimension(190, 26));

		XLabel receiverOrganizationLabel = new XLabel("收件人单位：");
		receiverOrganizationField = new JTextField();
		receiverOrganizationLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		receiverOrganizationField.setPreferredSize(new Dimension(90, 26));
		XLabel receiverCphoneLabel = new XLabel("收件人手机：");
		receiverCphoneField = new JTextField();
		receiverCphoneLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		receiverCphoneField.setPreferredSize(new Dimension(100, 26));
		XLabel receiverTphoneLabel = new XLabel("收件人电话：");
		receiverTphoneField = new JTextField();
		receiverTphoneLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		receiverTphoneField.setPreferredSize(new Dimension(100, 26));
		XButton addItemButton = new XButton("添加");
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			}
		});
		JLabel white = new JLabel("                       ");

		JPanel inputPanel1 = new JPanel();
		JPanel inputPanel2 = new JPanel();
		JPanel inputPanel3 = new JPanel();
		JPanel inputPanel4 = new JPanel();
		inputPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel4.setLayout(new FlowLayout(FlowLayout.LEFT));

		inputPanel1.add(senderNameLabel);
		inputPanel1.add(senderNameField);
		inputPanel1.add(departPlaceLabel);
		inputPanel1.add(departPlaceBox);
		inputPanel1.add(senaderAddressLabel);
		inputPanel1.add(senaderAddressField);
		inputPanel2.add(senderOrganizationLabel);
		inputPanel2.add(senderOrganizationField);
		inputPanel2.add(senderCphoneLabel);
		inputPanel2.add(senderCphoneField);
		inputPanel2.add(senderTphoneLabel);
		inputPanel2.add(senderTphoneField);

		inputPanel3.add(receiverNameLabel);
		inputPanel3.add(receiverNameField);
		inputPanel3.add(destinationLabel);
		inputPanel3.add(destinationBox);
		inputPanel3.add(receiverAddressLabel);
		inputPanel3.add(receiverAddressField);
		inputPanel4.add(receiverOrganizationLabel);
		inputPanel4.add(receiverOrganizationField);
		inputPanel4.add(receiverCphoneLabel);
		inputPanel4.add(receiverCphoneField);
		inputPanel4.add(receiverTphoneLabel);
		inputPanel4.add(receiverTphoneField);
		inputPanel4.add(white);
		inputPanel4.add(addItemButton);

		this.add(inputPanel1);
		this.add(inputPanel2);
		this.add(inputPanel3);
		this.add(inputPanel4);

	}

	private void initSubmitButton() {
		XButton submitButton = new XButton("提交");
		submitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean result = bl.submit();
				System.out.println(result);
				if (result == true) {
					JOptionPane.showMessageDialog(null, "提交成功！", "", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "提交失败！", "", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		JPanel submitPanel = new JPanel();
		// submitPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		JLabel totalPriceLabel = new JLabel("总价:");

		totalPrice = new XLabel("0.0");

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
		packagBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		packagBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					packag = (String) packagBox.getSelectedItem();
				}
			}
		});
		XLabel dataLabel = new XLabel("日期：");
		dataField = new JTextField();
		dataLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dataField.setPreferredSize(new Dimension(200, 26));
		ser = XTimeChooser.getInstance();
		ser.register(dataField);
		timePO = ser.getTimePO();
		dataField.setText(ser.getCurrentTime());
		dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		// try {
		// UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (InstantiationException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IllegalAccessException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (UnsupportedLookAndFeelException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		typeBox = new JComboBox();

		typeBox.addItem("经济快递");
		typeBox.addItem("标准快递");
		typeBox.addItem("特快专递");
		packag = "纸箱";
		type = "经济快递";
		// 初始化下拉框选项1
		// 设置选择事件
		typeBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		typeBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					type = (String) typeBox.getSelectedItem();
				}
			}
		});

		// 添加下拉框
		JPanel boxPanel = new JPanel();
		// boxPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		boxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		XLabel packagLabel = new XLabel("包装类型：");
		packagLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		XLabel typeLabel = new XLabel("快递类型：");
		typeLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		XLabel departPlaceLabel = new XLabel("出发地：");
		packagLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		XLabel destinationLabel = new XLabel("目的地：");
		typeLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		boxPanel.add(packagLabel);
		boxPanel.add(packagBox);
		boxPanel.add(typeLabel);
		boxPanel.add(typeBox);
		boxPanel.add(dataLabel);
		boxPanel.add(dataField);
		this.add(boxPanel);

	}

	private void initImportItemField() {
		XLabel amountLabel = new XLabel("原件数：");
		amountField = new JTextField();
		amountLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		amountField.setPreferredSize(new Dimension(50, 26));
		XLabel weightLabel = new XLabel("实际重量：");
		weightField = new JTextField();
		weightLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		weightField.setPreferredSize(new Dimension(50, 26));
		XLabel volumeLabel = new XLabel("体积：");
		volumeField = new JTextField();
		volumeLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		volumeField.setPreferredSize(new Dimension(50, 26));
		XLabel nameLabel = new XLabel("内件品名：");
		nameField = new JTextField();
		nameLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		nameField.setPreferredSize(new Dimension(70, 26));

		// JButton deleteItemButton = new JButton("删除");
		// deleteItemButton.addActionListener(new ActionListener(){
		// public void actionPerformed(ActionEvent arg0) {
		// deleteItem();
		// }
		// });

		JPanel inputPanel = new JPanel();

		// inputPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(weightLabel);
		inputPanel.add(weightField);
		inputPanel.add(amountLabel);
		inputPanel.add(amountField);
		inputPanel.add(volumeLabel);
		inputPanel.add(volumeField);
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);

		// inputPanel.add(deleteItemButton);

		this.add(inputPanel);
	}

	private void initWareListTable() {
		JScrollPane scrollPane = new JScrollPane();

		// 表头
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
		// //模型
		ordersInputModel = new DefaultTableModel(vData, vColumns);
		// //表格
		ordersInputTable = new JTable(ordersInputModel) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTableHeader tableH = ordersInputTable.getTableHeader();

		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		ordersInputTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ordersInputTable.setShowVerticalLines(false);
		ordersInputTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(ordersInputTable);
		ordersInputTable.setFillsViewportHeight(true);
		this.add(scrollPane);

	}

	private void addItem() {
		// 获取输入
		double weight = 0.0;
		int amount = 0;
		double volume = 0.0;
		try {
			amount = Integer.parseInt(amountField.getText());
			weight = Double.parseDouble(weightField.getText());
			volume = Double.parseDouble(volumeField.getText());

		} catch (NumberFormatException e) {
			// 输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		City departPlace1 = City.BEIJING;
		City destination1 = City.BEIJING;
		if (departPlace == "南京")
			departPlace1 = City.NANJING;
		if (departPlace == "上海")
			departPlace1 = City.SHANGHAI;
		if (departPlace == "广州")
			departPlace1 = City.GUANGZHOU;
		if (destination == "南京")
			destination1 = City.NANJING;
		if (destination == "上海")
			destination1 = City.SHANGHAI;
		if (destination == "广州")
			destination1 = City.GUANGZHOU;

		try {
			String name = nameField.getText();
			String senderName = senderNameField.getText();
			String senderAddress = senaderAddressField.getText();
			String senderOrganization = senderOrganizationField.getText();
			String senderCphone = Long.parseLong(senderCphoneField.getText()) + "";
			String receiverCphone = Long.parseLong(receiverCphoneField.getText()) + "";
			String senderTphone = Long.parseLong(senderTphoneField.getText()) + "";
			String receiverName = receiverNameField.getText();
			String receiverAddress = receiverAddressField.getText();
			String receiverOrganization = receiverOrganizationField.getText();
			String receiverTphone = Long.parseLong(receiverTphoneField.getText()) + "";
			// 添加进货项

			if (name.equals("") || senderName.equals("") || senderAddress.equals("") || senderOrganization.equals("")
					|| receiverName.equals("") || receiverAddress.equals("") || receiverOrganization.equals(""))
				JOptionPane.showMessageDialog(null, "请输入未输入项！", "", JOptionPane.ERROR_MESSAGE);
			else {
				WareVO ware = bl.addware(weight, amount, volume, packag, name, type, departPlace1, destination1,
						ListType.ORDER, senderName, senderAddress, senderOrganization, senderCphone, senderTphone,
						receiverName, receiverAddress, receiverOrganization, receiverCphone, receiverTphone, timePO);
				ordersInputModel.addRow(ware);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "请正确输入！", "", JOptionPane.ERROR_MESSAGE);
		}

		// 查无商品
		// if(item == null){
		// JOptionPane.showMessageDialog(null, "查无此商品！","",
		// JOptionPane.ERROR_MESSAGE);
		// return;
		// }
		// 清空输入
		senderNameField.setText("");
		senaderAddressField.setText("");
		senderOrganizationField.setText("");
		senderCphoneField.setText("");
		senderTphoneField.setText("");
		receiverNameField.setText("");
		receiverAddressField.setText("");
		receiverOrganizationField.setText("");
		receiverCphoneField.setText("");
		receiverTphoneField.setText("");
		weightField.setText("");
		amountField.setText("");
		volumeField.setText("");
		nameField.setText("");
		// 进货列表添加行
		totalPrice.setText("$" + bl.getCost());
		OrdersInputView.this.validate();
	}

	// protected void deleteItem() {
	// int index = importListTable.getSelectedRow();
	// if(index == -1){
	// JOptionPane.showMessageDialog(null, "请选中一个商品！","",
	// JOptionPane.ERROR_MESSAGE);
	// return;
	// }
	// boolean result = bl.deleteItem(index);
	// if(result == true){
	// importListModel.removeRow(index);
	// totalPrice.setText(""+bl.getTotalPrice());
	// }else{
	// JOptionPane.showMessageDialog(null, "删除失败！","",
	// JOptionPane.ERROR_MESSAGE);
	// }
	// }
}
