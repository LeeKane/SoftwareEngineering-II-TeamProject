package dataservice.listdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;

import po.TimePO;
import po.list.ArrivaListPO;
import util.City;
import util.GoodState;
import util.ListState;
import util.ListType;



public class ArrivalListDataService_Driver {
	public void driver(ArrivalListDataService service) throws FileNotFoundException, IOException{
		TimePO time=new TimePO(2043, 7, 13, 0, 0, 0);
		ArrivaListPO po=new ArrivaListPO(ListType.ARRIVE, time, 454124, City.BEIJING, GoodState.BROKEN,ListState.REVIEWED,15346210);
		ArrivaListPO p=new ArrivaListPO(ListType.ARRIVE, time, 454125, City.BEIJING, GoodState.BROKEN,ListState.REVIEWED,15346215);
		
		service.insert(service.findlast());

	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ArrivalListDataService service=new ArrivalListDataService_Stub();
		ArrivalListDataService_Driver driver=new ArrivalListDataService_Driver();
		driver.driver(service);
	}
	
	
}
