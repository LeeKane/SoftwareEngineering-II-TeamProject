package po.list;

import java.io.Serializable;

import po.TimePO;
import util.City;
import util.GoodState;
import util.ListState;
import util.ListType;

public class ArrivaListPO implements Serializable {

	
	private ListType type=ListType.ARRIVE;
	private TimePO time;/*到达日期*/
	private long transid;/*中转单编号*/
	private City StartCity;
	private ListState lst;/*单据状态*/
	
	private GoodState state;
	


	public ArrivaListPO(ListType type, TimePO time, long transid, City startCity,
		GoodState state,ListState lst) {
		super();
		this.type = type;
		this.time = time;
		this.transid = transid;
		StartCity = startCity;
		this.lst = lst;
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
