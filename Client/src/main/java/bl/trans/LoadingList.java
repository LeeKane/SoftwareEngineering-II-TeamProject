package bl.trans;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.transblservice.LoadingListBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.LoadingListDataService;
import dataservice.listdataservice.OrderListDataService;
import po.AccountPO;
import po.InstitutePO;
import po.TimePO;
import po.TransPO;
import po.WarePO;
import po.list.LoadingListPO;
import po.list.OrderListPO;
import util.City;
import util.ListState;
import util.ListType;
import util.OrgType;
import util.TransState;
import vo.LoadingVO;
import vo.list.LoadingListVO;

public class LoadingList implements LoadingListBLService {
	private LoadingVO lvo;
	private ArrayList<Long> idList = new ArrayList<Long>();
	private ArrayList<Long> idSet = new ArrayList<Long>();
	private String preFour;
	private String lastFour;
	private long Listid;
	private LoadingListDataService ld;
	private DataFactoryService dataFactory;
	private AccountPO po;

	public LoadingList(AccountPO po){
		this.po=po;
	}
	
	@Override
	public LoadingVO addLoading(TimePO loadDate, long transNum, City departPlace, City destination, long waybillNum,
			String loadMonitor, String loadPerformer, double freight) {
		lvo = new LoadingVO(loadDate, transNum, departPlace, destination, waybillNum, loadMonitor, loadPerformer,
				freight);
		idList.add(waybillNum);

		return lvo;
	}

	@Override
	public boolean submit() {
		// TODO Auto-generated method stub
		dataFactory=new DataFactory();
		ld = dataFactory.getLoadingListData();
		
		if (!idList.isEmpty()) {
			for (int i = 0; i < idList.size(); i++) {
				idSet.add(idList.get(i));
			    OrderListDataService obl=dataFactory.getWareData();
				OrderListPO order = null;
				try {
					order = obl.find(idList.get(i) + "");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				WarePO ware = order.getWare();
				Listid=myGetListId(ld,lvo.getLoadDate());
				TransPO transState = new TransPO(idList.get(i), TransState.CENTERCLERK_SHIPPING, lvo.getLoadDate(),
						new InstitutePO(ware.getDepartPlace(), OrgType.CENTER, "1111111111"));// 添加运输状态
		    	 InquireDataService inquireDataService=dataFactory.getInquireData();
				try {
					inquireDataService.insert(transState);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			LoadingListPO loadingList = new LoadingListPO(Listid, ListType.LOADING, lvo.getLoadDate(), lvo.getTransNum(),
					lvo.getDepartPlace(), lvo.getDestination(), idSet, lvo.getLoadMonitor(), lvo.getLoadPerformer(),
					lvo.getFreight(), ListState.SUBMITTED);
			try {
				ld.insert(loadingList);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			idList.clear();
			return true;
		} else
			return false;
	}

	@Override
	public LoadingListVO addLoadingLists(long id, ListType type, TimePO loadDate, long transNum, City departPlace,
			City destination, long[] waybillNumList, String loadMonitor, String loadPerformer, double freight) {
		// TODO Auto-generated method stub
		return null;
	}

	public long myGetListId(LoadingListDataService od, TimePO time) {

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
			lastFour = (od.findlast().getId() + 1) + "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lastFour = lastFour.substring(6);

		return Long.parseLong(preFour + "12" + lastFour);

	}
	
	@Override
	public AccountPO getPo() {
		return po;
	}

	@Override
	public long getListId() {
		// TODO Auto-generated method stub
		return this.Listid;
	}

	public LoadingListDataService getOd() {
		return this.ld;
	}
}
