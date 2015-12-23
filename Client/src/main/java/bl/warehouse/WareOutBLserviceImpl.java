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
import po.GarageBodyPO;
import po.GaragePlacePO;
import po.StaffPO;
import po.TimePO;
import po.list.WareInListPO;
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
private ArrayList<WareOutListVO> trainlist;
private ArrayList<WareOutListVO> planelist;
public WareOutBLserviceImpl(AccountPO po){
	

	this.po=po;
	list=new ArrayList<WareOutListVO>();
	trainlist=new ArrayList<WareOutListVO>();
	planelist=new ArrayList<WareOutListVO>();
	gd=DataFactory.getGarageData();
	wd=DataFactory.getWareOutData();
	wi=DataFactory.getWareInData();
	datafactory = new DataFactory();

}
	
	@Override
	public void addWareOut(long id, TimePO time, City destination, Vehicle vehicle, long transid,GaragePlacePO place) {
		// TODO Auto-generated method stub
		WareOutListVO vo=new WareOutListVO(ListType.STOCKOUT,id,time,vehicle,destination,transid,ListState.SUBMITTED);	
	   WareOutListPO ppo=new WareOutListPO(id,time,vehicle,destination,transid,ListState.SUBMITTED,Long.parseLong(po.getStaff().getOrgid()));
		addToTxt(ppo,place);
		if(vehicle.equals(Vehicle.CAR))
		list.add(vo);
		if(vehicle.equals(Vehicle.TRAIN))
		trainlist.add(vo);
		if(vehicle.equals(Vehicle.PLANE))
			planelist.add(vo);
		if(vehicle.equals(Vehicle.MOTOR)){
			;
		}
	}
	public ArrayList<WareOutListVO> getTrainWareOut(){
		return trainlist;
		
	}
	
	public ArrayList<WareOutListVO> getPlaneWareOut(){
		return planelist;
		
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
public void addToTxt(WareOutListPO po,GaragePlacePO place){
	try {
		wd.insert(po,place);
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
	WareInListPO po=wi.find(id);
	wi.delete(id);
	po.setState(ListState.REVIEWED)	;
	wi.insert(po);
	}
	return result;
}

@Override
public ArrayList<GarageBodyPO> getWareIn(TimePO start, TimePO end) throws NumberFormatException, RemoteException, IOException {
	// TODO Auto-generated method stub
ArrayList<GarageBodyPO>list=new ArrayList<GarageBodyPO>();

list=wi.findWareIn(start, end,Long.parseLong( po.getStaff().getOrgid()));
	
	return list;
}

public ArrayList<GarageBodyPO> getWareOut(TimePO start, TimePO end) throws NumberFormatException, RemoteException, IOException {
	// TODO Auto-generated method stub
ArrayList<GarageBodyPO>list=new ArrayList<GarageBodyPO>();

list=wi.findWareOut(start, end,Long.parseLong( po.getStaff().getOrgid()));
	
	return list;
}

@Override
public int getNum(long transid) throws RemoteException, ClassNotFoundException, IOException {
	// TODO Auto-generated method stub
	transid=Long.parseLong(po.getStaff().getOrgid());
	String address="TxtData/"+transid+".txt";
	String j="TxtData/"+transid+"_train.txt";
	String d="TxtData/"+transid+"_plane.txt";
	int result=gd.getGarage(address).getTemp();
	int result2=gd.getGarage(j).getTemp();
	int result3=gd.getGarage(d).getTemp();
	return result+result2+result3;
}


}
