package blservice.warehouseblservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import po.GarageBodyPO;
import po.GaragePlacePO;
import po.TimePO;
import util.City;
import util.Vehicle;
import vo.list.WareOutListVO;

public interface WareOutBLservice {
public void addWareOut(long id,TimePO time,City destination,Vehicle vehicle,long transid,GaragePlacePO place);
public String getTxtAddress(City city,long id);
public void submitWareOut();
public AccountPO getPo();
public boolean findWareIn(long id) throws IOException;
public ArrayList<WareOutListVO> getWareOut();
public ArrayList<GarageBodyPO> getWareIn(TimePO start,TimePO end) throws NumberFormatException, RemoteException, IOException;
public ArrayList<GarageBodyPO> getWareOut(TimePO start, TimePO end) throws NumberFormatException, RemoteException, IOException;
public int getNum(long transid) throws RemoteException, ClassNotFoundException, IOException;
public ArrayList<WareOutListVO> getTrainWareOut();
public ArrayList<WareOutListVO> getPlaneWareOut();
}
