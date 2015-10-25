package blservice.warehouseblservice;

import po.list.ListPO;
import util.ListType;
import util.PartitionType;
import util.ResultMessage;
import vo.WareHouseVO;
import vo.list.ListVO;

public class WarehouseBLService_Driver {
	public void drive(WarehouseBLService warehouseBLService){
		ResultMessage result=warehouseBLService.setPlaneShipping(new ListPO(ListType.TRANS,1));
		if(result==ResultMessage.SUCCESS)
			System.out.println("SetPlaneShipping Succeeded!");
		
		result=warehouseBLService.setCarShipping(new ListPO(ListType.TRANS,2));
		if(result==ResultMessage.SUCCESS)
			System.out.println("SetCarShipping Succeeded!");
		
		result=warehouseBLService.setTrainShipping(new ListPO(ListType.TRANS,3));
		if(result==ResultMessage.SUCCESS)
			System.out.println("SetTrainShipping Succeeded!");
		
		ListVO list=warehouseBLService.geneCenterList();
		System.out.println(list.getClass());
		
		result=warehouseBLService.wareIn();
		if(result==ResultMessage.SUCCESS)
			System.out.println("WareIn Succeeded!");
		
		result=warehouseBLService.wareOut();
		if(result==ResultMessage.SUCCESS)
			System.out.println("WareOut Succeeded!");
		
		WareHouseVO wareHouse=warehouseBLService.getWareInfo(10);
		System.out.println(wareHouse.getClass());
		
		result=warehouseBLService.WareStockTake();
		if(result==ResultMessage.SUCCESS)
			System.out.println("WareStockTake Succeeded!");
		
		result=warehouseBLService.WareAlarm();
		if(result==ResultMessage.SUCCESS)
			System.out.println("WareAlarm Succeeded!");
		
		result=warehouseBLService.ModWarePartition(PartitionType.VARIABLE,0);
		if(result==ResultMessage.SUCCESS)
			System.out.println("ModWarePartition Succeeded!");
		
		warehouseBLService.endWareHouse();		
	}
	
	public static void main(String[] args) {
		WarehouseBLService_Driver driver = new WarehouseBLService_Driver();
		driver.drive(new WarehouseBLService_Stub(ListType.TRANS, 1, 10, 0, PartitionType.VARIABLE));
	}
}