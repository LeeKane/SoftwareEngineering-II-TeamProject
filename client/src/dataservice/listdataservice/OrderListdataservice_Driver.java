package dataservice.listdataservice;

import java.rmi.RemoteException;
import po.*;
import po.list.OrderListPO;
import util.DeliverType;
import util.ListType;

public class OrderListdataservice_Driver {
 public void drive(OrderListDataService service){
	 TimePO time=new TimePO(1,1,1,1,1,1);
	 WarePO ware=new WarePO (12345 , 10, 10, "1", "book",DeliverType.ECO,156, time);
	 OrderListPO po = new OrderListPO(ListType.ORDER, "PIOA", "NK", "NJU", "18351286346", "48641356845", "ss", "gwareth", "sdfg", "13587975646", "13549864756", ware, "ok");
	 service.insert(po);
 }
 public static void main(String[] args) throws RemoteException{
		OrderListDataService service=new OrderListdataservice_Stub();
		OrderListdataservice_Driver driver=new OrderListdataservice_Driver();
		driver.drive(service);
	 
 }
}
