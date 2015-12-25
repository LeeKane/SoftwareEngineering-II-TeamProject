package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bl.finance.Reward;
import blservice.financeblservice.FinanceMOBLService;
import po.BaccountPO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import util.Entry;
import util.ListState;

import vo.list.MoneyOutListVO;

public class FinanceMO_FreigntView extends FinanceMOView {
	private Reward r;
	public FinanceMO_FreigntView(FinanceMOBLService bl) {
		super(bl);
		
		this.type="运费";
		this.setName("运费");
		r=new Reward();
		initImportItemField();
		// TODO Auto-generated constructor stub
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
		nameField.setPreferredSize(new Dimension(100, 26));
		
		XLabel accountLabel = new XLabel("付款账户：");
		accountField = new JTextField();
		accountLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		accountField.setPreferredSize(new Dimension(100, 26));
		XLabel costLabel = new XLabel("运费金额：");
	    costField = new JTextField();
		costField.setPreferredSize(new Dimension(100, 26));
		costLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		XLabel jobLabel = new XLabel("付款账号：");
		jobLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
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
	protected void addItem() {
		// TODO Auto-generated method stub
		long id=0;
		try{
		cost=Double.parseDouble(costField.getText());}
		catch (NumberFormatException e) {
			// 输入数量不是整数
			JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
			return;
		}
		name= nameField.getText();
		account=accountField.getText();
		notes=notesField.getText();
		if(!name.equals("")&&!account.equals(""))
		{
			MoneyOutListVO  MoneyOutList=bl.addMOList(bl.myGetListId(timePO), timePO, cost, name, new BaccountPO(account,"111111","999999"), Entry.toEntry(type), notes, ListState.SUBMITTED);
			nameField.setText("");
			accountField.setText("");
			notesField.setText("");
			costField.setText("");
			MOInputModel.addRow(MoneyOutList);
			FinanceMO_FreigntView.this.validate();
		}
		else {
			JOptionPane.showMessageDialog(null, "请输入未输入项！", "", JOptionPane.ERROR_MESSAGE);
		}
	
	}
	
}





