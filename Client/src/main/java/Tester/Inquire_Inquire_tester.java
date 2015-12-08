package Tester;

import static org.junit.Assert.*;

import org.junit.Test;

import bl.inquire.InquireList;
import mockobject.MockTransHistory;
import po.InstitutePO;
import po.TimePO;
import util.City;
import util.OrgType;

public class Inquire_Inquire_tester {

	@Test
	public void test() {
		MockTransHistory history1=new MockTransHistory(1, "南京中转中心已入库", new TimePO(2015, 11, 15, 11, 15, 0), 
				new InstitutePO(City.NANJING, OrgType.CENTER, 10));
		MockTransHistory history2=new MockTransHistory(1, "南京中转中心已出库", new TimePO(2015, 11, 15, 12, 30, 0), 
				new InstitutePO(City.NANJING, OrgType.CENTER, 10));
		
		InquireList inquireList=new InquireList();
		inquireList.getOneTransHistory(history1);
		inquireList.getOneTransHistory(history2);
		
		assertEquals(true,inquireList.isGetAll());
	}

}
