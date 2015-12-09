package blservice.warehouseblservice;

import java.util.ArrayList;

import po.TimePO;
import po.list.ListPO;
import util.ListState;
import util.ListType;
import util.PartitionType;
import util.ResultMessage;
import vo.WareHouseVO;
import vo.list.ListVO;

public class WarehouseBLService_Stub implements WarehouseBLService {

	ListType listTypet;
	long id;
	int timeDiff;
	double storage;
	PartitionType type;

	public WarehouseBLService_Stub(ListType listTypet, long id, int timeDiff, double storage, PartitionType type) {
		super();
		this.listTypet = listTypet;
		this.id = id;
		this.timeDiff = timeDiff;
		this.storage = storage;
		this.type = type;
	}

	@Override
	public ResultMessage setPlaneShipping(ListPO list) {
		// TODO Auto-generated method stub
		ArrayList<ListPO> planeShippingList = new ArrayList<ListPO>();
		planeShippingList.add(list);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setTrainShipping(ListPO list) {
		// TODO Auto-generated method stub
		ArrayList<ListPO> TrainShippingList = new ArrayList<ListPO>();
		TrainShippingList.add(list);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setCarShipping(ListPO list) {
		// TODO Auto-generated method stub
		ArrayList<ListPO> CarShippingList = new ArrayList<ListPO>();
		CarShippingList.add(list);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ListVO geneCenterList() {
		// TODO Auto-generated method stub
		return new ListVO(listTypet, id, ListState.SUBMITTED, new TimePO(1, 1, 1, 1, 1, 1));
	}

	@Override
	public ResultMessage wareIn() {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage wareOut() {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public WareHouseVO getWareInfo(int timeDiff) {
		// TODO Auto-generated method stub
		return new WareHouseVO();
	}

	@Override
	public ResultMessage WareStockTake() {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage WareAlarm() {
		// TODO Auto-generated method stub
		return ResultMessage.ALARM;
	}

	@Override
	public ResultMessage ModWarePartition(PartitionType type, double storage) {
		// TODO Auto-generated method stub
		// 完成WareHousePO/VO后要写
		return ResultMessage.SUCCESS;
	}

	@Override
	public void endWareHouse() {
		// TODO Auto-generated method stub
		System.out.println("WareHouse Ended!");
	}
}
