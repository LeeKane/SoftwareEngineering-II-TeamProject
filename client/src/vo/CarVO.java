package vo;
import java.awt.Image;

import util.*;
public class CarVO {
private Vehicle vehicle;/*种类*/

	private String name;/*车辆代号*/
	private long engine;/*发动机号*/
	private String carNum;/*车辆号*/
	private long basenumber;/*底盘号*/
	private String buytime;/*购买时间*/
	private String usetime;/*服役时间*/
	private Image image;/*车辆图片*/
	public CarVO(Vehicle vehicle, String name, long engine, String carNum,
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

	public long getEngine() {
		return engine;
	}

	public String getCarname() {
		return carNum;
	}
	
	public long getBasenumber() {
		return basenumber;
	}
	
	public String getBuytime() {
		return buytime;
	}
	
	public String getUsetime() {
		return usetime;
	}
	
	public Image getImage() {
		return image;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	
}
