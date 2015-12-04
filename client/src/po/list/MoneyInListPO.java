package po.list;

import po.TimePO;

public class MoneyInListPO {
	/*
	 * 收款日期、收款金额、收款快递员、对应的所有快递订单条形码号
	 */
	private TimePO time;
	private double money;
	private String name;
	private long[] code;
	
	public MoneyInListPO(TimePO time, double money, String name, long[] code){
		super();
		this.time= time;
		this.money = money;
		this.name = name;
		this.code = code;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long[] getCode() {
		return code;
	}

	public void setCode(long[] code) {
		this.code = code;
	}

}
