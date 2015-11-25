/**
 *运输管理数据层接口
 *@author parkdc
 *@date  2015/10/25
 */
package dataservice.transdataservice;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;

import po.CarPO;
import po.DriverPO;
import po.list.LoadingListPO;
import po.WarePO;
import po.list.LoadingListPO;
public interface TransDataService {
		//按ID进行查找返回相应的TransPO结果
		public WarePO findWare(long id) throws RemoteException;
		//在数据库中增加po记录
		public void insertWare(WarePO po) throws RemoteException;
		//删除一个po
		public void deleteWare(WarePO po) throws RemoteException, FileNotFoundException;
		//按ID进行查找返回相应的TransPO结果
		public DriverPO findDriver(long id) throws RemoteException;
		//在数据库中增加po记录
		public void insertDriver(DriverPO po) throws RemoteException;
		//删除一个po
		public void deleteDriver(DriverPO po) throws RemoteException;
		//按ID进行查找返回相应的TransPO结果
		public CarPO findCar(long id) throws RemoteException;
		//在数据库中增加po记录
		public void insertCar(CarPO po) throws RemoteException;
		//删除一个po
		public void deleteCar(CarPO po) throws RemoteException;
		//按ID进行查找返回相应的TransPO结果
		public LoadingListPO findLoading(long id) throws RemoteException;
		//在数据库中增加po记录
		public void insertLoading(LoadingListPO po) throws RemoteException;
		//删除一个po
		public void deleteLoading(LoadingListPO po) throws RemoteException;
		//初始化持久化数据库
		public void init() throws RemoteException;
		//结束持久化数据库
		public void finish() throws RemoteException;

}
