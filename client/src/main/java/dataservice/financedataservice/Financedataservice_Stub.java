package dataservice.financedataservice;
import java.rmi.RemoteException;

import po.FinancePO;
public class Financedataservice_Stub implements FinanceDataService {
	public FinancePO find(long id) throws RemoteException{
		System.out.println("FIND SUCCESS!");
		return null;
	}
	//在数据库中增加po记录
	public void insert(FinancePO po) throws RemoteException {
		System.out.println("INSERT SUCCESS!");
	}
	//删除一个po
	public void delete(FinancePO po) throws RemoteException{
		System.out.println("DELETE SUCCESS!");
	}
	//更新一个po
	public void update(FinancePO po) throws RemoteException{
		System.out.println("UPDATE SUCCESS!");
	}
	//初始化持久化数据库
	public void init() throws RemoteException{
		System.out.println("INIT SUCCESS!");
	}
	//结束持久化数据库
	public void finish() throws RemoteException{
		System.out.println("FINISH SUCCESS!");
	}
	
	
}
