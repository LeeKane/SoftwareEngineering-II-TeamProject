package blservice.reviewblservice;

import java.util.ArrayList;
import java.util.Iterator;

import po.AccountPO;
import vo.ConstantVO;

public interface ConstantBLService {
	public Iterator<ConstantVO> findAllPriceConstant();

	public boolean addPriceConstant(ArrayList<ConstantVO> list);

	public AccountPO getPo();

	public boolean addDisConstant(ArrayList<ConstantVO> list);

	public Iterator<ConstantVO> findAllDisConstant();
}
