package dataservice.moneyoutlistdataservice;

import java.rmi.Remote;

import po.list.MoneyInListPO;
import po.list.MoneyOutListPO;

public interface MoneyOutListDataService extends Remote{
	
	public void init();
	public void insert(MoneyOutListPO po);
	public MoneyOutListPO find(long id);

}
