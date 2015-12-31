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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import blservice.financeblservice.FinanceMOBLService;
import blservice.reviewblservice.LogBLService;
import po.BaccountPO;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import util.Entry;
import util.ListState;
import vo.WareVO;
import vo.list.MoneyOutListVO;

public class FinanceMOView extends JPanel {
	private static final long serialVersionUID = 1L;
	
	protected FinanceMOBLService bl;
	protected JTextField dataField;
	protected JTextField nameField;
	protected JComboBox accountField;
	protected JTextField costField;
	protected JTextField notesField;
	
	protected DefaultTableModel MOInputModel;
	protected JTable MOInputTable;
	protected XTimeChooser ser;
	
	protected TimePO timePO;
	protected String name;
	protected String account;
	protected double cost;
	protected String notes;
	protected String type;
	protected ArrayList<BaccountPO> polist;
	public FinanceMOView(FinanceMOBLService bl)
	{
		this.setName("成本管理");
		type="租金";
		cost=0.0;
		this.bl=bl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		polist=new ArrayList<BaccountPO>();
		polist=bl.findAll();

		initWareListTable();
		initSubmitButton();
	}
	private void initImportItemField() {
		// TODO Auto-generated method stub
		XLabel timeLabel = new XLabel("日期：");
		dataField = new JTextField();
		timeLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dataField.setPreferredSize(new Dimension(200, 26));
		ser = XTimeChooser.getInstance();
		ser.register(dataField);
		timePO = ser.getTimePO();
		dataField.setText(ser.getCurrentTime());
		dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		
		XLabel nameLabel = new XLabel("付款人：");
		nameField = new JTextField();
		nameLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		nameField.setPreferredSize(new Dimension(50, 26));
		
		XLabel accountLabel = new XLabel("付款账户：");
		accountField = new JComboBox();
		account=polist.get(0).getName();
		for(int i=0;i<polist.size();i++)
		{
			accountField.addItem(polist.get(i).getName());
		}
		accountField.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					account = (String) accountField.getSelectedItem();
				}
			}
		});
		accountLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		accountField.setPreferredSize(new Dimension(50, 26));
		
		XLabel typeLabel = new XLabel("条目：");
		
		XLabel costLabel = new XLabel("金额：");
		costField = new JTextField();
		costLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		costField.setPreferredSize(new Dimension(50, 26));
		
		XLabel notesLabel = new XLabel("备注：");
		notesField = new JTextField();
		notesLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		notesField.setPreferredSize(new Dimension(200, 26));
		
		XButton chooseItemButton = new XButton("添加");
		chooseItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timePO = ser.getTimePO();
				addItem();
			}
		});
		
		JPanel inputPanel = new JPanel();
		JPanel inputPanel2 = new JPanel();
		JPanel inputPanel3 = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		inputPanel.add(timeLabel);
		inputPanel.add(dataField);
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(accountLabel);
		inputPanel.add(accountField);
		inputPanel2.add(costLabel);
		inputPanel2.add(costField);
		inputPanel2.add(notesLabel);
		inputPanel2.add(notesField);
		inputPanel3.add(chooseItemButton);
		
		this.add(inputPanel);
		this.add(inputPanel2);
		this.add(inputPanel3);
		
	}

	private void initWareListTable() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();

		// 表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("单据id");
		vColumns.add("日期");
		vColumns.add("金额");
		vColumns.add("付款人");
		vColumns.add("付款账户");
		vColumns.add("条目");
		vColumns.add("备注");
		
		Vector<MoneyOutListVO> vData = new Vector<MoneyOutListVO>();
		// //模型
		MOInputModel = new DefaultTableModel(vData, vColumns);
		// //表格
		MOInputTable = new JTable(MOInputModel) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				if(column==0)
				return false;
				else
					return true;
			}
		};
		JTableHeader tableH = MOInputTable.getTableHeader();

		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		MOInputTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		MOInputTable.setShowVerticalLines(false);
		MOInputTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(MOInputTable);
		MOInputTable.setFillsViewportHeight(true);
		this.add(scrollPane);

	}
	private void initSubmitButton() {
		// TODO Auto-generated method stub
		XButton submitButton = new XButton("提交");
		submitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean result = bl.submit();
				System.out.println(result);
				if (result == true) {
					LogBLService.insert(TimePO.getNowTimePO(),
							bl.getPo().getPermission().toString()+bl.getPo().getUsername()
							+"提交了新的出款单");
					JOptionPane.showMessageDialog(null, "提交成功！", "", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "提交失败！", "", JOptionPane.ERROR_MESSAGE);
				}
				MOInputModel.setRowCount(0);
			}
		});
		JPanel submitPanel = new JPanel();
		submitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		submitPanel.add(submitButton);
		this.add(submitPanel);
	}
	
	protected void addItem() {
		// TODO Auto-generated method stub
		long id=0;
		name= nameField.getText();
		notes=notesField.getText();
		if(!name.equals("")&&!account.equals(""))
		{
			MoneyOutListVO  MoneyOutList=bl.addMOList(bl.myGetListId(timePO), timePO, cost, name, new BaccountPO(account,"111111","999999"), Entry.toEntry(type), notes, ListState.SUBMITTED);
			nameField.setText("");
			notesField.setText("");
			MOInputModel.addRow(MoneyOutList);
			FinanceMOView.this.validate();
		}
		else {
			JOptionPane.showMessageDialog(null, "请输入未输入项！", "", JOptionPane.ERROR_MESSAGE);
		}
	
	}
	
}
