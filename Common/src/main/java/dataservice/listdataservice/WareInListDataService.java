package dataservice.listdataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GarageBodyPO;
import po.TimePO;
import po.list.WareInListPO;

public interface WareInListDataService extends Remote {

	public void init() throws RemoteException;

	public void insert(WareInListPO po) throws RemoteException;

	public WareInListPO find(long id) throws RemoteException, IOException;

	public void delete(long id) throws RemoteException, IOException;

	public ArrayList<GarageBodyPO> findWareIn(TimePO start, TimePO end, long centerid)
			throws RemoteException, IOException;

	public ArrayList<GarageBodyPO> findWareOut(TimePO start, TimePO end, long centerid)
			throws RemoteException, IOException;

}
