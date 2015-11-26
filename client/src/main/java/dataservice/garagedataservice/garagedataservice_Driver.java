package dataservice.garagedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GarageBodyPO;
import po.GaragePO;
import po.GaragePlacePO;
import po.TimePO;
import po.garageitem;



public class garagedataservice_Driver {
public void drive(garagedataservice service) throws RemoteException{
		
	garageitem item=new garageitem(new TimePO(1,1,1,1,1,1), 123457);
	garageitem item2=new garageitem(new TimePO(1,1,1,1,1,1), 1234527);
	 ArrayList<GarageBodyPO>list=service.creat();
	   service.insert(list, item);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	   service.insert(list, item2);
	  
	  list.get(3).getPlace().showplace();
	}
	
	public static void main(String[] args) throws RemoteException {
		garagedataservice service=new garagedataservice_Stub();
		garagedataservice_Driver driver=new garagedataservice_Driver();
		driver.drive(service);
	}
}
