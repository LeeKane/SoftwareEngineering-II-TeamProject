package dataservice.logindataservice;

import java.rmi.RemoteException;
import po.*;
import util.Permission;
public class Logindataservice_Driver {
public void driver(LoginDataService service) throws RemoteException{
	AccountPO po=new AccountPO(151536,Permission.MANAGER,"james","bryant");
	service.find(12345);
	service.insert(po);
	service.init();
	service.finish();
	}
public static void main(String[] args) throws RemoteException {
	LoginDataService service=new Logindataservice_Stub();
	Logindataservice_Driver driver=new Logindataservice_Driver();
	driver.driver(service);
}


}
