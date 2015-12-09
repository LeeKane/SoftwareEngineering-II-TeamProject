package dataservice.warehousedataservice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import po.Garage;
import po.GarageBodyPO;
import po.GaragePlacePO;
import po.garageitem;

public class garagedataservice_Stub implements garagedataservice {

	@Override
	public Garage init() {
		// TODO Auto-generated method stub
		Garage g = new Garage();
		g.creat();

		return g;
	}

	public void serializable(Garage g, String txtaddress) throws IOException {// ���ֿ����л���txt��
		File file = new File(txtaddress);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(g);
	}

	public Garage antiserializable(String txtaddress) {

		return null;

	}

	@Override
	public void insert(Garage g, garageitem item) {
		// TODO Auto-generated method stub

		GaragePlacePO po = g.buildPlace();
		GarageBodyPO p = new GarageBodyPO(po, item);
		g.list.add(p);
		g.setTemp(g.getTemp() + 1);

	}

	@Override
	public double rate(Garage g) {
		// TODO Auto-generated method stub
		double m = g.getpercent();
		return m;
	}

	@Override
	public void destroy(Garage g) {
		// TODO Auto-generated method stub
		g.list.clear();
	}

	@Override
	public void show(Garage g) {
		// TODO Auto-generated method stub
		g.show();
	}

	@Override
	public garageitem find(Garage g, long id) {
		garageitem item = null;
		for (int i = 0; i < g.list.size(); i++) {
			if (g.list.get(i).getItem().getId() == id) {
				item = g.list.get(i).getItem();
				break;
			}
		}

		return item;

	}

	@Override
	public void delete(Garage g, long id) {
		// TODO Auto-generated method stub

		for (int i = 0; i < g.list.size(); i++) {
			if (g.list.get(i).getItem().getId() == id) {
				g.list.remove(i);
				break;
			}
		}

		g.setTemp(g.getTemp() - 1);
	}

}
