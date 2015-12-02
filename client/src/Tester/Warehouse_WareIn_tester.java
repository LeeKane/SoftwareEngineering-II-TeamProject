package Tester;

import static org.junit.Assert.*;

import org.junit.Test;

import bl.trans.Ware;
import bl.warehouse.*;
import util.ResultMessage;

public class Warehouse_WareIn_tester {

	@Test
	public void test() {
		Ware ware1=new Ware();
		Ware ware2=new Ware();
		
		WarehouseLineItem item1=new WarehouseLineItem(ware1);
		WarehouseLineItem item2=new WarehouseLineItem(ware2);
		
		WarehouseList warehouseList=new WarehouseList();
		warehouseList.addWarehouseLineItem(item1);
		warehouseList.addWarehouseLineItem(item2);
		
		assertEquals(ResultMessage.SUCCESS,warehouseList.check());
	}

}
