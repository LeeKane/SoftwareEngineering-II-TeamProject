package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bl.finance.Reward;
import blservice.financeblservice.FinanceMOBLService;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;


public class FinanceMO_SalaryView extends FinanceMOView{
private String job;
private Reward r;
	public FinanceMO_SalaryView(FinanceMOBLService bl) {
		super(bl);
		this.type="人员工资";
		r=new Reward();
		cost=r.getSalaryOfMonth_mailer();
		this.setName("工资");
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
		XLabel costLabel = new XLabel("金额：");
		XLabel costLabel1 = new XLabel(cost+"");
		costLabel1.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		costLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		XLabel jobLabel = new XLabel("付款账号：");
		jobLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		job="快递员";
		JComboBox jobBox = new JComboBox();
		jobBox.addItem("快递员");
		jobBox.addItem("营业厅业务员");
		jobBox.addItem("中转中心业务员");
		jobBox.addItem("中转中心仓库管理人员");
		jobBox.addItem("财务人员");
		jobBox.addItem("总经理");
		jobBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		jobBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					job = (String) jobBox.getSelectedItem();
					if(job.equals("快递员")){cost=r.getSalaryOfMonth_mailer();}
					if(job.equals("营业厅业务员")){cost=r.getSalaryOfMonth_hall();}
					if(job.equals("中转中心业务员")){cost=r.getSalaryOfMonth_center();}
					if(job.equals("中转中心仓库管理人员")){cost=r.getSalaryOfMonth_centerkeeper();}
					if(job.equals("财务人员")){cost=r.getSalaryOfMonth_finance();}
					if(job.equals("总经理")){cost=r.getSalaryOfMonth_manager();}
					costLabel1.setText(cost+"");
				}
			}
		});
		
	
		
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
		inputPanel2.add(jobLabel);
		inputPanel2.add(jobBox);
		inputPanel2.add(costLabel);
		inputPanel2.add(costLabel1);
		inputPanel2.add(notesLabel);
		inputPanel2.add(notesField);
		inputPanel3.add(chooseItemButton);
		
		this.add(inputPanel);
		this.add(inputPanel2);
		this.add(inputPanel3);
		
	}

}
