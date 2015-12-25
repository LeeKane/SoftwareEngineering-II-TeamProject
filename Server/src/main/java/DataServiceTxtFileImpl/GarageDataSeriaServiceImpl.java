package DataServiceTxtFileImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.warehousedataservice.GarageDataSeriaService;
import po.Garage;
import po.GarageBodyPO;
import po.GaragePlacePO;
import po.garageitem;

public class GarageDataSeriaServiceImpl extends UnicastRemoteObject implements GarageDataSeriaService {

	public GarageDataSeriaServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(String address) throws RemoteException, IOException {
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
	public void insert(String address, garageitem item) throws RemoteException, IOException, ClassNotFoundException {
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
	public void initgarage(long centerid) throws RemoteException{		
		String address = "TxtData/"+centerid+"_plane.txt";
		String address2 = "TxtData/"+centerid+".txt";
		String address3 = "TxtData/"+centerid+"_motor.txt";
		String address4 = "TxtData/"+centerid+"_train.txt";
		try {
			init(address4);
			init(address);
			init(address2);
			init(address3);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public GaragePlacePO find(String address, long id) throws RemoteException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File file = new File(address);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Garage g = (Garage) ois.readObject();
		GaragePlacePO item = null;
		for (int i = 0; i < g.list.size(); i++) {
			if (g.list.get(i).getItem().getId() == id) {
				item = g.list.get(i).getPlace();
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
	public void delete(String address, long id) throws RemoteException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File file = new File(address);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Garage g = (Garage) ois.readObject();
		for (int i = 0; i < g.list.size(); i++) {
			if (g.list.get(i).getItem().getId() == id) {
				g.delete(g.list.get(i).getItem());
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

	}

	@Override
	public double rate(String address) throws RemoteException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Garage g = getGarage(address);
		double m = g.getpercent();
		return m;
	}

	@Override
	public void destroy(String address) throws RemoteException, ClassNotFoundException, IOException {
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
	public void show(String address) throws RemoteException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Garage g = getGarage(address);
		g.show();
	}

	@Override
	public void breakTxt(String address) throws RemoteException{
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
	public Garage getGarage(String address) throws RemoteException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File file = new File(address);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Garage g = (Garage) ois.readObject();
		return g;
	}

	@Override
	public boolean insertByPlace(String address, garageitem item, GaragePlacePO place)
			throws RemoteException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		boolean contain=false;
		Garage g = getGarage(address);
		contain=g.insertByPlace(item, place);
		
		breakTxt(address);// 删除原来的
		File file = new File(address);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(g);
		oos.flush();
		oos.close();
		fos.close();
		return contain;
	}

	

}
