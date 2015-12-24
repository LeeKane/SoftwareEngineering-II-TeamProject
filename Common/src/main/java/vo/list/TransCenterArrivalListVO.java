package vo.list;

import java.io.Serializable;
import java.util.Vector;

import po.TimePO;
import util.City;
import util.GoodState;
import util.ListState;

public class TransCenterArrivalListVO extends Vector<String> implements Serializable {
	private String transcenterID;/* 中转中心编号 */
	private TimePO arrivatime;
	private long id;/* 中转单编号 */
	private City startCity;
	private GoodState state;/* 货物到达状态 */
	private ListState lst;// 单据状态
	private long code;

	public TransCenterArrivalListVO(String transcenterID, TimePO arrivatime, long id, City startCity, GoodState state,
			ListState lst, long code) {
		super();
		this.transcenterID = transcenterID;
		this.arrivatime = arrivatime;
		this.id = id;
		this.startCity = startCity;
		this.state = state;
		this.lst = lst;
		this.code = code;

		this.add(code + "");
		this.add(transcenterID + "");
		this.add(id + "");
		this.add(arrivatime.toNormalString());
		this.add(state.toString());
		this.add(startCity.toString());
	}

	public ListState getLst() {
		return lst;
	}

	public long getCode() {
		return code;
	}

	public String getTranscenterID() {
		return transcenterID;
	}

	public TimePO getArrivatime() {
		return arrivatime;
	}

	public long getId() {
		return id;
	}

	public City getStartCity() {
		return startCity;
	}

	public GoodState getState() {
		return state;
	}
}
