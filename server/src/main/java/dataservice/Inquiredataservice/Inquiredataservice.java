package dataservice.Inquiredataservice;
import util.*;
import java.rmi.RemoteException;
public interface Inquiredataservice {
	public InquirePO find(long id) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public void finish() throws RemoteException;

}
