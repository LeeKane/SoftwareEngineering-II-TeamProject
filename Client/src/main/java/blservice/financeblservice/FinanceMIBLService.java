package blservice.financeblservice;

import java.util.Iterator;

import po.AccountPO;
import po.TimePO;
import vo.list.MoneyInListVO;

public interface FinanceMIBLService {
	public Iterator<MoneyInListVO> findAll(TimePO time, String city);

	public double getCost();

	public AccountPO getPO();
}
