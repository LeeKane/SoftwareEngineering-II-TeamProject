package vo;

import java.util.Vector;

import po.TimePO;
import util.City;

public class WareInInputVO extends Vector<String> {
	public long id;
	public City destination;
	public TimePO time;// rukushijian

	public WareInInputVO(long id, City destination, TimePO time) {
		super();
		this.id = id;
		this.destination = destination;
		this.time = time;
		this.addElement(id + "");
		this.add(destination.toString());
		this.add(time.toString());
	}

	public long getId() {
		return id;
	}

	public City getDestination() {
		return destination;
	}

	public TimePO getTime() {
		return time;
	}
}
