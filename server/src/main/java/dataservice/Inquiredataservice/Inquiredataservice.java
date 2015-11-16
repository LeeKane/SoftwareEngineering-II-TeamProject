package dataservice.Inquiredataservice;
import java.rmi.RemoteException;

import po.InquirePO;
public interface Inquiredataservice {
	public InquirePO find(long id) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public void finish() throws RemoteException;

}
