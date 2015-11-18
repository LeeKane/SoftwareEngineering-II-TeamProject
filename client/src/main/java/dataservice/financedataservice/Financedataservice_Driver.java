package dataservice.financedataservice;
import java.rmi.RemoteException;

import po.*;
import util.*;
import dataservice.financedataservice.FinanceDataService;
public class Financedataservice_Driver {
	public void driver(FinanceDataService financedataservice) throws RemoteException{
		StaffPO staff=new StaffPO("JOHN",123456,OrgType.HALL,Permission.MANAGER);
		InstitutePO institute=new InstitutePO(City.BEIJING,OrgType.HALL,12345);
		TimePO time=new TimePO(2015,1,1,1,1,1);
		ReceiptPO po=new ReceiptPO(staff,  institute, 100.21, time);
	    long m=12345;
	    financedataservice.find(m);
	    financedataservice.insert(po);
	    financedataservice.delete(po);
	    financedataservice.update(po);
	    financedataservice.init();
	    financedataservice.finish();
	}
	public static void main(String[] args) throws RemoteException {
		FinanceDataService service=new Financedataservice_Stub();
		Financedataservice_Driver driver=new Financedataservice_Driver();
		driver.driver(service);
	}
}
