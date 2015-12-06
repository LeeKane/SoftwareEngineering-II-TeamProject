package po.list;

import po.TimePO;
import util.ListState;
import util.ListType;

public class MoneyInListPO {
	/*
	 * 收款单号
	 *收款日期、收款金额、收款快递员、对应的所有快递订单条形码号
	 */
	 ListType type=ListType.MONEYIN;


	private long id;
	private TimePO time;
	private double money;
	private String name;
	private long[] code;
	private ListState state;
	public MoneyInListPO(long id,TimePO time, double money, String name, long[] code,ListState state){
		super();
		this.id=id;
		this.time= time;
		this.money = money;
		this.name = name;
		this.code = code;
		this.state=state;
	}
	public ListType getType() {
		return type;
	}
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public ListState getState() {
		return state;
	}


	public void setState(ListState state) {
		this.state = state;
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
