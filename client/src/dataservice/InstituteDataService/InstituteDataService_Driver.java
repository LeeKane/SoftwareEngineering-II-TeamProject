package dataservice.InstituteDataService;

import java.io.FileNotFoundException;
import java.io.IOException;

import dataservice.DriverDataService.DriverDataService;
import dataservice.DriverDataService.DriverDataService_Driver;
import dataservice.DriverDataService.DriverDataService_Stub;
import po.DriverPO;
import po.InstitutePO;
import po.TimePO;
import util.City;
import util.OrgType;

public class InstituteDataService_Driver {
	public void driver(InstituteDataService service) throws FileNotFoundException, IOException{
		InstitutePO po=new InstitutePO(City.BEIJING,OrgType.HALL,"00010");
		service.insert(service.findlast());
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		InstituteDataService service=new InstituteDataService_Stub();
		InstituteDataService_Driver driver=new InstituteDataService_Driver();
		driver.driver(service);
	}
}
