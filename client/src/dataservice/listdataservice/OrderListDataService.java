package dataservice.listdataservice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import po.WarePO;
import po.list.OrderListPO;

public interface OrderListDataService {

public void init();
	public boolean insert(OrderListPO OrderList);

     public	OrderListPO find(String id);
	public  OrderListPO findlast() throws IOException;
	public String readLastLine(File file, String charset) throws IOException;
	public ArrayList<OrderListPO> findallOrder() throws IOException;
	public ArrayList<OrderListPO> findNoneReviewed() throws IOException;
}
