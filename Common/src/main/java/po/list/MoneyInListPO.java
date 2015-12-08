package po.list;

import java.io.Serializable;

import po.AccountPO;
import po.TimePO;
import util.ListState;
import util.ListType;

public class MoneyInListPO implements Serializable{
	/*
	 * 收款单号
	 *收款日期、收款金额、收款快递员、对应的所有快递订单条形码号
	 */
	 ListType type=ListType.MONEYIN;
	private TimePO time;
	private double money;
	private AccountPO account;
	private long id;
	private boolean isApproved;
	
	public MoneyInListPO(TimePO time, double money, AccountPO account, long id,boolean isApproved) {
		super();
		this.time = time;
		this.money = money;
		this.account = account;
		this.id = id;
		this.isApproved=isApproved;
	}

	public TimePO getTime() {
		return time;
	}

	public void setTime(TimePO time) {
		this.time = time;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public AccountPO getAccount() {
		return account;
	}

	public void setAccount(AccountPO account) {
		this.account = account;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
}
