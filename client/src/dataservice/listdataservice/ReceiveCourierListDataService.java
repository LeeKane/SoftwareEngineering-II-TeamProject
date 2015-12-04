package dataservice.listdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;

import po.list.ReceiveCourierListPO;

public interface ReceiveCourierListDataService {
	public void insert(ReceiveCourierListPO po);
	
	public void delete(long id) throws RemoteException, UnsupportedEncodingException, FileNotFoundException, IOException;
	
	public ReceiveCourierListPO find(long id) throws IOException;
	
	public void update(ReceiveCourierListPO po) throws IOException;
	
	public void init();
}
