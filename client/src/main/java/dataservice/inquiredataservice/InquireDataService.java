/**
 *查询数据层接口
 *@author parkdc park
 *@date  2015/10/25
 */

package dataservice.inquiredataservice;
import java.rmi.RemoteException;

public interface InquireDataService {
	//按ID进行查找返回相应的InquirePO结果
	Public InquirePO find(long id) throws RemoteException;
	//初始化持久化数据库
	public void init() throws RemoteException;
	//结束持久化数据库
	public void finish() throws RemoteException;

}
