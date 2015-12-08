package dataservice.StaffDataService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import dataservice.reviewdataservice.InstituteDataService_Driver;
import po.InstitutePO;
import po.StaffPO;
import util.City;
import util.OrgType;
import util.Permission;

public class StaffDataService_Driver {
	public void driver(StaffDataService service) throws FileNotFoundException, IOException{
		ArrayList<String> result=service.findbyOrg(City.NANJING, OrgType.HALL);
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i));
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		StaffDataService service=new StaffDataService_Stub();
		StaffDataService_Driver driver=new StaffDataService_Driver();
		driver.driver(service);
	}
}
