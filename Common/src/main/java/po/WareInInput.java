package po;

import util.City;

public class WareInInput {
	public long id;
	public City destination;
	public TimePO time;// rukushijian

	public WareInInput(long id, City destination, TimePO time) {
		super();
		this.id = id;
		this.destination = destination;
		this.time = time;
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

	public void setId(long id) {
		this.id = id;
	}

	public void setDestination(City destination) {
		this.destination = destination;
	}

	public void setTime(TimePO time) {
		this.time = time;
	}

}
