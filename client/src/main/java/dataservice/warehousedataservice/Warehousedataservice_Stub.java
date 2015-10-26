package dataservice.warehousedataservice;

import java.rmi.RemoteException;

import po.WareHousePO;

public class Warehousedataservice_Stub implements WarehouseDataService {

	@Override
	public WareHousePO find(long id) throws RemoteException {
		System.out.println("FIND SUCCESS!!!!");
		return new WareHousePO(1, 1, 1, 1);
	}

	@Override
	public void insert(WareHousePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("INSERT SUCCESS!!!!");
	}

	@Override
	public void delete(WareHousePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("DELETE SUCCESS!!!!");
	}

	@Override
	public void update(WareHousePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("UPDATE SUCCESS!!!!");
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("INIT SUCCESS!!!!");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FINISH SUCCESS!!!!");
	}

}
