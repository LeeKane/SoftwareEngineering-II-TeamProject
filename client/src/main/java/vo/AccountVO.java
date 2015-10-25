package vo;

import util.*;
public class AccountVO {
	private Permission permission;
	private String username;
	private String password;

	
public AccountVO(Permission permission,String username,String password){
	this.permission=permission;
	this.username=username;
	this.password=password;
	}
public Permission getPermission() {
	return permission;
}

public String getUsername() {
	return username;
}

public String getPassword() {
	return password;
}
}
