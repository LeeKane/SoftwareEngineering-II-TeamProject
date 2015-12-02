package mockobject;

import po.CarPO;
import bl.trans.Car;

public class MockCar extends Car{
	public CarPO po;
	public MockCar(CarPO po)
	{
		this.po=po;
	}
	
}
