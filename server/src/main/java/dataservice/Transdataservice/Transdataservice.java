package dataservice.Transdataservice;
import java.rmi.RemoteException;
public interface Transdataservice {
	public TransPO find(long id) throws RemoteException;
	public void insert(TransPO po) throws RemoteException;
	
	public void delete(TransPO po) throws RemoteException;

	public void insert() throws RemoteException;
	
	public void finish() throws RemoteException;


}
