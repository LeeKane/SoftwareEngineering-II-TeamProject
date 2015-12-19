package po.list;

import java.io.Serializable;

import po.GaragePlacePO;
import po.TimePO;
import util.City;
import util.ListState;
import util.ListType;

public class WareInListPO implements Serializable {
	private ListType type = ListType.STOCKIN;

	private long id;// 快递编号
	private TimePO time;// 入库时间
	private City Destination;// 目的地
	private GaragePlacePO place;// 仓库位置
	private ListState state;
private long transcenterid;
	public WareInListPO(long id, TimePO time, City destination, GaragePlacePO place, ListState state,long centerid) {
		super();
		this.id = id;
		this.time = time;
		Destination = destination;
		this.place = place;
		this.state = state;
		this.transcenterid=centerid;
	}

	public long getTranscenterid() {
		return transcenterid;
	}

	public void setTranscenterid(long transcenterid) {
		this.transcenterid = transcenterid;
	}

	public void setType(ListType type) {
		this.type = type;
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

	public City getDestination() {
		return Destination;
	}

	public void setDestination(City destination) {
		Destination = destination;
	}

	public GaragePlacePO getPlace() {
		return place;
	}

	public void setPlace(GaragePlacePO place) {
		this.place = place;
	}

	public ListState getState() {
		return state;
	}

	public void setState(ListState state) {
		this.state = state;
	}

}
