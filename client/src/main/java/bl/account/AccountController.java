package bl.account;

import po.AccountPO;
import util.Permission;
import util.ResultMessage;
import blservice.accountblservice.AccountBLService;

public class AccountController implements AccountBLService {

	@Override
	public AccountPO accountRev(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage permissionUpate(long id, Permission permission) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endAccount() {
		// TODO Auto-generated method stub
		
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
