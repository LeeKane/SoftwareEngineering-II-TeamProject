package dataservice.logindataservice;

import java.rmi.RemoteException;

import po.AccountPO;
import util.*;

public class Logindataservice_Stub implements LoginDataService {

	AccountPO po=new AccountPO(151235,Permission.MANAGER,"kobe","bryant");
	
	@Override
	public AccountPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FIND SUCCESS");
		return po;
	}

	@Override
	public void insert(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("INSERT SUCCESS");
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
