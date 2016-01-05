package bl.warehouse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.warehouseblservice.WareInBLservice;
import data.datafactory.DataFactory;
import dataservice.listdataservice.WareInListDataService;
import dataservice.warehousedataservice.GarageDataSeriaService;
import po.AccountPO;
import po.Garage;
import po.GarageBodyPO;
import po.GaragePlacePO;
import po.TimePO;
import po.garageitem;
import po.list.WareInListPO;
import util.City;
import util.ListState;
import util.Vehicle;
import vo.WareInInputVO;
import vo.list.WareInListVO;

public class WareInBLserviceImpl implements WareInBLservice {
	public ArrayList<WareInInputVO> WareInListlist;
	public ArrayList<WareInListVO> Listlist;
	public ArrayList<WareInListVO> trainlist;
	public ArrayList<WareInListVO> planelist;
	boolean result = false;
	private static GarageDataSeriaService gd;
	private WareInListDataService wd;
	private String org;
	private AccountPO po;

	public WareInBLserviceImpl(AccountPO po) {
		this.po = po;
		gd = DataFactory.getGarageData();
		wd = DataFactory.getWareInData();
		WareInListlist = new ArrayList<WareInInputVO>();
		Listlist = new ArrayList<WareInListVO>();
		trainlist = new ArrayList<WareInListVO>();
		planelist = new ArrayList<WareInListVO>();
	}

	public WareInInputVO addWareIn(long id, TimePO time, City destination, long transid) {
		// TODO Auto-generated method stub
		WareInInputVO wareIn = new WareInInputVO(id, destination, time);
		WareInListlist.add(wareIn);
		org = setAddress(transid);
		return wareIn;
	}

