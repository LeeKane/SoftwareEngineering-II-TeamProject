package vo.list;

import java.io.Serializable;
import java.util.Vector;

import po.BaccountPO;
import po.TimePO;
import util.Entry;
import util.ListState;
import util.ListType;

public class MoneyOutListVO extends Vector<String> implements Serializable {
	private ListType type = ListType.MONEYOUT;

	private long id;// 加了一个id，虽然不知道什么用，就叫它付款单号吧
	private TimePO time;
	private double money;
	private String name;
	private BaccountPO account;
	private Entry entry;
	private String note;// 备注
	private ListState lst;// 状态

	public MoneyOutListVO(long id, TimePO time, double money, String name, BaccountPO account, Entry entry, String note,
			ListState lst) {
		super();
		this.id = id;
		this.time = time;
		this.money = money;
		this.name = name;
		this.account = account;
		this.entry = entry;
		this.note = note;
		this.lst = lst;

		this.add(id + "");
		this.add(time.toSpecicalString());
		this.add(money + "");
		this.add(name);
		this.add(account.getName());
		this.add(entry.toString());
		this.add(note);

	}

	public ListType getType() {
		return type;
	}

	public void setType(ListType type) {
		this.type = type;
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

	public ListState getLst() {
		return lst;
	}

	public void setLst(ListState lst) {
		this.lst = lst;
	}

}
