package blservice.financeblservice;

import po.BaccountPO;
import po.TimePO;
import util.Entry;
import util.ListState;
import vo.list.MoneyOutListVO;

public interface FinanceMOBLService {
public MoneyOutListVO addMOList(long id, TimePO time, double money, String name, BaccountPO account, Entry entry, String note,
		ListState lst);
public boolean submit();
public long myGetListId(TimePO time);
}
