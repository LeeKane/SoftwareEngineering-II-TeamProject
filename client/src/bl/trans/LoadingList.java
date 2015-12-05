package bl.trans;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataServiceTxtFileImpl.InquireDataServiceTxtImpl;
import DataServiceTxtFileImpl.LoadingListDataServiceTxtImpl;
import DataServiceTxtFileImpl.OrderListDataServiceImpl;
import blservice.transblservice.LoadingListBLService;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.LoadingListDataService;
import po.InstitutePO;
import po.TimePO;
import po.TransPO;
import po.WarePO;
import po.list.LoadingListPO;
import po.list.OrderListPO;
import util.City;
import util.ListState;
import util.ListType;
import util.OrgType;
import util.TransState;
import vo.LoadingVO;
import vo.list.LoadingListVO;

public class LoadingList implements LoadingListBLService {
	LoadingVO lvo;
	ArrayList<Long> idList = new ArrayList<Long>();
	long[] idSet=new long[200];

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
		LoadingListDataService ld = new LoadingListDataServiceTxtImpl();
		long id = 1111111111;
		if(!idList.isEmpty()){
		for (int i = 0; i < idList.size(); i++) {
			idSet[i] = idList.get(i);
		    OrderListDataServiceImpl obl=new OrderListDataServiceImpl();
		    OrderListPO order=obl.find(idList.get(i)+"");
		    WarePO ware=order.getWare();
			TransPO transState=new TransPO(id,TransState.CENTERCLERK_SHIPPING,lvo.getLoadDate(),new InstitutePO(ware.getDepartPlace(),OrgType.CENTER,1111111111));//添加运输状态
	    	 InquireDataService inquireDataService=new InquireDataServiceTxtImpl();
	    	inquireDataService=new InquireDataServiceTxtImpl();
	    	try {
				inquireDataService.insert(transState);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		LoadingListPO loadingList = new LoadingListPO(id, ListType.LOADING, lvo.getLoadDate(), lvo.getTransNum(),
				lvo.getDepartPlace(), lvo.getDestination(), idSet, lvo.getLoadMonitor(), lvo.getLoadPerformer(),
				lvo.getFreight(),ListState.SUBMITTED);
		try {
			ld.insert(loadingList);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		idList.clear();
		return true;
		}
		else
			return false;
	}

	@Override
	public LoadingListVO addLoadingLists(long id, ListType type, TimePO loadDate, long transNum, City departPlace,
			City destination, long[] waybillNumList, String loadMonitor, String loadPerformer, double freight) {
		// TODO Auto-generated method stub
		return null;
	}

}
