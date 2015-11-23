package dataservice.accountdataservice;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import po.*;
import util.*;

public class Accountdataservice_Driver {
public void driver(AccountDataService accountdataservice) throws FileNotFoundException, IOException{
	AccountPO po=new AccountPO(151239,Permission.MANAGER,"bosser","123456");
    long m=151239;
    AccountPO accountPO=accountdataservice.find(m);
  
	
	accountdataservice.delete(po);
	
	accountdataservice.finish();
}
public static void main(String[] args) throws FileNotFoundException, IOException {
	AccountDataService service=new Accountdataservice_Stub();
	Accountdataservice_Driver driver=new Accountdataservice_Driver();
	driver.driver(service);
}
}
