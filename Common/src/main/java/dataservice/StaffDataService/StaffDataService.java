package dataservice.StaffDataService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StaffPO;
import util.City;
import util.OrgType;

public interface StaffDataService extends Remote{

	public void init()throws RemoteException;
	public void insert(StaffPO po)throws RemoteException;
	public StaffPO find(String orgid,String id) throws RemoteException, FileNotFoundException, IOException;
	public String readLastLine(File file, String charset) throws RemoteException, IOException;
	public StaffPO findlast(String orgId,String permission) throws RemoteException, IOException;
	public ArrayList<String> findbyOrg(City city,OrgType org) throws RemoteException, IOException;
	public void delete(String orgid,String id) throws RemoteException, IOException;
	public void update(StaffPO po) throws RemoteException, IOException;
	public ArrayList<StaffPO> findAll() throws RemoteException, IOException;
}
