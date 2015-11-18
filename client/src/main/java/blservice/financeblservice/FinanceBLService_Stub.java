package blservice.financeblservice;

import po.BaccountPO;
import po.CostchartPO;
import po.FinancePO;
import po.StatisticalchartPO;
import util.ResultMessage;

public class FinanceBLService_Stub implements FinanceBLService{

	@Override
	public ResultMessage BalanceMan(FinancePO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage CostMan(BaccountPO ba, CostchartPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage StatisticalChart(StatisticalchartPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage BaccountReview(BaccountPO ba) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage BaccountInit(BaccountPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public void endFinanace() {
		// TODO Auto-generated method stub
		System.out.println("Finance Ended!");
		
	}

}
