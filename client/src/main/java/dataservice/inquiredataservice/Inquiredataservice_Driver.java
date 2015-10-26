package dataservice.inquiredataservice;

import java.rmi.RemoteException;


public class Inquiredataservice_Driver {
public void drive(InquireDataService service) throws RemoteException{
	service.find(123456);
	service.init();
	service.finish();
}
public static void main(String[] args) throws RemoteException{
	InquireDataService Service=new Inquiredataservice_Stub();
	Inquiredataservice_Driver driver=new Inquiredataservice_Driver();
	driver.drive(Service);
	
}
}
