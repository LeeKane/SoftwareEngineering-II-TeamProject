package bl.list;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.listblservice.arrivaList_HallBLService;
import data.datafactory.DataFactory;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.ArrivalListDataService;
import dataservice.listdataservice.OrderListDataService;
import po.AccountPO;
import po.InstitutePO;
import po.TimePO;
import po.TransPO;
import po.WarePO;
import po.list.ArrivaListPO;
import po.list.OrderListPO;
import util.City;
import util.GoodState;
import util.ListState;
import util.ListType;
import util.TransState;
import vo.list.ArrivaListVO;

public class ArrivaListBL implements arrivaList_HallBLService {
	private TransPO transState;
	private ArrayList<ArrivaListVO> ArrivaListList;
	private ArrivalListDataService od;
	private String preFour;
	private String lastFour;
	private long Listid;
	private boolean result = false;
	private AccountPO po;
	private int count;

	public ArrivaListBL(AccountPO po) {
		this.po = po;
		count = 0;
		od = DataFactory.getArrivalData();
		ArrivaListList = new ArrayList<ArrivaListVO>();
	}

	@Override
	public ArrivaListVO addList(long transid, TimePO time, Long id, City StartCity, GoodState state) {
		// TODO Auto-generated method stub
		transid += count;
		Listid = myGetListId(od, time);
		ArrivaListVO ware = new ArrivaListVO(transid, time, id, StartCity, state);
		ArrivaListList.add(ware);
		count++;
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
		count = 0;
		if (!ArrivaListList.isEmpty()) {
			for (int i = 0; i < ArrivaListList.size(); i++) {
				ArrivaListVO vo = ArrivaListList.get(i);
				TimePO time = vo.getTime();
				Long id = vo.getId();
				City StartCity = vo.getCity();
				GoodState state = vo.getState();
				ArrivaListPO ArrivaList = new ArrivaListPO(ListType.ARRIVE, time, vo.getTransid(), StartCity, state,
						ListState.SUBMITTED, id);
				try {
					result = od.insert(ArrivaList);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				OrderListDataService obl = DataFactory.getWareData();
				OrderListPO order = null;
				try {
					order = obl.find(id + "");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				WarePO ware = order.getWare();
				TransPO transState = new TransPO(id, TransState.HALLCLERK_RECEIVE, time,
						new InstitutePO(po.getStaff().getCity(), po.getStaff().getOrgType(), po.getStaff().getOrgid()));// 添加运输状态
				InquireDataService inquireDataService = DataFactory.getInquireData();
				try {
					inquireDataService.insert(transState);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ArrivaListList.clear();
			return result;
		} else
			return false;
	}

	@Override
	public long myGetListId(ArrivalListDataService od, TimePO time) {

		// TODO Auto-generated method stub
		if (time.getHour() >= 10) {
			preFour = time.getHour() + "";
		} else {
			preFour = "0" + time.getHour();
		}
		if (time.getMin() >= 10)
			preFour += (time.getMin() + "");
		else
			preFour += ("0" + time.getMin());
		try {
			lastFour = (od.findlast().getid() + 1) + "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lastFour = lastFour.substring(6);

		return Long.parseLong(preFour + "01" + lastFour);

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

	public ArrivalListDataService getOd() {
		return od;
	}

}
