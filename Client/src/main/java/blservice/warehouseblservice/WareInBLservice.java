package blservice.warehouseblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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
public void addbyplace(long id,TimePO time,City destination,long transid,GaragePlacePO place) throws FileNotFoundException, ClassNotFoundException, IOException;
public ArrayList<GaragePlacePO> shownullplace(long transid) throws ClassNotFoundException, IOException;
public ArrayList<GaragePlacePO> getnullplace(long transid) throws ClassNotFoundException, IOException;
}
