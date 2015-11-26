package blservice.listblservice;

import po.TimePO;
import util.City;
import vo.list.DeliveryListVO;


public interface delivery_HallBLService {

	
	public DeliveryListVO addware(TimePO time, long code, String name);
	public TimePO getTime();
	public long getCode();
	public String getName();
	public boolean submit();
}
