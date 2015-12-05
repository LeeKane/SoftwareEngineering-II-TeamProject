package blservice.listblservice;

import dataservice.listdataservice.DeliveryListDataService;
import po.TimePO;
import vo.list.DeliveryListVO;


public interface delivery_HallBLService {

	
	public DeliveryListVO addware(TimePO time, long code, String name);
	public TimePO getTime();
	public long getCode();
	public String getName();
	public boolean submit();
	public long myGetListId(DeliveryListDataService od, TimePO time);
	public long getListId();
}
