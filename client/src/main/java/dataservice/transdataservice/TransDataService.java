/**
 *运输管理数据层接口
 *@author parkdc
 *@date  2015/10/25
 */
package dataservice.transdataservice;
import java.rmi.RemoteException;
import po.*;
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
		public void insertDriver(WarePO po) throws RemoteException;
		//删除一个po
		public void deleteDriver(WarePO po) throws RemoteException;
		//初始化持久化数据库
		public void init() throws RemoteException;
		//结束持久化数据库
		public void finish() throws RemoteException;

}
