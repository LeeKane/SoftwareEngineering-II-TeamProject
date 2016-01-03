package vo;

import java.io.Serializable;
import java.util.Vector;

public class BaccountVO extends Vector<String> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;/* 账户名称 */
	private String account;/* 银行卡号 */
	private String balance;/* 余额 */

	public BaccountVO(String name, String account, String balance) {
		super();
		this.name = name;
		this.account = account;
		this.balance = balance;

		this.add(account);
		this.add(name);
		this.add(balance);
	}

	public String getName() {
		return this.get(0);
	}

	public String getAccount() {
		return this.get(1);
	}

	public String getBalance() {
		return this.get(2);
	}

}
