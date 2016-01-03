package dataservice.financedataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BaccountPO;

public interface BAccountManageDataService extends Remote {
	public void init() throws RemoteException;

	public ArrayList<BaccountPO> findAll() throws RemoteException, IOException;

	public void insert(BaccountPO po) throws RemoteException;

	public void delete(String id) throws RemoteException, IOException;

	public BaccountPO find(String id) throws RemoteException;

	public void update(BaccountPO po) throws RemoteException, IOException;
}
