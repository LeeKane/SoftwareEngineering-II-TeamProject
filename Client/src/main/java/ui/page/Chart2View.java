package ui.page;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import blservice.financeblservice.FinanceMOBLService;
import blservice.listblservice.MoneyInListBLService;
import po.list.MoneyInListPO;
import po.list.MoneyOutListPO;
import ui.XLabel;
import ui.chart.chart2;

//成本收益表
public class Chart2View extends JPanel {
	private long income;
	private long outcome;
	private long totalcome;
	private FinanceMOBLService bl;
private MoneyInListBLService mibl;
    private double[] value1 = new double[12];
    private double[] value2= new double[12];
	public Chart2View(FinanceMOBLService bl,MoneyInListBLService mibl) {
		this.setName("查看统计分析");
   this.bl=bl;
   this.mibl=mibl;
	this.value1=null;
		this.value2 = null;
		setValue();
		for (int i = 0; i < value1.length; i++) {
			income += value1[i];
			outcome += value2[i];
		}
		totalcome = income - outcome;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new chart2().getChartPanel(value1, value2));
		initInfField();// 添加信息
	}
    
	private void setValue() {
		// TODO Auto-generated method stub
		ArrayList<MoneyOutListPO> MOlist=bl.findList();
		double outcome=0;
		for(int i=0;i<MOlist.size();i++)
		{
			outcome+=MOlist.get(i).getMoney();
		}
		double[] v2 = { outcome/1000, 885, 120, 395, 830, 500, 740, 256, 920, 800, 1300, 1100 };
		this.value2=v2;
		 ArrayList<MoneyInListPO> MIlist=mibl.findNoDel();
		 double income=0;
			for(int i=0;i<MIlist.size();i++)
			{
				income+=MIlist.get(i).getMoney();
				System.out.println(MIlist.get(i).getMoney());
			}
			System.out.println(income);
			double[] v1 = { income/1000, 485, 520, 695, 730, 700, 640, 856, 1520, 1900, 2950, 2250 };
			this.value1=v1;
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
