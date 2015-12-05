package bl.list;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import DataServiceTxtFileImpl.InquireDataServiceTxtImpl;
import DataServiceTxtFileImpl.OrderListDataServiceImpl;
import dataimpl.datafactory.DataFactory;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.ArrivalListDataService;
import po.InstitutePO;
import po.TimePO;
import po.TransPO;
import po.WarePO;
import po.list.ArrivaListPO;
import po.list.OrderListPO;
import util.City;
import util.DeliverType;
import util.GoodState;
import util.ListState;
import util.ListType;
import util.OrgType;
import util.TransState;
import vo.WareVO;
import vo.list.ArrivaListVO;
import blservice.listblservice.arrivaList_HallBLService;

public class ArrivaListBL implements arrivaList_HallBLService{
	private TransPO transState;
	private DataFactory dataFactory;//数据工厂
	private ArrayList<ArrivaListVO>ArrivaListList;
	private ArrivalListDataService od;
	private String preFour;
	private String lastFour;
	private long Listid;
	boolean result=false;
	public ArrivaListBL(){
	  
		dataFactory = new DataFactory();
		  od=dataFactory.getArrivalData();
		ArrivaListList = new ArrayList<ArrivaListVO>();
	}
	@Override
	public ArrivaListVO addList(long transid,TimePO time, Long id,City StartCity,
			GoodState state) {
		// TODO Auto-generated method stub
		Listid=myGetListId(od,time);
		ArrivaListVO ware = new ArrivaListVO(transid,time, id , StartCity,state);
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
		
		if(!ArrivaListList.isEmpty()){
			for(int i = 0; i<ArrivaListList.size();i++){
				ArrivaListVO vo = ArrivaListList.get(i);
				TimePO time=vo.getTime();
				Long id=vo.getId();
				City StartCity=vo.getCity();
	           GoodState state=vo.getState();
	           ArrivaListPO ArrivaList = new ArrivaListPO(ListType.ARRIVE,time,vo.getTransid(),StartCity,state,ListState.SUBMITTED,id);
		        result = od.insert(ArrivaList);
		        OrderListDataServiceImpl obl=new OrderListDataServiceImpl();
		    	OrderListPO order=obl.find(id+"");
		    	WarePO ware=order.getWare();
		    	TransPO transState=new TransPO(id,TransState.HALLCLERK_RECEIVE,time,new InstitutePO(ware.getDestination(),OrgType.HALL,Listid));//添加运输状态
		    	 InquireDataService inquireDataService=new InquireDataServiceTxtImpl();
		    	inquireDataService=new InquireDataServiceTxtImpl();
				try {
					inquireDataService.insert(transState);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ArrivaListList.clear();
			return result;
		}else
			return false;
	}
	@Override
	public long myGetListId(ArrivalListDataService od, TimePO time) {
	
			// TODO Auto-generated method stub
			preFour=time.getHour()+"";
			preFour+=(time.getMin()+"");
			try {
				lastFour=(od.findlast().getTransid()+1)+"";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lastFour=lastFour.substring(6);
			
			return Long.parseLong(preFour+"01"+lastFour);
		

	}

	@Override
	public long getListId() {
		// TODO Auto-generated method stub
		return this.Listid;
	}
	
	public ArrivalListDataService getOd() {
		return od;
	}

	}

