package bl.list;

import java.util.ArrayList;

import dataimpl.datafactory.DataFactory;
import dataservice.listdataservice.ArrivalListDataService;
import po.TimePO;
import po.WarePO;
import po.list.ArrivaListPO;
import util.City;
import util.DeliverType;
import util.GoodState;
import util.ListType;
import vo.WareVO;
import vo.list.ArrivaListVO;
import blservice.listblservice.arrivaList_HallBLService;

public class ArrivaListBL implements arrivaList_HallBLService{
	private DataFactory dataFactory;//数据工厂
	private ArrayList<ArrivaListVO>ArrivaListList;
	boolean result=false;
	public ArrivaListBL(){
		dataFactory = new DataFactory();
		ArrivaListList = new ArrayList<ArrivaListVO>();
	}
	@Override
	public ArrivaListVO addList(TimePO time, Long id,City StartCity,
			GoodState state) {
		// TODO Auto-generated method stub

		ArrivaListVO ware = new ArrivaListVO(time, id , StartCity,state);
		ArrivaListList.add(ware);
       return ware;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimePO getTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean submit() {
		// TODO Auto-generated method stub
		ArrivalListDataService od=dataFactory.getArrivalData();
		for(int i = 0; i<ArrivaListList.size();i++){
			ArrivaListVO vo = ArrivaListList.get(i);
			TimePO time=vo.getTime();
			Long id=vo.getId();
			City StartCity=vo.getCity();
           GoodState state=vo.getState();
    
           ArrivaListPO ArrivaList = new ArrivaListPO(ListType.ARRIVE,time,id,StartCity,state);
	        result = od.insert(ArrivaList);
		}
		return result;
	}

}
