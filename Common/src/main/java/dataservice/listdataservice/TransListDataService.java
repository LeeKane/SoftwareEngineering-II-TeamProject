package dataservice.listdataservice;

import java.io.File;
import java.io.IOException;
import java.rmi.Remote;

import po.list.TransListPO;
import po.list.TranscenterArrivalListPO;

public interface TransListDataService extends Remote{
	public void insert(TransListPO po);
	public void init();
    public TransListPO find(long id);
    public  TransListPO findlast() throws IOException;
    public String readLastLine(File file, String charset) throws IOException;
}
