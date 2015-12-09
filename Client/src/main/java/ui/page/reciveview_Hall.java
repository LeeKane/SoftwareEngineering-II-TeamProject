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
import blservice.listblservice.arrivaList_HallBLService;
import po.AccountPO;
import po.TimePO;
import po.WarePO;
import po.list.OrderListPO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import util.City;
import util.GoodState;
import vo.list.ArrivaListVO;

public class reciveview_Hall extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private arrivaList_HallBLService bl;

	private JTextField dataField;// 修改

	private JComboBox departPlaceBox;
	private JComboBox statusBox;
	private JTextField idField;
	private DefaultTableModel reciveInputModel;
	private JTable reciveInputTable;
	private XTimeChooser ser;

	private String departPlace;
	private String status;
	private TimePO timePO;
	private AccountPO po;

	public reciveview_Hall(arrivaList_HallBLService bl) {
		this.setName("接收");
		this.po = bl.getPo();
		this.bl = bl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// 初始化出发地和达到状态选择
		initBoxSelecter();

		// 初始化快件信息输入界面
		initImportItemField();

		// 初始化快件列表界面
		initWareListTable();

		// 初始化提交进货单按钮
		initSubmitButton();

		this.validate();
	}

	private void initSubmitButton() {
		// TODO Auto-generated method stub
		XButton submitButton = new XButton("提交");
		submitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean result = bl.submit();
				if (result == true) {
					JOptionPane.showMessageDialog(null, "提交成功！", "", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "提交失败！", "", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		JPanel submitPanel = new JPanel();
		// submitPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		submitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		submitPanel.add(submitButton);
		this.add(submitPanel);

	}

	private void initWareListTable() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("到达日期");
		vColumns.add("营业厅到达单编号");
		vColumns.add("出发地");
		vColumns.add("货物到达状态");
		Vector<ArrivaListVO> vData = new Vector<ArrivaListVO>();

		// //模型
		reciveInputModel = new DefaultTableModel(vData, vColumns);
		// //表格
		reciveInputTable = new JTable(reciveInputModel) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTableHeader tableH = reciveInputTable.getTableHeader();

		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
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
		XLabel idLabel = new XLabel("订单条形码号：");
		idField = new JTextField();
		idLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField.setPreferredSize(new Dimension(100, 26));
		XLabel dataLabel = new XLabel("达到日期：");
		dataField = new JTextField();
		dataLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dataField.setPreferredSize(new Dimension(200, 26));
		ser = XTimeChooser.getInstance();
		ser.register(dataField);
		timePO = ser.getTimePO();

		dataField.setText(ser.getCurrentTime());
		dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		XButton addItemButton = new XButton("添加");
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addItem();
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
		inputPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		inputPanel1.add(addItemButton);

		this.add(inputPanel);
		this.add(inputPanel1);

	}

	private void initBoxSelecter() {
		// TODO Auto-generated method stub
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

		statusBox = new JComboBox();

		statusBox.addItem("完好");
		statusBox.addItem("损坏");
		statusBox.addItem("遗失");

		statusBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		statusBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					status = (String) statusBox.getSelectedItem();
				}
			}
		});

		// status="完好";
		// departPlace="北京";

		JPanel boxPanel = new JPanel();
		// boxPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
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

	private void addItem() {
		// 获取输入
		long id = 1111111111;
		try {
			id = Long.parseLong(idField.getText());
		} catch (NumberFormatException e) {
			// 输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// String data = dataField.getText();
		OrdersInputBLService obl = new OrdersInputBL(po);
		OrderListPO order = obl.find(id + "");
		City departPlace1 = City.BEIJING;
		GoodState s = GoodState.INTACE;
		if (departPlace == "南京")
			departPlace1 = City.NANJING;
		if (departPlace == "上海")
			departPlace1 = City.SHANGHAI;
		if (departPlace == "广州")
			departPlace1 = City.GUANGZHOU;
		if (status == "完好")
			s = GoodState.INTACE;
		if (status == "损坏")
			s = GoodState.BROKEN;
		if (status == "遗失")
			s = GoodState.MISSING;

		if (order != null) {
			WarePO ware = order.getWare();
			// 添加监听 添加单据号的
			ArrivaListVO ArrivaList = bl.addList(bl.myGetListId(bl.getOd(), timePO), timePO, id, departPlace1, s);
			reciveInputModel.addRow(ArrivaList);
		} else {
			JOptionPane.showMessageDialog(null, "无此订单信息！", "", JOptionPane.ERROR_MESSAGE);
		}
		idField.setText("");
		dataField.setText(ser.getCurrentTime());
		dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		reciveview_Hall.this.validate();
	}
}
