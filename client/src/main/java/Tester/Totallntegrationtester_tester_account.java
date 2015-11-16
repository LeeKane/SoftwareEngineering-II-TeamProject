package Tester;

import static org.junit.Assert.*;
import mockobject.MockAccount;

import org.junit.Test;

import bl.account.AccountManger;
import po.AccountPO;
import util.Permission;

public class Totallntegrationtester_tester_account {

	@Test
	public void test() {
		AccountPO ap=new AccountPO(12235,Permission.COUNTER,"sfsaf","123456");
		AccountPO ap1=new AccountPO(12238,Permission.CENTERCLERK,"saf","234567");
		MockAccount ma=new MockAccount(ap);
		
		AccountManger am=new AccountManger();
		am.addAccount(ma.po.getid(), ma.po);
		assertEquals(ap,am.accountRev(ma.po.getid()));
		am.permissionUpate(ma.po.getid(), Permission.CENTERCLERK);
		assertEquals(Permission.CENTERCLERK,am.accountRev(ma.po.getid()).getPassword());
		am.deleteAccount(ma.po.getid());
		assertEquals(null,am.accountRev(ma.po.getid()));
		
	}

}
