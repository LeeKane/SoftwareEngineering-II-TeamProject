package bl.warehouse;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.warehouseblservice.WareOutBLservice;
import dataimpl.datafactory.DataFactory;
import dataservice.listdataservice.WareOutListDataService;
import dataservice.warehousedataservice.GarageDataSeriaService;
import po.AccountPO;
import po.TimePO;
import po.list.WareOutListPO;
import util.City;
import util.ListState;
import util.ListType;
import util.Vehicle;
import vo.list.WareOutListVO;

public class WareOutBLserviceImpl implements WareOutBLservice {
private DataFactory datafactory;

boolean result=false;
private String org="beijing";
private WareOutListDataService wd;
private GarageDataSeriaService gd;
private AccountPO po;
public WareOutBLserviceImpl(){
	this.po=po;
	gd=DataFactory.getGarageData();
	wd=DataFactory.getWareOutData();
	datafactory = new DataFactory();

}
	
	@Override
	public void addWareOut(long id, TimePO time, City destination, Vehicle vehicle, long transid) {
		// TODO Auto-generated method stub
		WareOutListVO vo=new WareOutListVO(ListType.STOCKOUT,id,time,vehicle,destination,transid,ListState.SUBMITTED);	
	   WareOutListPO po=new WareOutListPO(id,time,vehicle,destination,transid,ListState.SUBMITTED);
		addToTxt(po);
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
public void addToTxt(WareOutListPO po){
	try {
		wd.insert(po);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
