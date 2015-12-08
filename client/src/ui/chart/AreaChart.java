package ui.chart;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.TextAnchor;

public class AreaChart extends XChartPanellet
{
	double[] value1=new double[12] ;
    double[] value2 =new double[12];
	public AreaChart(double[] value1,double[] value2)
	{
		this.value1=value1;
		this.value2=value2;
		JFreeChart jfreechart = ChartFactory.createXYAreaChart("成本收益表", "月份", "数值", getDataset(), PlotOrientation.VERTICAL, true, true, false);
		XYPlot xyplot = (XYPlot)jfreechart.getPlot();
		
		xyplot.setForegroundAlpha(0.65F);//设置前景透明度
		ValueAxis domainAxis = xyplot.getDomainAxis();
		domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());//整型标注
		domainAxis.setLowerMargin(0.0);
		domainAxis.setUpperMargin(0.0);
		
		XYTextAnnotation textAnnotation = new XYTextAnnotation("",2005, 2256);	//x和y分别是domain和range坐标的值	
		textAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
		xyplot.addAnnotation(textAnnotation);
		
		setChart(jfreechart);
	}
	private XYDataset getDataset()
	{
		
		XYSeries series1 = new XYSeries("收入");
		for(int i=0;i<value1.length;i++)
		{
			series1.add(i+1,value1[i]);
		}
		XYSeries series2 = new XYSeries("支出");
		for(int i=0;i<value1.length;i++)
		{
			series2.add(i+1,value2[i]);
		}
		
		XYSeriesCollection seriesCollection = new XYSeriesCollection();
		seriesCollection.addSeries(series1);
		seriesCollection.addSeries(series2);
		return seriesCollection;
	}
}
