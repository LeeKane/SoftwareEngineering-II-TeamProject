package bl.trans;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataServiceTxtFileImpl.LoadingListDataServiceTxtImpl;
import blservice.transblservice.LoadingListBLService;
import dataservice.listdataservice.LoadingListDataService;
import po.TimePO;
import po.list.LoadingListPO;
import util.City;
import util.ListType;
import vo.LoadingVO;
import vo.list.LoadingListVO;

public class LoadingList implements LoadingListBLService{
	LoadingVO lvo;
	ArrayList<Long> idList=new ArrayList<Long>();
	long[] idSet;
	@Override
	public LoadingVO addLoading(TimePO loadDate,
			long transNum, City departPlace, City destination,
			long waybillNum, String loadMonitor, String loadPerformer,
			double freight) {
		lvo=new LoadingVO(loadDate,transNum,departPlace,destination,waybillNum,loadMonitor,loadPerformer,freight);
		idList.add(waybillNum);
		return lvo;
	}

	@Override
	public boolean submit() {
		// TODO Auto-generated method stub
		LoadingListDataService ld=new LoadingListDataServiceTxtImpl();
		long id=1111111111;
		for(int i=0;i<idList.size();i++)
		{
			idSet[i]=idList.get(i);
		}
		
		LoadingListPO loadingList=new LoadingListPO(id,ListType.TRANS,lvo.getLoadDate(),lvo.getTransNum(),lvo.getDepartPlace(),lvo.getDestination(),idSet,lvo.getLoadMonitor(),lvo.getLoadPerformer(),lvo.getFreight());
		try {
			ld.insert(loadingList);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public LoadingListVO addLoadingLists(long id, ListType type,
			TimePO loadDate, long transNum, City departPlace, City destination,
			long[] waybillNumList, String loadMonitor, String loadPerformer,
			double freight) {
		// TODO Auto-generated method stub
		return null;
	}

}
