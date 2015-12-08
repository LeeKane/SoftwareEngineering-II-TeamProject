package po;

import java.io.Serializable;

public class BaccountPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private String name;/*账户名称*/
private String account;/*银行卡号*/
private String balance;/*余额*/
/**
 * 构造方法
 * 
 * @param name
 * @param account
 * @param balance
 */
public BaccountPO(String name, String account, String balance) {
	super();
	this.name = name;
	this.account = account;
	this.balance = balance;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getBalance() {
	return balance;
}
public void setBalance(String balance) {
	this.balance = balance;
}
@Override
public String toString() {
	return name+","+account+","+balance;
}

	
	
	
}
