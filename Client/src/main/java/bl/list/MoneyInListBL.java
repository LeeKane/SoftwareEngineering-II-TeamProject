package bl.list;

import java.io.IOException;
import java.util.ArrayList;

import blservice.listblservice.MoneyInListBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.listdataservice.MoneyInListDataService;
import po.AccountPO;
import po.list.MoneyInListPO;
import vo.AccountVO;
import vo.list.MoneyInListVO;

public class MoneyInListBL implements MoneyInListBLService {
	private MoneyInListDataService mld;
	private ArrayList<MoneyInListVO> listList;
	private ArrayList<AccountVO> accountList;
	private AccountPO po;

	private DataFactoryService dataFactory;

	public MoneyInListBL(AccountPO po) {
		this.po = po;
		dataFactory = new DataFactory();
	}

	@Override
	public boolean MoneyInListUpdate(ArrayList<MoneyInListVO> voList) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<MoneyInListPO> polistList = new ArrayList<MoneyInListPO>();
		for (int i = 0; i < voList.size(); i++) {
			MoneyInListVO vo = voList.get(i);
			MoneyInListPO ipo = new MoneyInListPO(vo.getTime(), vo.getMoney(), vo.getAccount(), vo.getId(),
					vo.isApproved(),vo.getBaccount());
			polistList.add(ipo);
		}
		mld.MoneyInUpdate(polistList);
		return true;
	}

	@Override
	public ArrayList<MoneyInListVO> findAll(AccountPO po) {
		// TODO Auto-generated method stub
		mld = dataFactory.getMoneyInListData();
		ArrayList<MoneyInListVO> listList = new ArrayList<MoneyInListVO>();
		ArrayList<MoneyInListPO> polistList = new ArrayList<MoneyInListPO>();
		try {
			polistList = mld.findAll(po);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < polistList.size(); i++) {
			MoneyInListPO ipo = polistList.get(i);
			MoneyInListVO vo = new MoneyInListVO(ipo.getTime(), ipo.getMoney(), ipo.getAccount(), ipo.getId(),
					ipo.isApproved(),ipo.getBaccount());
			listList.add(vo);
		}
		System.out.println(listList.size());
		return listList;
	}
	
	@Override
	public ArrayList<MoneyInListVO> findAllExist(AccountPO po) {
		// TODO Auto-generated method stub
		mld = dataFactory.getMoneyInListData();
		ArrayList<MoneyInListVO> listList = new ArrayList<MoneyInListVO>();
		ArrayList<MoneyInListPO> polistList = new ArrayList<MoneyInListPO>();
		try {
			polistList = mld.findAllExist(po);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < polistList.size(); i++) {
			MoneyInListPO ipo = polistList.get(i);
			MoneyInListVO vo = new MoneyInListVO(ipo.getTime(), ipo.getMoney(), ipo.getAccount(), ipo.getId(),
					ipo.isApproved(),ipo.getBaccount());
			listList.add(vo);
		}

		return listList;
	}

	@Override
	public ArrayList<AccountVO> findAllCourier() {
		// TODO Auto-generated method stub
		mld = dataFactory.getMoneyInListData();
		ArrayList<AccountVO> accountList = new ArrayList<AccountVO>();
		ArrayList<AccountPO> poaccountList = new ArrayList<AccountPO>();
		try {
			poaccountList = mld.findAllCourier(po);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < poaccountList.size(); i++) {
			AccountPO apo = poaccountList.get(i);
			AccountVO vo = new AccountVO(apo.getid(), apo.getPermission(), apo.getUsername(), apo.getPassword(),
					apo.getStaff().getStaffId());
			accountList.add(vo);
		}
		return accountList;
	}

	@Override
	public MoneyInListVO addMoneyInList(MoneyInListPO po) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public AccountPO getPo() {
		return po;
	}
	
	@Override
	public ArrayList<String> findAllBaccount(){
		try {
			return mld.findAllBAccount();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
