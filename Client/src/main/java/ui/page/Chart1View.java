package ui.page;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import blservice.financeblservice.FinanceMOBLService;
import blservice.listblservice.MoneyInListBLService;
import blservice.reviewblservice.LogBLService;
import po.TimePO;
import po.list.MoneyInListPO;
import po.list.MoneyOutListPO;
import ui.chart.chart1;

public class Chart1View extends JPanel {
	// 经营状况表
	private FinanceMOBLService bl;
	private MoneyInListBLService mibl;
	private double[] value1 = new double[12];
	private double[] value2 = new double[12];

	public Chart1View(FinanceMOBLService bl, MoneyInListBLService mibl) {
		this.setName("经营状况表");
		this.bl = bl;
		this.mibl = mibl;
		setValue();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new chart1().getChartPanel(value1, value2));
		logadd();// 添加收款单
	}

	private void setValue() {
		// TODO Auto-generated method stub
		ArrayList<MoneyOutListPO> list = bl.findList();
		double outcome = 0;
		for (int i = 0; i < list.size(); i++) {
			outcome += list.get(i).getMoney();
		}
		double[] v2 = { outcome / 1000, 885, 120, 395, 830, 500, 740, 256, 920, 800, 1300, 1100 };
		this.value2 = v2;
		ArrayList<MoneyInListPO> MIlist = mibl.findNoDel();
		double income = 0;
		for (int i = 0; i < MIlist.size(); i++) {
			income += MIlist.get(i).getMoney();
			System.out.println(MIlist.get(i).getMoney());
		}
		System.out.println(income);
		double[] v1 = { income / 1000, 485, 520, 695, 730, 700, 640, 856, 1520, 1900, 2950, 2250 };
		this.value1 = v1;
	}

	private void logadd() {
		// TODO Auto-generated method stub
		LogBLService.insert(TimePO.getNowTimePO(),
				bl.getPo().getPermission().toString() + bl.getPo().getUsername() + "查看了经营状况表");
	}
}
