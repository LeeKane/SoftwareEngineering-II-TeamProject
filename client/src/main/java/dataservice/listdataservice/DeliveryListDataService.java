package dataservice.listdataservice;

import po.list.DeliveryListPO;

public interface DeliveryListDataService {
public void insert(DeliveryListPO list);
public void delete(long code);
public void init();
	
	
}
