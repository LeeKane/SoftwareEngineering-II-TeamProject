package po;

import java.io.Serializable;
import java.util.ArrayList;

public class Garage implements Serializable {
	private int QU = 5;
	private int PAI = 5;
	private int JIA = 5;
	private int WEI = 5;
	private int size = QU * PAI * JIA * WEI;
	private int temp = 0;// zhanshirongliang
	public ArrayList<GarageBodyPO> list;

	public void creat() {
		// TODO Auto-generated method stub
		ArrayList<GarageBodyPO> list = new ArrayList<GarageBodyPO>();

		this.list = list;
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
		GaragePlacePO po = buildPlace();
		GarageBodyPO p = new GarageBodyPO(po, item);
		list.add(p);
		setTemp(getTemp() + 1);
	}

	public void delete(garageitem item) {
		// TODO Auto-generated method stub
		list.remove(item);
		setTemp(getTemp() - 1);
	}

	public void init() {
		// TODO Auto-generated method stub
		list.clear();
		this.setTemp(0);
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

	public static void main(String[] args) {

		Garage g = new Garage();
		g.creat();
		garageitem item = new garageitem(new TimePO(1, 1, 1, 1, 1, 1), 123457);
		garageitem item2 = new garageitem(new TimePO(1, 1, 1, 1, 1, 1), 1234527);

		g.insert(item);
		g.insert(item2);
		g.insert(item2);
		g.insert(item2);
		g.delete(item2);
		System.out.println(g.getTemp());
		System.out.println(g.getSize());
		System.out.println(g.getpercent());
		g.list.get(2).getPlace().showplace();
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
