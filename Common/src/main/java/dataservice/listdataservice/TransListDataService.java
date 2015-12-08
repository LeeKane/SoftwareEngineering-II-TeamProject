package dataservice.listdataservice;

import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import po.list.TransListPO;
import po.list.TranscenterArrivalListPO;

public interface TransListDataService extends Remote{
	public void insert(TransListPO po)throws RemoteException;
	public void init()throws RemoteException;
    public TransListPO find(long id)throws RemoteException;
    public  TransListPO findlast() throws RemoteException, IOException;
    public String readLastLine(File file, String charset) throws RemoteException, IOException;
}
