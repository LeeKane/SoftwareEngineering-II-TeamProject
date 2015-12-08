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
import po.list.TranscenterArrivalListPO;
import util.City;
import util.DeliverType;
import util.GoodState;
import util.ListState;
import util.ListType;

public class ListStateDataService_Driver   {
	public void driver(ListStateDataService service) throws FileNotFoundException, IOException{
		ArrayList<TranscenterArrivalListPO> result=null;
		result=service.findNoneReviewedTrans();
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i).getLst());
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ListStateDataService service=new ListStateDataService_Stub();
		ListStateDataService_Driver driver=new ListStateDataService_Driver();
		driver.driver(service);
	}
	
	
}
