package blservice.financeblservice;

import java.util.ArrayList;

import po.AccountPO;
import po.TimePO;
import vo.list.MoneyInListVO;

public interface FinanceMIBLService {
	public ArrayList<MoneyInListVO> findAll(TimePO time ,String city);
	public double getCost();
	public AccountPO getPO();
}
