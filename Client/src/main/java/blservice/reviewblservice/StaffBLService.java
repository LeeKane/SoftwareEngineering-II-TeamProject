package blservice.reviewblservice;

import java.io.IOException;
import java.util.ArrayList;

import po.AccountPO;
import util.City;
import util.OrgType;
import util.Permission;
import vo.StaffVO;

public interface StaffBLService {
	public boolean staffUpdate(ArrayList<StaffVO> vo);

	public ArrayList<StaffVO> findAll();

	public StaffVO addStaff(City city, OrgType org, String orgId, Permission permission);

	public boolean deleteStaff(String orgId, String staffId);

	public ArrayList<String> findInstitute(City city, OrgType org) throws IOException;

	public AccountPO getPo();
}
