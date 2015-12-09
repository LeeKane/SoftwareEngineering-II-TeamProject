package dataservice.listdataservice;

import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.OrderListPO;

public interface OrderListDataService extends Remote {

	public void init() throws RemoteException;

	public boolean insert(OrderListPO OrderList) throws RemoteException;

	public OrderListPO find(String id) throws RemoteException;

	public OrderListPO findlast() throws IOException, RemoteException;

	public String readLastLine(File file, String charset) throws IOException, RemoteException;

	public ArrayList<OrderListPO> findallOrder() throws IOException, RemoteException;

	public ArrayList<OrderListPO> findNoneReviewed() throws IOException, RemoteException;
}
