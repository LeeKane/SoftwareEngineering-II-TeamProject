package vo;

import java.io.Serializable;
import java.util.Vector;

import util.*;
public class AccountVO extends Vector<String> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2160796412161848375L;
	private long id;
	private Permission permission;
	private String username;
	private String password;
    private String staffid;
	

public AccountVO(Long id,Permission permission,String username,String password,String staffid){
this.permission=permission;
this.id=id;
this.username=username;
this.password=password;
this.staffid=staffid;
this.add(id+"");
this.add(permission.toString());
this.add(username);
this.add(password);
this.add(staffid);
	}
public String getStaffid() {
	return staffid;
}
public void setStaffid(String staffid) {
	this.staffid = staffid;
}
public long getId() {
	return id;
}

public Permission getPermission1()
{
	return permission;
}
public String getIdInStr()
{
	return id+"";
}
public String getPermission() {
	return permission.toString();
}

public String getUsername() {
	return username;
}

public String getPassword() {
	return password;
}
}
