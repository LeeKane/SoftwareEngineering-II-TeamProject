package bl.trans;

import po.TimePO;
import util.City;
import util.ListType;
import vo.LoadingVO;
import vo.list.LoadingListVO;
import blservice.transblservice.LoadingListBLService;

public class LoadingList implements LoadingListBLService{

	@Override
	public LoadingVO addLoading(ListType type, TimePO loadDate, long transNum,
			City departPlace, City destination, long waybillNum,
			String loadMonitor, String loadPerformer, double freight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean submit() {
		// TODO Auto-generated method stub
		return false;
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
