package dataservice.reviewdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SetRewardDataService extends Remote {
public double[] findall() throws RemoteException;
public void Set(double[] s) throws RemoteException;

}
