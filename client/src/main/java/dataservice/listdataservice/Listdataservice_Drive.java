package dataservice.listdataservice;
import java.rmi.RemoteException;

import po.FinancePO;
import po.InstitutePO;
import po.StaffPO;
import po.TimePO;
import po.list.*;
import util.*;
import dataservice.financedataservice.FinanceDataService;
import dataservice.listdataservice.ListDataService;
public class Listdataservice_Drive {
	public void driver(ListDataService listdataservice) throws RemoteException{
		
		ListPO po=new ListPO();
	    long m=12345;
	    listdataservice.find(m);
		listdataservice.insert(po);
		listdataservice.delete(po);
		listdataservice.update(po);
		listdataservice.init();
		listdataservice.finish();
	}
}
