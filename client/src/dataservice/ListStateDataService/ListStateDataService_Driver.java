package dataservice.ListStateDataService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import dataservice.DriverDataService.DriverDataService;
import dataservice.DriverDataService.DriverDataService_Driver;
import dataservice.DriverDataService.DriverDataService_Stub;
import po.DriverPO;
import po.TimePO;
import po.list.ArrivaListPO;
import po.list.DeliveryListPO;
import util.City;
import util.GoodState;
import util.ListState;
import util.ListType;

public class ListStateDataService_Driver   {
	public void driver(ListStateDataService service) throws FileNotFoundException, IOException{
		ArrayList<ArrivaListPO> list=new ArrayList<ArrivaListPO>();
		TimePO time=new TimePO(2043, 7, 13, 0, 0, 0);
		ArrivaListPO p=new ArrivaListPO(ListType.ARRIVE, time, 1210011214, City.GUANGZHOU, GoodState.BROKEN,ListState.REVIEWED,15346215);
		service.updateArrival(p);
		
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ListStateDataService service=new ListStateDataService_Stub();
		ListStateDataService_Driver driver=new ListStateDataService_Driver();
		driver.driver(service);
	}
	
	
}
