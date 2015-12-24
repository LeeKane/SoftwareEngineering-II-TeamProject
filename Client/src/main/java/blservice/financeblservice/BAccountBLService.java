package blservice.financeblservice;

import java.util.ArrayList;

import util.City;
import vo.BaccountVO;
import vo.StaffVO;

public interface BAccountBLService {
	public ArrayList<BaccountVO> findAll();
	
	public BaccountVO addStaff(String id,City city);
	
	public boolean deleteStaff(String id);
	
	public boolean update(ArrayList<BaccountVO> vo);
}
