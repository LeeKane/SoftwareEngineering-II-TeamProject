package dataservice.WareHousedataservice;
import java.rmi.RemoteException;

import po.WareHousePO;
public interface WareHousedataservice {
	public WareHousePO find(long id) throws RemoteException;
	public void insert(WareHousePO po) throws RemoteException;
	
	public void delete(WareHousePO po) throws RemoteException;
	
	public void update(WareHousePO po) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public void finish() throws RemoteException;

}