package dataservice.accountdataservice;
import java.rmi.RemoteException;

import po.*;

public  class Accountdataservice_Stub implements AccountDataService {

	@Override
	public AccountPO find(long id) throws RemoteException {
		System.out.println("FIND SUCCESS");
	
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("INSERT SUCCESS");

	}

	@Override
	public void delete(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("DELETE SUCCESS");

	}

	@Override
	public void update(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("UPDATE SUCCESS");

	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("INIT SUCCESS");

	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FINISH SUCCESS");

	}

	
	
}
