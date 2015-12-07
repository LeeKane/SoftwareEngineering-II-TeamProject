package dataservice.StaffDataService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import po.StaffPO;
import util.City;
import util.OrgType;

public interface StaffDataService {

public void init();
public void insert(StaffPO po);
public StaffPO find(String orgid,String id) throws FileNotFoundException, IOException;
public String readLastLine(File file, String charset) throws IOException;
public StaffPO findlast() throws IOException;
public ArrayList<String>findbyOrg(City city,OrgType org) throws IOException;
}
