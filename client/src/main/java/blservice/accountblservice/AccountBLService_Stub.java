package blservice.accountblservice;

import po.AccountPO;
import util.Permission;
import util.ResultMessage;

public class AccountBLService_Stub implements AccountBLService{

	@Override
	public AccountPO accountRev(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage permissionUpate(long id, Permission permission) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS ;
	}

	@Override
	public void endAccount() {
		// TODO Auto-generated method stub
		System.out.println("Account Ended!");
	}

	@Override
	public ResultMessage addAccount(long id, AccountPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteAccount(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
