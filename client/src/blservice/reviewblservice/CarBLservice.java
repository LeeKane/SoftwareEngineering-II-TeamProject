package blservice.reviewblservice;

import java.util.ArrayList;

import po.TimePO;
import util.Permission;
import util.Vehicle;
import vo.AccountVO;
import vo.CarVO;

public interface CarBLservice {
	public ArrayList<CarVO> findAll();
	public CarVO addCar(Vehicle vehicle, String name, long engine, String carNum,
			long basenumber, TimePO buytime, TimePO usetime);
	public boolean deleteCar(String name);
	public boolean Upate (ArrayList<CarVO> vo) ;
	
}
