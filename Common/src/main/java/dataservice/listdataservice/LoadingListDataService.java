package dataservice.listdataservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.ArrivaListPO;
import po.list.DeliveryListPO;
import po.list.ListPO;
import po.list.LoadingListPO;

public interface LoadingListDataService extends Remote {


	public void insert(LoadingListPO po) throws RemoteException ;
	
	public LoadingListPO find(long id) throws RemoteException, FileNotFoundException;
	public  LoadingListPO findlast() throws RemoteException, IOException;
	public String readLastLine(File file, String charset) throws RemoteException, IOException;
	public void init()throws RemoteException;
	public ArrayList<LoadingListPO> findallLoading() throws RemoteException, IOException;
	public ArrayList<LoadingListPO> findNoneReviewed()throws RemoteException, IOException;
}