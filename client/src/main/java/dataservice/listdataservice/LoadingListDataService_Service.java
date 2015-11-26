package dataservice.listdataservice;

import java.rmi.RemoteException;

import po.TimePO;
import po.WarePO;
import po.list.OrderListPO;
import util.DeliverType;
import util.ListType;

public class LoadingListDataService_Service {
	 public void drive(OrderListDataService service){
		 
	 }
	 public static void main(String[] args) throws RemoteException{
			OrderListDataService service=new OrderListdataservice_Stub();
			OrderListdataservice_Driver driver=new OrderListdataservice_Driver();
			driver.drive(service);
		 
	 }

}
