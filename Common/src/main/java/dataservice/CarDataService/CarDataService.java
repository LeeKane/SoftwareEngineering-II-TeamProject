package dataservice.CarDataService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.util.ArrayList;

import po.AccountPO;
import po.CarPO;

public interface CarDataService extends Remote{
public void insert(CarPO car);//增加车辆
public CarPO find(String name) throws IOException;//查找车辆
public void delete(String name) throws FileNotFoundException, IOException;//删除车辆
public void init();//清空内存
public void update(CarPO car) throws IOException;//更新车辆信息
public ArrayList<CarPO> findAll() throws IOException;
CarPO findlast() throws IOException;
	
	
	
	
}
