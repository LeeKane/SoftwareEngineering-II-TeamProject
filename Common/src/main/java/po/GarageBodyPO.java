package po;

import java.io.Serializable;

public class GarageBodyPO implements Serializable {
	GaragePlacePO place;
	garageitem item;

	public GarageBodyPO(GaragePlacePO place, garageitem item) {
		super();
		this.place = place;
		this.item = item;
	}

	public GaragePlacePO getPlace() {
		return place;
	}

	public void setPlace(GaragePlacePO place) {
		this.place = place;
	}

	public garageitem getItem() {
		return item;
	}

	public void setItem(garageitem item) {
		this.item = item;
	}

}
