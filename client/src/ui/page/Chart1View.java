package ui.page;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import ui.chart.chart1;

public class Chart1View extends JPanel{
//经营状况表
public Chart1View()
{
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
   this.add(new chart1().getChartPanel());
   initListTable();//添加收款单
}

private void initListTable() {
	// TODO Auto-generated method stub
	
}
}
