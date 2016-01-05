package bl.finance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import blservice.financeblservice.FinanceMIBLService;
import data.datafactory.DataFactory;
import dataservice.listdataservice.MoneyInListDataService;
import po.AccountPO;
import po.TimePO;
import po.list.MoneyInListPO;
import vo.list.MoneyInListVO;

public class FinanceMIBL implements FinanceMIBLService {
	private MoneyInListDataService mld;
	private ArrayList<MoneyInListVO> listList;
	private AccountPO po;

	@Override
	public AccountPO getPO() {
		return po;
	}

	public FinanceMIBL(AccountPO po) {
		this.po = po;
	}

	@Override
	public Iterator<MoneyInListVO> findAll(TimePO time, String city) {
		// TODO Auto-generated method stub
		mld = DataFactory.getMoneyInListData();
		ArrayList<MoneyInListVO> listList = new ArrayList<MoneyInListVO>();
		ArrayList<MoneyInListPO> polistList = new ArrayList<MoneyInListPO>();
		try {
			polistList = mld.findAllWithNoDel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < polistList.size(); i++) {
			MoneyInListPO ipo = polistList.get(i);
			MoneyInListVO vo = new MoneyInListVO(ipo.getTime(), ipo.getMoney(), ipo.getAccount(), ipo.getId(),
					ipo.isApproved(), ipo.getBaccount());
			System.out.println(ipo.getTime().toSpecicalString() + "ss" + time.toSpecicalString());
			System.out.println(ipo.getAccount().getStaff().getCity().toString() + "ss" + city);
			if (ipo.getTime().toSpecicalString().equals(time.toSpecicalString())
					&& ipo.getAccount().getStaff().getCity().toString().equals(city))
				listList.add(vo);
		}
		return listList.iterator();
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

}
