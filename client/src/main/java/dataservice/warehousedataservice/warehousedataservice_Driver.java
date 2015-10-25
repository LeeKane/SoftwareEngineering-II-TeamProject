package dataservice.warehousedataservice;
import java.rmi.RemoteException;

import po.*;
import util.*;
import dataservice.reviewdataservice.ReviewDataService;
import dataservice.warehousedataservice.WarehouseDataService;
public class warehousedataservice_Driver {
	public void driver(WarehouseDataService service) throws RemoteException{
		
		WareHousePO po=new WareHousePO();
	    long m=12345;
	    service.find(m);
	    service.insert(po);
	    service.delete(po);
	    service.update(po);
	    service.init();
	    service.finish();
	}
}
