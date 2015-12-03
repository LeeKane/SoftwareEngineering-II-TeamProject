package po.list;

import java.io.Serializable;

import po.TimePO;
import util.City;
import util.GoodState;
import util.ListState;

public class TranscenterArrivalListPO implements Serializable {

	private long transcenterID;/*中转中心编号*/
	private TimePO arrivatime;
	private long translistID;/*中转单编号*/
	private City startCity;
	private GoodState state;/*货物到达状态*/
	private ListState lst;//单据状态
	private long code;
	

	
	public TranscenterArrivalListPO(long transcenterID, TimePO arrivatime, long translistID, City startCity,
			GoodState state, ListState lst, long code) {
		super();
		this.transcenterID = transcenterID;
		this.arrivatime = arrivatime;
		this.translistID = translistID;
		this.startCity = startCity;
		this.state = state;
		this.lst = lst;
		this.code = code;
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
	public long getTranslistID() {
		return translistID;
	}
	public void setTranslistID(long translistID) {
		this.translistID = translistID;
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
