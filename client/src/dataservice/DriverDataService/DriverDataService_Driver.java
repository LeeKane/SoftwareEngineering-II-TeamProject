package dataservice.DriverDataService;

import java.io.FileNotFoundException;
import java.io.IOException;

import dataservice.CarDataService.CarDataService;
import dataservice.CarDataService.CarDataService_Driver;
import dataservice.CarDataService.CarDataService_Stub;
import po.CarPO;
import po.DriverPO;
import po.TimePO;
import util.Vehicle;

public class DriverDataService_Driver {
	public void driver(DriverDataService service) throws FileNotFoundException, IOException{
		long a=123456;
		DriverPO po=new DriverPO(a,"老司机",new TimePO(1980,12,11,1,1,1),"12345","454564","BeijingDriverClub","male","2015年12月");
		DriverPO p=new DriverPO(a,"小司机",new TimePO(1980,12,11,1,1,1),"12345","454564","BeijingDriverClub","male","2015年12月");
		service.update(p);
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		DriverDataService service=new DriverDataService_Stub();
		DriverDataService_Driver driver=new DriverDataService_Driver();
		driver.driver(service);
	}
}
