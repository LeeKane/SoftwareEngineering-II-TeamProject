package po;

import java.io.Serializable;

import util.City;
import util.DeliverType;

public class WarePO implements Serializable {
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;

	private City departPlace;//出发地
	private City destination;//到达地
	private long id;//单据id
	private double weight;
	private int amount;
	private double volume;
	private String pack;
	private String name;
	private DeliverType type;
	private double cost;
	private TimePO time;

	/**
	 * @param weight
	 *            实际重量
	 * @param amount
	 *            数量
	 * @param volume
	 *            体积
	 * @param name
	 *            内件品名
	 * @param package
	 *            包装类型
	 * @param type
	 *            快递类型
	 */
	public WarePO(double weight, int amount, double volume, 
			String packag, String name, DeliverType type, 
			double cost, TimePO time) {//重写构造函数添加出发目的的
		this.weight = weight;
		this.amount = amount;
		this.volume = volume;
		this.pack = packag;
		this.name = name;
		this.type = type;
		this.cost = cost;
		this.time = time;
		this.departPlace=City.BEIJING;
		this.destination=City.NANJING;
	}

	public double getweight() {
		return weight;
	}

	public void setweight(double weight) {
		this.weight = weight;
	}

	public int getamount() {
		return amount;
	}

	public void setamount(int amount) {
		this.amount = amount;
	}

	public double getvolume() {
		return volume;
	}

	public void setvolume(double volume) {
		this.volume = volume;
	}

	public double getcost() {
		return cost;
	}

	public void setcost(double cost) {
		this.cost = cost;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getpackag() {
		return pack;
	}

	public void setpackag(String packag) {
		this.pack = packag;
	}

	public DeliverType gettype() {
		return type;
	}

	public void settype(DeliverType type) {
		this.type = type;
	}

	public TimePO gettime() {
		return time;
	}

	public void settime(TimePO time) {
		this.time = time;
	}
	public City getDepartPlace() {
		return departPlace;
	}

	public void setDepartPlace(City departPlace) {
		this.departPlace = departPlace;
	}

	public City getDestination() {
		return destination;
	}

	public void setDestination(City destination) {
		this.destination = destination;
	}

}
