package bl.account;

import java.io.IOException;
import java.util.ArrayList;

import DataServiceTxtFileImpl.logindataserviceimpl;
import blservice.accountblservice.AccountBLService;
import dataservice.logindataservice.LoginDataService;
import po.AccountPO;
import util.Permission;
import util.ResultMessage;
import vo.AccountVO;

public class AccountManger implements AccountBLService {
    private LoginDataService ld;
    public ArrayList<AccountVO> findAll()
    {
    	ld=new logindataserviceimpl();
    	ArrayList<AccountVO> voList=new ArrayList<AccountVO>();
    	ArrayList<AccountPO> poList=new ArrayList<AccountPO>();
    	try {
			poList=ld.findAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(int i = 0; i<poList.size();i++)
    	{
    		AccountPO po=poList.get(i);
    		AccountVO vo=new AccountVO(po.getPermission(),po.getUsername(),po.getPassword());
    		voList.add(vo);
    	}
		return voList;
    	
    }
	@Override
	public AccountPO accountRev(String username) {
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
