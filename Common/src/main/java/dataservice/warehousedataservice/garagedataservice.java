package dataservice.warehousedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.Garage;
import po.garageitem;

public interface garagedataservice extends Remote {

	public Garage init() throws RemoteException;

	public void insert(Garage g, garageitem item) throws RemoteException;

	public garageitem find(Garage g, long id) throws RemoteException;

	public void delete(Garage g, long id) throws RemoteException;

	public double rate(Garage g) throws RemoteException;

	public void destroy(Garage g) throws RemoteException;

	public void show(Garage g) throws RemoteException;

}
