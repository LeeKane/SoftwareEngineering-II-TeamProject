package dataservice.inquiredataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.TransPO;


public class Inquiredataservice_Driver {
public void drive(InquireDataService service) throws RemoteException{
	List<TransPO> po=service.find(123456);
	System.out.println(po.toString());
	service.init();
	service.finish();
}
public static void main(String[] args) throws RemoteException{
	InquireDataService Service=new Inquiredataservice_Stub();
	Inquiredataservice_Driver driver=new Inquiredataservice_Driver();
	driver.drive(Service);
	
}
}
