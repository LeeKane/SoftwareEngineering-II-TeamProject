package dataservice.listdataservice;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;

import po.list.ListPO;
import po.list.LoadingListPO;

public interface LoadingListDataService {
	public void insert(LoadingListPO po) throws RemoteException ;
	
	public LoadingListPO find(long id) throws RemoteException, FileNotFoundException;
	
	public void init();
}