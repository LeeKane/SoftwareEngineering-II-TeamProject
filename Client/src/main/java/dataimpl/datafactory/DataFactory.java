package dataimpl.datafactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.accountdataservice.AccountDataService;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.financedataservice.BAccountManageDataService;
import dataservice.financedataservice.MoneyOutListDataService;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.ArrivalListDataService;
import dataservice.listdataservice.DeliveryListDataService;
import dataservice.listdataservice.LoadingListDataService;
import dataservice.listdataservice.LoadingList_HallDataService;
import dataservice.listdataservice.MoneyInListDataService;
import dataservice.listdataservice.OrderListDataService;
import dataservice.listdataservice.ReceiveCourierListDataService;
import dataservice.listdataservice.TransCenterArrivalListDataService;
import dataservice.listdataservice.WareInListDataService;
import dataservice.listdataservice.WareOutListDataService;
import dataservice.logindataservice.LoginDataService;
import dataservice.reviewdataservice.InstituteDataService;
import dataservice.reviewdataservice.ListStateDataService;
import dataservice.reviewdataservice.StaffDataService;
import dataservice.transdataservice.CarDataService;
import dataservice.transdataservice.DriverDataService;
import dataservice.warehousedataservice.GarageDataSeriaService;

public class DataFactory implements DataFactoryService {

	@Override
	public   OrderListDataService getWareData() {
		// TODO Auto-generated method stub
		OrderListDataService ld = null;
		try {
			ld = (OrderListDataService) Naming.lookup("rmi://127.0.0.1:6600/OrderListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	public   static OrderListDataService getWareData2() {
		// TODO Auto-generated method stub
		OrderListDataService ld = null;
		try {
			ld = (OrderListDataService) Naming.lookup("rmi://127.0.0.1:6600/OrderListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}
	
	@Override
	public ArrivalListDataService getArrivalData() {
		// TODO Auto-generated method stub
		ArrivalListDataService ld = null;
		try {
			ld = (ArrivalListDataService) Naming.lookup("rmi://127.0.0.1:6600/ArrivalListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	@Override
	public AccountDataService getAccountData() {
		AccountDataService ld = null;
		try {
			ld = (AccountDataService) Naming.lookup("rmi://127.0.0.1:6600/AccountDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	@Override
	public DeliveryListDataService getDeliveryData() {
		DeliveryListDataService ld = null;
		try {
			ld = (DeliveryListDataService) Naming.lookup("rmi://127.0.0.1:6600/DeliveryListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	@Override
	public ReceiveCourierListDataService getReceiveCourierData() {
		ReceiveCourierListDataService ld = null;
		try {
			ld = (ReceiveCourierListDataService) Naming.lookup("rmi://127.0.0.1:6600/ReceiveCourierListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	@Override
	public TransCenterArrivalListDataService getTransCenterArrivalListData() {
		TransCenterArrivalListDataService ld = null;
		try {
			ld = (TransCenterArrivalListDataService) Naming
					.lookup("rmi://127.0.0.1:6600/TransCenterArrivalListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}
	
	
	public static TransCenterArrivalListDataService getTransCenterArrivalListData2() {
		TransCenterArrivalListDataService ld = null;
		try {
			ld = (TransCenterArrivalListDataService) Naming
					.lookup("rmi://127.0.0.1:6600/TransCenterArrivalListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	@Override
	public InquireDataService getInquireData() {
		InquireDataService id = null;
		try {
			id = (InquireDataService) Naming.lookup("rmi://127.0.0.1:6600/InquireDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public LoginDataService getLoginData() {
		LoginDataService ld = null;
		try {
			ld = (LoginDataService) Naming.lookup("rmi://127.0.0.1:6600/LoginDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	@Override
	public StaffDataService getStaffData() {
		// TODO Auto-generated method stub
		StaffDataService ld = null;
		try {
			ld = (StaffDataService) Naming.lookup("rmi://127.0.0.1:6600/StaffDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	@Override
	public MoneyInListDataService getMoneyInListData() {
		// TODO Auto-generated method stub
		MoneyInListDataService ld = null;
		try {
			ld = (MoneyInListDataService) Naming.lookup("rmi://127.0.0.1:6600/MoneyInListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}
	@Override
	public MoneyOutListDataService getMoneyOutListData()
	{
		MoneyOutListDataService ld = null;
		try {
			ld = (MoneyOutListDataService) Naming.lookup("rmi://127.0.0.1:6600/MoneyOutListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
		
	}
	@Override
	public CarDataService getCarData() {
		// TODO Auto-generated method stub
		CarDataService ld = null;
		try {
			ld = (CarDataService) Naming.lookup("rmi://127.0.0.1:6600/CarDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	@Override
	public DriverDataService getDriverData() {
		// TODO Auto-generated method stub
		DriverDataService ld = null;
		try {
			ld = (DriverDataService) Naming.lookup("rmi://127.0.0.1:6600/DriverDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	@Override
	public InstituteDataService getInstituteData() {
		// TODO Auto-generated method stub
		InstituteDataService ld = null;
		try {
			ld = (InstituteDataService) Naming.lookup("rmi://127.0.0.1:6600/InstituteDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	@Override
	public ListStateDataService getListStateData() {
		// TODO Auto-generated method stub
		ListStateDataService ld = null;
		try {
			ld = (ListStateDataService) Naming.lookup("rmi://127.0.0.1:6600/ListStateDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	@Override
	public LoadingList_HallDataService getLoadingList_HallData() {
		// TODO Auto-generated method stub
		LoadingList_HallDataService ld = null;
		try {
			ld = (LoadingList_HallDataService) Naming.lookup("rmi://127.0.0.1:6600/LoadingList_HallDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	@Override
	public LoadingListDataService getLoadingListData() {
		// TODO Auto-generated method stub
		LoadingListDataService ld = null;
		try {
			ld = (LoadingListDataService) Naming.lookup("rmi://127.0.0.1:6600/LoadingListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}
	public static GarageDataSeriaService getGarageData(){
		GarageDataSeriaService td=null;
		try {
			td=(GarageDataSeriaService) Naming.lookup("rmi://127.0.0.1:6600/GarageDataSeriaService");
			System.out.println("haha");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return td;
	}
	
	public static WareOutListDataService getWareOutData(){
		WareOutListDataService wd=null;
		try {
			wd=(WareOutListDataService) Naming.lookup("rmi://127.0.0.1:6600/WareOutListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wd;		
	}
	
	public static WareInListDataService getWareInData(){
		WareInListDataService wd=null;
		try {
			wd=(WareInListDataService) Naming.lookup("rmi://127.0.0.1:6600/WareInListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wd;
	}
	
	@Override
	public BAccountManageDataService getBAccountManageData(){
		BAccountManageDataService bad=null;
		try {
			bad=(BAccountManageDataService) Naming.lookup("rmi://127.0.0.1:6600/BAccountManageDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bad;
	}
}
