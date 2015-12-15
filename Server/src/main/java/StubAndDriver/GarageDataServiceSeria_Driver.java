package StubAndDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;

import DataServiceTxtFileImpl.GarageDataSeriaServiceImpl;
import dataservice.warehousedataservice.GarageDataSeriaService;
import po.Garage;
import po.GaragePlacePO;
import po.TimePO;
import po.garageitem;

public class GarageDataServiceSeria_Driver implements Serializable {
	public void drive(GarageDataSeriaService service) throws FileNotFoundException, IOException, ClassNotFoundException{
		garageitem item=new garageitem(new TimePO(1,1,1,1,1,1), 123457);
		garageitem item2=new garageitem(new TimePO(1,1,1,1,1,1), 1234527);
		garageitem item3=new garageitem(new TimePO(1,1,1,1,1,1), 1234557);
		garageitem item4=new garageitem(new TimePO(1,1,1,1,1,1), 2234557);
		String address="TxtData/10086.txt";
		service.init(address);
		
		}
		
		public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
			GarageDataSeriaService service=new GarageDataSeriaServiceImpl();
			GarageDataServiceSeria_Driver driver=new GarageDataServiceSeria_Driver();
			driver.drive(service);
		}
	
	
}
