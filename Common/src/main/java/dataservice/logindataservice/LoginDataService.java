/**
 *登录管理数据层接口
 *@author parkdc
 *@date  2015/10/25
 */
package dataservice.logindataservice;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;

public interface LoginDataService extends Remote {

	//按ID进行查找返回相应的LoginPO结果
	public AccountPO find(String username) throws RemoteException, FileNotFoundException, IOException;
	public ArrayList<AccountPO> findAll() throws RemoteException, FileNotFoundException, IOException;
	//在数据库中增加po记录
	public void insert(AccountPO po) throws RemoteException;
	public void update(AccountPO po) throws RemoteException, IOException;
	//初始化持久化数据库
	public void init() throws RemoteException;
	public void delete(long  id) throws RemoteException, UnsupportedEncodingException, FileNotFoundException, IOException;
	public AccountPO findlast() throws RemoteException, IOException;
	public String readLastLine(File file, String charset) throws RemoteException, IOException ;
	//结束持久化数据库
	public void finish() throws RemoteException;
    public boolean login(String username,String password) throws RemoteException, FileNotFoundException, IOException;
}
