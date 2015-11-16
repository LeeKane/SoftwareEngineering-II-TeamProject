package Tester;

import static org.junit.Assert.*;
import mockobject.MockList;

import org.junit.Test;

import bl.list.List;
import po.list.OrderListPO;
import util.ListType;

public class Totallntegrationtester_tester_list {

	@Test
	public void test() {
		OrderListPO op=new OrderListPO("da", "南京",
				"南京大学", null,
				"18565459658", "sa", "北京",
				"北京大学", null,
				"15985684569",ListType.ORDER,1124560);
		OrderListPO op1=new OrderListPO("cc", "南京",
				"南京大学", null,
				"18354545656", "aa", "北京",
				"北京大学", null,
				"15985684569",ListType.ORDER,1124560);
		MockList ml=new MockList(op);
		
		List l=new List();
		l.addList(ml.po.getId(), ml.po);
		assertEquals(ml.po,l.getList(ml.po.getId()));
		l.modifyList(ml.po.getId(), op1);
		assertEquals(op1,l.getList(ml.po.getId()));
		l.delrteList(ml.po.getId());
		assertEquals(null,l.getList(ml.po.getId()));
	
		
	}

}
