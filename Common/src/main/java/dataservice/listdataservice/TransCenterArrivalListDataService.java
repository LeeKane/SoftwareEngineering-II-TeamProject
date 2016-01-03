package dataservice.listdataservice;

import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.TranscenterArrivalListPO;
import vo.TransShow;

public interface TransCenterArrivalListDataService extends Remote {
	public void insert(TranscenterArrivalListPO po) throws RemoteException;

	public long getTransid(long centerid, long id) throws RemoteException;

	public void init() throws RemoteException;

	public ArrayList<TransShow> findtrans(long centerid) throws RemoteException;

	public TranscenterArrivalListPO find(long id) throws RemoteException;

	public TranscenterArrivalListPO findlast() throws RemoteException, IOException;

	public String readLastLine(File file, String charset) throws RemoteException, IOException;

	public String findAllOrder(long id) throws RemoteException, IOException;
}
