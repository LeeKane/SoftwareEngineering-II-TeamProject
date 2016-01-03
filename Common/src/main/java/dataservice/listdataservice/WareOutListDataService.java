package dataservice.listdataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import po.GaragePlacePO;
import po.list.WareOutListPO;

public interface WareOutListDataService extends Remote {
	public void init() throws RemoteException;

	public void insert(WareOutListPO po, GaragePlacePO place) throws RemoteException;

	public WareOutListPO find(long id) throws RemoteException, IOException;

	public void delete(long id) throws RemoteException, IOException;

	public boolean findWare(long id) throws RemoteException, IOException;

	public void deleteWareIn(long id) throws RemoteException, IOException;

	public boolean findMotor(long id) throws IOException, RemoteException;
}
