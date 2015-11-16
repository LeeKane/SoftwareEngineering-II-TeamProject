package dataservice.Financedataservice;
import java.rmi.RemoteException;

import po.FinancePO;
public interface Financedataservice {
	public FinancePO find(long id) throws RemoteException;
	public void insert(FinancePO po) throws RemoteException;
	
	public void delete(FinancePO po) throws RemoteException;
	
	public void update(FinancePO po) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public void finish() throws RemoteException;


}
