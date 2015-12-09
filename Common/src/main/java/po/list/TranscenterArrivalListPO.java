package po.list;

import java.io.Serializable;

import po.TimePO;
import util.City;
import util.GoodState;
import util.ListState;
import util.ListType;

public class TranscenterArrivalListPO implements Serializable {
	private ListType type = ListType.TRANSCENTERARRIVE;

	private long transcenterID;/* 中转中心编号 */
	private TimePO arrivatime;
	private long id;/* 中转单编号 */
	private City startCity;
	private GoodState state;/* 货物到达状态 */
	private ListState lst;// 单据状态
	private long code;

	public TranscenterArrivalListPO(long transcenterID, TimePO arrivatime, long id, City startCity, GoodState state,
			ListState lst, long code) {
		super();
		this.transcenterID = transcenterID;
		this.arrivatime = arrivatime;
		this.id = id;
		this.startCity = startCity;
		this.state = state;
		this.lst = lst;
		this.code = code;
	}

	public ListType getType() {
		return type;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public long getTranscenterID() {
		return transcenterID;
	}

	public void setTranscenterID(long transcenterID) {
		this.transcenterID = transcenterID;
	}

	public TimePO getArrivatime() {
		return arrivatime;
	}

	public void setArrivatime(TimePO arrivatime) {
		this.arrivatime = arrivatime;
	}

	public long getid() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public City getStartCity() {
		return startCity;
	}

	public void setStartCity(City startCity) {
		this.startCity = startCity;
	}

	public GoodState getState() {
		return state;
	}

	public void setState(GoodState state) {
		this.state = state;
	}

	public ListState getLst() {
		return lst;
	}

	public void setLst(ListState lst) {
		this.lst = lst;
	}

}
