package bl.list;



import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

import blservice.listblservice.OrdersInputBLService;
import po.TimePO;
import po.WarePO;
import util.City;
import util.DeliverConstant;
import util.DeliverType;
import vo.WareVO;
import dataimpl.datafactory.DataFactory;
import dataservice.listdataservice.OrdersDataService;




public class OrdersInputBL implements OrdersInputBLService{
	private DataFactory dataFactory;//数据工厂
	private ArrayList<WareVO>wareList;
	boolean result=false;
	public OrdersInputBL(){
		dataFactory = new DataFactory();
		wareList = new ArrayList<WareVO>();
	}
	@Override
	public WareVO addware(double weight, int amount, double volume,
			String packag, String name, String type,City departPlace ,City destination) {
				
		// TODO Auto-generated method stub
				double cost=1.0;
				int day=1;
				long id=1111111111;//设置id的方法
			
				cost=myGetCost(departPlace,destination,type,weight);
				day=myGetDay(departPlace,destination,type);
				TimePO time=new TimePO(1,1,day,1,1,1);
				DeliverType dType=null;
				if(type=="特快专递")
					dType=DeliverType.FAST;
				if(type=="标准快递")
					dType=DeliverType.STAND;
				else
					dType=DeliverType.ECO;
				WareVO ware = new WareVO(weight, amount , volume, packag, name, dType, cost,time,id,departPlace,destination);
				wareList.add(ware);
               return ware;
	}
	private int myGetDay(City departPlace, City destination, String type) {
		// TODO Auto-generated method stub
		int result=1;
		if(departPlace==City.BEIJING)
		{
			if(destination==City.GUANGZHOU)
				result=DeliverConstant.TIME_BEIJING_GUANGZHOU;
			if (destination==City.NANJING)
				result=DeliverConstant.TIME_BEIJING_NANJING;
			if (destination==City.SHANGHAI)
				result=DeliverConstant.TIME_BEIJING_SHANGHAI;
			if(destination==City.BEIJING)
				result=1;
		}
		if(departPlace==City.GUANGZHOU)
		{
			if(destination==City.BEIJING)
				result=DeliverConstant.TIME_GONGZHOU_BEIJING;
			if(destination==City.NANJING)
				result=DeliverConstant.TIME_GONGZHOU_NANJING;
			if(destination==City.SHANGHAI)
				result=DeliverConstant.TIME_GONGZHOU_SHANGHAI;
			if(destination==City.GUANGZHOU)
				result=1;
		}
		if(departPlace==City.NANJING)
		{
			if(destination==City.GUANGZHOU)
				result=DeliverConstant.TIME_NANJING_GUANGZHOU;
			if(destination==City.BEIJING)
				result=DeliverConstant.TIME_NANJING_BEIJING;
			if(destination==City.SHANGHAI)
				result=DeliverConstant.TIME_NANJING_SHANGHAI;
			if(destination==City.NANJING)
				result=1;
		}
		if(departPlace==City.SHANGHAI)
		{
			if(destination==City.BEIJING)
				result=DeliverConstant.TIME_SHANGHAI_BEIJING;
			if(destination==City.NANJING)
				result=DeliverConstant.TIME_SHANGHAI_NANJING;
			if(destination==City.GUANGZHOU)
				result=DeliverConstant.TIME_SHANGHAI_GONGZHOU;
			if(destination==City.SHANGHAI)
				result=1;
		}
		if(type=="特快专递")
		{	result--;
		     if(result==0)
		   {
			result=1;
	     	}
		}
		if(type=="经济快递")
		{
			if(result!=1)
			result++;
			}
		return result;
	}
	private double myGetCost(City departPlace, City destination, String type,
			double weight) {
		double result=1.0;
		double instance=1.0;
		double costOftype=1.0;
		
		DeliverType t=null;
		if(type=="特快专递")
			t=DeliverType.FAST;
		if(type=="标准快递")
			t=DeliverType.STAND;
		if(type=="经济快递")
			t=DeliverType.ECO;
		costOftype=t.getCost();
		System.out.println(departPlace.toString()+destination.toString()+costOftype+weight);
		if(departPlace==City.BEIJING)
		{
			if(destination==City.GUANGZHOU)
				instance=DeliverConstant.DISTANCE_BEIJING_GUANGZHOU;
			if(destination==City.NANJING)
				instance=DeliverConstant.DISTANCE_BEIJING_NANJING;
			if(destination==City.SHANGHAI)
				instance=DeliverConstant.DISTANCE_BEIJING_SHANGHAI;
			if(destination==City.BEIJING)
				instance=30;
		}
		if(departPlace==City.GUANGZHOU)
		{
			if(destination==City.BEIJING)
				instance=DeliverConstant.DISTANCE_GONGZHOU_BEIJING;
			if(destination==City.NANJING)
				instance=DeliverConstant.DISTANCE_GONGZHOU_NANJING;
			if(destination==City.SHANGHAI)
				instance=DeliverConstant.DISTANCE_GONGZHOU_SHANGHAI;
			if(destination==City.GUANGZHOU)
				instance=30;
		}
		if(departPlace==City.NANJING)
		{
			if(destination==City.GUANGZHOU)
				instance=DeliverConstant.DISTANCE_NANJING_GUANGZHOU;
			if(destination==City.BEIJING)
				instance=DeliverConstant.DISTANCE_NANJING_BEIJING;
			if(destination==City.SHANGHAI)
				instance=DeliverConstant.DISTANCE_NANJING_SHANGHAI;
			if(destination==City.NANJING)
				instance=30;
		}
		if(departPlace==City.SHANGHAI)
		{
			if(destination==City.BEIJING)
				instance=DeliverConstant.DISTANCE_SHANGHAI_BEIJING;
			if(destination==City.NANJING)
				instance=DeliverConstant.DISTANCE_SHANGHAI_NANJING;
			if(destination==City.GUANGZHOU)
				instance=DeliverConstant.DISTANCE_SHANGHAI_GONGZHOU;
			if(destination==City.SHANGHAI)
				instance=30;
		}
        result=instance/1000*costOftype*weight;
        BigDecimal b=new BigDecimal(result);
        result=b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
		// TODO Auto-generated method stub
		
	}
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getTime() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean submit() {
		OrdersDataService od=dataFactory.getWareData();
		for(int i = 0; i<wareList.size();i++){
			WareVO vo = wareList.get(i);
           double weight=vo.getweight();
           int amount=vo.getamount();
           double volume=vo.getvolume();
           String packag=vo.getpackag();
           String name=vo.getname();
          double cost=vo.getcost();
			WarePO ware = new WarePO(weight,amount,volume,packag,name,vo.gettype1(),cost,vo.gettime1());
	        result = od.insert(ware);
		}
		return result;
	}
	

}
