/**
 *财务数据层接口
 *@author parkdc park
 *@date  2015/10/25
 */

package dataservice.financedataservice;
import java.rmi.RemoteException;
import util.*;
import po.*;

public interface FinanceDataService {
	//按ID进行查找返回相应的FinancePO结果
	public FinancePO find(long id) throws RemoteException;
	//在数据库中增加po记录
	public void insert(FinancePO po) throws RemoteException;
	//删除一个po
	public void delete(FinancePO po) throws RemoteException;
	//更新一个po
	public void update(FinancePO po) throws RemoteException;
	//初始化持久化数据库
	public void init() throws RemoteException;
	//结束持久化数据库
	public void finish() throws RemoteException;

}
