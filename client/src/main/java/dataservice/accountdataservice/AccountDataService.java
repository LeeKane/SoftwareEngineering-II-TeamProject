/**
 *账号管理数据层接口
 *@author parkdc park
 *@date  2015/10/25
 */
package dataservice.accountdataservice;
import java.rmi.RemoteException;


public interface AccountDataService {
	//按ID进行查找返回相应的AccountPO结果
	Public AccountPO find(long id) throws RemoteException;
    //在数据库中增加po记录
	public void insert(AccountPO po) throws RemoteException;
	//删除一个po
	public void delete(AccountPO po) throws RemoteException;
	//更新一个po
	public void update(AccountPO po) throws RemoteException;
	//初始化持久化数据库
	public void init() throws RemoteException;
	//结束持久化数据库
	public void finish() throws RemoteException;
	

}
