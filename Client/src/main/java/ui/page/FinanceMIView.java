package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
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

import blservice.financeblservice.FinanceMIBLService;
import blservice.reviewblservice.LogBLService;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import vo.AccountVO;
import vo.list.MoneyInListVO;

public class FinanceMIView extends JPanel {
	private DefaultTableModel miModel;
	private JTable miTable;
	private ArrayList<MoneyInListVO> voList;
	private JTextField dataField;
	private JComboBox cityBox;
	private XTimeChooser ser;
	private TimePO timePO;
	private String city;
	private XLabel totalCost;
	private FinanceMIBLService bl;

	public FinanceMIView(FinanceMIBLService bl) {

		this.setName("结算管理");
		this.bl = bl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		voList = new ArrayList<MoneyInListVO>();
		initChooseField();
		initListTable();
		initCost();
		this.validate();
	}

	private void initCost() {
		// TODO Auto-generated method stub
		JPanel submitPanel = new JPanel();
		// submitPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		JLabel totalPriceLabel = new JLabel("总计:");
		totalCost = new XLabel("0.0");
		submitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		submitPanel.add(totalPriceLabel);
		submitPanel.add(totalCost);
		this.add(submitPanel);
	}

	private void initChooseField() {
		// TODO Auto-generated method stub
		XLabel timeLabel = new XLabel("时间：");
		XLabel cityLabel = new XLabel("营业厅：");
		city = "北京";
		cityBox = new JComboBox();
		cityBox.addItem("北京");
		cityBox.addItem("上海");
		cityBox.addItem("南京");
		cityBox.addItem("广州");
		cityBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		cityBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					city = (String) cityBox.getSelectedItem();
				}
			}
		});
		dataField = new JTextField();
		timeLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dataField.setPreferredSize(new Dimension(200, 26));
		ser = XTimeChooser.getInstance();
		ser.register(dataField);
		timePO = ser.getTimePO();
		dataField.setText(ser.getCurrentTime());
		dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		XButton chooseItemButton = new XButton("查看");
		chooseItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timePO = ser.getTimePO();
				chooseItem();
				LogBLService.insert(TimePO.getNowTimePO(),
						bl.getPO().getPermission().toString() + bl.getPO().getUsername() + "查看了结算管理信息");
			}
		});
		JPanel inputPanel = new JPanel();
		JPanel inputPanel2 = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		inputPanel.add(timeLabel);
		inputPanel.add(dataField);
		inputPanel.add(cityLabel);
		inputPanel.add(cityBox);
		inputPanel2.add(chooseItemButton);
		this.add(inputPanel);
		this.add(inputPanel2);
	}

	private void initListTable() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();

		// 表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("快递员");
		vColumns.add("日期");
		vColumns.add("ID");
		vColumns.add("金额");
		vColumns.add("核对状态");

		Vector<AccountVO> vData = new Vector<AccountVO>();
		// //模型
		miModel = new DefaultTableModel(vData, vColumns);
		// //表格
		miTable = new JTable(miModel);
		JTableHeader tableH = miTable.getTableHeader();
		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		miTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		miTable.setShowVerticalLines(false);
		miTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(miTable);
		miTable.setFillsViewportHeight(true);
		this.add(scrollPane);
	}

	protected void chooseItem() {
		// TODO Auto-generated method stub
		double cost = 0.0;
		miModel.setRowCount(0);
		voList = bl.findAll(timePO, city);
		if (voList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "无相应收款单！", "", JOptionPane.ERROR_MESSAGE);
		}
		for (int i = 0; i < voList.size(); i++) {
			MoneyInListVO vo = voList.get(i);
			miModel.addRow(vo);
			cost += vo.getMoney();
		}
		totalCost.setText(cost + "");
		FinanceMIView.this.validate();
	}
}
