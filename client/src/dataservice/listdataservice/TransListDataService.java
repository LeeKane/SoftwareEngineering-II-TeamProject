package dataservice.listdataservice;

import po.list.TransListPO;

public interface TransListDataService {
	public void insert(TransListPO po);
	public void init();
    public TransListPO find(long id);
}
