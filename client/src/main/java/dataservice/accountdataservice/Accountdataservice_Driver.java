package dataservice.accountdataservice;
import java.rmi.RemoteException;
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
}
