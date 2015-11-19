package po;
import java.io.Serializable;
import util.*;


public class StaffPO implements Serializable {
	
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private long id;
	OrgType orgType;
	Permission permission;
	//城市
	
	/**
	 * @param name 人员姓名
	 * @param id 人员编号
	 * @param permission 人员身份
	 * @param orgtype所属单位
	 */
	public StaffPO (long id,String name,OrgType OrgType,Permission permission){
		this.name=name;
		this.id=id;
		this.orgType=OrgType;
		this.permission=permission;
		
	}
	

	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public OrgType getOrgType() {
		return orgType;
	}

	public void setOrgType(OrgType orgType) {
		this.orgType = orgType;
	}

	

}
