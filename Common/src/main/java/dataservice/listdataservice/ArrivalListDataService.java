package dataservice.listdataservice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import po.list.ArrivaListPO;

public interface ArrivalListDataService {
  
	public boolean insert(ArrivaListPO po);
	public void init();
	public ArrivaListPO find(long id);
	public  ArrivaListPO findlast() throws IOException;
	public String readLastLine(File file, String charset) throws IOException;
	public ArrayList<ArrivaListPO> findNoneReviewd() throws IOException;
	 public ArrayList<ArrivaListPO> findallArrival() throws IOException;
}
