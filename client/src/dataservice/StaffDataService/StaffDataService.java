package dataservice.StaffDataService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import po.StaffPO;

public interface StaffDataService {

public void init();
public void insert(StaffPO po);
public StaffPO find(String orgid,String id) throws FileNotFoundException, IOException;
public String readLastLine(File file, String charset) throws IOException;
public StaffPO findlast() throws IOException;
	
}
