package dataservice.listdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import po.list.*;
import util.*;
import dataservice.listdataservice.ListDataService;
import dataservice.logindataservice.LoginDataService;
import dataservice.logindataservice.Logindataservice_Driver;
import dataservice.logindataservice.Logindataservice_Stub;
public class Listdataservice_Drive {
	public void driver(ListDataService listdataservice) throws RemoteException, FileNotFoundException{
		
		ListPO po=new ListPO(ListType.ARRIVE, 2);
	    long m=3;
	    listdataservice.insert(po);
	    ListPO po2=listdataservice.find(m);
	    System.out.println(po2.toString());
		
		listdataservice.delete(po);
		listdataservice.update(po);
		
		listdataservice.finish();
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ListDataService service=new Listdataservice_Stub();
		Listdataservice_Drive driver=new Listdataservice_Drive();
		driver.driver(service);
	}
	
	
}
