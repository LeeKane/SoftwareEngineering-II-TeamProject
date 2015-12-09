/**
 *查询数据层接口
 *@author parkdc park
 *@date  2015/10/25
 */

package dataservice.inquiredataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TransPO;

public interface InquireDataService extends Remote {
	// 按ID进行查找返回相应的InquirePO结果
	public ArrayList<TransPO> find(long id) throws RemoteException;

	// 插入历史轨迹信息
	public void insert(TransPO transPO) throws RemoteException;

	// 初始化持久化数据库
	public void init() throws RemoteException;

	// 结束持久化数据库
	public void finish() throws RemoteException;

}
