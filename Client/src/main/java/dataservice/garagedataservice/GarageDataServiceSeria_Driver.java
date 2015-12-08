package dataservice.garagedataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;

import po.Garage;
import po.TimePO;
import po.garageitem;

public class GarageDataServiceSeria_Driver implements Serializable {
	public void drive(GarageDataSeriaService service) throws FileNotFoundException, IOException, ClassNotFoundException{
	String address="TxtData/BeijingGarage.txt";
	service.breakTxt(address);
	service.init(address);
	garageitem item=new garageitem(new TimePO(1,1,1,1,1,1), 123457);
	service.insert(address, item);
	service.insert(address, item);
service.show(address);

		}
		
		public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
			GarageDataSeriaService service=new GarageDataSeriaService_Stub();
			GarageDataServiceSeria_Driver driver=new GarageDataServiceSeria_Driver();
			driver.drive(service);
		}
	
	
}
