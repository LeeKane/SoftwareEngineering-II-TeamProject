package bl.review;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.reviewblservice.StaffBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.reviewdataservice.StaffDataService;
import po.AccountPO;
import po.StaffPO;
import util.City;
import util.OrgType;
import util.Permission;
import vo.StaffVO;

public class StaffManager implements StaffBLService {
	private StaffDataService isd;
	private ArrayList<StaffVO> voList;
	private ArrayList<StaffPO> poList;
	private AccountPO po;
	private DataFactoryService dataFactory;

	public StaffManager(AccountPO po) {
		this.po = po;
		dataFactory = new DataFactory();
		isd = dataFactory.getStaffData();
	}

	@Override
	public boolean staffUpdate(ArrayList<StaffVO> voList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < voList.size(); i++) {
			StaffVO vo = voList.get(i);
			StaffPO po = new StaffPO(vo.getOrgid(), vo.getId(), vo.getCity(), vo.getOrgType(), vo.getPermission());
			// System.out.println(vo.getId()+"
			// "+vo.getPermission1().toString()+" "+vo.getUsername()+"
			// "+vo.getPassword());
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
		isd = dataFactory.getStaffData();
		ArrayList<StaffVO> voList = new ArrayList<StaffVO>();
		ArrayList<StaffPO> poList = new ArrayList<StaffPO>();
		try {
			poList = isd.findAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < poList.size(); i++) {
			StaffPO po = poList.get(i);
			StaffVO vo = new StaffVO(po.getOrgid(), po.getId(), po.getCity(), po.getOrgType(), po.getPermission());
			voList.add(vo);
		}
		return voList;
	}

	@Override
	public StaffVO addStaff(City city, OrgType org, String orgID, Permission permission) {
		// TODO Auto-generated method stub
		voList = new ArrayList<StaffVO>();
		String id = "";
		try {
			StaffPO po = null;
			if ((po = isd.findlast(orgID, permission.toString())) != null) {
				id = (Long.parseLong(po.getId()) + 1) + "";
			} else {
				id = 1001 + "";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		StaffVO vo = new StaffVO(orgID, id, city, org, permission);
		voList.add(vo);
		StaffPO po = new StaffPO(orgID, id, city, org, permission);
		try {
			isd.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public boolean deleteStaff(String orgId, String id) {
		// TODO Auto-generated method stub
		try {
			isd.delete(orgId, id);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public ArrayList<String> findInstitute(City city, OrgType org) throws IOException {
		// TODO Auto-generated method stub
		return isd.findbyOrg(city, org);
	}

}
