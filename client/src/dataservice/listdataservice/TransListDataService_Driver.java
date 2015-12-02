package dataservice.listdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;

import po.TimePO;
import po.list.TransListPO;
import po.list.TranscenterArrivalListPO;
import util.City;
import util.GoodState;
import util.ListType;

public class TransListDataService_Driver {
	public void driver(TransListDataService service) throws FileNotFoundException, IOException{
		
		long[] list={1,2,3,4,5};
		TransListPO po=new TransListPO(ListType.TRANS, new TimePO(1,1,1,1,1,1), 123, 456, City.BEIJING, City.GUANGZHOU, 4654654, "lin", list, 1500.8);
		service.init();
		service.insert(po);
		TransListPO p=service.find(123);
		service.insert(p);
		}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		TransListDataService service=new TransListDataService_Stub();
		TransListDataService_Driver driver=new TransListDataService_Driver();
		driver.driver(service);
	}
}
