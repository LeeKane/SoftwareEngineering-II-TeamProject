package bl.review;

import java.io.IOException;
import java.util.ArrayList;

import blservice.reviewblservice.StaffBLService;
import dataservice.StaffDataService.StaffDataService;
import po.AccountPO;
import po.StaffPO;
import util.City;
import util.OrgType;
import util.Permission;
import vo.StaffVO;

public class StaffManager implements StaffBLService{
	private StaffDataService isd;
    private ArrayList<StaffVO> voList;
	private AccountPO po;
	
	public StaffManager(AccountPO po){
		this.po=po;
	}
	
	@Override
	public boolean staffUpdate(ArrayList<StaffVO> voList) {
		// TODO Auto-generated method stub
		for(int i = 0; i<voList.size();i++){	
			StaffVO vo=voList.get(i);
			StaffPO po=new StaffPO(vo.getOrgid(),vo.getId(),vo.getCity(),vo.getOrgType(),vo.getPermission());
//			System.out.println(vo.getId()+" "+vo.getPermission1().toString()+" "+vo.getUsername()+" "+vo.getPassword());
			try {
				isd.update(po);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			return true;
	}

	@Override
	public ArrayList<StaffVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffVO addStaff(City city, OrgType org, Permission permission) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStaff(String orgId, String staffId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> findInstitute(City city, OrgType org) {
		// TODO Auto-generated method stub
		return null;
	}

}
