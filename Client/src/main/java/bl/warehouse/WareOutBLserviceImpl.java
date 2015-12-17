package bl.warehouse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.warehouseblservice.WareOutBLservice;
import dataimpl.datafactory.DataFactory;
import dataservice.listdataservice.WareInListDataService;
import dataservice.listdataservice.WareOutListDataService;
import dataservice.warehousedataservice.GarageDataSeriaService;
import po.AccountPO;
import po.StaffPO;
import po.TimePO;
import po.list.WareOutListPO;
import util.City;
import util.ListState;
import util.ListType;
import util.Permission;
import util.Vehicle;
import vo.list.WareOutListVO;

public class WareOutBLserviceImpl implements WareOutBLservice {
private DataFactory datafactory;

boolean result=false;
private String org="beijing";
private WareOutListDataService wd;
private WareInListDataService wi;

private GarageDataSeriaService gd;
private AccountPO po;
private ArrayList<WareOutListVO> list;
public WareOutBLserviceImpl(AccountPO po){
	

	this.po=po;
	list=new ArrayList<WareOutListVO>();
	gd=DataFactory.getGarageData();
	wd=DataFactory.getWareOutData();
	wi=DataFactory.getWareInData();
	datafactory = new DataFactory();

}
	
	@Override
	public void addWareOut(long id, TimePO time, City destination, Vehicle vehicle, long transid) {
		// TODO Auto-generated method stub
		WareOutListVO vo=new WareOutListVO(ListType.STOCKOUT,id,time,vehicle,destination,transid,ListState.SUBMITTED);	
	   WareOutListPO po=new WareOutListPO(id,time,vehicle,destination,transid,ListState.SUBMITTED);
		addToTxt(po);
		list.add(vo);
	}

	
	public ArrayList<WareOutListVO> getWareOut(){
		return list;
		
	}
	public String getTxtAddress(City city, long id) {
		String address=city.toString()+""+"_"+id+"";
		return address;
	}
/*public static void main (String[] args){
	WareOutBLserviceImpl wb=new WareOutBLserviceImpl();
	wb.addWareOut(746413,new TimePO(2,1,2,1,2,1),City.BEIJING,Vehicle.PLANE,4567);
}*/
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

@Override
public AccountPO getPo() {
	// TODO Auto-generated method stub
	return po;
}

@Override
public boolean findWareIn(long id) throws IOException {
	// TODO Auto-generated method stub
	boolean result=false;
	result=wd.findWare(id);
	if(result==true){
		wi.delete(id);
	}
	return result;
}
}
