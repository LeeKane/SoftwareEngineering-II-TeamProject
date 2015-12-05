package bl.account;

import po.AccountPO;
import util.Permission;
import util.ResultMessage;
import vo.AccountVO;

import java.util.ArrayList;

import blservice.accountblservice.AccountBLService;

public class AccountController implements AccountBLService {

	@Override
	public AccountPO accountRev(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean permissionUpate(ArrayList<AccountVO> vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<AccountVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountVO addAccount(Permission permission, String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAccount(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void endAccount() {
		// TODO Auto-generated method stub
		
	}


}
