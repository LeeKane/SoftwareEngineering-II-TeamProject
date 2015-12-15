package vo.list;

import java.util.Vector;

import po.GaragePlacePO;
import po.TimePO;
import util.City;
import util.ListState;

public class WareInListVO extends Vector<String>{
	private long id;//快递编号
	private TimePO time;//入库时间
	private City Destination;//目的地
	private GaragePlacePO place;//仓库位置
	private ListState state;
	public WareInListVO(long id, TimePO time, City destination, GaragePlacePO place,ListState state) {
		super();
		this.id = id;
		this.time = time;
		Destination = destination;
		this.place = place;
		this.state=state;
		this.add(id+"");
		this.add(time.toString());
		this.add(destination.toString());
		this.add(place.getQu()+"");
		this.add(place.getPai()+"");
		this.add(place.getJia()+"");
		this.add(place.getWei()+"");
		
	}
	public long getId() {
		return id;
	}
	public TimePO getTime() {
		return time;
	}
	public City getDestination() {
		return Destination;
	}
	public GaragePlacePO getPlace() {
		return place;
	}
	public ListState getState() {
		return state;
	}
	

}
