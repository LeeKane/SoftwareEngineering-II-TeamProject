package bl.trans;

import blservice.transblservice.TransBLService;
import po.CarPO;
import po.DriverPO;
import po.WarePO;
import po.list.LoadingListPO;
import util.ResultMessage;

public class Trans implements TransBLService  {

	@Override
	public double getCost(WarePO po) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTime(WarePO po) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage addCar(CarPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteCar(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarPO getCar(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverPO getDriver(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addDriver(DriverPO po, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteDriver(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addLoading(LoadingListPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getIncome(double income, long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void endTrans() {
		// TODO Auto-generated method stub
		
	}

}
