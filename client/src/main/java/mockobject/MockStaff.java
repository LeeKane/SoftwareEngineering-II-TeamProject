package mockobject;

import bl.review.Staff;
import po.StaffPO;
import util.OrgType;
import util.Permission;

public class MockStaff extends Staff{
	String name;
	long id;
	OrgType OrgType;
	Permission permission;
	StaffPO staff;
	
	public MockStaff(String name, long id, OrgType OrgType, Permission permission) {
		super();
		staff=new StaffPO(name, id, OrgType, permission);
	}
	
	public StaffPO getStaff(){
		return staff;
	}
}
