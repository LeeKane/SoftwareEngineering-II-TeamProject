package bl.list;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import DataServiceTxtFileImpl.InquireDataServiceTxtImpl;
import DataServiceTxtFileImpl.OrderListDataServiceImpl;
import blservice.listblservice.delivery_HallBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.ArrivalListDataService;
import dataservice.listdataservice.DeliveryListDataService;
import po.InstitutePO;
import po.TimePO;
import po.TransPO;
import po.WarePO;
import po.list.DeliveryListPO;
import po.list.OrderListPO;
import util.ListState;
import util.ListType;
import util.OrgType;
import util.TransState;
import vo.list.DeliveryListVO;

public class DeliveryListBL implements delivery_HallBLService{
	private DataFactory dataFactory;//数据工厂
	private ArrayList<DeliveryListVO>DeliveryListList;
	private boolean result=false;
	private String preFour;
	private String lastFour;
	private long Listid;
	private DeliveryListDataService od;
	
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
		od=dataFactory.getDeliveryData();

		if (!DeliveryListList.isEmpty()){
			for(int i = 0; i<DeliveryListList.size();i++){
			DeliveryListVO vo = DeliveryListList.get(i);
			TimePO time=vo.getTime();
			Long id=vo.getCode();
			String name=vo.getName();
			DeliveryListPO DeliveryList = new DeliveryListPO(myGetListId(od, time),time,id,name,ListState.SUBMITTED);
			result = od.insert(DeliveryList);
			OrderListDataServiceImpl obl=new OrderListDataServiceImpl();
			OrderListPO order=obl.find(id+"");
			WarePO ware=order.getWare();

			TransPO transState=new TransPO(id,TransState.HALLCLERK_DISTRIBUTE,time,new InstitutePO(ware.getDestination(),OrgType.HALL,"1111111111"));//添加运输状态
			   InquireDataService inquireDataService=new InquireDataServiceTxtImpl();
			inquireDataService=new InquireDataServiceTxtImpl();
			try {
				inquireDataService.insert(transState);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			DeliveryListList.clear();
			return result;
		}else
			return false;
	}

	@Override
	public long myGetListId(DeliveryListDataService od, TimePO time) {
	
			// TODO Auto-generated method stub
		if( time.getHour()>=10)
		{
		preFour = time.getHour() + "";
		}
		else
		{
		preFour = "0"+time.getHour() ;
		}
		if(time.getMin()>=10)
		preFour += (time.getMin() + "");
		else
		preFour += ("0"+time.getMin());
			try {
				lastFour=(od.findlast().getId()+1)+"";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lastFour=lastFour.substring(6);
			
			return Long.parseLong(preFour+"09"+lastFour);
		

	}

	@Override
	public long getListId() {
		// TODO Auto-generated method stub
		return this.Listid;
	}
	
	public DeliveryListDataService getOd() {
		return this.od;
	}
}
