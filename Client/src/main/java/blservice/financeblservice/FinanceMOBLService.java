package blservice.financeblservice;

import java.util.ArrayList;

import po.AccountPO;
import po.BaccountPO;
import po.TimePO;
import po.list.MoneyOutListPO;
import util.Entry;
import util.ListState;
import vo.list.MoneyOutListVO;

public interface FinanceMOBLService {
	public MoneyOutListVO addMOList(long id, TimePO time, double money, String name, BaccountPO account, Entry entry,
			String note, ListState lst);

	public boolean submit();

	public long myGetListId(TimePO time);

	public ArrayList<BaccountPO> findAll();

	public void updata(ArrayList<BaccountPO> polist);

	public ArrayList<MoneyOutListPO> findList();

	public AccountPO getPo();
}
