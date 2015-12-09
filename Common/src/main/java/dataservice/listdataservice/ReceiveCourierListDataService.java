package dataservice.listdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import po.list.ReceiveCourierListPO;

public interface ReceiveCourierListDataService extends Remote {
	public void insert(ReceiveCourierListPO po) throws RemoteException;

	public void delete(long id)
			throws RemoteException, UnsupportedEncodingException, FileNotFoundException, IOException;

	public ReceiveCourierListPO find(long id) throws RemoteException, IOException;

	public void update(ReceiveCourierListPO po) throws RemoteException, IOException;

	public void init() throws RemoteException;
}
