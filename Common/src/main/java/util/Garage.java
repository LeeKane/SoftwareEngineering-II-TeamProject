package util;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GarageBodyPO;
import po.GaragePlacePO;
import po.TimePO;
import po.garageitem;

public class Garage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2165782244496729073L;
	private int QU = 5;
	private int PAI = 5;
	private int JIA = 5;
	private int WEI = 5;
	private int size = 30;
	private int temp = 0;// zhanshirongliang
	public ArrayList<GarageBodyPO> list;
	public ArrayList<GaragePlacePO> nullplace;// 空的位置

	public void creat() {
		// TODO Auto-generated method stub
		ArrayList<GarageBodyPO> list = new ArrayList<GarageBodyPO>();
		ArrayList<GaragePlacePO> nullplace = new ArrayList<GaragePlacePO>();
		this.list = list;
		this.nullplace = nullplace;
	}

	public void show() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("ID" + " " + list.get(i).getItem().getId() + "位置为" + list.get(i).getPlace().getQu() + "区"
					+ list.get(i).getPlace().getPai() + "排" + list.get(i).getPlace().getJia() + "架"
					+ list.get(i).getPlace().getWei() + "位");
		}
	}

	public void insert(garageitem item) {
		// TODO Auto-generated method stub
		GaragePlacePO place = buildPlace();
		boolean contain = false;
		for (int i = 0; i < list.size(); i++) {
			GaragePlacePO pp = list.get(i).getPlace();
			if (pp.getQu() == place.getQu() && pp.getPai() == place.getPai() && pp.getJia() == place.getJia()
					&& pp.getWei() == place.getWei()) {
				contain = true;
			}
		}
		if (contain == false) {
			GarageBodyPO p = new GarageBodyPO(place, item);
			list.add(p);

			for (int i = 0; i < nullplace.size(); i++) {
				GaragePlacePO compare = nullplace.get(i);
				if (compare.getQu() == place.getQu() && compare.getPai() == place.getPai()
						&& compare.getJia() == place.getJia() && compare.getWei() == place.getWei()) {
					nullplace.remove(i);
				}
			}

			setTemp(getTemp() + 1);
		}
	}

	public void delete(garageitem item) {
		// TODO Auto-generated method stub

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItem().equals(item)) {
				nullplace.add(list.get(i).getPlace());
				list.remove(i);
			}

		}
		setTemp(getTemp() - 1);
	}

	public void setNullplace(ArrayList<GaragePlacePO> p) {
		this.nullplace = p;
	}

	public void init() {
		// TODO Auto-generated method stub
		list.clear();
		this.setTemp(0);
	}

	public boolean insertByPlace(garageitem item, GaragePlacePO place) throws RemoteException {

		boolean contain = false;
		for (int i = 0; i < list.size(); i++) {
			GaragePlacePO pp = list.get(i).getPlace();
			if (pp.getQu() == place.getQu() && pp.getPai() == place.getPai() && pp.getJia() == place.getJia()
					&& pp.getWei() == place.getWei()) {
				contain = true;
			}
		}
		if (contain == false) {
			System.out.println("mlgb");
			GarageBodyPO p = new GarageBodyPO(place, item);
			list.add(p);

			for (int i = 0; i < nullplace.size(); i++) {
				GaragePlacePO compare = nullplace.get(i);
				if (compare.getQu() == place.getQu() && compare.getPai() == place.getPai()
						&& compare.getJia() == place.getJia() && compare.getWei() == place.getWei()) {
					nullplace.remove(i);
				}
			}
			for (int i = 0; i < list.size(); i++) {
				for (int j = i; j < list.size(); j++) {
					if (Compare(list.get(i).getPlace(), list.get(j).getPlace())) {
						GarageBodyPO temp = list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}
				}
			}

			setTemp(getTemp() + 1);
		}
		return contain;
	}

	public boolean Compare(GaragePlacePO a, GaragePlacePO b) {
		if (a.getQu() > b.getQu()) {
			return true;
		}
		if (a.getQu() < b.getQu()) {
			return false;
		}
		if (a.getQu() == b.getQu()) {
			if (a.getPai() > b.getPai()) {
				return true;
			}
			if (a.getPai() < b.getPai()) {
				return false;
			}
			if (a.getPai() == b.getPai()) {
				if (a.getJia() > b.getJia()) {
					return true;
				}
				if (a.getJia() < b.getJia()) {
					return false;
				}
				if (a.getJia() == b.getJia()) {
					if (a.getWei() > b.getWei()) {
						return true;
					}
					if (a.getWei() < b.getWei()) {
						return false;
					}
				}

			}
		}

		return false;
	}

	public ArrayList<GaragePlacePO> getNullplace() {
		return nullplace;
	}

	public GaragePlacePO buildPlace() {
		// TODO Auto-generated method stub
		int size = list.size();

		GaragePlacePO place = null;
		if (size == 0) {
			place = new GaragePlacePO(1, 1, 1, 1);
		}

		if (size != 0) {

			GarageBodyPO po = list.get(list.size() - 1);
			GaragePlacePO preplace = po.getPlace();
			int qu = preplace.getQu();
			int pai = preplace.getPai();
			int jia = preplace.getJia();
			int wei = preplace.getWei();

			if (wei < WEI) {
				wei++;
				pai = preplace.getPai();
				jia = preplace.getJia();
				qu = preplace.getQu();
			}
			if (wei == WEI) {
				wei = 1;
				jia = preplace.getJia();
				if (jia < JIA) {
					jia++;
					pai = preplace.getPai();
					qu = preplace.getQu();
				}
				if (jia == JIA) {
					jia = 1;
					pai = preplace.getPai();
					if (pai < PAI) {
						pai++;
						qu = preplace.getQu();
					}
					if (pai == PAI) {
						pai = 1;
						qu = preplace.getQu() + 1;
					}
				}
			}

			place = new GaragePlacePO(qu, pai, jia, wei);
		}
		return place;
	}

	public double getpercent() {
		double a = getTemp();
		double b = getSize();
		double m = a / b;
		return m;

	}

	public static void main(String[] args) throws RemoteException {

		Garage g = new Garage();
		g.creat();
		garageitem item = new garageitem(new TimePO(1, 1, 1, 1, 1, 1), 123457);
		garageitem item2 = new garageitem(new TimePO(1, 1, 1, 1, 1, 1), 1234527);
		garageitem item3 = new garageitem(new TimePO(1, 1, 1, 1, 1, 1), 1234557);
		garageitem item4 = new garageitem(new TimePO(1, 1, 1, 1, 1, 1), 2234557);
		g.insert(item);
		g.insert(item2);
		g.insert(item3);
		g.insert(item4);
		g.delete(item2);
		g.delete(item3);
		GaragePlacePO place = new GaragePlacePO(1, 1, 1, 2);
		g.insertByPlace(item4, place);

		System.out.println("//");
		ArrayList<GaragePlacePO> p = new ArrayList<GaragePlacePO>();
		p = g.getNullplace();
		for (int i = 0; i < p.size(); i++) {
			p.get(i).showplace();
		}

	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
