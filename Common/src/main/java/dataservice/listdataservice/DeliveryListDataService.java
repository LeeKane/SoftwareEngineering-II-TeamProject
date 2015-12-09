package dataservice.listdataservice;

import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.DeliveryListPO;

public interface DeliveryListDataService extends Remote {
	public boolean insert(DeliveryListPO list) throws RemoteException;

	public DeliveryListPO find(long code) throws RemoteException;

	public void delete(long code) throws RemoteException;

	public void init() throws RemoteException;

	public DeliveryListPO findlast() throws RemoteException, IOException;

	public String readLastLine(File file, String charset) throws RemoteException, IOException;

	public ArrayList<DeliveryListPO> findallDelivery() throws RemoteException, IOException;

	public ArrayList<DeliveryListPO> findNoneReviewed() throws RemoteException, IOException;
}
