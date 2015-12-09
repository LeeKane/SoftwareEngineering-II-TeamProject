package dataservice.transdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DriverPO;

public interface DriverDataService extends Remote {
	public void insert(DriverPO po) throws RemoteException;

	public ArrayList<DriverPO> findAll() throws RemoteException, IOException;

	public DriverPO find(long number) throws RemoteException, IOException;

	public void delete(long number) throws RemoteException, FileNotFoundException, IOException;

	public void init() throws RemoteException;

	public void update(DriverPO po) throws RemoteException, IOException;

	DriverPO findlast() throws RemoteException, IOException;
}
