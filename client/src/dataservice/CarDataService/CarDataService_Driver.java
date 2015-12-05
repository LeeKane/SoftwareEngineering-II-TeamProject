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
		CarPO ca=new CarPO(Vehicle.CAR,"164321452",5516332,"苏A89998",15445213,new TimePO(2015,1,2,3,4,5),new TimePO(2015,10,2,3,4,5));
	service.insert(ca);
	
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		CarDataService service=new CarDataService_Stub();
		CarDataService_Driver driver=new CarDataService_Driver();
		driver.driver(service);
	}
}
