package blservice.transblservice;

import po.TimePO;
import util.City;
import util.GoodState;
import vo.list.TransCenterArrivalListVO;

public interface TransCenterArriveBLService {
	public TransCenterArrivalListVO addTransCenterArrivalList(long transcenterID, long id, TimePO arriveTime,
			City startCity, GoodState state);

	public boolean submit();
}
