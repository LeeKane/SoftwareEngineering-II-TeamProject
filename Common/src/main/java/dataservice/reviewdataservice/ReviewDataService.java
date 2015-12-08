/**
 *s审查管理数据层接口
 *@author parkdc
 *@date  2015/10/25
 */
package dataservice.reviewdataservice;
import java.rmi.Remote;
import java.rmi.RemoteException;

import po.*;



public interface ReviewDataService extends Remote{

	//按ID进行查找返回相应的ReviewPO结果
	public ReviewPO find(long id) throws RemoteException;
	//在数据库中增加po记录
	public void insert(ReviewPO po) throws RemoteException;
	//删除一个po
	public void delete(ReviewPO po) throws RemoteException;
	//更新一个po
	public void update(ReviewPO po) throws RemoteException;
	//初始化持久化数据库
	public void init() throws RemoteException;
	//结束持久化数据库
	public void finish() throws RemoteException;

}
