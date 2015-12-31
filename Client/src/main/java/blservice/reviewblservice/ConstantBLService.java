package blservice.reviewblservice;

import java.util.ArrayList;

import vo.ConstantVO;

public interface ConstantBLService {
	public ArrayList<ConstantVO> findAllPriceConstant();
	
	public void addPriceConstant(ArrayList<ConstantVO> list);
}
