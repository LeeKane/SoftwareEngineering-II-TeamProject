package bl.trans;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.reviewblservice.CarBLservice;
import dataimpl.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.transdataservice.CarDataService;
import po.AccountPO;
import po.CarPO;
import po.TimePO;
import util.Vehicle;
import vo.CarVO;

public class CarBL implements CarBLservice {
	private CarDataService cd;
	private ArrayList<CarVO> voList;
	private DataFactoryService dataFactory;
	private AccountPO po;

	public CarBL(AccountPO po) {
		super();
		this.po = po;
	}

	@Override
	public AccountPO getPo() {
		return po;
	}

	@Override
	public ArrayList<CarVO> findAll() {
		// TODO Auto-generated method stub
		dataFactory = new DataFactory();
		cd = dataFactory.getCarData();
		ArrayList<CarVO> voList = new ArrayList<CarVO>();
		ArrayList<CarPO> poList = new ArrayList<CarPO>();
		try {
			poList = cd.findAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < poList.size(); i++) {
			CarPO po = poList.get(i);
			CarVO vo = new CarVO(po.getVehicle(), po.getName(), po.getEngine(), po.getCarNum(), po.getBasenumber(),
					po.getBuytime(), po.getUsetime());
			voList.add(vo);
		}
		return voList;

	}

	@Override
	public CarVO addCar(Vehicle vehicle, String name, long engine, String carNum, long basenumber, TimePO buytime,
			TimePO usetime) {
		// TODO Auto-generated method stub
		voList = new ArrayList<CarVO>();
		long id = 1111111111;
		try {
			id = Long.parseLong(cd.findlast().getName()) + 1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		CarVO vo = new CarVO(vehicle, id + "", engine, carNum, basenumber, buytime, usetime);
		voList.add(vo);
		CarPO po = new CarPO(vehicle, id + "", engine, carNum, basenumber, buytime, usetime);
		try {
			cd.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public boolean deleteCar(String name) {
		// TODO Auto-generated method stub
		try {
			cd.delete(name);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean Upate(ArrayList<CarVO> voList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < voList.size(); i++) {
			CarVO vo = voList.get(i);
			CarPO po = new CarPO(Vehicle.CAR, vo.getName(), vo.getEngine(), vo.getCarname(), vo.getBasenumber(),
					vo.getBuytime(), vo.getUsetime());
			// System.out.println(vo.getId()+"
			// "+vo.getPermission1().toString()+" "+vo.getUsername()+"
			// "+vo.getPassword());
			try {
				cd.update(po);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

}
