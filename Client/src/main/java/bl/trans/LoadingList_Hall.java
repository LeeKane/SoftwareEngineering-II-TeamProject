package bl.trans;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.transblservice.LoadingList_HallBLService;
import data.datafactory.DataFactory;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.LoadingList_HallDataService;
import dataservice.listdataservice.OrderListDataService;
import po.AccountPO;
import po.InstitutePO;
import po.TimePO;
import po.TransPO;
import po.WarePO;
import po.list.LoadingListPO;
import po.list.OrderListPO;
import util.City;
import util.ListState;
import util.ListType;
import util.TransState;
import vo.LoadingVO;
import vo.list.LoadingListVO;

public class LoadingList_Hall implements LoadingList_HallBLService {
	private LoadingVO lvo;
	private ArrayList<Long> idList = new ArrayList<Long>();
	private ArrayList<Long> idSet = new ArrayList<Long>();
	private LoadingList_HallDataService ld;
	private String preFour;
	private String lastFour;
	private long Listid;
	private AccountPO po;

	public LoadingList_Hall(AccountPO po) {
		super();
		this.po = po;
	}

	@Override
	public LoadingVO addLoading(TimePO loadDate, long transNum, City departPlace, City destination, long waybillNum,
			String loadMonitor, String loadPerformer, double freight) {
		lvo = new LoadingVO(loadDate, transNum, departPlace, destination, waybillNum, loadMonitor, loadPerformer,
				freight);
		idList.add(waybillNum);

		return lvo;
	}

	@Override
	public boolean submit() {
		// TODO Auto-generated method stub
		ld = DataFactory.getLoadingList_HallData();

		if (!idList.isEmpty()) {
			for (int i = 0; i < idList.size(); i++) {
				idSet.add(idList.get(i));
				OrderListDataService obl = DataFactory.getWareData();
				OrderListPO order = null;
				try {
					order = obl.find(idList.get(i) + "");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				WarePO ware = order.getWare();
				Listid = myGetListId(ld, lvo.getLoadDate());
				TransPO transState = new TransPO(idList.get(i), TransState.HALLCLERK_LOADING, lvo.getLoadDate(),
						new InstitutePO(po.getStaff().getCity(), po.getStaff().getOrgType(), po.getStaff().getOrgid()));// 添加运输状态
				InquireDataService inquireDataService = DataFactory.getInquireData();
				try {
					inquireDataService.insert(transState);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			LoadingListPO loadingList = new LoadingListPO(Listid, ListType.LOADINGHALL, lvo.getLoadDate(),
					lvo.getTransNum(), lvo.getDepartPlace(), lvo.getDestination(), idSet, lvo.getLoadMonitor(),
					lvo.getLoadPerformer(), lvo.getFreight(), ListState.SUBMITTED);
			try {
				ld.insert(loadingList);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			idList.clear();
			return true;
		} else
			return false;
	}

	@Override
	public LoadingListVO addLoadingLists(long id, ListType type, TimePO loadDate, long transNum, City departPlace,
			City destination, long[] waybillNumList, String loadMonitor, String loadPerformer, double freight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long myGetListId(LoadingList_HallDataService od, TimePO time) {

		// TODO Auto-generated method stub
		if (time.getHour() >= 10) {
			preFour = time.getHour() + "";
		} else {
			preFour = "0" + time.getHour();
		}
		if (time.getMin() >= 10)
			preFour += (time.getMin() + "");
		else
			preFour += ("0" + time.getMin());
		try {
			lastFour = (od.findlast().getId() + 1) + "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lastFour = lastFour.substring(6);

		return Long.parseLong(preFour + "12" + lastFour);

	}

	@Override
	public long getListId() {
		// TODO Auto-generated method stub
		return this.Listid;
	}

	public LoadingList_HallDataService getOd() {
		return this.ld;
	}
}