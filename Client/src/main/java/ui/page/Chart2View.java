package ui.page;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import ui.XLabel;
import ui.chart.chart2;

//成本收益表
public class Chart2View extends JPanel {
	private long income;
	private long outcome;
	private long totalcome;

	public Chart2View() {
		this.setName("查看统计分析");
		double[] value1 = { 400, 485, 520, 695, 730, 700, 640, 856, 1520, 1900, 2950, 2250 };
		double[] value2 = { 500, 885, 120, 395, 830, 500, 740, 256, 920, 800, 1300, 1100 };
		for (int i = 0; i < value1.length; i++) {
			income += value1[i];
			outcome += value2[i];
		}
		totalcome = income - outcome;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new chart2().getChartPanel(value1, value2));
		initInfField();// 添加信息
	}

	private void initInfField() {
		XLabel inComeLabel = new XLabel("总收入");
		XLabel inComeLabel1 = new XLabel("        ");
		XLabel outComeLabel = new XLabel("总支出");
		XLabel outComeLabel1 = new XLabel("       ");
		XLabel totalComeLabel = new XLabel("总利润");
		XLabel totalComeLabel1 = new XLabel("       ");
		inComeLabel1.setText(income + "");
		outComeLabel1.setText(outcome + "");
		totalComeLabel1.setText(totalcome + "");

		JPanel come = new JPanel();

		come.add(inComeLabel);
		come.add(inComeLabel1);
		come.add(outComeLabel);
		come.add(outComeLabel1);
		come.add(totalComeLabel1);
		come.add(totalComeLabel);
		come.add(totalComeLabel1);
		this.add(come);
	}
}
