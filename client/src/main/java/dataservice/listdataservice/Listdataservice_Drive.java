package dataservice.listdataservice;

import java.rmi.RemoteException;
import po.list.*;
import util.*;
import dataservice.listdataservice.ListDataService;
public class Listdataservice_Drive {
	public void driver(ListDataService listdataservice) throws RemoteException{
		
		ListPO po=new ListPO(ListType.ARRIVE, 1);
	    long m=12345;
	    ListPO po2=listdataservice.find(m);
	    System.out.println(po2.toString());
		listdataservice.insert(po);
		listdataservice.delete(po);
		listdataservice.update(po);
		listdataservice.init();
		listdataservice.finish();
	}
}
