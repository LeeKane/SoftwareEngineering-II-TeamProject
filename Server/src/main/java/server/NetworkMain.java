package server;

import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import DataServiceTxtFileImpl.AccountDataServiceTxtImpl;
import DataServiceTxtFileImpl.ArrivalListImpl;
import DataServiceTxtFileImpl.BAccountDataServiceTxtImpl;
import DataServiceTxtFileImpl.BeginningSetupDataServiceTxtImpl;
import DataServiceTxtFileImpl.CarDataServiceTxtImpl;
import DataServiceTxtFileImpl.ConstantDataServiceTxtImpl;
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
import testserviceimpl.TestServiceImpl;

public class NetworkMain extends JFrame {
	private static String hostIP = "localhost";
	private static String port = "6600";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NetworkMain main = new NetworkMain();
		main.init();
		main.setVisible(true);
	}

	public void init() {
		// System.setProperty("java.rmi.server.hostname","169.254.35.28");

		// this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
		JPanel main = new JPanel();
		this.setContentPane(main);
		JPanel jp = new JPanel();
		JButton jb1 = new JButton("Activate");
		JButton jb2 = new JButton("Inactivate");
		JTextArea inf = new JTextArea(50, 27);
		inf.setPreferredSize(new Dimension(200, 200));
		JScrollPane scrollPane = new JScrollPane();
		// scrollPane.add(textArea);
		scrollPane.setViewportView(inf);
		scrollPane.getViewport().add(inf);
		ActionListener al1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				activate();
				inf.append("   IP:" + hostIP + "\n");
				inf.append("   Service Start!\n");
			}
		};
		ActionListener al2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inactivate();
				inf.append("   Service End!\n");
			}
		};

		jb1.addActionListener(al1);
		jb2.addActionListener(al2);

		jp.add(jb1);
		jp.add(jb2);
		main.add(jp);
		main.add(scrollPane);

		setSize(300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Server");
		setResizable(true);
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
			MoneyOutListDataService moneyOutListDataService = new MoneyOutListDataServiceImpl();
			CarDataService carDataService = new CarDataServiceTxtImpl();
			DriverDataService driverDataService = new DriverDataServiceTxtImpl();
			InstituteDataService instituteDataService = new InstituteDataServiceTxtImpl();
			ListStateDataService listStateDataService = new ListStateDataServiceTxtlmpl();
			LoadingList_HallDataService loadingList_HallDataService = new LoadingList_HallDataServiceTxtImpl();
			LoadingListDataService loadingListDataService = new LoadingListDataServiceTxtImpl();
			GarageDataSeriaService garageDataSeriaService = new GarageDataSeriaServiceImpl();
			WareInListDataService wareInListDataService = new WareInListDataServiceTxtImpl();
			WareOutListDataService wareOutListDataService = new WareOutDataServiceTxtImpl();
			BAccountManageDataService bAccountManageDataService = new BAccountDataServiceTxtImpl();
			TestService testService = new TestServiceImpl();
			SetRewardDataService setRewardDataService = new SetRewardDataServiceImpl();
			BeginningSetupDataService beginningSetupDataService = new BeginningSetupDataServiceTxtImpl();
			LogDataService logDataService = new LogDataServiceTxtImpl();
			ConstantDataService constantDataService = new ConstantDataServiceTxtImpl();

			Naming.rebind("rmi://" + hostIP + ":" + port + "/TestService", testService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/OrderListDataService", orderListDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/AccountDataService", accountDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/ArrivalListDataService", arrivalListDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/DeliveryListDataService", deliveryListDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/ReceiveCourierListDataService",
					receiveCourierListDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/TransCenterArrivalListDataService",
					transCenterArrivalListDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/InquireDataService", inquireDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/LoginDataService", loginDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/StaffDataService", staffDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/MoneyInListDataService", moneyInListDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/MoneyOutListDataService", moneyOutListDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/CarDataService", carDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/DriverDataService", driverDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/InstituteDataService", instituteDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/ListStateDataService", listStateDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/LoadingList_HallDataService", loadingList_HallDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/LoadingListDataService", loadingListDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/GarageDataSeriaService", garageDataSeriaService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/WareInListDataService", wareInListDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/WareOutListDataService", wareOutListDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/SetRewardDataService", setRewardDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/BAccountManageDataService", bAccountManageDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/BeginningSetupDataService", beginningSetupDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/LogDataService", logDataService);
			Naming.rebind("rmi://" + hostIP + ":" + port + "/ConstantDataService", constantDataService);

			System.out.println("Service Start!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void inactivate() {
		try {
			Naming.unbind("rmi://" + hostIP + ":" + port + "/TestService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/OrderListDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/AccountDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/ArrivalListDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/DeliveryListDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/ReceiveCourierListDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/TransCenterArrivalListDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/InquireDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/LoginDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/StaffDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/MoneyInListDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/CarDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/DriverDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/InstituteDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/ListStateDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/LoadingList_HallDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/LoadingListDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/SetRewardDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/BAccountManageDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/BeginningSetupDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/LogDataService");
			Naming.unbind("rmi://" + hostIP + ":" + port + "/ConstantDataService");
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
