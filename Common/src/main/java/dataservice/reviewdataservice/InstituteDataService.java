package dataservice.reviewdataservice;

import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InstitutePO;
import util.City;
import util.OrgType;

public interface InstituteDataService extends Remote{
    public OrgType getOrg(String m);
	public void init() throws RemoteException;
	public void insert(InstitutePO po);
	public ArrayList<InstitutePO> findAll() throws IOException;
	public InstitutePO find(String id) throws IOException;
	public void delete(String id) throws IOException;
	public InstitutePO findlast(City city,OrgType org) throws IOException;
	public String readLastLine(File file, String charset) throws IOException;
	public void update(InstitutePO po) throws IOException;
}
