package blservice.transblservice;

import po.CarPO;
import po.DriverPO;
import po.LoadingPO;
import po.WarePO;
import util.ResultMessage;
import vo.CarVO;
import vo.DriverVO;

public interface TransBLService {
	//输出报价
	public double getCost(WarePO po);
	
	//输出估计时间
	public double getTime(WarePO po);
	
	//增加相应车辆信息
	public ResultMessage addCar(CarPO po);
	
	//删除相应车辆信息
	public ResultMessage deleteCar(long id);
	
	//得到相应车辆信息
	public CarPO getCar(long id);
	
	//得到相应司机信息
	public DriverPO getDriver(long id);
	
	//增加相应司机信息
	public ResultMessage addDriver(DriverPO po,long id);
	
	//删除相应司机信息
	public ResultMessage deleteDriver(long id);
	
	//	增加相应装运信息
	public ResultMessage addLoading(LoadingPO po);
	
	//在相应快递员下保存输入的收款
	public double getIncome(double income,long id);
	
	//结束Trans
	public void endTrans();

}
