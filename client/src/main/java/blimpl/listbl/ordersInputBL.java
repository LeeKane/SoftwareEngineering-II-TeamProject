package blimpl.listbl;



import java.util.ArrayList;

import blservice.listblservice.ordersInputBLService;
import po.TimePO;
import po.WarePO;
import util.DeliverType;
import vo.WareVO;
import dataimpl.datafactory.DataFactory;
import dataservice.listdataservice.ordersDataService;




public class ordersInputBL implements ordersInputBLService{
	private DataFactory dataFactory;//数据工厂
	private double cost;
	private String time;
	private ArrayList<WareVO>wareList;
	boolean result=false;
	public ordersInputBL(){
		dataFactory = new DataFactory();
		wareList = new ArrayList<WareVO>();
	}
	@Override
	public WareVO addware(double weight, int amount, double volume,
			String packag, String name, String type) {
				
		// TODO Auto-generated method stub
				double cost=1.0;
				TimePO time=new TimePO(1,1,1,1,1,1);
				DeliverType dType=null;
				if(type=="特快专递")
					dType=DeliverType.FAST;
				if(type=="标准快递")
					dType=DeliverType.STAND;
				else
					dType=DeliverType.ECO;
				WareVO ware = new WareVO(weight, amount , volume, packag, name, dType, cost,time);
				wareList.add(ware);
               return ware;
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
		ordersDataService od=dataFactory.getWareData();
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
