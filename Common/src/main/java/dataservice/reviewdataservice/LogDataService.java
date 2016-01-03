package dataservice.reviewdataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogPO;

public interface LogDataService extends Remote {
	public void init() throws RemoteException;

	public void insert(LogPO po) throws RemoteException, IOException;

	public ArrayList<LogPO> findAll() throws RemoteException, IOException;
}
