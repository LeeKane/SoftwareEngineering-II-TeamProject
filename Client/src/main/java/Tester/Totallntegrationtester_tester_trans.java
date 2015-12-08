package Tester;

import static org.junit.Assert.*;

import mockobject.MockCar;
import mockobject.MockDriver;
import mockobject.MockIncome;
import mockobject.MockWare;

import org.junit.Test;

import bl.trans.Trans;
import po.CarPO;
import po.DriverPO;
import po.TimePO;
import po.WarePO;
import util.DeliverType;
import util.Vehicle;

public class Totallntegrationtester_tester_trans {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		WarePO po1=new WarePO(100.0, 2, 10.0, 
				"纸盒", "手机", DeliverType.FAST, 
				30.5, new TimePO(0,0,5,0,0,0));
		WarePO po2=new WarePO(100.0, 2, 10.0, 
				"纸盒", "手机", DeliverType.FAST, 
				58.5, new TimePO(0,0,3,0,0,0));
		MockWare ware1=new MockWare(po1);
		MockWare ware2=new MockWare(po2);//ware
		
		MockIncome mi=new MockIncome(80.0,14125101);//income
		
		CarPO cpo=new CarPO(Vehicle.CAR, "x5",15646, "苏A88888",
				4568, "2015/11/15", "2015/11/16", null);
		MockCar mc=new MockCar(cpo);//car
		
		DriverPO dpo=new DriverPO(1, "sir", null, null,
				"18359565845", null, "男", "2018");
		MockDriver md=new MockDriver(dpo,1101);//driver
		
		
		Trans t=new Trans();
		assertEquals(30.5,t.getCost(ware1.po));
		assertEquals(58.5,t.getCost(ware2.po));
		assertEquals(5,t.getTime(ware1.po));
		assertEquals(3,t.getTime(ware2.po));//ware
		
		assertEquals(80.0,t.getIncome(mi.income, mi.id));//income
		
		t.addCar(mc.po);
		assertEquals(cpo,t.getCar(mc.po.getEngine()));
		t.deleteCar(mc.po.getEngine());
		assertEquals(null,t.getCar(mc.po.getEngine()));//car
	
		t.addDriver(md.po,md.id);
		assertEquals(dpo,t.getDriver(md.id));
		t.deleteDriver(md.id);
		assertEquals(null,t.getDriver(md.id));
		
	}

}
