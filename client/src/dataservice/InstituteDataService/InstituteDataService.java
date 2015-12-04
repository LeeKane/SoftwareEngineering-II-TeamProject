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
	public InstitutePO find(long id);
	public void delete(long id);
	public InstitutePO findlast();
	public String readLastLine(File file, String charset) throws IOException;
}
