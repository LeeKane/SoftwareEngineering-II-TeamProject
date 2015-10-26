package vo;

import java.util.Vector;

import util.*;
public class AccountVO extends Vector<String> {
	private Permission permission;
	private String username;
	private String password;

	
public AccountVO(Permission permission,String username,String password){
this.permission=permission;
this.add(permission.toString());
this.add(username);
this.add(password);
	}

public Permission getPermission1()
{
	return permission;
}
public String getPermission() {
	return this.get(0);
}

public String getUsername() {
	return this.get(1);
}

public String getPassword() {
	return this.get(2);
}
}
