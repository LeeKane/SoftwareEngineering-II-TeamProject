package blservice.listblservice;

import java.io.IOException;
import java.util.ArrayList;

import po.AccountPO;
import po.BaccountPO;
import po.list.MoneyInListPO;
import vo.AccountVO;
import vo.list.MoneyInListVO;

public interface MoneyInListBLService {
	public boolean MoneyInListUpdate(ArrayList<MoneyInListVO> vo) throws IOException;

	public ArrayList<MoneyInListVO> findAll(AccountPO po);

	public ArrayList<AccountVO> findAllCourier();

	public MoneyInListVO addMoneyInList(MoneyInListPO po);

	public ArrayList<MoneyInListVO> findAllExist(AccountPO po);

	public AccountPO getPo();

	public ArrayList<String> findAllBaccount();

	public ArrayList<BaccountPO> findAll();

	public void updata(ArrayList<BaccountPO> polist);

	public ArrayList<MoneyInListPO> findNoDel();
}
