package vo;

import java.util.Vector;

import util.*;
public class AccountVO extends Vector<String> {
	private long id;


	private Permission permission;
	private String username;
	private String password;

	
public AccountVO(Long id,Permission permission,String username,String password){
this.permission=permission;
this.id=id;
this.add(id+"");
this.add(permission.toString());
this.add(username);
this.add(password);
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
	return this.get(0);
}
public String getPermission() {
	return this.get(1);
}

public String getUsername() {
	return this.get(2);
}

public String getPassword() {
	return this.get(3);
}
}
