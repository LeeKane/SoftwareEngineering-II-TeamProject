package vo.list;

import java.util.Vector;

import po.TimePO;
import util.City;
import util.ListState;
import util.ListType;
import util.Vehicle;

public class WareOutListVO extends Vector<String> {
	private ListType type=ListType.STOCKOUT;

	private long id;//快递编号
	private TimePO time;//出库时间
	private Vehicle vehicle;//装运形式
	private City Destination;//目的地
	private long transid;//中转单编号
	private ListState state;
	public WareOutListVO(ListType type, long id, TimePO time, Vehicle vehicle, City destination, long transid,
			ListState state) {
		super();
		this.type = type;
		this.id = id;
		this.time = time;
		this.vehicle = vehicle;
		Destination = destination;
		this.transid = transid;
		this.state = state;
	
		this.add(id+"");
		this.add(time.toString());
	
		this.add(vehicle.toString());
		this.add(destination.toString());
		this.add(transid+"");
	
			}
	public ListType getType() {
		return type;
	}
	public long getId() {
		return id;
	}
	public TimePO getTime() {
		return time;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public City getDestination() {
		return Destination;
	}
	public long getTransid() {
		return transid;
	}
	public ListState getState() {
		return state;
	}
	
	
	
}









