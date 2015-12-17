package blservice.warehouseblservice;

import po.AccountPO;
import po.TimePO;
import util.City;
import util.Vehicle;

public interface WareOutBLservice {
public void addWareOut(long id,TimePO time,City destination,Vehicle vehicle,long transid);
public String getTxtAddress(City city,long id);
public void submitWareOut();
public AccountPO getPo();

	
	
}
