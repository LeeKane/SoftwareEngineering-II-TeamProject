package blservice.warehouseblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import po.GarageBodyPO;
import po.GaragePlacePO;
import po.TimePO;
import po.list.WareInListPO;
import util.City;
import vo.WareInInputVO;
import vo.list.WareInListVO;

public interface WareInBLservice {
public WareInInputVO addWareIn(long id, TimePO time, City destination,long transid);
public boolean submitWareIn() throws FileNotFoundException, IOException, ClassNotFoundException;
public GaragePlacePO getplace(long id) throws ClassNotFoundException, IOException;
public String setAddress(long id);
public  ArrayList<WareInListVO> getWareInList();
public void addtotxt(WareInListPO po);
public void deletefromtxt(long id) throws IOException;
public void deleteEmpty(long id,GaragePlacePO place) throws ClassNotFoundException, IOException;
public boolean addbyplace(long id,TimePO time,City destination,long transid,GaragePlacePO place) throws RemoteException,  FileNotFoundException, ClassNotFoundException, IOException;
public ArrayList<GaragePlacePO> shownullplace(long transid) throws ClassNotFoundException, IOException;
public ArrayList<GaragePlacePO> getnullplace(long transid) throws ClassNotFoundException, IOException;
public AccountPO getPo();
public ArrayList<GarageBodyPO> getPlace(long transid) throws RemoteException, ClassNotFoundException, IOException;
}
