package vo.list;

import java.util.Vector;

import po.TimePO;
import util.City;
import util.GoodState;

public class ArrivaListVO extends Vector<String> {
	private static final long serialVersionUID = 1L;
	private long transid;// 中转单编号

	private TimePO time;
	private City StartCity;
	private GoodState state;
	private long id;// 条形码号

	public ArrivaListVO(long transid, TimePO time, long id, City StartCity, GoodState state) {
		this.transid = transid;
		this.id = id;
		this.time = time;
		this.StartCity = StartCity;
		this.state = state;
		this.add(time.toString());
		this.add(transid + "");
		this.add(StartCity.toString());
		this.add(state.toString());
	}

	public long getTransid() {
		return transid;
	}

	public TimePO getTime() {
		return this.time;
	}

	public Long getId() {
		return this.id;
	}

	public City getCity() {
		return this.StartCity;
	}

	public GoodState getState() {
		return this.state;
	}
}
