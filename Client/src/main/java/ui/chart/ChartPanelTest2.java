package ui.chart;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class ChartPanelTest2 {
	public JPanel getChartPanel() {
		List<JPanel> chartPanels = new ArrayList<JPanel>();
		// 柱图
		chartPanels.add(new StackBarChart());
		chartPanels.add(new StackBarChart2());
		// chartPanels.add(new AreaChart());//this
		// 线图
		chartPanels.add(new PieChart());
		chartPanels.add(new GanttChart());
		chartPanels.add(new DialChart());
		chartPanels.add(new MeterChart());
		chartPanels.add(new BubbleChart());
		chartPanels.add(new ScatterChart());

		XChartPanel chartPanel = new XChartPanel(3, 3, chartPanels);
		return chartPanel;
	}
}
