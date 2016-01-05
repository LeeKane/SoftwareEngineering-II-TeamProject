package blservice.financeblservice;

import java.util.ArrayList;
import java.util.Iterator;

import po.AccountPO;
import vo.BaccountVO;

public interface BAccountBLService {
	public Iterator<BaccountVO> findAll();

	public BaccountVO addStaff(String id, String string);

	public boolean deleteStaff(String id);

	public boolean update(ArrayList<BaccountVO> vo);

	public AccountPO getPo();
}
