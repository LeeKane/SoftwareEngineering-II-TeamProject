package StubAndDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import DataServiceTxtFileImpl.GarageDataSeriaServiceImpl;
import dataservice.warehousedataservice.GarageDataSeriaService;
import po.Garage;
import po.GarageBodyPO;
import po.GaragePlacePO;
import po.TimePO;
import po.garageitem;

public class GarageDataServiceSeria_Driver implements Serializable {
	public void drive(GarageDataSeriaService service) throws FileNotFoundException, IOException, ClassNotFoundException{
		garageitem item=new garageitem(new TimePO(1,1,1,1,1,1), 123457);
		garageitem item2=new garageitem(new TimePO(1,1,1,1,1,1), 1234527);
		garageitem item3=new garageitem(new TimePO(1,1,1,1,1,1), 4646);
		garageitem item4=new garageitem(new TimePO(1,1,1,1,1,1), 55555);
		GaragePlacePO place=new GaragePlacePO(1,1,1,2);
		String address="TxtData/1100.txt";

service.delete(address, 2);
service.delete(address, 3);

Garage g=service.getGarage(address);
g.show();

		
		}
		
		public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
			GarageDataSeriaService service=new GarageDataSeriaServiceImpl();
			GarageDataServiceSeria_Driver driver=new GarageDataServiceSeria_Driver();
			driver.drive(service);
		}
	
	
}
