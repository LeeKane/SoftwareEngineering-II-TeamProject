/**
 *运输管理数据层接口
 *@author parkdc
 *@date  2015/10/25
 */
package dataservice.transdataservice;
import java.rmi.RemoteException;

public class TransDataService {
	//按ID进行查找返回相应的TransPO结果
		Public TransPO find(long id) throws RemoteException;
		//在数据库中增加po记录
		public void insert(TransPO po) throws RemoteException;
		//删除一个po
		public void delete(TransPO po) throws RemoteException;
		//初始化持久化数据库
		public void init() throws RemoteException;
		//结束持久化数据库
		public void finish() throws RemoteException;

}
