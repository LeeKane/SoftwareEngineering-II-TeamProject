package blservice.financeblservice;

import po.BaccountPO;
import po.CostchartPO;
import po.InstitutePO;
import po.ReceiptPO;
import po.StaffPO;
import po.StatisticalchartPO;
import po.TimePO;
import util.City;
import util.ListType;
import util.OrgType;
import util.Permission;
import util.ResultMessage;
import util.RewardType;

public class FinanceBLService_Driver {
	public void drive(FinanceBLService financeBLService) {

		ResultMessage balanceman = financeBLService.BalanceMan(
				new ReceiptPO(new StaffPO("10000", "1000", City.NANJING, OrgType.CENTER, Permission.COURIER),
						new InstitutePO(City.BEIJING, OrgType.CENTER, "1"), 1, new TimePO(1, 1, 1, 1, 1, 1)));
		if (balanceman == ResultMessage.SUCCESS)
			System.out.println("BalanceManagement Succeeded!");

		ResultMessage costman = financeBLService.CostMan(new BaccountPO("haha", "asd", "piid"),
				new CostchartPO(ListType.MONEYIN, new TimePO(1, 1, 1, 1, 1, 1), 1, "haha", "shar", 1,
						new TimePO(1, 1, 1, 1, 1, 1), 1, 1, 1, new TimePO(1, 1, 1, 1, 1, 1), 1, RewardType.COUNT));
		if (costman == ResultMessage.SUCCESS)
			System.out.println("CostManagement Succeeded!");

		ResultMessage statisticalchart = financeBLService.StatisticalChart(
				new StatisticalchartPO(false, ListType.MONEYIN, ResultMessage.SUCCESS, new TimePO(1, 1, 1, 1, 1, 1)));
		if (statisticalchart == ResultMessage.SUCCESS)
			System.out.println("StatisticalChart Succeeded!");

		ResultMessage baccountreview = financeBLService.BaccountReview(new BaccountPO("haha", "asd", "piid"));
		if (baccountreview == ResultMessage.SUCCESS)
			System.out.println("BaccountReview Succeeded!");

		ResultMessage baccountinit = financeBLService.BaccountInit(new BaccountPO("haha", "asd", "piid"));
		if (baccountinit == ResultMessage.SUCCESS)
			System.out.println("BaccountInit Succeeded!");

		financeBLService.endFinanace();
	}

	public static void main(String[] args) {
		FinanceBLService financeBLService = new FinanceBLService_Stub();
		FinanceBLService_Driver driver = new FinanceBLService_Driver();
		driver.drive(financeBLService);
	}

}
