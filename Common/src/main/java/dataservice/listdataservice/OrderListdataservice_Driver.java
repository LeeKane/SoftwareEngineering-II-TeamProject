package dataservice.listdataservice;

import java.io.IOException;
import java.rmi.RemoteException;
import po.*;
import po.list.OrderListPO;
import util.DeliverType;
import util.ListType;

public class OrderListdataservice_Driver {
 public void drive(OrderListDataService service) throws IOException{
	 TimePO time=new TimePO(1,2,3,4,5,6);
	 WarePO ware=new WarePO (12345 , 10, 10, "1", "book",DeliverType.ECO,156, time);
	 OrderListPO po = new OrderListPO(ListType.ORDER, "PIOA", "NK", "NJU", "18351286346", "48641356845", "ss", "gwareth", "sdfg", "13587975646", "13549864756", ware, "123456");

	
	
	 service.insert(service.findlast());
 }
 public static void main(String[] args) throws IOException{
		OrderListDataService service=new OrderListdataservice_Stub();
		OrderListdataservice_Driver driver=new OrderListdataservice_Driver();
		driver.drive(service);
	 
 }
}
