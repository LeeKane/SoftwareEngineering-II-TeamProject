package dataservice.garagedataservice;
import java.rmi.RemoteException;

import po.GaragePO;
import po.garageware;
public interface garagedataservice {
public  GaragePO creat(GaragePO po);
public void insert(garageware po);
public void delete(garageware po);
public void init();
public void showGarage();
	
}
