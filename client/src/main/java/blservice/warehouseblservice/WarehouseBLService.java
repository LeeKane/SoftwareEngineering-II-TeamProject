package blservice.warehouseblservice;

import po.list.ListPO;
import util.ResultMessage;

public interface WarehouseBLService {
	
	//飞机装运管理
	public ResultMessage setPlaneShipping (ListPO list);
	
	//火车装运管理
	public ResultMessage setTrainShipping (ListPO list);
	
	//汽车装运管理
	public ResultMessage setCarShipping (ListPO list);
	
	//
	public ResultMessage geneCenterList();
	
	
}
