package dataservice.listdataservice;

import po.list.DeliveryListPO;

public interface DeliveryListDataService {
public boolean insert(DeliveryListPO list);
public DeliveryListPO find(long code);
public void delete(long code);
public void init();
	
	
}
