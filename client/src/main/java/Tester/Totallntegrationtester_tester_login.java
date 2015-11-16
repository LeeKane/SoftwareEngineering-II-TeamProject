package Tester;

import static org.junit.Assert.*;
import mockobject.MockAccount;

import org.junit.Test;

import bl.account.AccountManger;
import bl.login.Login;
import po.AccountPO;
import util.Permission;

public class Totallntegrationtester_tester_login {

	@Test
	public void test() {
		AccountPO ap=new AccountPO(14156856,Permission.COUNTER, "ccsd", "123456");
		MockAccount ma=new MockAccount(ap);
		
		Login l=new Login();
		AccountManger am=new AccountManger();
		l.addAcount(ma.po);
		assertEquals(ap,am.accountRev(ma.po.getid()));
	}

}
