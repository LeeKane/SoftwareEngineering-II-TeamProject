package dataservice.transdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CarPO;

public interface CarDataService extends Remote {
	public void insert(CarPO car) throws RemoteException;// 增加车辆

	public CarPO find(String name) throws RemoteException, IOException;// 查找车辆

	public void delete(String name) throws RemoteException, FileNotFoundException, IOException;// 删除车辆

	public void init() throws RemoteException;// 清空内存

	public void update(CarPO car) throws RemoteException, IOException;// 更新车辆信息

	public ArrayList<CarPO> findAll() throws RemoteException, IOException;

	CarPO findlast() throws RemoteException, IOException;

}
