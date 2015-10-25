package blservice.warehouseblservice;

import po.list.ListPO;
import util.ResultMessage;

public interface WarehouseBLService {
	//在飞机装运管理中进行参数设置
	public ResultMessage setPlaneShipping (ListPO list);
	
	//在火车装运管理中进行参数设置
	public ResultMessage setTrainShipping (ListPO list);
	
	//在汽车装运管理中进行参数设置
	public ResultMessage setCarShipping (ListPO list);
	
	//生成中转中心接受单
	public ResultMessage geneCenterList();
	
	//生成入库单
	public ResultMessage wareIn();
	
	//生成出库单
	public ResultMessage wareOut();
	
	//获取到库存信息
	public ResultMessage getWareInfo(int timeDiff);
	
	//完成盘点
	public ResultMessage WareStockTake();
	
	//进行库存报警提示
	public ResultMessage WareAlarm();
	
	//分区得到调整
	public ResultMessage ModWarePartition (int type, double storage);
	
	//结束中转中心任务，持久化更新设计的领域对象的数据
	public ResultMessage endWareHouse();

}
