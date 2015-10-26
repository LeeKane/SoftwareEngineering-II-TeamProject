package dataservice.transdataservice;

import java.rmi.RemoteException;

import po.CarPO;
import po.DriverPO;
import po.LoadingPO;
import po.TimePO;
import po.WarePO;
import util.DeliverType;

public class TransDataService_Stub implements TransDataService{
	private double weight ;
	private int amount;
	private double volume;
	private String pack;
	private String name;
	private DeliverType type;
	private double cost;
	private TimePO time;
	
	
	
	@Override
	public WarePO findWare(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWare(WarePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWare(WarePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DriverPO findDriver(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertDriver(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDriver(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CarPO findCar(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCar(CarPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCar(CarPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LoadingPO findLoading(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertLoading(LoadingPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLoading(LoadingPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
