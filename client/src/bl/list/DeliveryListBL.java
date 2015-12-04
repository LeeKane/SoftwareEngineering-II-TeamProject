package bl.list;

import java.util.ArrayList;

import blservice.listblservice.delivery_HallBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.listdataservice.DeliveryListDataService;
import po.TimePO;
import po.list.DeliveryListPO;
import util.ListType;
import vo.list.DeliveryListVO;

public class DeliveryListBL implements delivery_HallBLService{
	private DataFactory dataFactory;//数据工厂
	private ArrayList<DeliveryListVO>DeliveryListList;
	boolean result=false;
	public DeliveryListBL(){
		dataFactory = new DataFactory();
		DeliveryListList = new ArrayList<DeliveryListVO>();
	}
	@Override
	public DeliveryListVO addware(TimePO time, long code, String name) {
		// TODO Auto-generated method stub
		DeliveryListVO DeliveryList = new DeliveryListVO(time, code , name);
		DeliveryListList.add(DeliveryList);
       return DeliveryList;
	}

	@Override
	public TimePO getTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean submit() {
		// TODO Auto-generated method stub
		DeliveryListDataService od=dataFactory.getDeliveryData();
		if (!DeliveryListList.isEmpty()){
			for(int i = 0; i<DeliveryListList.size();i++){
				DeliveryListVO vo = DeliveryListList.get(i);
				TimePO time=vo.getTime();
				Long id=vo.getCode();
				String name=vo.getName();
         
    
				DeliveryListPO DeliveryList = new DeliveryListPO(time,id,name);
				result = od.insert(DeliveryList);
			}
			DeliveryListList.clear();
			return result;
		}else
			return false;		
	}
	

}
