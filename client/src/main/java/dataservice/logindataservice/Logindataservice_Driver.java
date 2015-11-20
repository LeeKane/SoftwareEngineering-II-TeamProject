package dataservice.logindataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import po.*;
import util.Permission;
public class Logindataservice_Driver {
public void driver(LoginDataService service) throws FileNotFoundException, IOException{
	AccountPO po=new AccountPO(151536,Permission.MANAGER,"jdames","bryant");
	long k=151536;
	service.init();
	service.insert(po);
	AccountPO p=service.find(k);
service.insert(p);
	service.finish();
	}
public static void main(String[] args) throws FileNotFoundException, IOException {
	LoginDataService service=new Logindataservice_Stub();
	Logindataservice_Driver driver=new Logindataservice_Driver();
	driver.driver(service);
}


}
