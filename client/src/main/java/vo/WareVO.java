package vo;

import java.util.Vector;

import po.TimePO;
import util.DeliverType;

public class WareVO extends Vector<String> {

	public WareVO (double weight , int amount, double volume, String packag, String name,DeliverType type,double cost,TimePO time){
		this.add(""+weight);
		this.add(""+amount);
		this.add(""+volume);
		this.add(""+packag);
		this.add(name);
		this.add(""+type.toString());
		this.add(""+cost);
		this.add(""+time.toString());
		}
	
	public double getweight()
	{
		double weight=Double.parseDouble(this.get(0));
		return weight;
	}
	public int getamount()
	{
		int amount=Integer.parseInt(this.get(1));
		return amount;
	}
	public double getvolume()
	{
		double volume=Double.parseDouble(this.get(2));
		return volume;
	}
	public String getpackag()
	{
		return this.get(3);
	}
	public String getname()
	{
		return this.get(4);
	}
	public String gettype()
	{
		return this.get(5);
	}
	public double getcost()
	{
		double cost=Double.parseDouble(this.get(6));
		return cost;
	}
	public String gettime()
	{
		return this.get(7);
	}
	
	public DeliverType gettype1(){
		if(gettype()=="特快专递")
			return DeliverType.FAST;
		if(gettype()=="标准快递")
			return DeliverType.STAND;
		else
			return DeliverType.ECO;
		
	}
	public TimePO gettime1()
	{
		return new TimePO(1,1,1,1,1,1);
		
	}
}
