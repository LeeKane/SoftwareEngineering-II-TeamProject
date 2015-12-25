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
import util.Vehicle;
import vo.WareInInputVO;
import vo.list.WareInListVO;

public interface WareInBLservice {
	public WareInInputVO addWareIn(long id, TimePO time, City destination, long transid);

	public boolean submitWareIn() throws FileNotFoundException, IOException, ClassNotFoundException;

	public GaragePlacePO getplace(long id) throws ClassNotFoundException, IOException;

	public String setAddress(long id);

	public ArrayList<WareInListVO> getWareInList();

	public void addtotxt(WareInListPO po);

	public void deletefromtxt(long id) throws IOException;

	public void deleteEmpty(long id, GaragePlacePO place) throws ClassNotFoundException, IOException;

	public boolean addbyplace(long id, TimePO time, City destination, long transid, GaragePlacePO place,Vehicle vehicle)
			throws RemoteException, FileNotFoundException, ClassNotFoundException, IOException;
	public boolean addtomotor(long id, TimePO time, City destination, long transid, GaragePlacePO place,Vehicle vehicle)
			throws RemoteException, FileNotFoundException, ClassNotFoundException, IOException;
	public ArrayList<GaragePlacePO> shownullplace(long transid) throws ClassNotFoundException, IOException;
	public ArrayList<WareInListVO> getPlaneInList();
	public ArrayList<GaragePlacePO> getnullplace(long transid) throws ClassNotFoundException, IOException;
	public ArrayList<GaragePlacePO> getnullplaceplane(long transid) throws ClassNotFoundException, IOException;
	public AccountPO getPo();
	public ArrayList<GarageBodyPO> getPlanePlace(long transid) throws RemoteException, ClassNotFoundException, IOException;
	public ArrayList<GarageBodyPO> getPlace(long transid) throws RemoteException, ClassNotFoundException, IOException;
	public ArrayList<GaragePlacePO> getnullplacetrain(long transid) throws ClassNotFoundException, IOException;
	public String getPercent(long transid) throws RemoteException, ClassNotFoundException, IOException;
	public String getTrainPercent(long transid) throws RemoteException, ClassNotFoundException, IOException;
	public String getPlanePercent(long transid) throws RemoteException, ClassNotFoundException, IOException;
	public ArrayList<WareInListVO> getTrainInList() ;
	public ArrayList<GarageBodyPO> getTrainPlace(long transid) throws RemoteException, ClassNotFoundException, IOException;
	public ArrayList<GarageBodyPO>getMotorplace(long transid)throws RemoteException, ClassNotFoundException, IOException;
}
