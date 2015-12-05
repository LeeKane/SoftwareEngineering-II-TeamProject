package dataservice.CarDataService;

import java.io.FileNotFoundException;
import java.io.IOException;

import dataservice.accountdataservice.AccountDataService;
import dataservice.accountdataservice.Accountdataservice_Driver;
import dataservice.accountdataservice.Accountdataservice_Stub;
import po.AccountPO;
import po.CarPO;
import po.TimePO;
import util.Permission;
import util.Vehicle;

public class CarDataService_Driver {
	public void driver(CarDataService service) throws FileNotFoundException, IOException{
		CarPO car=new CarPO(Vehicle.CAR,"154321452",5516332,"苏A88888",1544563,new TimePO(2015,1,2,3,4,5),new TimePO(2015,10,2,3,4,5));
		CarPO car2=new CarPO(Vehicle.CAR,"154321453",5516333,"苏A66666",1544564,new TimePO(2015,1,2,3,4,5),new TimePO(2015,10,2,3,4,5));
		service.init();
		service.insert(car);
		service.insert(car2);
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		CarDataService service=new CarDataService_Stub();
		CarDataService_Driver driver=new CarDataService_Driver();
		driver.driver(service);
	}
}
