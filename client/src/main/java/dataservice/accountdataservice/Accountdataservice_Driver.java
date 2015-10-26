package dataservice.accountdataservice;
import java.rmi.RemoteException;
import po.*;
import util.*;

public class Accountdataservice_Driver {
public void driver(AccountDataService accountdataservice) throws RemoteException{
	AccountPO po=new AccountPO(Permission.MANAGER,"boss","123456");
    long m=123456;
    AccountPO accountPO=accountdataservice.find(m);
    System.out.println(accountPO.toString());
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
