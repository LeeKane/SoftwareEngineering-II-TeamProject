package blservice.financeblservice;

import java.util.ArrayList;

import po.AccountPO;
import vo.BaccountVO;

public interface BAccountBLService {
	public ArrayList<BaccountVO> findAll();

	public BaccountVO addStaff(String id, String string);

	public boolean deleteStaff(String id);

	public boolean update(ArrayList<BaccountVO> vo);

	public AccountPO getPo();
}
