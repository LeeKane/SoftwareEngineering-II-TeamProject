package vo;

import java.util.Vector;

import util.Vehicle;

public class GaragePlaceVehicleVO extends Vector<String> {
	private int qu;
	private int pai;
	private int jia;
	private int wei;
	private Vehicle vehicle;
	public GaragePlaceVehicleVO(int qu, int pai, int jia, int wei,Vehicle vehicle) {
		super();
		this.qu = qu;
		this.pai = pai;
		this.jia = jia;
		this.wei = wei;
		this.vehicle=vehicle;
		this.add(qu+"");
		this.add(pai+"");
		this.add(jia+"");
		this.add(wei+"");
		this.add(vehicle.toString());
	}
	public int getQu() {
		return qu;
	}
	public int getPai() {
		return pai;
	}
	public int getJia() {
		return jia;
	}
	public int getWei() {
		return wei;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	
}
