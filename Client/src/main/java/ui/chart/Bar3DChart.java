package ui.chart;

import java.awt.Paint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import ui.XContorlUtil;

public class Bar3DChart extends XChartPanellet {
	public Bar3DChart(double[] s) {
		init(s);
	}

	public void init(double[] s) {
		// 因为这里bar的颜色会根据警戒值变化，所以Legend不显示，否则会混乱
		JFreeChart jfreechart = ChartFactory.createBarChart3D("", "", "金额", getDataset(s), PlotOrientation.VERTICAL,
				false, true, false);
		CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
		CustomBarRenderer3D custombarrenderer3d = new CustomBarRenderer3D();
		custombarrenderer3d.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		custombarrenderer3d.setBaseItemLabelsVisible(true);
		custombarrenderer3d.setItemLabelAnchorOffset(10D);
		custombarrenderer3d.setBasePositiveItemLabelPosition(
				new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		categoryplot.setRenderer(custombarrenderer3d);
		// 警戒线
		// ValueMarker valuemarker = new ValueMarker(180.00D, new Color(200,
		// 200, 255), new BasicStroke(1.0F),
		// new Color(200, 200, 255), new BasicStroke(1.0F), 1.0F);
		// categoryplot.addRangeMarker(valuemarker, Layer.BACKGROUND);
		// custombarrenderer3d.setBaseItemLabelsVisible(true);
		// custombarrenderer3d.setMaximumBarWidth(0.050000000000000003D);
		// 标记 (名称，在哪个domain区域内，对应的rangAxis坐标的值是多少)
		// CategoryTextAnnotation categorytextannotation = new
		// CategoryTextAnnotation("警戒线", "江西", 181.0D);
		// categorytextannotation.setCategoryAnchor(CategoryAnchor.START);
		// categorytextannotation.setFont(new Font("宋体", 0, 12));
		// // 标记的对齐方式
		// categorytextannotation.setTextAnchor(TextAnchor.BOTTOM_CENTER);
		// categoryplot.addAnnotation(categorytextannotation);

		// NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
		// numberaxis.setNumberFormatOverride(NumberFormat.getPercentInstance());
		// numberaxis.setUpperMargin(0.10000000000000001D);

		setChart(jfreechart);
	}

	public CategoryDataset getDataset(double[] s) {
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		defaultcategorydataset.clear();
		defaultcategorydataset.addValue(s[1], "", "财务人员");
		defaultcategorydataset.addValue(s[2], "", "总经理");
		defaultcategorydataset.addValue(s[3], "", "营业厅业务员");
		defaultcategorydataset.addValue(s[4], "", "中转中心业务员");
		defaultcategorydataset.addValue(s[5], "", "仓库管理员");
		defaultcategorydataset.addValue(s[6], "", "快递员");
		return defaultcategorydataset;
	}

	class CustomBarRenderer3D extends BarRenderer3D {

		public Paint getItemPaint(int i, int j) {
			return XContorlUtil.SELECTED_TEXT_COLOR;
		}

		public CustomBarRenderer3D() {
		}
	}
}
