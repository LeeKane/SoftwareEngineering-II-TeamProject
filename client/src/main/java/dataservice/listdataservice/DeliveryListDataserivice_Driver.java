package dataservice.listdataservice;

import java.rmi.RemoteException;

import po.TimePO;
import po.WarePO;
import po.list.DeliveryListPO;
import util.DeliverType;

public class DeliveryListDataserivice_Driver {
	 public void drive(DeliveryListDataService service){
		 TimePO time=new TimePO(1,1,1,1,1, 0);
		DeliveryListPO  po=new DeliveryListPO(time, 1524512, "JOHN");
		
		 service.insert(po);
		 service.delete(1234);
	 }
	 public static void main(String[] args) throws RemoteException{
			DeliveryListDataService service=new DeliveryListDataservice_Stub();
			DeliveryListDataserivice_Driver driver=new DeliveryListDataserivice_Driver();
			driver.drive(service);
		 
	 }
	
	
	
}
