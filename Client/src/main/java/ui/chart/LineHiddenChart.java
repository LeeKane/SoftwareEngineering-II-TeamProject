
package ui.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.LegendItemEntity;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineHiddenChart extends XChartPanellet {
	private XYLineAndShapeRenderer renderer;

	public LineHiddenChart(double[] value1,double[] value2) {
		super();
		JFreeChart chart = ChartFactory.createXYLineChart("经营状况表", "月份", "数值(x1000)", getDataset(value1,value2), PlotOrientation.VERTICAL,
				true, true, false);
		renderer = new XYLineAndShapeRenderer(true, false);// 只有XYLineAndShapeRenderer才支持setSeriesLinesVisible
		chart.getXYPlot().setRenderer(renderer);

		setChart(chart);
		addChartMouseListener(new MyChartMouseListener());
	}

	private XYDataset getDataset(double[] v1,double[] v2) {
		double[] level = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

		double[] value1 = { 400, 485, 520, 695, 730, 700, 640, 856, 1520, 1900, 2950, 2250 };
		double[] value2 = { 500, 885, 120, 395, 830, 500, 740, 256, 920, 800, 1300, 1100 };
		value1=v1;
		value2=v2;
		XYSeries series1 = new XYSeries("收入");
		XYSeries series2 = new XYSeries("支出");
		for (int i = 0; i < level.length; i++) {
			series1.add(level[i], value1[i]);
		}
		for (int i = 0; i < level.length; i++) {
			series2.add(level[i], value2[i]);
		}
		XYSeriesCollection seriesCollection = new XYSeriesCollection(series1);
		seriesCollection.addSeries(series2);
		return seriesCollection;
	}

	// 点击Lengend的时候，显示或隐藏对应的Line，注意要使用setSeriesLinesVisible
	class MyChartMouseListener implements ChartMouseListener {

		@Override
		public void chartMouseClicked(ChartMouseEvent e) {
			ChartEntity entity = e.getEntity();
			if (entity instanceof LegendItemEntity) {
				LegendItemEntity legendItem = (LegendItemEntity) entity;
				Comparable<String> seriesKey = legendItem.getSeriesKey();
				int seriesIndex = -1;
				if (seriesKey.equals("收入")) {
					seriesIndex = 0;
				}
				if (seriesKey.equals("支出")) {
					seriesIndex = 1;
				}
				boolean visible = renderer.getItemLineVisible(seriesIndex, 0);
				renderer.setSeriesLinesVisible(seriesIndex, !visible);
				// boolean flag =
				// chart.getXYPlot().getRenderer().getItemVisible(seriesIndex,
				// 1);线和legend全部消失
				// chart.getXYPlot().getRenderer().setserie.setSeriesVisible(seriesIndex,
				// new Boolean(!flag),true);
			}
		}

		@Override
		public void chartMouseMoved(ChartMouseEvent e) {
			// TODO Auto-generated method stub

		}
	}
}
