package dataservice.ListStateDataService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import dataservice.DriverDataService.DriverDataService;
import dataservice.DriverDataService.DriverDataService_Driver;
import dataservice.DriverDataService.DriverDataService_Stub;
import po.DriverPO;
import po.TimePO;
import po.WarePO;
import po.list.ArrivaListPO;
import po.list.DeliveryListPO;
import po.list.LoadingListPO;
import po.list.OrderListPO;
import util.City;
import util.DeliverType;
import util.GoodState;
import util.ListState;
import util.ListType;

public class ListStateDataService_Driver   {
	public void driver(ListStateDataService service) throws FileNotFoundException, IOException{
		 long[]list={5,6,7,1,2,6,77,0};
		 LoadingListPO po=new LoadingListPO(77777,ListType.DELIVER, new TimePO(2015,10,11,2,5,5), 5516332, City.BEIJING, City.GUANGZHOU, list, "chen", "wang", 15.7,ListState.REVIEWED);
         service.updateLoading(po);
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ListStateDataService service=new ListStateDataService_Stub();
		ListStateDataService_Driver driver=new ListStateDataService_Driver();
		driver.driver(service);
	}
	
	
}
