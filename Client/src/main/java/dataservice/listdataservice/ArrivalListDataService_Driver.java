package dataservice.listdataservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import po.TimePO;
import po.list.ArrivaListPO;
import util.City;
import util.GoodState;
import util.ListState;
import util.ListType;



public class ArrivalListDataService_Driver {
	public void driver(ArrivalListDataService service) throws FileNotFoundException, IOException{
		ArrayList<ArrivaListPO> result=new ArrayList<ArrivaListPO>();
		result=service.findNoneReviewd();
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i).getLst().toString());
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ArrivalListDataService service=new ArrivalListDataService_Stub();
		ArrivalListDataService_Driver driver=new ArrivalListDataService_Driver();
		driver.driver(service);
	}
	
	
}
