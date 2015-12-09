package dataservice.listdataservice;

import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.ArrivaListPO;

public interface ArrivalListDataService extends Remote {

	public boolean insert(ArrivaListPO po) throws RemoteException;

	public void init() throws RemoteException;

	public ArrivaListPO find(long id) throws RemoteException;

	public ArrivaListPO findlast() throws RemoteException, IOException;

	public String readLastLine(File file, String charset) throws RemoteException, IOException;

	public ArrayList<ArrivaListPO> findNoneReviewd() throws RemoteException, IOException;

	public ArrayList<ArrivaListPO> findallArrival() throws RemoteException, IOException;
}
