package dataservice.CarDataService;

import po.CarPO;

public interface CarDataService {
public void insert(CarPO car);//增加车辆
public CarPO find(String name);//查找车辆
public void delete(String name);//删除车辆
public void init();//清空内存
public void update(CarPO car);//更新车辆信息

	
	
	
	
}
