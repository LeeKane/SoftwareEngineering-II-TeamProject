package ui.chart;

import javax.swing.JPanel;

public class chart2 {
	public JPanel getChartPanel(double[] value1,double[] value2)
	{
		return new AreaChart(value1,value2);
	}
}
