package blservice.transblservice;

import po.CarPO;
import po.DriverPO;
import po.LoadingPO;
import po.WarePO;

public interface TransBLService {
	//输出报价
	public double getCost(WarePO po);
	
	//输出估计时间
	public double getTime(WarePO po);
	
	//增加相应车辆信息
	public double addCar(CarPO po);
	
	//删除相应车辆信息
	public double deleteCar(long id);
	
	//得到相应车辆信息
	public double getCar(long id);
	
	//得到相应司机信息
	public double getDriver(long id);
	
	//增加相应司机信息
	public double addDriver(DriverPO po,long id);
	
	//删除相应司机信息
	public double deleteDriver(long id);
	
	//	增加相应装运信息
	public double addLoading(LoadingPO po);
	
	//在相应快递员下保存输入的收款
	public double getIncome(double income,long id);

}
