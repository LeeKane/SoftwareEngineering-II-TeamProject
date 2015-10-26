package vo;

import java.util.Vector;

public class BaccountVO extends Vector<String> {
	private String name;/*账户名称*/
	private String account;/*银行卡号*/
	private String balance;/*余额*/
	public BaccountVO(String name, String account, String balance) {
		super();
		this.name = name;
		this.account = account;
		this.balance = balance;
		this.add(name);
		this.add(account);
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
