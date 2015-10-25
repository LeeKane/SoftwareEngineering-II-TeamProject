/**
 *登录管理数据层接口
 *@author parkdc
 *@date  2015/10/25
 */
package dataservice.logindataservice;
import java.rmi.RemoteException;

public class LoginDataService {
	//按ID进行查找返回相应的LoginPO结果
	Public LoginPO find(long id) throws RemoteException;
	//在数据库中增加po记录
	public void insert(LoginPO po) throws RemoteException;
	//初始化持久化数据库
	public void init() throws RemoteException;
	//结束持久化数据库
	public void finish() throws RemoteException;

}
