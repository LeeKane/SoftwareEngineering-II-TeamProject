package dataservice.financedataservice;
import java.rmi.RemoteException;

import po.ReceiptPO;
public class Financedataservice_Stub implements FinanceDataService {
	public ReceiptPO find(long id) throws RemoteException{
		System.out.println("FIND SUCCESS!");
		return null;
	}
	//在数据库中增加po记录
	public void insert(ReceiptPO po) throws RemoteException {
		System.out.println("INSERT SUCCESS!");
	}
	//删除一个po
	public void delete(ReceiptPO po) throws RemoteException{
		System.out.println("DELETE SUCCESS!");
	}
	//更新一个po
	public void update(ReceiptPO po) throws RemoteException{
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
