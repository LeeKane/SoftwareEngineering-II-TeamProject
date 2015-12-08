package bl.list;

import java.io.IOException;
import java.util.ArrayList;

import DataServiceTxtFileImpl.MoneyInListDataServiceImpl;
import blservice.listblservice.MoneyInListBLService;
import dataservice.listdataservice.MoneyInListDataService;
import po.AccountPO;
import po.InstitutePO;
import po.list.MoneyInListPO;
import vo.AccountVO;
import vo.InstituteVO;
import vo.list.MoneyInListVO;

public class MoneyInListBL implements MoneyInListBLService{
	private MoneyInListDataService mld;
    private ArrayList<MoneyInListVO> listList;
    private ArrayList<AccountVO> accountList;
    private AccountPO po;
    
    public MoneyInListBL(AccountPO po){
    	this.po=po;
    }
       
	@Override
	public boolean MoneyInListUpdate(ArrayList<MoneyInListVO> voList) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<MoneyInListPO> polistList=new ArrayList<MoneyInListPO>();
		for(int i = 0; i<voList.size();i++)
    	{
			MoneyInListVO vo=voList.get(i);
    		MoneyInListPO ipo=new MoneyInListPO(vo.getTime(),vo.getMoney(),vo.getAccount(),vo.getId(),vo.isApproved());
    		polistList.add(ipo);
    	}		
		mld.MoneyInUpdate(polistList);
		return true;
	}

	@Override
	public ArrayList<MoneyInListVO> findAll(AccountPO po) {
		// TODO Auto-generated method stub
		mld=new MoneyInListDataServiceImpl();
		ArrayList<MoneyInListVO> listList=new ArrayList<MoneyInListVO>();
    	ArrayList<MoneyInListPO> polistList=new ArrayList<MoneyInListPO>();
    	try {
    		polistList=mld.findAll(po);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(int i = 0; i<polistList.size();i++)
    	{
    		MoneyInListPO ipo=polistList.get(i);
    		MoneyInListVO vo=new MoneyInListVO(ipo.getTime(),ipo.getMoney(),ipo.getAccount(),ipo.getId(),ipo.isApproved());
    		listList.add(vo);
    	}
    	
    	
    	
    	
    	
		return listList;
	}

	@Override
	public ArrayList<AccountVO> findAllCourier() {
		// TODO Auto-generated method stub
		mld=new MoneyInListDataServiceImpl();
		ArrayList<AccountVO> accountList=new ArrayList<AccountVO>();
    	ArrayList<AccountPO> poaccountList=new ArrayList<AccountPO>();
    	try {
    		poaccountList=mld.findAllCourier(po);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(int i = 0; i<poaccountList.size();i++)
    	{
    		AccountPO apo=poaccountList.get(i);
    		AccountVO vo=new AccountVO(apo.getid(),apo.getPermission(),apo.getUsername(),apo.getPassword(),"1001-1001");
    		accountList.add(vo);
    	}
		return accountList;
	}

	@Override
	public MoneyInListVO addMoneyInList(MoneyInListPO po) {
		// TODO Auto-generated method stub
		return null;
	}

}
