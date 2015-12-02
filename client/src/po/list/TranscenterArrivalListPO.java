package po.list;

import java.io.Serializable;

import po.TimePO;
import util.City;
import util.GoodState;

public class TranscenterArrivalListPO implements Serializable {

	private long transcenterID;/*中转中心编号*/
	private TimePO arrivatime;
	private long translistID;/*中转单编号*/
	private City startCity;
	private GoodState state;/*货物到达状态*/
	
	
	
	public TranscenterArrivalListPO(long transcenterID, TimePO arrivatime,
			long translistID, City startCity, GoodState state) {
		super();
		this.transcenterID = transcenterID;
		this.arrivatime = arrivatime;
		this.translistID = translistID;
		this.startCity = startCity;
		this.state = state;
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
	
	
	
	
}
