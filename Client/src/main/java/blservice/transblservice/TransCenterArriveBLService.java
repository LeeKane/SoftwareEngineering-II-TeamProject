package blservice.transblservice;

import po.AccountPO;
import po.TimePO;
import util.City;
import util.GoodState;
import vo.list.TransCenterArrivalListVO;

public interface TransCenterArriveBLService {

	public boolean submit();

	public AccountPO getAccountPO();

	TransCenterArrivalListVO addTransCenterArrivalList(String transcenterID, long id, TimePO arriveTime, City startCity,
			GoodState state);
}
