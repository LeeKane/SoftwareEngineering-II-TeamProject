package dataservice.garagedataservice;

import java.rmi.RemoteException;

import po.GaragePO;
import po.garageware;



public class garagedataservice_Driver {
public void drive(garagedataservice service) throws RemoteException{
		
		GaragePO po=null;
	   garageware p=null;
	    service.creat(po);
	    service.insert(p);
	    service.delete(p);
	    service.init();
	   service.showGarage();
	}
	
	public static void main(String[] args) throws RemoteException {
		garagedataservice service=new garagedataservice_Stub();
		garagedataservice_Driver driver=new garagedataservice_Driver();
		driver.drive(service);
	}
}
