package dataservice.StaffDataService;

import java.io.FileNotFoundException;
import java.io.IOException;

import dataservice.InstituteDataService.InstituteDataService;
import dataservice.InstituteDataService.InstituteDataService_Driver;
import dataservice.InstituteDataService.InstituteDataService_Stub;
import po.InstitutePO;
import po.StaffPO;
import util.City;
import util.OrgType;
import util.Permission;

public class StaffDataService_Driver {
	public void driver(StaffDataService service) throws FileNotFoundException, IOException{
		StaffPO po=new StaffPO("10010","10001",City.GUANGZHOU,OrgType.WAREHOUSE,Permission.CENTERCLERK);
		service.insert(service.find("12111","0001"));
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		StaffDataService service=new StaffDataService_Stub();
		StaffDataService_Driver driver=new StaffDataService_Driver();
		driver.driver(service);
	}
}
