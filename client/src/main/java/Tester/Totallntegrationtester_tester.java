package Tester;

import static org.junit.Assert.*;
import mockobject.MockWare;

import org.junit.Test;

import bltrans.trans.Trans;
import po.TimePO;
import po.WarePO;
import util.DeliverType;

public class Totallntegrationtester_tester {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		WarePO po=new WarePO(100.0, 2, 10.0, 
				"纸盒", "手机", DeliverType.FAST, 
				30.5, new TimePO(0,0,3,0,0,0));
		
		MockWare ware=new MockWare(po);
		Trans t=new Trans();
		assertEquals(30.5,t.getCost(ware.po));
	}

}
