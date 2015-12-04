package dataservice.InstituteDataService;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

import po.InstitutePO;
import util.OrgType;

public interface InstituteDataService {
    public OrgType getOrg(String m);
	public void init() throws RemoteException;
	public void insert(InstitutePO po);
	public InstitutePO find(String id) throws IOException;
	public void delete(String id);
	public InstitutePO findlast() throws IOException;
	public String readLastLine(File file, String charset) throws IOException;
}
