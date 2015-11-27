package dataservice.listdataservice;

import po.list.TranscenterArrivalListPO;

public interface TransCenterArrivalListDataService  {
	public void insert(TranscenterArrivalListPO po);
	public void init();
    public TranscenterArrivalListPO find(long id);
}
