package dataservice.accountdataservice;
import java.rmi.RemoteException;

import dataservice.warehousedataservice.WarehouseDataService;
import dataservice.warehousedataservice.Warehousedataservice_Driver;
import dataservice.warehousedataservice.Warehousedataservice_Stub;
import po.*;
import util.*;

public class Accountdataservice_Driver {
public void driver(AccountDataService accountdataservice) throws RemoteException{
	AccountPO po=new AccountPO(Permission.MANAGER,"boss","123456");
    long m=123456;
    accountdataservice.find(m);
	accountdataservice.insert(po);
 accountdataservice.delete(po);
 accountdataservice.update(po);
 accountdataservice.init();
 accountdataservice.finish();
}
public static void main(String[] args) throws RemoteException {
	AccountDataService service=new Accountdataservice_Stub();
	Accountdataservice_Driver driver=new Accountdataservice_Driver();
	driver.driver(service);
}
}
