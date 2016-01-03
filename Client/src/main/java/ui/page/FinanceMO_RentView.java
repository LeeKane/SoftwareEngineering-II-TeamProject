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

public class FinanceMO_RentView extends FinanceMOView {
	private String year;
	private Reward r;

	public FinanceMO_RentView(FinanceMOBLService bl) {
		super(bl);
		this.type = "租金";
		year = "1";
		r = new Reward();
		cost = r.getRentOfYear();
		this.setName("租金");
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
		accountField = new JComboBox();
		account = polist.get(0).getName();
		for (int i = 0; i < polist.size(); i++) {
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
		accountField.setPreferredSize(new Dimension(150, 26));
		XLabel costLabel = new XLabel("金额：");
		XLabel costLabel1 = new XLabel(cost + "");
		costLabel1.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		costLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		XLabel jobLabel = new XLabel("付款账号：");
		jobLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		XLabel countLabel = new XLabel("租借年限：");
		countLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		JComboBox countBox = new JComboBox();
		countBox.addItem("1");
		countBox.addItem("2");
		countBox.addItem("3");
		countBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		countBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					cost = r.getRentOfYear();
					year = (String) countBox.getSelectedItem();
					cost *= Integer.parseInt(year);
					costLabel1.setText(cost + "");
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
		inputPanel2.add(countLabel);
		inputPanel2.add(countBox);
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
