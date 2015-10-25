package dataservice.Reviewdataservice;
import java.rmi.RemoteException;
public interface Reviewdataservice {
	public ReviewPO find(long id) throws RemoteException;
	public void insert(ReviewPO po) throws RemoteException;

	public void delete(ReviewPO po) throws RemoteException;
	
	public void update(ReviewPO po) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public void finish() throws RemoteException;

}
