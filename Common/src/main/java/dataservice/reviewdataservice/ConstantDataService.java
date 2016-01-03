package dataservice.reviewdataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ConstantPO;

public interface ConstantDataService extends Remote {

	public ArrayList<ConstantPO> findAllPrice() throws RemoteException, IOException;

	public void setPrice(ConstantPO po) throws RemoteException, IOException;

	public void init() throws RemoteException, IOException;

	public void initDis() throws RemoteException, IOException;

	public void setDis(ConstantPO po) throws RemoteException, IOException;

	public ArrayList<ConstantPO> findAllDis() throws RemoteException, IOException;
}
