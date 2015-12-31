package bl.review;

import java.io.IOException;
import java.util.ArrayList;

import blservice.reviewblservice.ListReviewBLServive;
import dataimpl.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.reviewdataservice.ListStateDataService;
import po.AccountPO;
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
import util.ListState;
import util.ListType;
import vo.list.ListVO;

public class ListReviewBL implements ListReviewBLServive {

	private ArrayList<Object> allList;
	private ArrayList<ArrivaListPO> arriveList;
	private ArrayList<MoneyInListPO> moneyinList;
	private ArrayList<MoneyOutListPO> moneyoutList;
	private ArrayList<OrderListPO> orderList;
	private ArrayList<WareInListPO> wareinList;
	private ArrayList<WareOutListPO> wareoutList;
	private ArrayList<TranscenterArrivalListPO> transcenterarrivalList;
	private ArrayList<TransListPO> transList;

	private ArrayList<DeliveryListPO> deliverylList;
	private ArrayList<LoadingListPO> loadingList;
	private ArrayList<LoadingListPO> loading_hallList;
	private ArrayList<TranscenterArrivalListPO> transCenterArrivalList;
	private ArrayList<MoneyInListPO> moneyInList;
	private ArrayList<MoneyOutListPO> moneyOutList;
	private ArrayList<WareInListPO> wareInList;
	private ArrayList<WareOutListPO> wareOutList;
	private ListStateDataService dl;
	private DataFactoryService dataFactory;
	private AccountPO po;

	@Override
	public AccountPO getPo() {
		return po;
	}

