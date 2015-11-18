/**
 *登录管理数据层接口
 *@author parkdc
 *@date  2015/10/25
 */
package dataservice.logindataservice;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import po.AccountPO;

public interface LoginDataService {
	//按ID进行查找返回相应的LoginPO结果
	public AccountPO find(long id) throws RemoteException, FileNotFoundException, IOException;
	//在数据库中增加po记录
	public void insert(AccountPO po) throws RemoteException;
	//初始化持久化数据库
	public void init() throws RemoteException;
	//结束持久化数据库
	public void finish() throws RemoteException;

}
