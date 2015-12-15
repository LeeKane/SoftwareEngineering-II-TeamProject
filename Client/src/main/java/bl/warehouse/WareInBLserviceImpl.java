package bl.warehouse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.warehouseblservice.WareInBLservice;
import dataimpl.datafactory.DataFactory;
import dataservice.listdataservice.WareInListDataService;
import dataservice.warehousedataservice.GarageDataSeriaService;
import po.Garage;
import po.GaragePlacePO;
import po.TimePO;
import po.garageitem;
import po.list.WareInListPO;
import util.City;
import util.ListState;
import vo.WareInInputVO;
import vo.list.WareInListVO;

public class WareInBLserviceImpl implements WareInBLservice{
	private DataFactory dataFactory;// 数据工厂
	public ArrayList<WareInInputVO> WareInListlist;
	public ArrayList<WareInListVO> Listlist;

	boolean result=false;
	private static GarageDataSeriaService gd;
	private WareInListDataService wd;
	private String org;
	
	public WareInBLserviceImpl(){
		 gd=DataFactory.getGarageData();
		 wd=DataFactory.getWareInData();
		dataFactory = new DataFactory();
		WareInListlist = new ArrayList<WareInInputVO>();
		Listlist = new ArrayList<WareInListVO>();
		
	}
	
	
	public WareInInputVO addWareIn(long id, TimePO time, City destination,long transid) {
		// TODO Auto-generated method stub
		WareInInputVO wareIn=new WareInInputVO( id,  destination, time);
			WareInListlist.add(wareIn);
			org=setAddress(transid);
		return wareIn;
	}

	@Override
	public boolean submitWareIn() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		
		if(!WareInListlist.isEmpty()){
			for(int i=0;i<WareInListlist.size();i++){
				WareInInputVO vo=WareInListlist.get(i);
				long id=vo.getId();
				TimePO time=vo.getTime();
				City city=vo.getDestination();
			garageitem item=new garageitem(time,id);
			gd.insert(org, item);
			GaragePlacePO place=getplace(id);
			WareInListVO list=new WareInListVO(id,time,city,place,ListState.SUBMITTED);
			WareInListPO po=new WareInListPO(id,time,city,place,ListState.SUBMITTED);
			addtotxt(po);
			Listlist.add(list);
					}
		}
		return true;
		
	}

	@Override
	public GaragePlacePO getplace(long id) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
	
		GaragePlacePO po=gd.find(org, id);
		
		return po;
	}

	@Override
	public String setAddress(long id) {
		// TODO Auto-generated method stub
		String address="TxtData/"+id+".txt";
		return address;
	}
public  ArrayList<WareInListVO> getWareInList(){
	return this.Listlist;
}


@Override
public void addtotxt(WareInListPO po) {
	// TODO Auto-generated method stub
try {
	wd.insert(po);
} catch (RemoteException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}


@Override
public void deletefromtxt(long id) throws IOException {
	// TODO Auto-generated method stub
	wd.delete(id);
}


@Override
public void addbyplace(long id, TimePO time, City destination, long transid, GaragePlacePO place) throws FileNotFoundException, ClassNotFoundException, IOException {
	// TODO Auto-generated method stub
	org=setAddress(transid);
	
		garageitem item=new garageitem(time,id);
		gd.insertByPlace(org, item, place);
		
		WareInListVO list=new WareInListVO(id,time,destination,place,ListState.SUBMITTED);
		WareInListPO po=new WareInListPO(id,time,destination,place,ListState.SUBMITTED);
		addtotxt(po);
	Listlist.add(list);
				
	
	
}


@Override
public ArrayList<GaragePlacePO> shownullplace(long transid) throws ClassNotFoundException, IOException {
	// TODO Auto-generated method stub
String orgd=setAddress(transid);
	Garage g=gd.getGarage(orgd);
	ArrayList<GaragePlacePO> result;
	result=g.nullplace;
	return result;
	
}
public ArrayList<GaragePlacePO> getnullplace(long transid) throws ClassNotFoundException, IOException {
	// TODO Auto-generated method stub
String orgd=setAddress(transid);
	Garage g=gd.getGarage(orgd);
	ArrayList<GaragePlacePO> result;
	result=g.nullplace;
	return result;
	
}

public static void main(String [] args) throws ClassNotFoundException, IOException
{
	WareInBLserviceImpl bl=new WareInBLserviceImpl();
	Garage G=gd.getGarage("TxtData/10086.txt");
	ArrayList<GaragePlacePO> p=G.getNullplace();
	System.out.println(p.size());

}
}
