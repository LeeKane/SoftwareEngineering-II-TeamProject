package po;
import java.io.Serializable;

import util.*;
public class AccountPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 序列化版本号
	 */
	private long id;
	private Permission permission;
	private String username;
	private String password;
	
	/**
	* @param permission 身份
	 * @param username 账号
	 * @param password 密码
		 */
	
	public AccountPO(long id,Permission permission, String username, String password) {
		super();
		this.id=id;
		this.permission = permission;
		this.username = username;
		this.password = password;
	}
	public long getid()
	{
		return id;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
