package vo;

import java.io.Serializable;
import java.util.Vector;

import util.City;
import util.OrgType;
import util.Permission;

public class StaffVO extends Vector<String> implements Serializable {
	private String orgid;
	private String id;
	private City city;
	OrgType orgType;
	Permission permission;

	public StaffVO(String orgid, String id, City city, OrgType orgType, Permission permission) {
		super();
		this.orgid = orgid;
		this.id = id;
		this.city = city;
		this.orgType = orgType;
		this.permission = permission;

		this.add(orgid + "-" + id);
		this.add(city.toString());
		this.add(orgType.toString());
		this.add(permission.toString());
	}

	public String getOrgid() {
		return orgid;
	}

	public String getId() {
		return id;
	}

	public City getCity() {
		return city;
	}

	public OrgType getOrgType() {
		return orgType;
	}

	public Permission getPermission() {
		return permission;
	}
}
