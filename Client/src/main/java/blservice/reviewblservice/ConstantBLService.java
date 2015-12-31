package blservice.reviewblservice;

import java.util.ArrayList;

import po.AccountPO;
import vo.ConstantVO;

public interface ConstantBLService {
	public ArrayList<ConstantVO> findAllPriceConstant();
	
	public boolean addPriceConstant(ArrayList<ConstantVO> list);

	public AccountPO getPo();

	public boolean addDisConstant(ArrayList<ConstantVO> list);

	public ArrayList<ConstantVO> findAllDisConstant();
}
