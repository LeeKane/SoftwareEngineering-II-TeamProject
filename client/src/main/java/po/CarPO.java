package po;
import java.io.Serializable;
import java.awt.Image;

import util.Vehicle;
public class CarPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vehicle vehicle;/*种类*/
	private String name;/*车辆代号*/
	private long engine;/*发动机号*/
	private String carNum;/*车辆号*/
	private long basenumber;/*底盘号*/
	private String buytime;/*购买时间*/
	private String usetime;/*服役时间*/
	private Image image;/*车辆图片*/
	
	public CarPO(Vehicle vehicle, String name, long engine, String carNum,
			long basenumber, String buytime, String usetime, Image image) {
		super();
		this.vehicle = vehicle;
		this.name = name;
		this.engine = engine;
		this.carNum = carNum;
		this.basenumber = basenumber;
		this.buytime = buytime;
		this.usetime = usetime;
		this.image = image;
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
	public String getBuytime() {
		return buytime;
	}
	public void setBuytime(String buytime) {
		this.buytime = buytime;
	}
	public String getUsetime() {
		return usetime;
	}
	public void setUsetime(String usetime) {
		this.usetime = usetime;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
