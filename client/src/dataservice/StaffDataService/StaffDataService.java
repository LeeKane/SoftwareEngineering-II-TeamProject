package dataservice.StaffDataService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import po.StaffPO;
import util.City;
import util.OrgType;
import util.Permission;

public interface StaffDataService {

	public void init();
	public void insert(StaffPO po);
	public StaffPO find(String orgid,String id) throws FileNotFoundException, IOException;
	public String readLastLine(File file, String charset) throws IOException;
	public StaffPO findlast(String orgId,String permission) throws IOException;
	public ArrayList<String> findbyOrg(City city,OrgType org) throws IOException;
	public void delete(String orgid,String id) throws IOException;
	public void update(StaffPO po) throws IOException;
	public ArrayList<StaffPO> findAll() throws IOException;
}
