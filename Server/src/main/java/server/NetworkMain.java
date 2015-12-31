package server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DataServiceTxtFileImpl.AccountDataServiceTxtImpl;
import DataServiceTxtFileImpl.ArrivalListImpl;
import DataServiceTxtFileImpl.BAccountDataServiceTxtImpl;
import DataServiceTxtFileImpl.BeginningSetupDataServiceTxtImpl;
import DataServiceTxtFileImpl.CarDataServiceTxtImpl;
import DataServiceTxtFileImpl.DeliveryListDataServiceTxtImpl;
import DataServiceTxtFileImpl.DriverDataServiceTxtImpl;
import DataServiceTxtFileImpl.GarageDataSeriaServiceImpl;
import DataServiceTxtFileImpl.InquireDataServiceTxtImpl;
import DataServiceTxtFileImpl.InstituteDataServiceTxtImpl;
import DataServiceTxtFileImpl.ListStateDataServiceTxtlmpl;
import DataServiceTxtFileImpl.LoadingListDataServiceTxtImpl;
import DataServiceTxtFileImpl.LoadingList_HallDataServiceTxtImpl;
import DataServiceTxtFileImpl.LogDataServiceTxtImpl;
import DataServiceTxtFileImpl.MoneyInListDataServiceImpl;
import DataServiceTxtFileImpl.MoneyOutListDataServiceImpl;
import DataServiceTxtFileImpl.OrderListDataServiceImpl;
import DataServiceTxtFileImpl.ReceiveCourierListImpl;
import DataServiceTxtFileImpl.SetRewardDataServiceImpl;
import DataServiceTxtFileImpl.StaffDataServiceTxtImpl;
import DataServiceTxtFileImpl.TransCenterArrivalListDataServiceTxtImpl;
import DataServiceTxtFileImpl.WareInListDataServiceTxtImpl;
import DataServiceTxtFileImpl.WareOutDataServiceTxtImpl;
import DataServiceTxtFileImpl.logindataserviceimpl;
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
import dataservice.reviewdataservice.InstituteDataService;
import dataservice.reviewdataservice.ListStateDataService;
import dataservice.reviewdataservice.LogDataService;
import dataservice.reviewdataservice.SetRewardDataService;
import dataservice.reviewdataservice.StaffDataService;
import dataservice.transdataservice.CarDataService;
import dataservice.transdataservice.DriverDataService;
import dataservice.warehousedataservice.GarageDataSeriaService;
import testservice.TestService;
import testserviceimpl.TestServiceImpl;

