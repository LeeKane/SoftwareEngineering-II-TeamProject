package dataservice.transdataservice;

import java.awt.Image;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CarPO;
import po.DriverPO;
import po.LoadingPO;
import po.TimePO;
import po.WarePO;
import util.DeliverType;
import util.Vehicle;

public class TransDataService_Stub implements TransDataService{
	private double weight ;
	private int amount;
	private double volume;
	private String pack;
	private String wareName;
	private DeliverType type;
	private double cost;
	private TimePO time;
	
	private long number;/*司机编号*/
	private String driverName;/*司机姓名*/
	private TimePO birthday;/*出生日期*/
	private String ID;/*身份证号*/
	private String Tel;/*手机号码*/
	private String carunit;/*车辆单位*/
	private String sex;/*性别*/
	private String licensedate;/*行驶证期限*/

	private Vehicle vehicle;/*种类*/
	private String vehicleName;/*车辆代号*/
	private long engine;/*发动机号*/
	private String carNum;/*车辆号*/
	private long basenumber;/*底盘号*/
	private String buytime;/*购买时间*/
	private String usetime;/*服役时间*/
	private Image image;/*车辆图片*/
	
	private TimePO loadDate;//装车日期
	private long transNum;//本营业厅汽运编号
	private String departPlace;//出发地
	private String destination;//到达地
	private ArrayList<?> waybillNumList;//本次装箱所有托运单号
	private String loadMonitor;//监装员
	private String loadPerformer;//押运员
	private double freight;//运费
	
	public TransDataService_Stub(double weight, int amount, double volume, String pack, String wareName,
			DeliverType type, double cost, TimePO time, long number, String driverName, TimePO birthday, String iD,
			String tel, String carunit, String sex, String licensedate, Vehicle vehicle, String vehicleName,
			long engine, String carNum, long basenumber, String buytime, String usetime, Image image, TimePO loadDate,
			long transNum, String departPlace, String destination, ArrayList<?> waybillNumList, String loadMonitor,
			String loadPerformer, double freight) {
		super();
		this.weight = weight;
		this.amount = amount;
		this.volume = volume;
		this.pack = pack;
		this.wareName = wareName;
		this.type = type;
		this.cost = cost;
		this.time = time;
		this.number = number;
		this.driverName = driverName;
		this.birthday = birthday;
		ID = iD;
		Tel = tel;
		this.carunit = carunit;
		this.sex = sex;
		this.licensedate = licensedate;
		this.vehicle = vehicle;
		this.vehicleName = vehicleName;
		this.engine = engine;
		this.carNum = carNum;
		this.basenumber = basenumber;
		this.buytime = buytime;
		this.usetime = usetime;
		this.image = image;
		this.loadDate = loadDate;
		this.transNum = transNum;
		this.departPlace = departPlace;
		this.destination = destination;
		this.waybillNumList = waybillNumList;
		this.loadMonitor = loadMonitor;
		this.loadPerformer = loadPerformer;
		this.freight = freight;
	}

	@Override
	public WarePO findWare(long id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FindWare Succeeded!");
		return new WarePO (weight, amount, volume, pack, wareName, type, cost, time);
	}

	@Override
	public void insertWare(WarePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("InsertWare Succeeded!");
	}

	@Override
	public void deleteWare(WarePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("DeleteWare Succeeded!");
	}

	@Override
	public DriverPO findDriver(long id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FindDriver Succeeded!");
		return new DriverPO(number, driverName, birthday, ID, Tel, carunit, sex, licensedate);
	}

	@Override
	public void insertDriver(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("InsertDriver Succeeded!");
	}

	@Override
	public void deleteDriver(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("DeleteDriver Succeeded!");
	}

	@Override
	public CarPO findCar(long id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FindCar Succeeded!");
		return new CarPO(vehicle, vehicleName, engine, carNum, basenumber, buytime, usetime, image);
	}

	@Override
	public void insertCar(CarPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("InsertCar Succeeded!");
	}

	@Override
	public void deleteCar(CarPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("DeleteCar Succeeded!");
	}

	@Override
	public LoadingPO findLoading(long id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FindLoading Succeeded!");
		return new LoadingPO(loadDate, transNum, departPlace, destination, waybillNumList, loadMonitor, loadPerformer, freight);
	}

	@Override
	public void insertLoading(LoadingPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("InsertLoading Succeeded!");
	}

	@Override
	public void deleteLoading(LoadingPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("DeleteLoading Succeeded!");

	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init Succeeded!");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Succeeded!");
	}

}
