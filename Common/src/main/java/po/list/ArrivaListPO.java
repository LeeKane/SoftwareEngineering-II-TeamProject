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
	private long id;/*中转单编号*/
	private City StartCity;
	private ListState lst;/*单据状态*/
	private GoodState state;
	private long code;//条形码


	public ArrivaListPO(ListType type, TimePO time, long id, City startCity,
		GoodState state,ListState lst,long code) {
		super();
		this.type = type;
		this.time = time;
		this.id = id;
		StartCity = startCity;
		this.lst = lst;
		this.state = state;
		this.code=code;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
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
	public long getid() {
		return id;
	}
	public void setid(long id) {
		this.id = id;
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
