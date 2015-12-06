package po.list;

import java.io.Serializable;

import po.GaragePlacePO;
import po.TimePO;
import util.City;
import util.ListState;

public class WareInListPO implements Serializable {
	private long id;//快递编号
	private TimePO time;//入库时间
	private City Destination;//目的地
	private GaragePlacePO place;//仓库位置
	private ListState state;
	public WareInListPO(long id, TimePO time, City destination, GaragePlacePO place,ListState state) {
		super();
		this.id = id;
		this.time = time;
		Destination = destination;
		this.place = place;
		this.state=state;
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
