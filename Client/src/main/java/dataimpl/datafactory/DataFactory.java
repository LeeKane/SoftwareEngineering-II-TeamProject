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
import dataservice.reviewdataservice.BeginningSetupDataService;
import dataservice.reviewdataservice.ConstantDataService;
import dataservice.reviewdataservice.InstituteDataService;
import dataservice.reviewdataservice.ListStateDataService;
import dataservice.reviewdataservice.LogDataService;
import dataservice.reviewdataservice.SetRewardDataService;
import dataservice.reviewdataservice.StaffDataService;
import dataservice.transdataservice.CarDataService;
import dataservice.transdataservice.DriverDataService;
import dataservice.warehousedataservice.GarageDataSeriaService;
import testservice.TestService;

public class DataFactory implements DataFactoryService {
	public static String port = "6600";
	public static String hostIP;

	@Override
	public OrderListDataService getWareData() {
		// TODO Auto-generated method stub
		OrderListDataService ld = null;
		try {

			ld = (OrderListDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/OrderListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	public static OrderListDataService getWareData2() {
		// TODO Auto-generated method stub
		OrderListDataService ld = null;
		try {

			ld = (OrderListDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/OrderListDataService");

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

			ld = (ArrivalListDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/ArrivalListDataService");

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

			ld = (AccountDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/AccountDataService");

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

			ld = (DeliveryListDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/DeliveryListDataService");

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

			ld = (ReceiveCourierListDataService) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/ReceiveCourierListDataService");

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

					.lookup("rmi://" + hostIP + ":" + port + "/TransCenterArrivalListDataService");

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

					.lookup("rmi://" + hostIP + ":" + port + "/TransCenterArrivalListDataService");

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

			id = (InquireDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/InquireDataService");

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

			ld = (LoginDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/LoginDataService");

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

			ld = (StaffDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/StaffDataService");

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

			ld = (MoneyInListDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/MoneyInListDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	@Override
	public MoneyOutListDataService getMoneyOutListData() {
		MoneyOutListDataService ld = null;
		try {

			ld = (MoneyOutListDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/MoneyOutListDataService");

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

			ld = (CarDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/CarDataService");

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

			ld = (DriverDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/DriverDataService");

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

			ld = (InstituteDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/InstituteDataService");

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

			ld = (ListStateDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/ListStateDataService");

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

			ld = (LoadingList_HallDataService) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/LoadingList_HallDataService");

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

			ld = (LoadingListDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/LoadingListDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	public static GarageDataSeriaService getGarageData() {
		GarageDataSeriaService td = null;
		try {

			td = (GarageDataSeriaService) Naming.lookup("rmi://" + hostIP + ":" + port + "/GarageDataSeriaService");

			System.out.println("haha");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return td;
	}

	public static WareOutListDataService getWareOutData() {
		WareOutListDataService wd = null;
		try {

			wd = (WareOutListDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/WareOutListDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wd;
	}

	public static WareInListDataService getWareInData() {
		WareInListDataService wd = null;
		try {

			wd = (WareInListDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/WareInListDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wd;
	}

	@Override
	public SetRewardDataService getSetRewardData() {
		// TODO Auto-generated method stub
		SetRewardDataService wd = null;
		try {

			wd = (SetRewardDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/SetRewardDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wd;
	}

	@Override
	public BAccountManageDataService getBAccountManageData() {
		BAccountManageDataService bad = null;
		try {

			bad = (BAccountManageDataService) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/BAccountManageDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bad;
	}

	@Override
	public BeginningSetupDataService getBeginningSetupData() {
		// TODO Auto-generated method stub
		BeginningSetupDataService bsd = null;
		try {

			bsd = (BeginningSetupDataService) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/BeginningSetupDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bsd;
	}

	@Override
	public LogDataService getLogData() {
		LogDataService ld = null;
		try {

			ld = (LogDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/LogDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	public static TestService getTest() throws MalformedURLException, RemoteException, NotBoundException {
		TestService ts = null;

		ts = (TestService) Naming.lookup("rmi://" + hostIP + ":" + port + "/TestService");

		return ts;
	}

	@Override
	public ConstantDataService getConstant() {
		ConstantDataService cds = null;
		try {
			cds = (ConstantDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/ConstantDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cds;
	}
}
