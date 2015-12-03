package dataservice.listdataservice;

import java.io.File;
import java.io.IOException;

import po.list.ArrivaListPO;
import po.list.DeliveryListPO;

public interface DeliveryListDataService {
public boolean insert(DeliveryListPO list);
public DeliveryListPO find(long code);
public void delete(long code);
public void init();
public  DeliveryListPO findlast() throws IOException;
public String readLastLine(File file, String charset) throws IOException;
	
}
