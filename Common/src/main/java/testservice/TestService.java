package testservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TestService extends Remote {
	public void test() throws RemoteException;
}
