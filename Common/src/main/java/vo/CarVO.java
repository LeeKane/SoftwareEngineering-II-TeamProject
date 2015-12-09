package vo;

import java.io.Serializable;
import java.util.Vector;

import po.TimePO;
import util.Vehicle;

public class CarVO extends Vector<String> implements Serializable {

	private Vehicle vehicle;/* 种类 */

	private String name;/* 车辆代号 */
	private long engine;/* 发动机号 */
	private String carNum;/* 车辆号 */
	private long basenumber;/* 底盘号 */
	private TimePO buytime;/* 购买时间 */
	private TimePO usetime;/* 服役时间 */

	public CarVO(Vehicle vehicle, String name, long engine, String carNum, long basenumber, TimePO buytime,
			TimePO usetime) {
		super();

		this.vehicle = vehicle;
		this.name = name;
		this.engine = engine;
		this.carNum = carNum;
		this.basenumber = basenumber;
		this.buytime = buytime;
		this.usetime = usetime;

		this.add(name);
		this.add(engine + "");
		this.add(carNum);
		this.add(basenumber + "");
		this.add(buytime.toString());
		this.add(usetime.toString());

	}

	public String getName() {
		return name;
	}

	public long getEngine() {
		return engine;
	}

	public String getCarname() {
		return carNum;
	}

	public long getBasenumber() {
		return basenumber;
	}

	public TimePO getBuytime() {
		return buytime;
	}

	public TimePO getUsetime() {
		return usetime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

}
