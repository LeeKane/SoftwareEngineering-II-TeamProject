package data.datafactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.accountdataservice.AccountDataService;
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

public class DataFactory {
	public static String port = "6600";
	public static String hostIP = null;
	private static OrderListDataService ld = null;
	private static OrderListDataService ld2 = null;
	private static ArrivalListDataService ald = null;
	private static AccountDataService ad = null;
	private static DeliveryListDataService dld = null;
	private static ReceiveCourierListDataService rcld = null;
	private static TransCenterArrivalListDataService tcald = null;
	private static TransCenterArrivalListDataService tcald2 = null;
	private static InquireDataService id = null;
	private static LoginDataService lgd = null;
	private static StaffDataService sd = null;
	private static MoneyInListDataService mild = null;
	private static MoneyOutListDataService mold = null;
	private static CarDataService cd = null;
	private static DriverDataService dd = null;
	private static InstituteDataService ind = null;
	private static ListStateDataService lsd = null;
	private static LoadingList_HallDataService llhd = null;
	private static LoadingListDataService lold = null;
	private static GarageDataSeriaService gd = null;
	private static WareOutListDataService wold = null;
	private static WareInListDataService waild = null;
	private static SetRewardDataService srd = null;
	private static BAccountManageDataService bad = null;
	private static BeginningSetupDataService bsd = null;
	private static LogDataService logd = null;
	private static TestService ts = null;
	private static ConstantDataService cds = null;
	
	private DataFactory(){
		
	}

	public static OrderListDataService getWareData() {
		// TODO Auto-generated method stub
		try {
			if (ld == null)
				ld = (OrderListDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/OrderListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld;
	}

	public static OrderListDataService getWareData2() {
		// TODO Auto-generated method stub
		try {
			if (ld2 == null)
				ld2 = (OrderListDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/OrderListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ld2;
	}

	public static ArrivalListDataService getArrivalData() {
		// TODO Auto-generated method stub
		try {
			if (ald == null)
				ald = (ArrivalListDataService) Naming
						.lookup("rmi://" + hostIP + ":" + port + "/ArrivalListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ald;
	}

	public static AccountDataService getAccountData() {
		try {
			if (ad == null)
				ad = (AccountDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/AccountDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ad;
	}

	public static DeliveryListDataService getDeliveryData() {
		try {
			if (dld == null)
				dld = (DeliveryListDataService) Naming
						.lookup("rmi://" + hostIP + ":" + port + "/DeliveryListDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dld;
	}

	public static ReceiveCourierListDataService getReceiveCourierData() {
		try {
			if (rcld == null)
				rcld = (ReceiveCourierListDataService) Naming
						.lookup("rmi://" + hostIP + ":" + port + "/ReceiveCourierListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rcld;
	}

	public static TransCenterArrivalListDataService getTransCenterArrivalListData() {
		try {
			if (tcald == null)
				tcald = (TransCenterArrivalListDataService) Naming
						.lookup("rmi://" + hostIP + ":" + port + "/TransCenterArrivalListDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tcald;
	}

	public static TransCenterArrivalListDataService getTransCenterArrivalListData2() {
		try {
			if (tcald2 == null)
				tcald2 = (TransCenterArrivalListDataService) Naming

						.lookup("rmi://" + hostIP + ":" + port + "/TransCenterArrivalListDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tcald2;
	}

	public static InquireDataService getInquireData() {
		try {
			if (id == null)
				id = (InquireDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/InquireDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public static LoginDataService getLoginData() {
		try {
			if (lgd == null)
				lgd = (LoginDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/LoginDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lgd;
	}

	public static StaffDataService getStaffData() {
		// TODO Auto-generated method stub
		try {
			if (sd == null)
				sd = (StaffDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/StaffDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sd;
	}

	public static MoneyInListDataService getMoneyInListData() {
		// TODO Auto-generated method stub
		try {
			if (mild == null)
				mild = (MoneyInListDataService) Naming
						.lookup("rmi://" + hostIP + ":" + port + "/MoneyInListDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mild;
	}

	public static MoneyOutListDataService getMoneyOutListData() {
		try {
			if (mold == null)
				mold = (MoneyOutListDataService) Naming
						.lookup("rmi://" + hostIP + ":" + port + "/MoneyOutListDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mold;

	}

	public static CarDataService getCarData() {
		// TODO Auto-generated method stub
		try {
			if (cd == null)
				cd = (CarDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/CarDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cd;
	}

	public static DriverDataService getDriverData() {
		// TODO Auto-generated method stub
		try {
			if (dd == null)
				dd = (DriverDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/DriverDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dd;
	}

	public static InstituteDataService getInstituteData() {
		// TODO Auto-generated method stub
		try {
if(ind==null)
			ind = (InstituteDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/InstituteDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ind;
	}

	public static ListStateDataService getListStateData() {
		// TODO Auto-generated method stub
		try {
			if(lsd==null)
			lsd = (ListStateDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/ListStateDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lsd;
	}

	public static LoadingList_HallDataService getLoadingList_HallData() {
		// TODO Auto-generated method stub
		try {
			if(llhd==null)
			llhd = (LoadingList_HallDataService) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/LoadingList_HallDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return llhd;
	}

	public static LoadingListDataService getLoadingListData() {
		// TODO Auto-generated method stub
		try {
			if(lold==null)
			lold = (LoadingListDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/LoadingListDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lold;
	}

	public static GarageDataSeriaService getGarageData() {
		try {
			if(gd==null)
			gd = (GarageDataSeriaService) Naming.lookup("rmi://" + hostIP + ":" + port + "/GarageDataSeriaService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gd;
	}

	public static WareOutListDataService getWareOutData() {
		try {
			if(wold==null)
			wold = (WareOutListDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/WareOutListDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wold;
	}

	public static WareInListDataService getWareInData() {
		try {
			if(waild==null)
			waild = (WareInListDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/WareInListDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return waild;
	}

	public static SetRewardDataService getSetRewardData() {
		// TODO Auto-generated method stub
		try {
			if(srd==null)
			srd = (SetRewardDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/SetRewardDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return srd;
	}

	public static BAccountManageDataService getBAccountManageData() {
		try {
			if(bad==null)
			bad = (BAccountManageDataService) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/BAccountManageDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bad;
	}

	public static BeginningSetupDataService getBeginningSetupData() {
		// TODO Auto-generated method stub
		try {
			if(bsd==null)
			bsd = (BeginningSetupDataService) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/BeginningSetupDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bsd;
	}

	public static LogDataService getLogData() {
		try {
			if(logd==null)
			logd = (LogDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/LogDataService");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logd;
	}

	public static TestService getTest() throws MalformedURLException, RemoteException, NotBoundException {
		if(ts==null)
		ts = (TestService) Naming.lookup("rmi://" + hostIP + ":" + port + "/TestService");

		return ts;
	}

	public static ConstantDataService getConstant() {
		try {
			if(cds==null)
			cds = (ConstantDataService) Naming.lookup("rmi://" + hostIP + ":" + port + "/ConstantDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cds;
	}
}
