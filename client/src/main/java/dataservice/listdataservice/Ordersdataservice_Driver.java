package dataservice.listdataservice;

import java.rmi.RemoteException;
import po.*;
import util.DeliverType;

public class Ordersdataservice_Driver {
 public void drive(OrdersDataService service){
	 TimePO time=new TimePO(1,1,1,1,1,1);
	 WarePO po=new WarePO (12345 , 10, 10, "1", "book",DeliverType.ECO,156, time);
	 service.insert(po);
 }
 public static void main(String[] args) throws RemoteException{
		OrdersDataService service=new Ordersdataservice_Stub();
		Ordersdataservice_Driver driver=new Ordersdataservice_Driver();
		driver.drive(service);
	 
 }
}
