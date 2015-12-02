package blservice.transblservice;

import java.util.ArrayList;

import po.*;
import po.list.LoadingListPO;
import util.City;
import util.DeliverType;
import util.ListType;
import util.ResultMessage;
import util.Vehicle;
import vo.CarVO;
import vo.DriverVO;

public class TransBLService_Driver {
	public void drive(TransBLService transBLService){
		double cost=transBLService.getCost(new WarePO(1, 1, 1, "HaHa", "HaHa", DeliverType.ECO, 1, new TimePO(2015, 1, 1, 1, 1, 1)));
		System.out.println(cost);
		
		double time=transBLService.getTime(new WarePO(1, 1, 1, "HaHa", "HaHa", DeliverType.ECO, 1, new TimePO(2015, 1, 1, 1, 1, 1)));
		System.out.println(time);
		
		ResultMessage result=transBLService.addCar(new CarPO(Vehicle.CAR, "苏A HAHAH", 1, "Ha1s", 1, "2015-1-1", "2015-1-1", null));
		if(result==ResultMessage.SUCCESS)
			System.out.println("AddCar Succeeded!");
		
		result=transBLService.deleteCar(1);
		if(result==ResultMessage.SUCCESS)
			System.out.println("DeleteCar Succeeded!");
		
		CarPO carPO=transBLService.getCar(1);
		System.out.println(carPO.getClass());
		
		DriverPO driverPO=transBLService.getDriver(1);
		System.out.println(driverPO.getClass());
		
		result=transBLService.addDriver(new DriverPO(1, "HaHa", new TimePO(2015, 1, 1, 1, 1, 1), "1", "10000000000", "301", "Male", "1"), 1);
		if(result==ResultMessage.SUCCESS)
			System.out.println("AddDriver Succeeded!");
		
		result=transBLService.deleteDriver(1);
		if(result==ResultMessage.SUCCESS)
			System.out.println("DeleteDriver Succeeded!");
		
		result=transBLService.addLoading(new LoadingListPO(ListType.TRANS, new TimePO(0, 0, 0, 0, 0, 0), 4541244, City.BEIJING, City.GUANGZHOU, null, "fu", "lin", 121454));
		if(result==ResultMessage.SUCCESS)
			System.out.println("AddLoading Succeeded!");
		
		double income=transBLService.getIncome(1, 1);
		System.out.println(income);
		
		transBLService.endTrans();	
	}
	
	public static void main(String[] args) {
		TransBLService transBLService=new TransBLService_Stub(1, 2, Vehicle.CAR, "苏A HAHAH", 1, "Ha1s", 1, "2015-1-1", "2015-1-1", null,1, "HaHa", new TimePO(2015, 1, 1, 1, 1, 1), "1", "10000000000", "301", "Male", "1", 3);
		TransBLService_Driver driver=new TransBLService_Driver();
		driver.drive(transBLService);
	}
}