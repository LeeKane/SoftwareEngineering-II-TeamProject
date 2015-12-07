package blservice.reviewblservice;

import java.util.ArrayList;

import util.City;
import util.OrgType;
import util.Permission;
import vo.StaffVO;

public interface StaffBLService {
	public boolean staffUpdate (ArrayList<StaffVO> vo) ;
	public ArrayList<StaffVO> findAll();
	public StaffVO addStaff(City city,OrgType org,Permission permission);
	public boolean deleteStaff(String orgId,String staffId);
	public ArrayList<String> findInstitute(City city,OrgType org);
}
