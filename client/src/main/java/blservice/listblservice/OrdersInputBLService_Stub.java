package blservice.listblservice;

import po.TimePO;
import util.DeliverType;
import vo.WareVO;

public class OrdersInputBLService_Stub implements OrdersInputBLService{
	double weight ;
	int amount;
	double volume;
	String pack;
	String wareName;
	DeliverType dType;
	String type;
	double wareCost;
	TimePO time;
	
	double cost;
	double time2;
	
	public OrdersInputBLService_Stub(double weight, int amount, double volume, String pack, String wareName,
			String type, double wareCost, TimePO time, double cost, double time2) {
		super();
		this.weight = weight;
		this.amount = amount;
		this.volume = volume;
		this.pack = pack;
		this.wareName = wareName;
		this.type = type;
		this.wareCost = wareCost;
		this.time = time;
		this.cost = cost;
		this.time2 = time2;
		switch (type){
			case "特快专递":
				dType=DeliverType.FAST;
			case "标准快递":
				dType=DeliverType.STAND;
			case "经济快递":
				dType=DeliverType.ECO;
			default:
				dType=DeliverType.STAND;
		}
	}

	@Override
	public WareVO addware(double weight, int amount, double volume, String packag, String name, String type) {
		// TODO Auto-generated method stub
		System.out.println("Addware Succeeded!");
		return new WareVO(weight , amount, volume, packag, name, dType, cost, time);
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		System.out.println("GetCost Succeeded!");
		return cost;
	}

	@Override
	public double getTime() {
		// TODO Auto-generated method stub
		System.out.println("GetTime Succeeded!");
		return time2;
	}

	@Override
	public boolean submit() {
		// TODO Auto-generated method stub
		System.out.println("Submit Succeeded!");
		return false;
	}

}
