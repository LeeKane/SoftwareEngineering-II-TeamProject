package dataservice.listdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import po.TimePO;
import po.WarePO;
import po.list.LoadingListPO;
import po.list.OrderListPO;
import util.City;
import util.DeliverType;
import util.ListType;

public class LoadingListDataService_Driver {
	 public void drive(LoadingListDataService service) throws IOException{
		 long[]list={5,6,7,1,2,6,77};
		 LoadingListPO po=new LoadingListPO(88888,ListType.TRANS, new TimePO(2015,10,11,2,5,5), 5516332, City.BEIJING, City.GUANGZHOU, list, "chen", "wang", 15.7);

		 LoadingListPO p=new LoadingListPO(99999,ListType.TRANS, new TimePO(2015,10,11,2,5,5), 5516332, City.BEIJING, City.GUANGZHOU, list, "chen", "wang", 15.7);
		 service.insert(service.findlast());
		
	 }
	 public static void main(String[] args) throws IOException{
			LoadingListDataService service=new LoadingListDataService_Stub();
			 LoadingListDataService_Driver driver=new  LoadingListDataService_Driver();
			driver.drive(service);
		 
	 }

}
