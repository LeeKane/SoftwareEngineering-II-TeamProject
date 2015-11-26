package dataservice.listdataservice;

import po.list.DeliveryListPO;

public interface DeliveryListDataService {
public boolean insert(DeliveryListPO list);
public void delete(long code);
public void init();
	
	
}
