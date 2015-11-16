package dataservice.Listdataservice;
import java.rmi.RemoteException;

import po.ListPO;
public interface Listdataservice {
	public ListPO find(long id) throws RemoteException;
	public void insert(ListPO po) throws RemoteException;
	
	public void delete(ListPO po) throws RemoteException;
	
	public void update(ListPO po) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public void finish() throws RemoteException;


}
