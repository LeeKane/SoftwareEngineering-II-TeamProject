package bl.list;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.listblservice.MoneyInListBLService;
import data.datafactory.DataFactory;
import dataservice.financedataservice.BAccountManageDataService;
import dataservice.listdataservice.MoneyInListDataService;
import po.AccountPO;
import po.BaccountPO;
import po.list.MoneyInListPO;
import vo.AccountVO;
import vo.list.MoneyInListVO;

public class MoneyInListBL implements MoneyInListBLService {
	private MoneyInListDataService mld;
	private ArrayList<MoneyInListVO> listList;
	private ArrayList<AccountVO> accountList;
	private AccountPO po;

	public MoneyInListBL(AccountPO po) {
		this.po = po;
	}

	@Override
	public boolean MoneyInListUpdate(ArrayList<MoneyInListVO> voList) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<BaccountPO> accountList = new ArrayList<BaccountPO>();
		accountList = findAll();

		ArrayList<MoneyInListPO> polistList = new ArrayList<MoneyInListPO>();
		for (int i = 0; i < voList.size(); i++) {
			MoneyInListVO vo = voList.get(i);
			MoneyInListPO ipo = new MoneyInListPO(vo.getTime(), vo.getMoney(), vo.getAccount(), vo.getId(),
					vo.isApproved(), vo.getBaccount());
			polistList.add(ipo);
		}
		mld.MoneyInUpdate(polistList);

		for (MoneyInListVO vo : voList) {
			for (int l = 0; l < accountList.size(); l++) {
				if (vo.getBaccount().equals(accountList.get(l).getName())) {
					double balance = Double.parseDouble(accountList.get(l).getBalance());
					balance += vo.getMoney();
					accountList.get(l).setBalance(balance + "");
				}
			}
		}
		updata(accountList);

		return true;
	}

	@Override
	public ArrayList<MoneyInListVO> findAll(AccountPO po) {
		// TODO Auto-generated method stub
		mld = DataFactory.getMoneyInListData();
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
					ipo.isApproved(), ipo.getBaccount());
			listList.add(vo);
		}
		System.out.println(listList.size());
		return listList;
	}

	@Override
	public ArrayList<MoneyInListPO> findNoDel() {
		mld = DataFactory.getMoneyInListData();
		ArrayList<MoneyInListPO> polistList = new ArrayList<MoneyInListPO>();
		try {
			polistList = mld.findAllWithNoDel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return polistList;
	}

	@Override
	public ArrayList<MoneyInListVO> findAllExist(AccountPO po) {
		// TODO Auto-generated method stub
		mld = DataFactory.getMoneyInListData();
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
					ipo.isApproved(), ipo.getBaccount());
			listList.add(vo);
		}

		return listList;
	}

	@Override
	public ArrayList<AccountVO> findAllCourierNoPo() {
		mld = DataFactory.getMoneyInListData();
		ArrayList<AccountVO> accountList = new ArrayList<AccountVO>();
		ArrayList<AccountPO> poaccountList = new ArrayList<AccountPO>();
		try {
			poaccountList = mld.findAllCourierNoPo();
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
	public ArrayList<AccountVO> findAllCourier() {
		// TODO Auto-generated method stub
		mld = DataFactory.getMoneyInListData();
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
	public ArrayList<String> findAllBaccount() {
		try {
			return mld.findAllBAccount();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<BaccountPO> findAll() {
		// TODO Auto-generated method stub
		BAccountManageDataService data = DataFactory.getBAccountManageData();
		ArrayList<BaccountPO> polist = new ArrayList<BaccountPO>();
		try {
			polist = data.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return polist;
	}

	@Override
	public void updata(ArrayList<BaccountPO> polist) {
		// TODO Auto-generated method stub
		BAccountManageDataService data = DataFactory.getBAccountManageData();
		for (int i = 0; i < polist.size(); i++) {
			try {
				data.update(polist.get(i));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
