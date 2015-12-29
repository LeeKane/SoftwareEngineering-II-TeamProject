package ui.chart;

import javax.swing.JPanel;

public class chart1 {
	public JPanel getChartPanel(double[] value1,double[] value2) {
		return new LineHiddenChart(value1,value2);
	}
}
