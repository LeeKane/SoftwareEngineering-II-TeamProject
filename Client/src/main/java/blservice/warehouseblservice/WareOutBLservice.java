package blservice.warehouseblservice;

import java.io.IOException;
import java.util.ArrayList;

import po.AccountPO;
import po.TimePO;
import util.City;
import util.Vehicle;
import vo.list.WareOutListVO;

public interface WareOutBLservice {
public void addWareOut(long id,TimePO time,City destination,Vehicle vehicle,long transid);
public String getTxtAddress(City city,long id);
public void submitWareOut();
public AccountPO getPo();
public boolean findWareIn(long id) throws IOException;
public ArrayList<WareOutListVO> getWareOut();
	
}
