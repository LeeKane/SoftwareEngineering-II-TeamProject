package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.list.MoneyOutListPO;

public interface MoneyOutListDataService extends Remote {

	public void init() throws RemoteException;

	public void insert(MoneyOutListPO po) throws RemoteException;

	public MoneyOutListPO find(long id) throws RemoteException;

}
