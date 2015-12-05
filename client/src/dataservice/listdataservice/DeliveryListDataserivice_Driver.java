package dataservice.listdataservice;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

import po.TimePO;
import po.WarePO;
import po.list.DeliveryListPO;
import util.DeliverType;
import util.ListState;

public class DeliveryListDataserivice_Driver {
	 public void drive(DeliveryListDataService service) throws IOException{
		 TimePO time=new TimePO(1,1,1,1,1, 0);
		DeliveryListPO  po=new DeliveryListPO(1111111111,time, 1524512, "JOHN",ListState.SUBMITTED);
		DeliveryListPO  p=new DeliveryListPO(222222222,time, 15245133, "JOHNSON",ListState.REVIEWED);
		
		 File file = new File("TxtData/DeliveryList.txt");
			String Line = service.readLastLine(file, "UTF-8");
			System.out.println(Line);
		
		
	 }
	 public static void main(String[] args) throws IOException{
			DeliveryListDataService service=new DeliveryListDataservice_Stub();
			DeliveryListDataserivice_Driver driver=new DeliveryListDataserivice_Driver();
			driver.drive(service);
		 
	 }
	
	
	
}
