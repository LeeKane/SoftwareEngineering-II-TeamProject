package bl.review;

import java.io.IOException;
import java.util.ArrayList;

import DataServiceTxtFileImpl.ListStateDataServiceTxtlmpl;
import blservice.reviewblservice.ListReviewBLServive;
import dataservice.ListStateDataService.ListStateDataService;
import po.list.ArrivaListPO;
import po.list.DeliveryListPO;
import po.list.LoadingListPO;
import po.list.MoneyInListPO;
import po.list.MoneyOutListPO;
import po.list.OrderListPO;
import po.list.TranscenterArrivalListPO;
import po.list.WareInListPO;
import po.list.WareOutListPO;

public class ListReviewBL implements ListReviewBLServive{
	

	private ArrayList<Object> allList;
	private ArrayList<ArrivaListPO> arriveList;
	private ArrayList<MoneyInListPO> moneyinList;
	private ArrayList<MoneyOutListPO> moneyoutList;
	private ArrayList<OrderListPO> orderList;
	private ArrayList<WareInListPO> wareinList;
	private ArrayList<WareOutListPO> wareoutList;
	private ArrayList<TranscenterArrivalListPO> transcenterarrivalList;
	private ArrayList<DeliveryListPO> deliverylList;
	private ArrayList<LoadingListPO> loadingList;
	private ArrayList<LoadingListPO> loading_hallList;
	private ListStateDataService dl;
	public ListReviewBL()
	{
	dl=new ListStateDataServiceTxtlmpl();
	try {
		arriveList=dl.findallArrival();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		//
	}
	@Override
	public ArrayList<Object> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<ArrivaListPO> getArriveList() {
		return arriveList;
	}

	public ArrayList<MoneyInListPO> getMoneyinList() {
		return moneyinList;
	}

	public ArrayList<MoneyOutListPO> getMoneyoutList() {
		return moneyoutList;
	}

	public ArrayList<OrderListPO> getOrderList() {
		return orderList;
	}

	public ArrayList<WareInListPO> getWareinList() {
		return wareinList;
	}

	public ArrayList<WareOutListPO> getWareoutList() {
		return wareoutList;
	}

	public ArrayList<TranscenterArrivalListPO> getTranscenterarrivalList() {
		return transcenterarrivalList;
	}

	public ArrayList<DeliveryListPO> getDeliverylList() {
		return deliverylList;
	}

	public ArrayList<LoadingListPO> getLoadingList() {
		return loadingList;
	}

	public ArrayList<LoadingListPO> getLoading_hallList() {
		return loading_hallList;
	}
	@Override
	public boolean updata() {
		// 更新只需要将从界面传来的全部的volist改为各个po来updata
		return false;
	}
}
