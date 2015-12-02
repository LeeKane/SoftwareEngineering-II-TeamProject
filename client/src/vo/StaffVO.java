package vo;

import java.util.Vector;

import util.OrgType;
import util.Permission;

public class StaffVO extends Vector<String>{
	private String name;
	private long id;
	OrgType orgType;
	Permission permission;
	public StaffVO(String name, long id, OrgType orgType, Permission permission) {
		super();
		this.name = name;
		this.id = id;
		this.orgType = orgType;
		this.permission = permission;
		this.add(name);
		this.add(id+"");
		this.add(orgType.toString());
		this.add(permission.toString());
	}
	public String getName() {
		return name;
	}
	public long getId() {
		return id;
	}
	public OrgType getOrgType() {
		return orgType;
	}
	public Permission getPermission() {
		return permission;
	}
	
	
}