public class NetworkMain extends JFrame {
	private static String hostIP = "localhost";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NetworkMain main = new NetworkMain();
		main.init();
		main.setVisible(true);
	}

	public void init() {
		//System.setProperty("java.rmi.server.hostname","169.254.35.28");
		try {
			String hostIP = InetAddress.getLocalHost().getHostAddress();
			System.out.println(hostIP);
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			LocateRegistry.createRegistry(6600);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JPanel jp = new JPanel();
		JButton jb1 = new JButton("Activate");
		JButton jb2 = new JButton("Inactivate");

		ActionListener al1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				activate();
			}
		};
		ActionListener al2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inactivate();
			}
		};

		jb1.addActionListener(al1);
		jb2.addActionListener(al2);

		jp.add(jb1);
		jp.add(jb2);
		this.add(jp);
		setSize(200, 95);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Server");
		setResizable(false);
	}

	public static void activate() {
		
		try {
			hostIP = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(hostIP);
		try {
			OrderListDataService orderListDataService = new OrderListDataServiceImpl();
			AccountDataService accountDataService = new AccountDataServiceTxtImpl();
			ArrivalListDataService arrivalListDataService = new ArrivalListImpl();
			DeliveryListDataService deliveryListDataService = new DeliveryListDataServiceTxtImpl();
			ReceiveCourierListDataService receiveCourierListDataService = new ReceiveCourierListImpl();
			TransCenterArrivalListDataService transCenterArrivalListDataService = new TransCenterArrivalListDataServiceTxtImpl();
			InquireDataService inquireDataService = new InquireDataServiceTxtImpl();
			LoginDataService loginDataService = new logindataserviceimpl();
			StaffDataService staffDataService = new StaffDataServiceTxtImpl();
			MoneyInListDataService moneyInListDataService = new MoneyInListDataServiceImpl();
			MoneyOutListDataService moneyOutListDataService=new MoneyOutListDataServiceImpl();
			CarDataService carDataService = new CarDataServiceTxtImpl();
			DriverDataService driverDataService = new DriverDataServiceTxtImpl();
			InstituteDataService instituteDataService = new InstituteDataServiceTxtImpl();
			ListStateDataService listStateDataService = new ListStateDataServiceTxtlmpl();
			LoadingList_HallDataService loadingList_HallDataService = new LoadingList_HallDataServiceTxtImpl();
			LoadingListDataService loadingListDataService = new LoadingListDataServiceTxtImpl();
			GarageDataSeriaService garageDataSeriaService=new GarageDataSeriaServiceImpl();
			WareInListDataService wareInListDataService=new WareInListDataServiceTxtImpl();
			WareOutListDataService wareOutListDataService=new WareOutDataServiceTxtImpl();
			BAccountManageDataService bAccountManageDataService=new BAccountDataServiceTxtImpl();
			TestService testService = new TestServiceImpl();
			SetRewardDataService setRewardDataService=new SetRewardDataServiceImpl();
			BeginningSetupDataService beginningSetupDataService=new BeginningSetupDataServiceTxtImpl();
			LogDataService logDataService=new LogDataServiceTxtImpl();

			Naming.rebind("rmi://127.0.0.1:6600/TestService", testService);
			Naming.rebind("rmi://127.0.0.1:6600/OrderListDataService", orderListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/AccountDataService", accountDataService);
			Naming.rebind("rmi://127.0.0.1:6600/ArrivalListDataService", arrivalListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/DeliveryListDataService", deliveryListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/ReceiveCourierListDataService", receiveCourierListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/TransCenterArrivalListDataService", transCenterArrivalListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/InquireDataService", inquireDataService);
			Naming.rebind("rmi://127.0.0.1:6600/LoginDataService", loginDataService);
			Naming.rebind("rmi://127.0.0.1:6600/StaffDataService", staffDataService);
			Naming.rebind("rmi://127.0.0.1:6600/MoneyInListDataService", moneyInListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/MoneyOutListDataService", moneyOutListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/CarDataService", carDataService);
			Naming.rebind("rmi://127.0.0.1:6600/DriverDataService", driverDataService);
			Naming.rebind("rmi://127.0.0.1:6600/InstituteDataService", instituteDataService);
			Naming.rebind("rmi://127.0.0.1:6600/ListStateDataService", listStateDataService);
			Naming.rebind("rmi://127.0.0.1:6600/LoadingList_HallDataService", loadingList_HallDataService);
			Naming.rebind("rmi://127.0.0.1:6600/LoadingListDataService", loadingListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/GarageDataSeriaService", garageDataSeriaService);
			Naming.rebind("rmi://127.0.0.1:6600/WareInListDataService", wareInListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/WareOutListDataService", wareOutListDataService);
			Naming.rebind("rmi://127.0.0.1:6600/SetRewardDataService", setRewardDataService);
			Naming.rebind("rmi://127.0.0.1:6600/BAccountManageDataService", bAccountManageDataService);
			Naming.rebind("rmi://127.0.0.1:6600/BeginningSetupDataService", beginningSetupDataService);
			Naming.rebind("rmi://127.0.0.1:6600/LogDataService", logDataService);

			System.out.println("Service Start!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void inactivate() {
		try {
			Naming.unbind("rmi://127.0.0.1:6600/TestService");
			Naming.unbind("rmi://127.0.0.1:6600/OrderListDataService");
			Naming.unbind("rmi://127.0.0.1:6600/AccountDataService");
			Naming.unbind("rmi://127.0.0.1:6600/ArrivalListDataService");
			Naming.unbind("rmi://127.0.0.1:6600/DeliveryListDataService");
			Naming.unbind("rmi://127.0.0.1:6600/ReceiveCourierListDataService");
			Naming.unbind("rmi://127.0.0.1:6600/TransCenterArrivalListDataService");
			Naming.unbind("rmi://127.0.0.1:6600/InquireDataService");
			Naming.unbind("rmi://127.0.0.1:6600/LoginDataService");
			Naming.unbind("rmi://127.0.0.1:6600/StaffDataService");
			Naming.unbind("rmi://127.0.0.1:6600/MoneyInListDataService");
			Naming.unbind("rmi://127.0.0.1:6600/CarDataService");
			Naming.unbind("rmi://127.0.0.1:6600/DriverDataService");
			Naming.unbind("rmi://127.0.0.1:6600/InstituteDataService");
			Naming.unbind("rmi://127.0.0.1:6600/ListStateDataService");
			Naming.unbind("rmi://127.0.0.1:6600/LoadingList_HallDataService");
			Naming.unbind("rmi://127.0.0.1:6600/LoadingListDataService");
			Naming.unbind("rmi://127.0.0.1:6600/SetRewardDataService");
			Naming.unbind("rmi://127.0.0.1:6600/BAccountManageDataService");
			Naming.unbind("rmi://127.0.0.1:6600/BeginningSetupDataService");
			Naming.unbind("rmi://127.0.0.1:6600/LogDataService");			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Service End!");
	}
}
