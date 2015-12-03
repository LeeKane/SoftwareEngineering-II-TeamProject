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
		TranscenterArrivalListPO po=new TranscenterArrivalListPO(15536, new TimePO(1,2,3,4,5,6), 4545124, City.BEIJING, GoodState.INTACE);
		TranscenterArrivalListPO p=new TranscenterArrivalListPO(15536, new TimePO(2015,2,3,4,5,2), 454511124, City.BEIJING, GoodState.INTACE);
	
		service.insert(service.findlast());
		}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		TransCenterArrivalListDataService service=new TransCenterArrivalListDataService_Stub();
		TransCenterArrivalListDataService_Driver driver=new TransCenterArrivalListDataService_Driver();
		driver.driver(service);
	}
	
	
}
