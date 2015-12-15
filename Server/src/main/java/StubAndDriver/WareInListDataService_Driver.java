package StubAndDriver;

import java.io.File;
import java.io.IOException;

import DataServiceTxtFileImpl.WareInListDataServiceTxtImpl;
import dataservice.listdataservice.WareInListDataService;
import po.GaragePlacePO;
import po.TimePO;
import po.list.DeliveryListPO;
import po.list.WareInListPO;
import util.City;
import util.ListState;

public class WareInListDataService_Driver {
	 public void drive(WareInListDataService service) throws IOException{
		 TimePO time=new TimePO(1,1,1,1,1, 0);
		 GaragePlacePO place=new GaragePlacePO(1,2,3,1);
	WareInListPO list=new WareInListPO(4647,time,City.BEIJING,place,ListState.SUBMITTED);

	service.delete(4646);
	 }
	 public static void main(String[] args) throws IOException{
		 WareInListDataService service=new WareInListDataServiceTxtImpl();
		 WareInListDataService_Driver driver=new WareInListDataService_Driver();
			driver.drive(service);
		 
	 }
}
