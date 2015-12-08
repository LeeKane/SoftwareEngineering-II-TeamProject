package dataservice.ListStateDataService;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.ArrivaListPO;
import po.list.DeliveryListPO;
import po.list.LoadingListPO;
import po.list.MoneyInListPO;
import po.list.MoneyOutListPO;
import po.list.OrderListPO;
import po.list.TranscenterArrivalListPO;
import po.list.WareInListPO;
import po.list.WareOutListPO;

public interface ListStateDataService extends Remote {
  public ArrayList<ArrivaListPO> findallArrival() throws RemoteException, IOException;
  public ArrayList<ArrivaListPO> findNoneReviewd() throws RemoteException, IOException;
  public ArrayList<DeliveryListPO> findallDelivery() throws RemoteException, IOException;
  public ArrayList<DeliveryListPO> findNoneReviewed() throws RemoteException, IOException;
  public ArrayList<OrderListPO> findallOrder() throws RemoteException, IOException;
  public ArrayList<LoadingListPO> findallLoading() throws RemoteException, IOException;
  public ArrayList<LoadingListPO> findNoneReviewedLoading() throws RemoteException, IOException;
  public ArrayList<LoadingListPO> findallHallLoading() throws RemoteException, IOException;
  public ArrayList<LoadingListPO> findNoneReviewedLoadingHall() throws RemoteException, IOException;
  public ArrayList<MoneyInListPO> findallMoneyIn() throws RemoteException, IOException;
  public ArrayList<MoneyOutListPO> findallMoneyOut() throws RemoteException, IOException;
  public ArrayList<WareInListPO> findallWareIn() throws RemoteException, IOException;
  public ArrayList<WareOutListPO> findallWareOut() throws RemoteException, IOException;
  public ArrayList<Object> findall()throws RemoteException, IOException;
  public void updateArrival(ArrivaListPO po) throws RemoteException, IOException;
public void deleteArrival(long id) throws RemoteException, IOException;
public void insertArrival(ArrivaListPO po)throws RemoteException;
public void init(String Txtaddress)throws RemoteException;
  public void updateDelivery(DeliveryListPO po)throws RemoteException, IOException;
  public void deleteDelivery(long id)throws RemoteException, IOException;
  public void insertDelivery(DeliveryListPO po)throws RemoteException;
  public void updateOrder(OrderListPO po) throws RemoteException, IOException;
  public void deleteOrder(String id) throws RemoteException, IOException;
  public void insertOrder(OrderListPO PO)throws RemoteException;
  public void updateLoading(LoadingListPO po) throws RemoteException, IOException;
  public void deleteLoading(long id) throws RemoteException, IOException;
  public void insertLoading(LoadingListPO po)throws RemoteException;
  public void updateLoadingHall(LoadingListPO po) throws RemoteException, IOException;
  public void deleteLoadingHall(long id) throws RemoteException, IOException;
  public void insertLoadingHall(LoadingListPO po)throws RemoteException;
  public void updateMoneyIn(MoneyInListPO po)throws RemoteException;
  public void deleteMoneyIn(long id)throws RemoteException;
  public void insertMoneyIn(MoneyInListPO po)throws RemoteException;
  public ArrayList<OrderListPO> findNoneReviewedOrder() throws RemoteException, IOException;
  public ArrayList<TranscenterArrivalListPO> findallTrans()throws RemoteException, IOException;
  public ArrayList<TranscenterArrivalListPO> findNoneReviewedTrans()throws RemoteException, IOException;
  public void updateTrans(TranscenterArrivalListPO po) throws RemoteException, IOException;
  public void deleteTrans(long id) throws RemoteException, IOException;
  public void insertTrans(TranscenterArrivalListPO po)throws RemoteException;
  
  
  
}
