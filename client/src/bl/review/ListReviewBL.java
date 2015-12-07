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
	private ListStateDataService dl;

	public ListReviewBL() {
		dl = new ListStateDataServiceTxtlmpl();
		try {
			arriveList = dl.findNoneReviewd();
			deliverylList = dl.findNoneReviewed();
			loadingList=dl.findNoneReviewedLoading();
			loading_hallList=dl.findNoneReviewedLoadingHall();
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
					if (vo.getId() == po.getid()&&vo.getLst()==ListState.REVIEWED) {
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
					if (vo.getId() == po.getId()&&vo.getLst()==ListState.REVIEWED) {
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
					if (vo.getId() == po.getId()) {
						po.setLst(ListState.REVIEWED);
					}
					// try {
					// dl.updateDelivery(po);
					// } catch (IOException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
				}
			}
			if (vo.getListType() == ListType.LOADINGHALL) {
				for (int l = 0; l < loading_hallList.size(); l++) {
					LoadingListPO po = loading_hallList.get(l);
					if (vo.getId() == po.getId()) {
						po.setLst(ListState.REVIEWED);
					}
					// try {
					// dl.updateDelivery(po);
					// } catch (IOException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
				}
			}

			if (vo.getListType() == ListType.MONEYIN) {
//				for (int l = 0; l < moneyinList.size(); l++) {
//					MoneyInListPO po = moneyinList.get(l);
//					if (vo.getId() == po.getId()) {
//						po.setState(ListState.REVIEWED);
//					}
//					 try {
//					 dl.updateDelivery(po);
//					 } catch (IOException e) {
//					 // TODO Auto-generated catch block
//					 e.printStackTrace();
//					 }
//				}
			}

			if (vo.getListType() == ListType.MONEYOUT) {
				for (int l = 0; l < moneyoutList.size(); l++) {
					MoneyOutListPO po = moneyoutList.get(l);
					if (vo.getId() == po.getId()) {
						po.setLst(ListState.REVIEWED);
					}
					// try {
					// dl.updateDelivery(po);
					// } catch (IOException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					// }
				}
			}
			if (vo.getListType() == ListType.ORDER) {
				for (int l = 0; l < orderList.size(); l++) {
					OrderListPO po = orderList.get(l);
					if (vo.getId() == Long.parseLong(po.getId())) {
						po.setLst(ListState.REVIEWED);
					}
					// try {
					// dl.updateDelivery(po);
					// } catch (IOException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					// }
				}
			}
			if (vo.getListType() == ListType.STOCKIN) {
				for (int l = 0; l < wareinList.size(); l++) {
					WareInListPO po = wareinList.get(l);
					if (vo.getId() == po.getId()) {
						po.setState(ListState.REVIEWED);
					}
					// try {
					// dl.updateDelivery(po);
					// } catch (IOException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					// }
				}
			}
			if (vo.getListType() == ListType.STOCKOUT) {
				for (int l = 0; l < wareoutList.size(); l++) {
					WareOutListPO po = wareoutList.get(l);
					if (vo.getId() == po.getId()) {
						po.setState(ListState.REVIEWED);
					}
					// try {
					// dl.updateDelivery(po);
					// } catch (IOException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					// }
				}
			}
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
			// }
			if (vo.getListType() == ListType.TRANS) {
				for (int l = 0; l < transList.size(); l++) {
					TransListPO po = transList.get(l);
					if (vo.getId() == po.getId()) {
						po.setLst(ListState.REVIEWED);
					}
					// try {
					// dl.updateDelivery(po);
					// } catch (IOException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					// }
				}
			}
			if (vo.getListType() == ListType.TRANSCENTERARRIVE) {
				for (int l = 0; l < transcenterarrivalList.size(); l++) {
					TranscenterArrivalListPO po = transcenterarrivalList.get(l);
					if (vo.getId() == po.getid()) {
						po.setLst(ListState.REVIEWED);
					}
					// try {
					// dl.updateDelivery(po);
					// } catch (IOException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					// }
				}
			}

		}
		return true;
	}

	@Override
	public boolean updata() {
		// TODO Auto-generated method stub
		return false;
	}

}
