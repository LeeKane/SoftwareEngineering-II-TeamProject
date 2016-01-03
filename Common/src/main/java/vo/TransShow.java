package vo;

import java.util.Vector;

import po.TimePO;

public class TransShow extends Vector<String> {
	private long transid;
	private long id;
	private TimePO time;

	public TransShow(long transid, long id, TimePO time) {
		super();
		this.transid = transid;
		this.id = id;
		this.time = time;
		this.add(transid + "");
		this.add(id + "");
		this.add(time.toString());
	}

	public long getTransid() {
		return transid;
	}

	public void setTransid(long transid) {
		this.transid = transid;
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

}
