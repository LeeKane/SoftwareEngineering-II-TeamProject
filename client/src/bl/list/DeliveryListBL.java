package bl.list;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataServiceTxtFileImpl.InquireDataServiceTxtImpl;
import DataServiceTxtFileImpl.OrderListDataServiceImpl;
import blservice.listblservice.delivery_HallBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.inquiredataservice.InquireDataService;
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
		for(int i = 0; i<DeliveryListList.size();i++){
			DeliveryListVO vo = DeliveryListList.get(i);
			TimePO time=vo.getTime();
			Long id=vo.getCode();
			String name=vo.getName();
			DeliveryListPO DeliveryList = new DeliveryListPO(1111111111,time,id,name,ListState.SUBMITTED);
	        result = od.insert(DeliveryList);
	        OrderListDataServiceImpl obl=new OrderListDataServiceImpl();
	    	OrderListPO order=obl.find(id+"");
	    	WarePO ware=order.getWare();
          
	    	TransPO transState=new TransPO(id,TransState.HALLCLERK_DISTRIBUTE,time,new InstitutePO(ware.getDestination(),OrgType.HALL,1111111111));//添加运输状态
	    	   InquireDataService inquireDataService=new InquireDataServiceTxtImpl();
	    	inquireDataService=new InquireDataServiceTxtImpl();
			try {
				inquireDataService.insert(transState);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
         
		
		return result;
	}
	

}
