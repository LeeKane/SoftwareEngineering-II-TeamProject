package blservice.listblservice;

import dataservice.listdataservice.ArrivalListDataService;
import po.TimePO;
import util.City;
import util.GoodState;
import vo.WareVO;
import vo.list.ArrivaListVO;

public interface arrivaList_HallBLService {
	public ArrivaListVO addList(long transid,TimePO time, Long id, City StartCity,
			GoodState state);
	public long getId();
	public String getName();
	public TimePO getTime();
	public boolean submit();
	public long myGetListId(ArrivalListDataService od, TimePO time);
	public long getListId();
	public ArrivalListDataService getOd();
}
