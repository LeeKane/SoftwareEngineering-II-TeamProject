package bl.trans;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.transblservice.TransCenterArriveBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.TransCenterArrivalListDataService;
import po.AccountPO;
import po.InstitutePO;
import po.TimePO;
import po.TransPO;
import po.list.TranscenterArrivalListPO;
import util.City;
import util.GoodState;
import util.ListState;
import util.TransState;
import vo.list.TransCenterArrivalListVO;

public class TransCenterArriveBL implements TransCenterArriveBLService {
	private DataFactory dataFactory;// 数据工厂
	private ArrayList<TransCenterArrivalListVO> TransCenterArrivalListList;
	private long listID;
	private TransPO transState;
	private InquireDataService inquireDataService;
	private TransCenterArrivalListDataService td;
	private AccountPO accountPO;

	public TransCenterArriveBL(AccountPO accountPO) {
		this.accountPO = accountPO;
		dataFactory = new DataFactory();
		TransCenterArrivalListList = new ArrayList<TransCenterArrivalListVO>();
	}

	@Override
	public TransCenterArrivalListVO addTransCenterArrivalList(long transcenterID, long id, TimePO arriveTime,
			City startCity, GoodState state) {
		// TODO Auto-generated method stub
		td = dataFactory.getTransCenterArrivalListData();
		String orders=null;
		try {
			orders=td.findAllOrder(id);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(orders!=null){
			try {
				TranscenterArrivalListPO po = td.findlast();
				if (po != null)
					listID = po.getCode() + 1 + TransCenterArrivalListList.size();
				else {
					listID = 1000000001 + TransCenterArrivalListList.size();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			TransCenterArrivalListVO vo = new TransCenterArrivalListVO(transcenterID, arriveTime, id, startCity, state,
					ListState.SUBMITTED, listID);
			TransCenterArrivalListList.add(vo);
			return vo;
		}else
			return null;		
	}

	@Override
	public boolean submit() {
		// TODO Auto-generated method stub
		inquireDataService=dataFactory.getInquireData();
		td = dataFactory.getTransCenterArrivalListData();
		if (!TransCenterArrivalListList.isEmpty()) {
			for (TransCenterArrivalListVO vo : TransCenterArrivalListList) {
				long transcenterID = vo.getTranscenterID();
				long id = vo.getId();
				TimePO arriveTime = vo.getArrivatime();
				City startCity = vo.getStartCity();
				GoodState state = vo.getState();
				long code = vo.getCode();

				TranscenterArrivalListPO po = new TranscenterArrivalListPO(transcenterID, arriveTime, id, startCity,
						state, ListState.SUBMITTED, code);
				try {
					td.insert(po);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String orders=null;
				try {
					orders = td.findAllOrder(id);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String orderArray[]=orders.split("-");
				for(String order:orderArray){
					TransPO transPO=new TransPO(Long.parseLong(order), TransState.CENTERCLERK_RECEIVE,
							arriveTime, new InstitutePO(accountPO.getStaff().getCity(), accountPO.getStaff().getOrgType(), 
									accountPO.getStaff().getOrgid()));
					try {
						inquireDataService.insert(transPO);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// transState=new
				// TransPO(id1,TransState.COURIER_RECEIVE,x.getTimePO(),new
				// InstitutePO(vo.getdepartPlace1(),OrgType.HALL,"1111111111"));//添加运输状态
				// inquireDataService=new InquireDataServiceTxtImpl();
				//
				// try {
				// inquireDataService.insert(transState);
				// } catch (RemoteException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
			}
			TransCenterArrivalListList.clear();
			return true;
		} else
			return false;
	}
	
	@Override
	public AccountPO getAccountPO() {
		return accountPO;
	}
}