	public ListReviewBL(AccountPO po) {
		this.po=po;
		dataFactory = new DataFactory();
		dl = dataFactory.getListStateData();
		try {
			arriveList = dl.findNoneReviewd();
			deliverylList = dl.findNoneReviewed();
			loadingList = dl.findNoneReviewedLoading();
			loading_hallList = dl.findNoneReviewedLoadingHall();
			orderList = dl.findNoneReviewedOrder();
			transCenterArrivalList=dl.findNoneReviewedTrans();
			moneyInList=dl.findallMoneyIn();
			moneyOutList=dl.findallMoneyOut();
			wareInList=dl.findallWareIn();
			wareOutList=dl.findallWareOut();
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
		return moneyInList;
	}

	public ArrayList<MoneyOutListPO> getMoneyoutList() {
		
		return moneyOutList;
	}

	public ArrayList<OrderListPO> getOrderList() {
		return orderList;
	}

	public ArrayList<WareInListPO> getWareinList() {
		return wareInList;
	}

	public ArrayList<WareOutListPO> getWareoutList() {
		return wareOutList;
	}

	public ArrayList<TranscenterArrivalListPO> getTranscenterarrivalList() {
		return transCenterArrivalList;
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

	public ArrayList<TransListPO> getTransList() {
		return transList;
	}

	@Override
	public boolean updata(ArrayList<ListVO> voUpdateList) {
		// 更新只需要将从界面传来的全部的volist改为各个po来updata
		for (int i = 0; i < voUpdateList.size(); i++) {
			ListVO vo = voUpdateList.get(i);
			if (vo.getListType() == ListType.ARRIVE) {
				for (int l = 0; l < arriveList.size(); l++) {
					ArrivaListPO po = arriveList.get(l);
					if (vo.getId() == po.getid() && vo.getLst() == ListState.REVIEWED) {
						po.setLst(ListState.REVIEWED);
					}
					try {
						dl.updateArrival(po);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (vo.getListType() == ListType.DELIVER) {
				for (int l = 0; l < deliverylList.size(); l++) {
					DeliveryListPO po = deliverylList.get(l);
					if (vo.getId() == po.getId() && vo.getLst() == ListState.REVIEWED) {
						po.setLst(ListState.REVIEWED);
					}
					try {
						dl.updateDelivery(po);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (vo.getListType() == ListType.LOADING) {
				for (int l = 0; l < loadingList.size(); l++) {
					LoadingListPO po = loadingList.get(l);
					if (vo.getId() == po.getId() && vo.getLst() == ListState.REVIEWED) {
						po.setLst(ListState.REVIEWED);
					}
					try {
						dl.updateLoading(po);
						;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (vo.getListType() == ListType.LOADINGHALL) {
				for (int l = 0; l < loading_hallList.size(); l++) {
					LoadingListPO po = loading_hallList.get(l);
					if (vo.getId() == po.getId() && vo.getLst() == ListState.REVIEWED) {
						po.setLst(ListState.REVIEWED);
					}
					try {
						dl.updateLoadingHall(po);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			if (vo.getListType() == ListType.MONEYIN) {
				// for (int l = 0; l < moneyinList.size(); l++) {
				// MoneyInListPO po = moneyinList.get(l);
				// if (vo.getId() == po.getId()) {
				// po.setState(ListState.REVIEWED);
				// }
				// try {
				// dl.updateDelivery(po);
				// } catch (IOException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
				// }
			}

			if (vo.getListType() == ListType.MONEYOUT) {
				
				for (int l = 0; l < moneyoutList.size(); l++) {
					MoneyOutListPO po = moneyoutList.get(l);
					if (vo.getId() == po.getId()) {
						po.setLst(ListState.REVIEWED);
					}
					 try {
					 dl.updateMoneyOut(po);
					 } catch (IOException e) {
					 // TODO Auto-generated catch block
					 e.printStackTrace();
					 }
					 }
				}
			
			if (vo.getListType() == ListType.ORDER) {
				for (int l = 0; l < orderList.size(); l++) {
					OrderListPO po = orderList.get(l);
					if (vo.getId() == Long.parseLong(po.getId()) && vo.getLst() == ListState.REVIEWED) {
						po.setLst(ListState.REVIEWED);
					}
					try {
						dl.updateOrder(po);
						;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			 if (vo.getListType() == ListType.STOCKIN) {
			 for (int l = 0; l < wareinList.size(); l++) {
			 WareInListPO po = wareinList.get(l);
			 if (vo.getId() == po.getId()) {
			 po.setState(ListState.REVIEWED);
			 }
			 try {
			 dl.updateWareIn(po);
			 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			 }
			 }
			
			 if (vo.getListType() == ListType.STOCKOUT) {
			 for (int l = 0; l < wareoutList.size(); l++) {
			 WareOutListPO po = wareoutList.get(l);
			 if (vo.getId() == po.getId()) {
			 po.setState(ListState.REVIEWED);
			 }
			 try {
			 dl.updateWareOut(po);
			 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			 // }
			 }
			//
			// if(vo.getListType()==ListType.TOTALMONEYIN)
			// {
			// for(int l=0;l<wareoutList.size();l++)
			// {
			// WareOutListPO po=wareoutList.get(l);
			// if(vo.getId()==po.getId())
			// {
			// po.setState(ListState.REVIEWED);
			// }
			//// try {
			//// dl.updateDelivery(po);
			//// } catch (IOException e) {
			//// // TODO Auto-generated catch block
			//// e.printStackTrace();
			//// }
			//// }
			// }
			// //
			// if (vo.getListType() == ListType.TRANS) {
			// for (int l = 0; l < transList.size(); l++) {
			// TransListPO po = transList.get(l);
			// if (vo.getId() == po.getId()) {
			// po.setLst(ListState.REVIEWED);
			// }
			// try {
			// dl.updateDelivery(po);
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// // }
			// }
			//
			 if (vo.getListType() == ListType.TRANSCENTERARRIVE) {
			 for (int l = 0; l < transcenterarrivalList.size(); l++) {
			 TranscenterArrivalListPO po = transcenterarrivalList.get(l);
			 if (vo.getId() == po.getid()) {
			 po.setLst(ListState.REVIEWED);
			 }
			 try {
			 dl.updateTrans(po);
			 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			 }
			 }
			

		}}
		return true;
	}

	@Override
	public boolean updata() {
		// TODO Auto-generated method stub
		return false;
	}

}
