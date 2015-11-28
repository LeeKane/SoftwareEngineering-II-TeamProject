package dataservice.listdataservice;

import po.list.ArrivaListPO;

public interface ArrivalListDataService {
  
	public boolean insert(ArrivaListPO po);
	public void init();
	public ArrivaListPO find(long id);
	
}
