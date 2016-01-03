package ui.chart;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class ChartPanelTest1 {
	public JPanel getChartPanel() {
		List<JPanel> chartPanels = new ArrayList<JPanel>();
		// // 柱图
		// chartPanels.add(new BarChart());
		// chartPanels.add(new BarXYChart());
		//// chartPanels.add(new Bar3DChart());
		// // 线图
		// chartPanels.add(new LineChart());
		// chartPanels.add(new CombinedLineAndBarChart());

		chartPanels.add(new DynamicDatasetChart());
		chartPanels.add(new IntervalChart());
		chartPanels.add(new StackLineChart());

		XChartPanel chartPanel = new XChartPanel(3, 3, chartPanels);
		return chartPanel;
	}
}
