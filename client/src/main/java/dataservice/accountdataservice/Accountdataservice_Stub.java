package dataservice.accountdataservice;
import java.rmi.RemoteException;

import po.*;
import util.Permission;

public  class Accountdataservice_Stub implements AccountDataService {

	@Override
	public AccountPO find(long id) throws RemoteException {
		System.out.println("FIND SUCCESS");
	
		// TODO Auto-generated method stub
		return new AccountPO(151236,Permission.COURIER, "HaHa", "1s1s1s");
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
