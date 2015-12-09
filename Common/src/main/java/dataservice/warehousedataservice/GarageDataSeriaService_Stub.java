package dataservice.warehousedataservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import po.Garage;
import po.GarageBodyPO;
import po.GaragePlacePO;
import po.garageitem;

public class GarageDataSeriaService_Stub implements GarageDataSeriaService {

	@Override
	public void init(String address) throws IOException {
		// TODO Auto-generated method stub
		Garage g = new Garage();
		g.creat();
		File file = new File(address);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(g);
		oos.flush();
		oos.close();
		fos.close();
	}

	@Override
	public void insert(String address, garageitem item) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Garage g = getGarage(address);
		GaragePlacePO po = g.buildPlace();
		GarageBodyPO p = new GarageBodyPO(po, item);
		g.list.add(p);
		g.setTemp(g.getTemp() + 1);
		breakTxt(address);// 删除原来的
		File file = new File(address);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(g);
		oos.flush();
		oos.close();
		fos.close();

	}

	@Override
	public garageitem find(String address, long id) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File file = new File(address);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Garage g = (Garage) ois.readObject();
		garageitem item = null;
		for (int i = 0; i < g.list.size(); i++) {
			if (g.list.get(i).getItem().getId() == id) {
				item = g.list.get(i).getItem();
				break;
			}
		}
		breakTxt(address);// 删除原来的
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(g);
		oos.flush();
		oos.close();
		fos.close();

		return item;
	}

	@Override
	public void delete(String address, long id) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File file = new File(address);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Garage g = (Garage) ois.readObject();
		for (int i = 0; i < g.list.size(); i++) {
			if (g.list.get(i).getItem().getId() == id) {
				g.list.remove(i);
				break;
			}
		}

		g.setTemp(g.getTemp() - 1);

		breakTxt(address);// 删除原来的
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(g);
		oos.flush();
		oos.close();
		fos.close();

	}

	@Override
	public double rate(String address) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Garage g = getGarage(address);
		double m = g.getpercent();
		return m;
	}

	@Override
	public void destroy(String address) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Garage g = getGarage(address);
		g.list.clear();
		breakTxt(address);// 删除原来的
		File file = new File(address);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(g);
		oos.flush();
		oos.close();
		fos.close();
	}

	@Override
	public void show(String address) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Garage g = getGarage(address);
		g.show();
	}

	@Override
	public void breakTxt(String address) {
		// TODO Auto-generated method stub
		try {
			File f5 = new File(address);
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {

		}

	}

	@Override
	public Garage getGarage(String address) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File file = new File(address);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Garage g = (Garage) ois.readObject();
		return g;
	}

}
