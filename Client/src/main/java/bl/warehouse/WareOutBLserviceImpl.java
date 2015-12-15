package bl.warehouse;

import java.util.ArrayList;

import blservice.warehouseblservice.WareOutBLservice;
import dataimpl.datafactory.DataFactory;
import dataservice.warehousedataservice.GarageDataSeriaService;
import po.TimePO;
import util.City;
import util.ListState;
import util.ListType;
import util.Vehicle;
import vo.list.WareOutListVO;

public class WareOutBLserviceImpl implements WareOutBLservice {
private DataFactory datafactory;
private ArrayList<WareOutListVO> listlist;
boolean result=false;
private GarageDataSeriaService service;
private String org="beijing";
public WareOutBLserviceImpl(){
	
	datafactory = new DataFactory();
	listlist = new ArrayList<WareOutListVO>();
}
	
	@Override
	public void addWareOut(long id, TimePO time, City destination, Vehicle vehicle, long transid) {
		// TODO Auto-generated method stub
		WareOutListVO vo=new WareOutListVO(ListType.STOCKOUT,id,time,vehicle,destination,transid,ListState.SUBMITTED);	
		listlist.add(vo);
		
	}

	@Override
	public String getTxtAddress(City city, long id) {
		String address=city.toString()+""+"_"+id+"";
		return address;
	}

	@Override
	public void submitWareOut() {
		// TODO Auto-generated method stub
		
	}

}
