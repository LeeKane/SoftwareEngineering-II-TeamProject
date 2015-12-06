package dataservice.MoneyInListDataService;

import po.list.MoneyInListPO;

public interface MoneyInListDataService {
	
	public void init();
	public void insert(MoneyInListPO po);
	public MoneyInListPO find(long id);
	
}
