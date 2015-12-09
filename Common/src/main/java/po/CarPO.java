package po;

import java.io.Serializable;

import util.Vehicle;

public class CarPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Vehicle vehicle;/* 种类 */
	private String name;/* 车辆代号 */
	private long engine;/* 发动机号 */
	private String carNum;/* 车牌号 */
	private long basenumber;/* 底盘号 */
	private TimePO buytime;/* 购买时间 */
	private TimePO usetime;/* 服役时间 */

	public CarPO(Vehicle vehicle, String name, long engine, String carNum, long basenumber, TimePO buytime,
			TimePO usetime) {
		super();

		this.vehicle = vehicle;
		this.name = name;
		this.engine = engine;
		this.carNum = carNum;
		this.basenumber = basenumber;
		this.buytime = buytime;
		this.usetime = usetime;

	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getEngine() {
		return engine;
	}

	public void setEngine(long engine) {
		this.engine = engine;
	}

	public String getCarname() {
		return carNum;
	}

	public void setCarname(String carname) {
		this.carNum = carname;
	}

	public long getBasenumber() {
		return basenumber;
	}

	public void setBasenumber(long basenumber) {
		this.basenumber = basenumber;
	}

	public TimePO getBuytime() {
		return buytime;
	}

	public void setBuytime(TimePO buytime) {
		this.buytime = buytime;
	}

	public TimePO getUsetime() {
		return usetime;
	}

	public void setUsetime(TimePO usetime) {
		this.usetime = usetime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
