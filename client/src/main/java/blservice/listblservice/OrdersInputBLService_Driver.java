package blservice.listblservice;

import po.TimePO;
import util.City;
import util.DeliverType;
import vo.WareVO;

public class OrdersInputBLService_Driver {
	public void drive(OrdersInputBLService ordersInputBLService){
		WareVO vo=ordersInputBLService.addware(1, 1, 1, "Ha", "HaHa", "特快专递",City.BEIJING,City.NANJING);
		System.out.println(vo.toString());
		
		double cost=ordersInputBLService.getCost();
		System.out.println(cost);
		double time=ordersInputBLService.getTime();
		System.out.println(time);
		
		System.out.println(ordersInputBLService.submit());
		
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrdersInputBLService ordersInputBLService=new OrdersInputBLService_Stub(1, 2, 3, "Ha", "HaHa", "特快专递", 4, new TimePO(7,8,9,10,11,12), 5, 6);
		OrdersInputBLService_Driver driver=new OrdersInputBLService_Driver();
		driver.drive(ordersInputBLService);
	}

}
