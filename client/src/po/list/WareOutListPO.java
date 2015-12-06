package po.list;

import java.io.Serializable;

import po.GaragePlacePO;
import po.TimePO;
import util.City;
import util.ListState;
import util.Vehicle;

public class WareOutListPO implements Serializable{
	private long id;//快递编号
	private TimePO time;//出库时间
	private Vehicle vehicle;//装运形式
	private City Destination;//目的地
	private long transid;//中转单编号
	private ListState state;
	public WareOutListPO(long id, TimePO time, Vehicle vehicle, City destination, long transid, ListState state) {
		super();
		this.id = id;
		this.time = time;
		this.vehicle = vehicle;
		Destination = destination;
		this.transid = transid;
		this.state = state;
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
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public City getDestination() {
		return Destination;
	}
	public void setDestination(City destination) {
		Destination = destination;
	}
	public long getTransid() {
		return transid;
	}
	public void setTransid(long transid) {
		this.transid = transid;
	}
	public ListState getState() {
		return state;
	}
	public void setState(ListState state) {
		this.state = state;
	}
	
	
	
}
