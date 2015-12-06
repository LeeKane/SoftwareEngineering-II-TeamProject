package bl.account;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import DataServiceTxtFileImpl.logindataserviceimpl;
import blservice.accountblservice.AccountBLService;
import dataservice.logindataservice.LoginDataService;
import po.AccountPO;
import util.Permission;
import vo.AccountVO;

public class AccountManger implements AccountBLService {
    private LoginDataService ld;
    private ArrayList<AccountVO> voList;
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
    		AccountVO vo=new AccountVO(po.getid(),po.getPermission(),po.getUsername(),po.getPassword());
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
	public boolean permissionUpate(ArrayList<AccountVO> voList) {
		// TODO Auto-generated method stub
		for(int i = 0; i<voList.size();i++){	
		AccountVO vo=voList.get(i);
		AccountPO po=new AccountPO(vo.getId(),vo.getPermission1(),vo.getUsername(),vo.getPassword());
//		System.out.println(vo.getId()+" "+vo.getPermission1().toString()+" "+vo.getUsername()+" "+vo.getPassword());
		try {
			ld.update(po);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return true;
	}

	@Override
	public void endAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountVO addAccount(Permission permission,String username,String password) {
		// TODO Auto-generated method stub
		voList=new  ArrayList<AccountVO>();
		long id=111111;
		try {
			id=ld.findlast().getid()+1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		AccountVO vo=new AccountVO(id,permission,username,password);
		voList.add(vo);
		AccountPO po=new AccountPO(id,permission,username,password);
		try {
			ld.insert(po);
		} catch (RemoteException e) {

			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public boolean deleteAccount(long id) {
		try {
			ld.delete(id);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	
	}

}
