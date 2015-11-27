package dataservice.listdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;

import po.AccountPO;
import po.TimePO;
import po.list.TranscenterArrivalListPO;
import util.City;
import util.GoodState;
import util.Permission;
import dataservice.logindataservice.LoginDataService;
import dataservice.logindataservice.Logindataservice_Driver;
import dataservice.logindataservice.Logindataservice_Stub;

public class TransCenterArrivalListDataService_Driver {
	public void driver(TransCenterArrivalListDataService service) throws FileNotFoundException, IOException{
		TranscenterArrivalListPO po=new TranscenterArrivalListPO(15536, new TimePO(1,1,1,1,1,1), 4545124, City.BEIJING, GoodState.INTACE);
		service.insert(po);
		service.init();
		}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		TransCenterArrivalListDataService service=new TransCenterArrivalListDataService_Stub();
		TransCenterArrivalListDataService_Driver driver=new TransCenterArrivalListDataService_Driver();
		driver.driver(service);
	}
	
	
}
