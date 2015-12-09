package blservice.transblservice;

import dataservice.listdataservice.LoadingList_HallDataService;
import po.TimePO;
import util.City;
import util.ListType;
import vo.LoadingVO;
import vo.list.LoadingListVO;

public interface LoadingList_HallBLService {
	public LoadingVO addLoading(TimePO loadDate, long transNum, City departPlace, City destination, long waybillNum,
			String loadMonitor, String loadPerformer, double freight);

	public boolean submit();

	public LoadingListVO addLoadingLists(long id, ListType type, TimePO loadDate, long transNum, City departPlace,
			City destination, long[] waybillNumList, String loadMonitor, String loadPerformer, double freight);

	long getListId();

	long myGetListId(LoadingList_HallDataService od, TimePO time);
}
