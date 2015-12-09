package bl.warehouse;

import blservice.warehouseblservice.WarehouseBLService;
import po.list.ListPO;
import util.PartitionType;
import util.ResultMessage;
import vo.WareHouseVO;
import vo.list.ListVO;

public class Warehouse implements WarehouseBLService {

	@Override
	public ResultMessage setPlaneShipping(ListPO list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setTrainShipping(ListPO list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setCarShipping(ListPO list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListVO geneCenterList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage wareIn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage wareOut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WareHouseVO getWareInfo(int timeDiff) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage WareStockTake() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage WareAlarm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage ModWarePartition(PartitionType type, double storage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endWareHouse() {
		// TODO Auto-generated method stub

	}

}
