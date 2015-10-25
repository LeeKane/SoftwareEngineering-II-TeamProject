package dataservice.Logindataservice;
import java.rmi.RemoteException;

public interface Logindataservice {
	public LoginPO(long id) throws RemoteException;

	public void insert(LoginPO po) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public void finish() throws RemoteException;


}
