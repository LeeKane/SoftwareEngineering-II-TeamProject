package bl.account;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.accountblservice.AccountBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.StaffDataService.StaffDataService;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.logindataservice.LoginDataService;
import po.AccountPO;
import po.StaffPO;
import util.Permission;
import vo.AccountVO;

public class AccountManger implements AccountBLService {
	private LoginDataService ld;
    private ArrayList<AccountVO> voList;
    private StaffDataService sd;
    private DataFactoryService dataFactory;
    public ArrayList<AccountVO> findAll()
    {
    	dataFactory=new DataFactory();
    	sd=dataFactory.getStaffData();
    	ld=dataFactory.getLoginData();	
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
    		if(po.getStaff()!=null){
    		AccountVO vo=new AccountVO(po.getid(),po.getPermission(),po.getUsername(),po.getPassword(),po.getStaff().getStaffId());
    		voList.add(vo);}
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
		String idset[]=vo.getStaffid().split("-");
		StaffPO staff=null;
		try {
			staff = sd.find(idset[0], idset[1]);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		AccountPO po=new AccountPO(vo.getId(),vo.getPermission1(),vo.getUsername(),vo.getPassword(),staff);
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
	public AccountVO addAccount(Permission permission,String username,String password,String staffid) throws NullPointerException{
		// TODO Auto-generated method stub
		voList=new  ArrayList<AccountVO>();
		long id=111111;
		try {
			id=ld.findlast().getid()+1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		AccountVO vo=new AccountVO(id,permission,username,password,staffid);
		voList.add(vo);
		String idset[]=staffid.split("-");
		StaffPO staff=null;
		try {
			staff = sd.find(idset[0], idset[1]);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		AccountPO po=new AccountPO(id,permission,username,password,staff);
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
