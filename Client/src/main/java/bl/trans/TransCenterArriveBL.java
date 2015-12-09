package bl.trans;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.transblservice.TransCenterArriveBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.TransCenterArrivalListDataService;
import po.AccountPO;
import po.TimePO;
import po.TransPO;
import po.list.TranscenterArrivalListPO;
import util.City;
import util.GoodState;
import util.ListState;
import vo.list.TransCenterArrivalListVO;

public class TransCenterArriveBL implements TransCenterArriveBLService {
	private DataFactory dataFactory;// 数据工厂
	private ArrayList<TransCenterArrivalListVO> TransCenterArrivalListList;
	private long listID;
	private TransPO transState;
	private InquireDataService inquireDataService;
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

		TransCenterArrivalListDataService td = dataFactory.getTransCenterArrivalListData();
		try {
			TranscenterArrivalListPO po = td.findlast();
			if (po != null)
				listID = po.getCode() + 1;
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
	}

	@Override
	public boolean submit() {
		// TODO Auto-generated method stub
		TransCenterArrivalListDataService td = dataFactory.getTransCenterArrivalListData();
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
}
