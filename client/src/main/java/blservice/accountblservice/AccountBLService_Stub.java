package blservice.accountblservice;

import util.Permission;
import util.ResultMessage;

public class AccountBLService_Stub implements AccountBLService{

	@Override
	public ResultMessage accountRev(long id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
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

	
}
