package blservice.transblservice;

import java.awt.Image;

import po.CarPO;
import po.DriverPO;

import po.TimePO;
import po.WarePO;
import po.list.LoadingListPO;
import util.ResultMessage;
import util.Vehicle;
import vo.CarVO;
import vo.DriverVO;

public class TransBLService_Stub implements TransBLService{
	double cost;
	double time;
	
	Vehicle vehicle;/*种类*/
	String carName;/*车辆代号*/
	long engine;/*发动机号*/
	String carNum;/*车辆号*/
	long basenumber;/*底盘号*/
	String buytime;/*购买时间*/
	String usetime;/*服役时间*/
	Image image;/*车辆图片*/
	
	long number;/*司机编号*/
	String driverName;/*司机姓名*/
	TimePO birthday;/*出生日期*/
	String ID;/*身份证号*/
	String Tel;/*手机号码*/
	String carunit;/*车辆单位*/
	String sex;/*性别*/
	String licensedate;/*行驶证期限*/
	
	double income;	
	
	public TransBLService_Stub(double cost, double time, Vehicle vehicle, String carName, long engine, String carNum,
			long basenumber, String buytime, String usetime, Image image, long number, String driverName,
			TimePO birthday, String iD, String tel, String carunit, String sex, String licensedate, double income) {
		super();
		this.cost = cost;
		this.time = time;
		this.vehicle = vehicle;
		this.carName = carName;
		this.engine = engine;
		this.carNum = carNum;
		this.basenumber = basenumber;
		this.buytime = buytime;
		this.usetime = usetime;
		this.image = image;
		this.number = number;
		this.driverName = driverName;
		this.birthday = birthday;
		ID = iD;
		Tel = tel;
		this.carunit = carunit;
		this.sex = sex;
		this.licensedate = licensedate;
		this.income = income;
	}

	@Override
	public double getCost(WarePO po) {
		// TODO Auto-generated method stub
		return cost;
	}

	@Override
	public double getTime(WarePO po) {
		// TODO Auto-generated method stub
		return time;
	}

	@Override
	public ResultMessage addCar(CarPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteCar(long id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public CarPO getCar(long id) {
		// TODO Auto-generated method stub
		return new CarPO(vehicle, carName, engine, carNum, basenumber, buytime, usetime, image);
	}

	@Override
	public DriverPO getDriver(long id) {
		// TODO Auto-generated method stub
		return new DriverPO(number, driverName, birthday, ID, Tel, carunit, sex, licensedate);
	}

	@Override
	public ResultMessage addDriver(DriverPO po, long id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteDriver(long id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage addLoading1(LoadingListPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public double getIncome(double income, long id) {
		// TODO Auto-generated method stub
		return this.income;
	}

	@Override
	public void endTrans() {
		// TODO Auto-generated method stub
		System.out.println("Trans Ended!");
	}

	@Override
	public ResultMessage addLoading(LoadingListPO po) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
