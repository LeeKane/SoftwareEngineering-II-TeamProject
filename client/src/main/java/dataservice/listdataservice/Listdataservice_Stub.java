package dataservice.listdataservice;
import java.rmi.RemoteException;

import po.list.ListPO;

public class Listdataservice_Stub implements ListDataService {

	
	public ListPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FIND SUCCESS!!");
		return null;
	}

	@Override
	public void insert(ListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("INSERT SUCCESS!!");
	}

	@Override
	public void delete(ListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("DELETE SUCCESS!!");
	}

	@Override
	public void update(ListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("UPDATE SUCCESS!!");
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("INIT SUCCESS!!");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FINISH SUCCESS!!");
	}

}
