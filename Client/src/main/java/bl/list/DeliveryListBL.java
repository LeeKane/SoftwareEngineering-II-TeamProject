package bl.list;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.listblservice.delivery_HallBLService;
import data.datafactory.DataFactory;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.DeliveryListDataService;
import dataservice.listdataservice.OrderListDataService;
import po.AccountPO;
import po.InstitutePO;
import po.TimePO;
import po.TransPO;
import po.WarePO;
import po.list.DeliveryListPO;
import po.list.OrderListPO;
import util.ListState;
import util.TransState;
import vo.list.DeliveryListVO;

public class DeliveryListBL implements delivery_HallBLService {
	private ArrayList<DeliveryListVO> DeliveryListList;
	private boolean result = false;
	private String preFour;
	private String lastFour;
	private long Listid;
	private DeliveryListDataService od;
	private AccountPO po;

	public DeliveryListBL(AccountPO po) {
		this.po = po;
		DeliveryListList = new ArrayList<DeliveryListVO>();
	}

	@Override
	public DeliveryListVO addware(TimePO time, long code, String name) {
		// TODO Auto-generated method stub
		DeliveryListVO DeliveryList = new DeliveryListVO(time, code, name);
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
		od = DataFactory.getDeliveryData();

		if (!DeliveryListList.isEmpty()) {
			for (int i = 0; i < DeliveryListList.size(); i++) {
				DeliveryListVO vo = DeliveryListList.get(i);
				TimePO time = vo.getTime();
				Long id = vo.getCode();
				String name = vo.getName();
				DeliveryListPO DeliveryList = new DeliveryListPO(myGetListId(od, time), time, id, name,
						ListState.SUBMITTED);
				try {
					result = od.insert(DeliveryList);
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

				TransPO transState = new TransPO(id, TransState.HALLCLERK_DISTRIBUTE, time,
						new InstitutePO(po.getStaff().getCity(), po.getStaff().getOrgType(), po.getStaff().getOrgid()));// 添加运输状态
				InquireDataService inquireDataService = DataFactory.getInquireData();
				try {
					inquireDataService.insert(transState);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			DeliveryListList.clear();
			return result;
		} else
			return false;
	}

	@Override
	public long myGetListId(DeliveryListDataService od, TimePO time) {

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
			lastFour = (od.findlast().getId() + 1) + "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lastFour = lastFour.substring(6);

		return Long.parseLong(preFour + "09" + lastFour);

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

	public DeliveryListDataService getOd() {
		return this.od;
	}
}
