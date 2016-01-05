package blservice.reviewblservice;

import java.util.ArrayList;
import java.util.Iterator;

import po.AccountPO;
import vo.ConstantVO;

public interface ConstantBLService {
	public AccountPO getPo();

	public Iterator<ConstantVO> findAll();

	public boolean addConstant(ArrayList<ConstantVO> list);
}
