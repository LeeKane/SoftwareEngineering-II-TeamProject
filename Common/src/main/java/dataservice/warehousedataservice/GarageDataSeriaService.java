package dataservice.warehousedataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import po.GaragePlacePO;
import po.garageitem;
import util.Garage;

public interface GarageDataSeriaService extends Remote {
	public void init(String address) throws RemoteException, FileNotFoundException, IOException;

	public void insert(String address, garageitem item)
			throws RemoteException, FileNotFoundException, IOException, ClassNotFoundException;

	public GaragePlacePO find(String address, long id) throws RemoteException, IOException, ClassNotFoundException;

	public void delete(String address, long id) throws RemoteException, IOException, ClassNotFoundException;

	public double rate(String address) throws RemoteException, ClassNotFoundException, IOException;

	public void destroy(String address) throws RemoteException, ClassNotFoundException, IOException;

	public void show(String address) throws RemoteException, ClassNotFoundException, IOException;

	public void breakTxt(String address) throws RemoteException;

	public boolean insertByPlace(String address, garageitem item, GaragePlacePO place)
			throws RemoteException, FileNotFoundException, IOException, ClassNotFoundException;

	public Garage getGarage(String address) throws RemoteException, IOException, ClassNotFoundException;

	public void initgarage(long centerid) throws RemoteException;
}
