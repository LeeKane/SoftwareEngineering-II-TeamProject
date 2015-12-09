package bl.list;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.listblservice.OrdersInputBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.OrderListDataService;
import po.AccountPO;
import po.InstitutePO;
import po.TimePO;
import po.TransPO;
import po.WarePO;
import po.list.OrderListPO;
import ui.XTimeChooser;
import util.City;
import util.DeliverConstant;
import util.DeliverType;
import util.ListState;
import util.ListType;
import util.OrgType;
import util.TransState;
import vo.WareVO;
import vo.list.OrderListVO;

public class OrdersInputBL implements OrdersInputBLService {
	private DataFactory dataFactory;// 数据工厂
	private ArrayList<WareVO> wareList;
	private ArrayList<OrderListVO> OrderListList;
	boolean result = false;
	private TransPO transState;
	private InquireDataService inquireDataService;
	private String foreFour;
	private City departPlace;
	private City destination;
	private String account;

	public OrdersInputBL(AccountPO accountPO) {
		this.account = accountPO.getUsername();
		dataFactory = new DataFactory();
		wareList = new ArrayList<WareVO>();
		OrderListList = new ArrayList<OrderListVO>();
	}

	@Override
	public OrderListPO find(String id) {
		try {
			return dataFactory.getWareData().find(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public WareVO addware(double weight, int amount, double volume, String packag, String name, String type,
			City departPlace, City destination, ListType listtype, String senderName, String senaderAddress,
			String senderOrganization, String senderTphone, String senderCphone, String receiverName,
			String receiverAddress, String receiverOrganization, String receiverTphone, String receiverCphone,
			TimePO time) {

		// TODO Auto-generated method stub
		double cost = 1.0;
		int day = 1;
		String backSix = "147258";
		this.departPlace = departPlace;
		this.destination = destination;
		cost = myGetCost(departPlace, destination, type, weight);
		day = myGetDay(departPlace, destination, type);
		String idStr = foreFour + backSix;
		long id = Long.parseLong(idStr);// 设置id的方法
		DeliverType dType = null;
		if (type == "特快专递")
			dType = DeliverType.FAST;
		else if (type == "标准快递")
			dType = DeliverType.STAND;
		else if (type == "经济快递")
			dType = DeliverType.ECO;
		WareVO ware1 = new WareVO(weight, amount, volume, packag, name, dType, cost, time, id, departPlace,
				destination);
		wareList.add(ware1);
		double weight1 = ware1.getweight();
		int amount1 = ware1.getamount();
		double volume1 = ware1.getvolume();
		String packag1 = ware1.getpackag();
		String name1 = ware1.getname();
		double cost1 = ware1.getcost();
		WarePO warepo = new WarePO(weight, amount, volume, packag, name, ware1.gettype1(), cost, ware1.gettime1(),
				departPlace, destination);
		System.out.println(idStr);
		OrderListVO ov = addOrderList(ListType.ORDER, senderName, senaderAddress, senderOrganization, senderTphone,
				senderCphone, receiverName, receiverAddress, receiverOrganization, receiverTphone, receiverCphone,
				warepo, id, account);
		return ware1;
	}

	private int myGetDay(City departPlace, City destination, String type) {
		// TODO Auto-generated method stub

		int result = 1;
		if (departPlace == City.BEIJING) {
			if (destination == City.GUANGZHOU) {
				result = DeliverConstant.TIME_BEIJING_GUANGZHOU;
				foreFour = "0104";
			}
			if (destination == City.NANJING) {
				result = DeliverConstant.TIME_BEIJING_NANJING;
				foreFour = "0103";
			}
			if (destination == City.SHANGHAI) {
				result = DeliverConstant.TIME_BEIJING_SHANGHAI;
				foreFour = "0102";
			}
			if (destination == City.BEIJING) {
				result = 1;
				foreFour = "0101";
			}

		}
		if (departPlace == City.GUANGZHOU) {
			if (destination == City.BEIJING) {
				result = DeliverConstant.TIME_GONGZHOU_BEIJING;
				foreFour = "0401";
			}
			if (destination == City.NANJING) {
				result = DeliverConstant.TIME_GONGZHOU_NANJING;
				foreFour = "0403";
			}
			if (destination == City.SHANGHAI) {
				foreFour = "0402";
				result = DeliverConstant.TIME_GONGZHOU_SHANGHAI;
			}
			if (destination == City.GUANGZHOU) {
				foreFour = "0404";
				result = 1;
			}
		}
		if (departPlace == City.NANJING) {
			if (destination == City.GUANGZHOU) {
				foreFour = "0304";
				result = DeliverConstant.TIME_NANJING_GUANGZHOU;
			}
			if (destination == City.BEIJING) {
				foreFour = "0301";
				result = DeliverConstant.TIME_NANJING_BEIJING;
			}
			if (destination == City.SHANGHAI) {
				foreFour = "0302";
				result = DeliverConstant.TIME_NANJING_SHANGHAI;
			}
			if (destination == City.NANJING) {
				foreFour = "0303";
				result = 1;
			}
		}
		if (departPlace == City.SHANGHAI) {
			if (destination == City.BEIJING) {
				foreFour = "0201";
				result = DeliverConstant.TIME_SHANGHAI_BEIJING;
			}
			if (destination == City.NANJING) {
				foreFour = "0203";
				result = DeliverConstant.TIME_SHANGHAI_NANJING;
			}
			if (destination == City.GUANGZHOU) {
				foreFour = "0204";
				result = DeliverConstant.TIME_SHANGHAI_GONGZHOU;
			}
			if (destination == City.SHANGHAI) {
				foreFour = "0202";
				result = 1;
			}
		}
		if (type == "特快专递") {
			result--;
			if (result == 0) {
				result = 1;
			}
		}
		if (type == "经济快递") {
			if (result != 1)
				result++;
		}
		return result;
	}

	private double myGetCost(City departPlace, City destination, String type, double weight) {
		double result = 1.0;
		double instance = 1.0;
		double costOftype = 1.0;

		DeliverType t = null;
		if (type == "特快专递")
			t = DeliverType.FAST;
		if (type == "标准快递")
			t = DeliverType.STAND;
		if (type == "经济快递")
			t = DeliverType.ECO;
		costOftype = t.getCost();

		if (departPlace == City.BEIJING) {
			if (destination == City.GUANGZHOU)
				instance = DeliverConstant.DISTANCE_BEIJING_GUANGZHOU;
			if (destination == City.NANJING)
				instance = DeliverConstant.DISTANCE_BEIJING_NANJING;
			if (destination == City.SHANGHAI)
				instance = DeliverConstant.DISTANCE_BEIJING_SHANGHAI;
			if (destination == City.BEIJING)
				instance = 30;
		}
		if (departPlace == City.GUANGZHOU) {
			if (destination == City.BEIJING)
				instance = DeliverConstant.DISTANCE_GONGZHOU_BEIJING;
			if (destination == City.NANJING)
				instance = DeliverConstant.DISTANCE_GONGZHOU_NANJING;
			if (destination == City.SHANGHAI)
				instance = DeliverConstant.DISTANCE_GONGZHOU_SHANGHAI;
			if (destination == City.GUANGZHOU)
				instance = 30;
		}
		if (departPlace == City.NANJING) {
			if (destination == City.GUANGZHOU)
				instance = DeliverConstant.DISTANCE_NANJING_GUANGZHOU;
			if (destination == City.BEIJING)
				instance = DeliverConstant.DISTANCE_NANJING_BEIJING;
			if (destination == City.SHANGHAI)
				instance = DeliverConstant.DISTANCE_NANJING_SHANGHAI;
			if (destination == City.NANJING)
				instance = 30;
		}
		if (departPlace == City.SHANGHAI) {
			if (destination == City.BEIJING)
				instance = DeliverConstant.DISTANCE_SHANGHAI_BEIJING;
			if (destination == City.NANJING)
				instance = DeliverConstant.DISTANCE_SHANGHAI_NANJING;
			if (destination == City.GUANGZHOU)
				instance = DeliverConstant.DISTANCE_SHANGHAI_GONGZHOU;
			if (destination == City.SHANGHAI)
				instance = 30;
		}
		result = instance / 1000 * costOftype * weight;
		BigDecimal b = new BigDecimal(result);
		result = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
		// TODO Auto-generated method stub

	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean submit() {
		OrderListDataService od = dataFactory.getWareData();
		if (!OrderListList.isEmpty()) {
			for (int i = 0; i < OrderListList.size(); i++) {

				OrderListVO ov = OrderListList.get(i);
				WareVO vo = wareList.get(i);

				double weight = vo.getweight();
				int amount = vo.getamount();
				double volume = vo.getvolume();
				String packag = vo.getpackag();
				String name = vo.getname();
				double cost = vo.getcost();
				WarePO ware = new WarePO(weight, amount, volume, packag, name, vo.gettype1(), cost, vo.gettime1(),
						departPlace, destination);
				String id = vo.getId();
				long id1 = Long.parseLong(id);
				String senderName = ov.getSenderName();
				String senaderAddress = ov.getSenaderAddress();
				String senderOrganization = ov.getSenderOrganization();
				String senderTphone = ov.getSenderTphone();
				String senderCphone = ov.getSenderCphone();
				String receiverName = ov.getReceiverName();
				String receiverAddress = ov.getReceiverAddress();
				String receiverOrganization = ov.getReceiverOrganization();
				String receiverTphone = ov.getReceiverTphone();
				String receiverCphone = ov.getReceiverCphone();
				OrderListPO orderList = new OrderListPO(ListType.ORDER, senderName, senaderAddress, senderOrganization,
						senderTphone, senderCphone, receiverName, receiverAddress, receiverOrganization, receiverTphone,
						receiverCphone, ware, id, ListState.SUBMITTED, account);
				try {
					result = od.insert(orderList);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				XTimeChooser x = XTimeChooser.getInstance();
				x.getCurrentTime();
				x.getTimePO();
				transState = new TransPO(id1, TransState.COURIER_RECEIVE, x.getTimePO(),
						new InstitutePO(vo.getdepartPlace1(), OrgType.HALL, "1111111111"));// 添加运输状态

				inquireDataService = dataFactory.getInquireData();
				try {
					inquireDataService.insert(transState);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			OrderListList.clear();
			wareList.clear();
			return result;
		} else
			return false;
	}

	@Override
	public OrderListVO addOrderList(ListType listtype, String senderName, String senaderAddress,
			String senderOrganization, String senderTphone, String senderCphone, String receiverName,
			String receiverAddress, String receiverOrganization, String receiverTphone, String receiverCphone,
			WarePO ware, long id, String account) {
		// TODO Auto-generated method stub
		OrderListVO ov = new OrderListVO(listtype, senderName, senaderAddress, senderOrganization, senderTphone,
				senderCphone, receiverName, receiverAddress, receiverOrganization, receiverTphone, receiverCphone, ware,
				id, account);
		OrderListList.add(ov);

		return ov;
	}

}