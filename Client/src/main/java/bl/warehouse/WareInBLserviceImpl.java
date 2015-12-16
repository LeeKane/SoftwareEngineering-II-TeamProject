package bl.warehouse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
	
	
	garageitem item=new garageitem(new TimePO(1,1,1,1,1,1), 55555);
	GaragePlacePO place=new GaragePlacePO(1,1,2,2);


}

@Override
public void deleteEmpty(long  id, GaragePlacePO place) throws ClassNotFoundException, IOException {
	// TODO Auto-generated method stub
	ArrayList<GaragePlacePO> result=new ArrayList<GaragePlacePO>();
	
	String address=setAddress(id);
	Garage g=gd.getGarage(address);
	result=g.getNullplace();
	for(int i=0;i<result.size();i++){
	GaragePlacePO compare=result.get(i);
			if(compare.getQu()==place.getQu()&&compare.getPai()==place.getPai()&&compare.getJia()==place.getJia()&&compare.getWei()==place.getWei()){
				result.remove(i);
	}
	}
	g.setNullplace(result);
	try {
		File f5 = new File(address);
		FileWriter fw5 = new FileWriter(f5);
		BufferedWriter bw1 = new BufferedWriter(fw5);
		bw1.write("");
	} catch (Exception e) {

	}
	File file=new File(address);
	FileOutputStream fos = new FileOutputStream(file);
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(g);
	oos.flush();
	oos.close();
	fos.close();
	
}
}
