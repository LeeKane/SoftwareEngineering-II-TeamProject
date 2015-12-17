package StubAndDriver;

import java.io.FileNotFoundException;
import java.io.IOException;

import DataServiceTxtFileImpl.GarageDataSeriaServiceImpl;
import DataServiceTxtFileImpl.WareOutDataServiceTxtImpl;
import dataservice.listdataservice.WareOutListDataService;
import dataservice.warehousedataservice.GarageDataSeriaService;
import po.Garage;
import po.GaragePlacePO;
import po.TimePO;
import po.garageitem;
import po.list.WareOutListPO;
import util.City;
import util.ListState;
import util.Vehicle;

public class WareOutListDataService_Driver {
	public void drive(WareOutListDataService service) throws FileNotFoundException, IOException, ClassNotFoundException{
	WareOutListPO po=new WareOutListPO(746413,new TimePO(2014,1,1,1,2,3),Vehicle.PLANE,City.GUANGZHOU,4567,ListState.SUBMITTED);
		service.insert(po);

		
		}
		
		public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
			WareOutListDataService service=new WareOutDataServiceTxtImpl();
			WareOutListDataService_Driver driver=new WareOutListDataService_Driver();
			driver.drive(service);
		}
}
