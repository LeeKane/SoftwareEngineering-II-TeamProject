package testserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import testservice.TestService;

public class TestServiceImpl extends UnicastRemoteObject implements TestService{
	public TestServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void test() throws RemoteException {
		System.out.println("Test Succeeded!");
	}
}
