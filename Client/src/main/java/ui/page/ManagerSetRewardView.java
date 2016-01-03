package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import blservice.reviewblservice.LogBLService;
import blservice.reviewblservice.ManagerSetRewardBLService;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.chart.Bar3DChart;

public class ManagerSetRewardView extends JPanel {
	private JTextField salaryOfMonth_financeField;
	private JTextField salaryOfMonth_managerField;
	private JTextField salaryOfMonth_hallField;
	private JTextField salaryOfMonth_centerField;
	private JTextField salaryOfMonth_centerkeeperField;
	private JTextField salaryOfMonth_mailerField;
	private JTextField driverOfOnceField;
	private JTextField commissionOfMailerField;
	private JPanel chartPanels;
	private Bar3DChart bc;
	private ManagerSetRewardBLService bl;
	private double[] updata;

	public ManagerSetRewardView(ManagerSetRewardBLService bl) {
		this.bl = bl;
		this.setName("修改工资策略");
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		updata = new double[9];
		updata = bl.find();
		initInputField();

	}

	private void initInputField() {
		// TODO Auto-generated method stub
		XLabel Label1 = new XLabel("提成：");
		XLabel driverOfOnceFieldLabel = new XLabel("司机按次计费：");
		driverOfOnceFieldLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		XLabel commissionOfMailerFieldLabel = new XLabel("快递员提成比例：");
		XLabel commissionOfMailerFieldLabel1 = new XLabel("%");
		commissionOfMailerFieldLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		driverOfOnceField = new JTextField();
		driverOfOnceField.setPreferredSize(new Dimension(100, 26));

		commissionOfMailerField = new JTextField();
		commissionOfMailerField.setPreferredSize(new Dimension(100, 26));

		XLabel Label2 = new XLabel("月薪：");
		XLabel salaryOfMonth_financeFieldLabel = new XLabel("财务人员：");
		salaryOfMonth_financeFieldLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		salaryOfMonth_financeField = new JTextField();
		salaryOfMonth_financeField.setPreferredSize(new Dimension(100, 26));
		XLabel salaryOfMonth_managerFieldLabel = new XLabel("总经理：");
		salaryOfMonth_managerFieldLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		salaryOfMonth_managerField = new JTextField();
		salaryOfMonth_managerField.setPreferredSize(new Dimension(100, 26));
		XLabel salaryOfMonth_hallFieldLabel = new XLabel("营业厅业务员：");
		salaryOfMonth_hallFieldLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		salaryOfMonth_hallField = new JTextField();
		salaryOfMonth_hallField.setPreferredSize(new Dimension(100, 26));
		XLabel salaryOfMonth_centerFieldLabel = new XLabel("中转中心业务员：");
		salaryOfMonth_centerFieldLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		salaryOfMonth_centerField = new JTextField();
		salaryOfMonth_centerField.setPreferredSize(new Dimension(100, 26));
		XLabel salaryOfMonth_centerkeeperFieldLabel = new XLabel("仓库管理员：");
		salaryOfMonth_centerkeeperFieldLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		salaryOfMonth_centerkeeperField = new JTextField();
		salaryOfMonth_centerkeeperField.setPreferredSize(new Dimension(100, 26));
		XLabel salaryOfMonth_mailerFieldLabel = new XLabel("快递员：");
		salaryOfMonth_mailerFieldLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		salaryOfMonth_mailerField = new JTextField();
		salaryOfMonth_mailerField.setPreferredSize(new Dimension(100, 26));

		XButton addItemButton = new XButton("确定");
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			}
		});

		commissionOfMailerField.setText(updata[8] * 100 + "");
		driverOfOnceField.setText(updata[7] + "");
		salaryOfMonth_financeField.setText(updata[1] + "");
		salaryOfMonth_managerField.setText(updata[2] + "");
		salaryOfMonth_hallField.setText(updata[3] + "");
		salaryOfMonth_centerField.setText(updata[4] + "");
		salaryOfMonth_centerkeeperField.setText(updata[5] + "");
		salaryOfMonth_mailerField.setText(updata[6] + "");

		JPanel inputPanel = new JPanel();
		JPanel inputPanel1 = new JPanel();
		JPanel inputPanel2 = new JPanel();
		JPanel inputPanel3 = new JPanel();
		JPanel inputPanel31 = new JPanel();
		JPanel inputPanel4 = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(Label1);

		inputPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel1.add(driverOfOnceFieldLabel);
		inputPanel1.add(driverOfOnceField);

		inputPanel1.add(commissionOfMailerFieldLabel);
		inputPanel1.add(commissionOfMailerField);
		inputPanel1.add(commissionOfMailerFieldLabel1);
		inputPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel2.add(Label2);

		inputPanel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel31.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel3.add(salaryOfMonth_mailerFieldLabel);
		inputPanel3.add(salaryOfMonth_mailerField);
		inputPanel3.add(salaryOfMonth_centerkeeperFieldLabel);
		inputPanel3.add(salaryOfMonth_centerkeeperField);
		inputPanel3.add(salaryOfMonth_centerFieldLabel);
		inputPanel3.add(salaryOfMonth_centerField);
		inputPanel3.add(salaryOfMonth_hallFieldLabel);
		inputPanel3.add(salaryOfMonth_hallField);
		inputPanel31.add(salaryOfMonth_managerFieldLabel);
		inputPanel31.add(salaryOfMonth_managerField);
		inputPanel31.add(salaryOfMonth_financeFieldLabel);
		inputPanel31.add(salaryOfMonth_financeField);

		inputPanel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		inputPanel4.add(addItemButton);
		chartPanels = new JPanel();
		bc = new Bar3DChart(updata);
		chartPanels.add(bc);
		this.add(inputPanel);
		this.add(inputPanel1);
		this.add(inputPanel2);
		this.add(inputPanel3);
		this.add(inputPanel31);
		this.add(inputPanel4);
		this.add(chartPanels);
	}

	protected void addItem() {
		// TODO Auto-generated method stub
		double temp = updata[8];
		try {
			updata[1] = Double.parseDouble(salaryOfMonth_financeField.getText());
			updata[2] = Double.parseDouble(salaryOfMonth_managerField.getText());
			updata[3] = Double.parseDouble(salaryOfMonth_hallField.getText());
			updata[4] = Double.parseDouble(salaryOfMonth_centerField.getText());
			updata[5] = Double.parseDouble(salaryOfMonth_centerkeeperField.getText());
			updata[6] = Double.parseDouble(salaryOfMonth_mailerField.getText());
			updata[7] = Double.parseDouble(driverOfOnceField.getText());
			updata[8] = Double.parseDouble(commissionOfMailerField.getText()) / 100;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
		}
		System.out.println(updata[8]);
		if (updata[8] >= 0.1 && updata[8] <= 0.5) {
			bl.updata(updata);
			JOptionPane.showMessageDialog(null, "修改成功！", "", JOptionPane.INFORMATION_MESSAGE);
			LogBLService.insert(TimePO.getNowTimePO(),
					bl.getPo().getPermission().toString() + bl.getPo().getUsername() + "修改了工资策略");
			bc.getDataset(updata);
			bc.init(updata);
			ManagerSetRewardView.this.validate();
		} else {
			JOptionPane.showMessageDialog(null, "快递员提成请输入0-50之间的数值！", "", JOptionPane.ERROR_MESSAGE);
			commissionOfMailerField.setText(temp + "");
		}
	}
}
