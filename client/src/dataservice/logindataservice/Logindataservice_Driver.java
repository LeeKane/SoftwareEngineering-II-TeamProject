package dataservice.logindataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import po.*;
import util.Permission;
public class Logindataservice_Driver {
public void driver(LoginDataService service) throws FileNotFoundException, IOException{
AccountPO p=new AccountPO(151231,Permission.DRIVER,"boss","hello");
service.update(p);
	service.finish();
	}
public static void main(String[] args) throws FileNotFoundException, IOException {
	LoginDataService service=new Logindataservice_Stub();
	Logindataservice_Driver driver=new Logindataservice_Driver();
	driver.driver(service);
}


}
