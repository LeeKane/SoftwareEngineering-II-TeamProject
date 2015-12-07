package dataservice.ListStateDataService;

import java.io.IOException;
import java.util.ArrayList;

import po.list.ArrivaListPO;
import po.list.DeliveryListPO;
import po.list.LoadingListPO;
import po.list.MoneyInListPO;
import po.list.MoneyOutListPO;
import po.list.OrderListPO;
import po.list.WareInListPO;
import po.list.WareOutListPO;

public interface ListStateDataService {
  public ArrayList<ArrivaListPO> findallArrival() throws IOException;
  public ArrayList<ArrivaListPO> findNoneReviewd() throws IOException;
  public ArrayList<DeliveryListPO> findallDelivery() throws IOException;
  public ArrayList<DeliveryListPO> findNoneReviewed() throws IOException;
  public ArrayList<OrderListPO> findallOrder() throws IOException;
  public ArrayList<LoadingListPO> findallLoading() throws IOException;
  public ArrayList<LoadingListPO> findNoneReviewedLoading() throws IOException;
  public ArrayList<LoadingListPO> findallHallLoading() throws IOException;
  public ArrayList<LoadingListPO> findNoneReviewedLoadingHall() throws IOException;
  public ArrayList<MoneyInListPO> findallMoneyIn() throws IOException;
  public ArrayList<MoneyOutListPO> findallMoneyOut() throws IOException;
  public ArrayList<WareInListPO> findallWareIn() throws IOException;
  public ArrayList<WareOutListPO> findallWareOut() throws IOException;
  public ArrayList<Object> findall()throws IOException;
  public void updateArrival(ArrivaListPO po) throws IOException;
public void deleteArrival(long id) throws IOException;
public void insertArrival(ArrivaListPO po);
public void init(String Txtaddress);
  public void updateDelivery(DeliveryListPO po)throws IOException;
  public void deleteDelivery(long id)throws IOException;
  public void insertDelivery(DeliveryListPO po);
  public void updateOrder(OrderListPO po) throws IOException;
  public void deleteOrder(String id) throws IOException;
  public void insertOrder(OrderListPO PO);
  public void updateLoading(LoadingListPO po) throws IOException;
  public void deleteLoading(long id) throws IOException;
  public void insertLoading(LoadingListPO po);
  public void updateLoadingHall(LoadingListPO po) throws IOException;
  public void deleteLoadingHall(long id) throws IOException;
  public void insertLoadingHall(LoadingListPO po);
  public void updateMoneyIn(MoneyInListPO po);
  public void deleteMoneyIn(long id);
  public void insertMoneyIn(MoneyInListPO po);
  public ArrayList<OrderListPO> findNoneReviewedOrder() throws IOException;
}
