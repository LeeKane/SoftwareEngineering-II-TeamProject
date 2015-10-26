/**
 *运输管理数据层接口
 *@author parkdc
 *@date  2015/10/25
 */
package dataservice.transdataservice;
import java.rmi.RemoteException;

import po.CarPO;
import po.DriverPO;
import po.LoadingPO;
import po.WarePO;
public interface TransDataService {
		//按ID进行查找返回相应的TransPO结果
		public WarePO findWare(long id) throws RemoteException;
		//在数据库中增加po记录
		public void insertWare(WarePO po) throws RemoteException;
		//删除一个po
		public void deleteWare(WarePO po) throws RemoteException;
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
		public LoadingPO findLoading(long id) throws RemoteException;
		//在数据库中增加po记录
		public void insertLoading(LoadingPO po) throws RemoteException;
		//删除一个po
		public void deleteLoading(LoadingPO po) throws RemoteException;
		//初始化持久化数据库
		public void init() throws RemoteException;
		//结束持久化数据库
		public void finish() throws RemoteException;

}
