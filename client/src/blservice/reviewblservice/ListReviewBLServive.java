package blservice.reviewblservice;

import java.util.ArrayList;

import po.list.ArrivaListPO;
import po.list.DeliveryListPO;
import po.list.LoadingListPO;
import po.list.MoneyInListPO;
import po.list.MoneyOutListPO;
import po.list.OrderListPO;
import po.list.TransListPO;
import po.list.TranscenterArrivalListPO;
import po.list.WareInListPO;
import po.list.WareOutListPO;
import vo.list.ListVO;

public interface ListReviewBLServive {
	public ArrayList<Object> findAll();
	public ArrayList<ArrivaListPO> getArriveList() ;

	public ArrayList<MoneyInListPO> getMoneyinList() ;

	public ArrayList<MoneyOutListPO> getMoneyoutList();
	public ArrayList<OrderListPO> getOrderList() ;

	public ArrayList<WareInListPO> getWareinList() ;
	public ArrayList<WareOutListPO> getWareoutList() ;

	public ArrayList<TranscenterArrivalListPO> getTranscenterarrivalList() ;

	public ArrayList<DeliveryListPO> getDeliverylList() ;

	public ArrayList<LoadingListPO> getLoadingList() ;

	public ArrayList<LoadingListPO> getLoading_hallList() ;
	public ArrayList<TransListPO> getTransList() ;
	public boolean updata();
	boolean updata(ArrayList<ListVO> voUpdateList);
}
