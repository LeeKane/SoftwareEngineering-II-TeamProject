package dataservice.listdataservice;

import java.io.File;
import java.io.IOException;

import po.list.DeliveryListPO;
import po.list.TranscenterArrivalListPO;

public interface TransCenterArrivalListDataService  {
	public void insert(TranscenterArrivalListPO po);
	public void init();
    public TranscenterArrivalListPO find(long id);
    public  TranscenterArrivalListPO findlast() throws IOException;
    public String readLastLine(File file, String charset) throws IOException;
}
