package po.list;

import java.io.Serializable;

import po.TimePO;
import util.City;
import util.GoodState;
import util.ListType;

public class ArrivaList implements Serializable {

	
	private ListType type=ListType.ARRIVE;
	private TimePO time;/*到达日期*/
	private long transid;/*中转单编号*/
	private City StartCity;
	private City EndCity;
	private GoodState state;
	
	public ArrivaList(ListType type, TimePO time, long transid, City startCity,
			City endCity, GoodState state) {
		super();
		this.type = type;
		this.time = time;
		this.transid = transid;
		StartCity = startCity;
		EndCity = endCity;
		this.state = state;
	}
	public ListType getType() {
		return type;
	}
	public void setType(ListType type) {
		this.type = type;
	}
	public TimePO getTime() {
		return time;
	}
	public void setTime(TimePO time) {
		this.time = time;
	}
	public long getTransid() {
		return transid;
	}
	public void setTransid(long transid) {
		this.transid = transid;
	}
	public City getStartCity() {
		return StartCity;
	}
	public void setStartCity(City startCity) {
		StartCity = startCity;
	}
	public City getEndCity() {
		return EndCity;
	}
	public void setEndCity(City endCity) {
		EndCity = endCity;
	}
	public GoodState getState() {
		return state;
	}
	public void setState(GoodState state) {
		this.state = state;
	}
	
	
	
	

}
