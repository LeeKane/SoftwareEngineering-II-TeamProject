package dataservice.reviewdataservice;
import java.rmi.RemoteException;

import po.ReviewPO;

public class Reviewdataservice_Stub implements ReviewDataService {

	@Override
	public ReviewPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FIND SUCCESS!!!");
		return null;
	}

	@Override
	public void insert(ReviewPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("INSERT SUCCESS!!!");

	}

	@Override
	public void delete(ReviewPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("DELETE SUCCESS!!!");

	}

	@Override
	public void update(ReviewPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("UPDATE SUCCESS!!!");

	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("INIT SUCCESS!!!");

	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FINISH SUCCESS!!!");

	}

}
