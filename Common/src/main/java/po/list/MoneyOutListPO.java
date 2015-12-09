package po.list;

import java.io.Serializable;

import po.BaccountPO;
import po.TimePO;
import util.Entry;
import util.ListState;
import util.ListType;
import util.RewardType;

public class MoneyOutListPO implements Serializable {

	/*
	 * 付款日期、付款金额、付款人、付款账号、条目（租金（按年收） 运费（按次计算）人员工资（按月统计）奖励（一次性）），
	 * 备注（租金年份、运单号、标注工资月份）。（快递员提成、司机计次、业务员月薪）
	 */
	private ListType type = ListType.MONEYOUT;

	private long id;// 加了一个id，虽然不知道什么用，就叫它付款单号吧
	private TimePO time;
	private double money;
	private String name;
	private BaccountPO account;
	private Entry entry;
	private String note;// 备注
	private RewardType reward;
	private ListState lst;// 状态

	public MoneyOutListPO(long id, TimePO time, double money, String name, BaccountPO account, Entry entry, String note,
			RewardType reward, ListState lst) {
		super();
		this.id = id;
		this.time = time;
		this.money = money;
		this.name = name;
		this.account = account;
		this.entry = entry;
		this.note = note;
		this.reward = reward;
		this.lst = lst;
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

	public BaccountPO getAccount() {
		return account;
	}

	public void setAccount(BaccountPO account) {
		this.account = account;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public RewardType getReward() {
		return reward;
	}

	public void setReward(RewardType reward) {
		this.reward = reward;
	}

	public ListState getLst() {
		return lst;
	}

	public void setLst(ListState lst) {
		this.lst = lst;
	}

}
