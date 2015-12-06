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
import util.ListState;

public class ListStateDataService_Driver   {
	public void driver(ListStateDataService service) throws FileNotFoundException, IOException{
		ArrayList<ArrivaListPO> list=new ArrayList<ArrivaListPO>();
		list=service.findallArrival();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getTransid());
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ListStateDataService service=new ListStateDataService_Stub();
		ListStateDataService_Driver driver=new ListStateDataService_Driver();
		driver.driver(service);
	}
	
	
}
