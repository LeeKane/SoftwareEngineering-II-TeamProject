package Tester;

import static org.junit.Assert.*;

import org.junit.Test;

import bl.finance.FinanceList;
import mockobject.MockFinanceReceipt;
import po.InstitutePO;
import po.StaffPO;
import po.TimePO;
import util.City;
import util.OrgType;
import util.Permission;
import util.ResultMessage;

public class Finance_BalanceManagement_tester {

	@Test
	public void test() {
		MockFinanceReceipt fr1=new MockFinanceReceipt(new TimePO(2015, 11, 15, 11, 15, 0), 
				new StaffPO("ha", 1, OrgType.HALL, Permission.COURIER), 
				new InstitutePO(City.NANJING, OrgType.HALL, 100), 1024);
		MockFinanceReceipt fr2=new MockFinanceReceipt(new TimePO(2015, 11, 15, 11, 16, 0), 
				new StaffPO("haha", 10, OrgType.HALL, Permission.COURIER), 
				new InstitutePO(City.BEIJING, OrgType.HALL, 1000), 128);
		
		FinanceList financeList=new FinanceList();
		financeList.addFinanceItem(fr1);
		financeList.addFinanceItem(fr2);
		
		assertEquals(ResultMessage.SUCCESS,financeList.check());
	}
}
