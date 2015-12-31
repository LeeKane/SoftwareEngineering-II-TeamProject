package dataservice.reviewdataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ConstantPO;

public interface ConstantDataService extends Remote{
	
	public ArrayList<ConstantPO> findAllPrice() throws RemoteException, IOException;
	
	public void setAllPrice(ArrayList<ConstantPO> list) throws RemoteException, IOException;

}
