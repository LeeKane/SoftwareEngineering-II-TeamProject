package dataservice.reviewdataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SetupPO;

public interface BeginningSetupDataService extends Remote {
	public void insert(SetupPO po) throws RemoteException, IOException;

	public void init() throws RemoteException;

	public ArrayList<SetupPO> findAll() throws RemoteException, IOException;

	public void delete(String time) throws RemoteException, IOException;

	public void update(SetupPO po) throws RemoteException, IOException;

	public void swap(SetupPO po1, SetupPO po2) throws RemoteException, IOException;

	public void init(String address) throws RemoteException, IOException;

	public void initgarage(long centerid, SetupPO po) throws RemoteException;
}
