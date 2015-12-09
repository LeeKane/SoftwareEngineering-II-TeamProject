/**
 *单据数据层接口
 *@author parkdc
 *@date  2015/10/25
 */
package dataservice.listdataservice;

import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import po.list.ListPO;

public interface ListDataService extends Remote {
	// 按ID进行查找返回相应的ListPO结果
	public ListPO find(long id) throws RemoteException, FileNotFoundException;

	// 在数据库中增加po记录
	public void insert(ListPO po) throws RemoteException;

	// 删除一个po
	public void delete(ListPO po) throws RemoteException;

	// 更新一个po
	public void update(ListPO po) throws RemoteException;

	// 初始化持久化数据库
	public void init() throws RemoteException;

	// 结束持久化数据库
	public void finish() throws RemoteException;

}
