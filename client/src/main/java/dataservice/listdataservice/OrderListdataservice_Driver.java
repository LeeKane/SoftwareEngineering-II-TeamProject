package dataservice.listdataservice;

import java.rmi.RemoteException;
import po.*;
import util.DeliverType;

public class OrderListdataservice_Driver {
 public void drive(OrderListDataService service){
	 TimePO time=new TimePO(1,1,1,1,1,1);
	 WarePO po=new WarePO (12345 , 10, 10, "1", "book",DeliverType.ECO,156, time);
	 service.insert(po);
 }
 public static void main(String[] args) throws RemoteException{
		OrderListDataService service=new OrderListdataservice_Stub();
		OrderListdataservice_Driver driver=new OrderListdataservice_Driver();
		driver.drive(service);
	 
 }
}
