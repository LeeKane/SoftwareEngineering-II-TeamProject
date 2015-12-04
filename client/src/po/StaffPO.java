package po;
import java.io.Serializable;
import util.*;


public class StaffPO implements Serializable {
	
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	
	private String orgid;
	private String id;
    private City city;
	OrgType orgType;
	Permission permission;
	//城市
	public StaffPO(String orgid, String id, City city, OrgType orgType, Permission permission) {
		super();
		this.orgid = orgid;
		this.id = id;
		this.city = city;
		this.orgType = orgType;
		this.permission = permission;
		
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public OrgType getOrgType() {
		return orgType;
	}
	public void setOrgType(OrgType orgType) {
		this.orgType = orgType;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * @param name 人员姓名
	 * @param id 人员编号
	 * @param permission 人员身份
	 * @param orgtype所属单位
	 */
	

	

}
