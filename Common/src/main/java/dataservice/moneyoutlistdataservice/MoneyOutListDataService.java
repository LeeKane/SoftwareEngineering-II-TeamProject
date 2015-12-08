package dataservice.moneyoutlistdataservice;

import po.list.MoneyInListPO;
import po.list.MoneyOutListPO;

public interface MoneyOutListDataService {
	
	public void init();
	public void insert(MoneyOutListPO po);
	public MoneyOutListPO find(long id);

}
