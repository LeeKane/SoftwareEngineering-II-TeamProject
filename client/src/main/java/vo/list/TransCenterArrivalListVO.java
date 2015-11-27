package vo.list;

import java.util.Vector;

import po.TimePO;
import util.City;
import util.GoodState;

public class TransCenterArrivalListVO extends Vector<String>{
	private long transcenterID;/*中转中心编号*/
	private TimePO arrivatime;
	private long translistID;/*中转单编号*/
	private City startCity;
	private GoodState state;/*货物到达状态*/
	
	
	
	public TransCenterArrivalListVO(long transcenterID, TimePO arrivatime,
			long translistID, City startCity, GoodState state) {
		super();
		this.transcenterID = transcenterID;
		this.arrivatime = arrivatime;
		this.translistID = translistID;
		this.startCity = startCity;
		this.state = state;
		this.add(transcenterID+"");
		this.add(arrivatime.toString());
		this.add(translistID+"");
		this.add(startCity.toString());
		this.add(state.toString());
	}
	public long getTranscenterID() {
		return transcenterID;
	}
	public TimePO getArrivatime() {
		return arrivatime;
	}
	public long getTranslistID() {
		return translistID;
	}
	public City getStartCity() {
		return startCity;
	}
	public GoodState getState() {
		return state;
	}
	
	
}