	@Override
	public boolean submitWareIn() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		if (!WareInListlist.isEmpty()) {

			WareInInputVO vo = WareInListlist.get(WareInListlist.size() - 1);
			long id = vo.getId();
			TimePO time = vo.getTime();
			City city = vo.getDestination();
			garageitem item = new garageitem(time, id);
			gd.insert(org, item);
			GaragePlacePO place = getplace(id);
			// WareInListVO list = new WareInListVO(id, time, city, place,
			// ListState.SUBMITTED);
			// WareInListPO ppo = new WareInListPO(id, time, city, place,
			// ListState.SUBMITTED,
			// Long.parseLong(po.getStaff().getOrgid()));
			// addtotxt(ppo);
			// Listlist.add(list);

		}
		return true;

	}

	@Override
	public GaragePlacePO getplace(long id) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub

		GaragePlacePO po = gd.find(org, id);

		return po;
	}

	@Override
	public String setAddress(long id) {
		// TODO Auto-generated method stub
		String address = "TxtData/" + id + ".txt";
		return address;
	}

	public ArrayList<WareInListVO> getWareInList() {
		return this.Listlist;
	}

	public ArrayList<WareInListVO> getTrainInList() {
		return this.trainlist;
	}

	public ArrayList<WareInListVO> getPlaneInList() {
		return this.planelist;
	}

	@Override
	public void addtotxt(WareInListPO po) {
		// TODO Auto-generated method stub
		try {
			wd.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deletetxt(long id) throws RemoteException, IOException {
		wd.delete(id);
	}

	@Override
	public void deletefromtxt(long id) throws IOException {
		// TODO Auto-generated method stub
		wd.delete(id);
	}

	@Override
	public boolean addbyplace(long id, TimePO time, City destination, long transid, GaragePlacePO place,
			Vehicle vehicle) throws FileNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		boolean contain = false;
		if (vehicle.equals(Vehicle.CAR)) {
			org = setAddress(transid);
		}
		if (vehicle.equals(Vehicle.TRAIN)) {
			org = "TxtData/" + transid + "_train.txt";
		}
		if (vehicle.equals(Vehicle.PLANE)) {
			org = "TxtData/" + transid + "_plane.txt";
		}
		garageitem item = new garageitem(time, id);
		contain = gd.insertByPlace(org, item, place);
		// contain= gd.insertByPlace(org, item, place);

		if (contain == false) {
			WareInListVO list = new WareInListVO(id, time, destination, place, ListState.SUBMITTED, vehicle);
			WareInListPO pppo = new WareInListPO(id, time, destination, place, ListState.SUBMITTED,
					Long.parseLong(po.getStaff().getOrgid()), vehicle);
			addtotxt(pppo);
			if (vehicle.equals(Vehicle.CAR))
				Listlist.add(list);
			if (vehicle.equals(Vehicle.TRAIN))
				trainlist.add(list);
			if (vehicle.equals(Vehicle.PLANE))
				planelist.add(list);

		}

		return contain;
	}

	@Override
	public ArrayList<GaragePlacePO> shownullplace(long transid) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		String orgd = setAddress(transid);
		Garage g = gd.getGarage(orgd);
		ArrayList<GaragePlacePO> result;
		result = g.nullplace;
		return result;

	}

	public ArrayList<GaragePlacePO> getnullplace(long transid) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		String orgd = setAddress(transid);
		Garage g = gd.getGarage(orgd);
		ArrayList<GaragePlacePO> result;
		result = g.nullplace;
		return result;

	}

	public ArrayList<GaragePlacePO> getnullplacetrain(long transid) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		String orgd = "TxtData/" + transid + "_train.txt";
		Garage g = gd.getGarage(orgd);
		ArrayList<GaragePlacePO> result;
		result = g.nullplace;
		return result;

	}

	public ArrayList<GaragePlacePO> getnullplaceplane(long transid) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		String orgd = "TxtData/" + transid + "_plane.txt";
		Garage g = gd.getGarage(orgd);
		ArrayList<GaragePlacePO> result;
		result = g.nullplace;
		return result;

	}

	@Override
	public void deleteEmpty(long id, GaragePlacePO place) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<GaragePlacePO> result = new ArrayList<GaragePlacePO>();

		String address = setAddress(id);
		Garage g = gd.getGarage(address);
		result = g.getNullplace();
		for (int i = 0; i < result.size(); i++) {
			GaragePlacePO compare = result.get(i);
			if (compare.getQu() == place.getQu() && compare.getPai() == place.getPai()
					&& compare.getJia() == place.getJia() && compare.getWei() == place.getWei()) {
				result.remove(i);
			}
		}
		g.setNullplace(result);
		try {
			File f5 = new File(address);
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {

		}
		File file = new File(address);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(g);
		oos.flush();
		oos.close();
		fos.close();

	}

	@Override
	public AccountPO getPo() {
		return po;
	}

	public String getPercent(long transid) throws RemoteException, ClassNotFoundException, IOException {
		String d = setAddress(transid);

		Garage g = gd.getGarage(d);

		double percent = g.getpercent() * 100;

		if (percent > 90) {
			return null;
		}
		String output = "汽运区：" + percent + "%";
		return output;

	}

	@Override
	public ArrayList<GarageBodyPO> getPlace(long transid) throws RemoteException, ClassNotFoundException, IOException {
		String orgd = setAddress(transid);
		Garage g = gd.getGarage(orgd);
		ArrayList<GarageBodyPO> result;
		result = g.list;
		return result;
	}

	public ArrayList<GarageBodyPO> getTrainPlace(long transid)
			throws RemoteException, ClassNotFoundException, IOException {
		String orgd = "TxtData/" + transid + "_train.txt";
		Garage g = gd.getGarage(orgd);
		ArrayList<GarageBodyPO> result;
		result = g.list;
		return result;
	}

	public ArrayList<GarageBodyPO> getPlanePlace(long transid)
			throws RemoteException, ClassNotFoundException, IOException {
		String orgd = "TxtData/" + transid + "_plane.txt";
		Garage g = gd.getGarage(orgd);
		ArrayList<GarageBodyPO> result;
		result = g.list;
		return result;
	}

	@Override
	public String getTrainPercent(long transid) throws RemoteException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		String m = "TxtData/" + transid + "_train.txt";
		Garage f = gd.getGarage(m);
		double percent2 = f.getpercent() * 100;
		if (percent2 > 90) {
			return null;
		}
		String output = "火车区：" + percent2 + "" + "%";
		return output;

	}

	@Override
	public String getPlanePercent(long transid) throws RemoteException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		String m = "TxtData/" + transid + "_plane.txt";
		Garage f = gd.getGarage(m);
		double percent2 = f.getpercent() * 100;
		if (percent2 > 90) {
			return null;
		}
		String output = "航运区：" + percent2 + "" + "%";
		return output;
	}

	@Override
	public ArrayList<GarageBodyPO> getMotorplace(long transid)
			throws RemoteException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		String orgd = "TxtData/" + transid + "_motor.txt";
		Garage g = gd.getGarage(orgd);
		ArrayList<GarageBodyPO> result;
		result = g.list;
		return result;

	}

	@Override
	public boolean addtomotor(long id, TimePO time, City destination, long transid, GaragePlacePO place,
			Vehicle vehicle) throws RemoteException, FileNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		boolean contain = false;
		org = "TxtData/" + transid + "_motor.txt";
		garageitem item = new garageitem(time, id);
		contain = gd.insertByPlace(org, item, place);
		// contain= gd.insertByPlace(org, item, place);

		if (contain == false) {

			WareInListPO pppo = new WareInListPO(id, time, destination, place, ListState.DRAFT,
					Long.parseLong(po.getStaff().getOrgid()), vehicle);
			deletetxt(id);
			addtotxt(pppo);

		}

		return contain;
	}

}
