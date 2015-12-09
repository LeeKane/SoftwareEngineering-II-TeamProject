package dataservice.warehousedataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import po.Garage;
import po.garageitem;

public interface GarageDataSeriaService extends Remote {
	public void init(String address) throws RemoteException, FileNotFoundException, IOException;

	public void insert(String address, garageitem item)
			throws RemoteException, FileNotFoundException, IOException, ClassNotFoundException;

	public garageitem find(String address, long id) throws RemoteException, IOException, ClassNotFoundException;

	public void delete(String address, long id) throws RemoteException, IOException, ClassNotFoundException;

	public double rate(String address) throws RemoteException, ClassNotFoundException, IOException;

	public void destroy(String address) throws RemoteException, ClassNotFoundException, IOException;

	public void show(String address) throws RemoteException, ClassNotFoundException, IOException;

	public void breakTxt(String address) throws RemoteException;

	public Garage getGarage(String address) throws RemoteException, IOException, ClassNotFoundException;
}
