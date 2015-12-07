package dataservice.listdataservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.ArrivaListPO;
import po.list.DeliveryListPO;
import po.list.ListPO;
import po.list.LoadingListPO;

public interface LoadingListDataService {


	public void insert(LoadingListPO po) throws RemoteException ;
	
	public LoadingListPO find(long id) throws RemoteException, FileNotFoundException;
	public  LoadingListPO findlast() throws IOException;
	public String readLastLine(File file, String charset) throws IOException;
	public void init();
	public ArrayList<LoadingListPO> findallLoading() throws IOException;
	public ArrayList<LoadingListPO> findNoneReviewed()throws IOException;
}