package vo;

public class BaccountVO {
	private String name;/*账户名称*/
	private String account;/*银行卡号*/
	private String balance;/*余额*/
	public BaccountVO(String name, String account, String balance) {
		super();
		this.name = name;
		this.account = account;
		this.balance = balance;
	}
	public String getName() {
		return name;
	}

	public String getAccount() {
		return account;
	}
	public String getBalance() {
		return balance;
	}
	
}
