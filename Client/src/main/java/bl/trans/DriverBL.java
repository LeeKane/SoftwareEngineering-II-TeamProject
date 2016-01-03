package bl.trans;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.reviewblservice.DriverBLservice;
import dataimpl.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.transdataservice.DriverDataService;
import po.AccountPO;
import po.DriverPO;
import po.TimePO;
import vo.DriverVO;

public class DriverBL implements DriverBLservice {
	private DriverDataService cd;
	private ArrayList<DriverVO> voList;
	private DataFactoryService dataFactory;
	private AccountPO po;

	public DriverBL(AccountPO po) {
		super();
		this.po = po;
	}

	@Override
	public AccountPO getPo() {
		return po;
	}

	@Override
	public ArrayList<DriverVO> findAll() {
		// TODO Auto-generated method stub
		dataFactory = new DataFactory();
		cd = dataFactory.getDriverData();
		ArrayList<DriverVO> voList = new ArrayList<DriverVO>();
		ArrayList<DriverPO> poList = new ArrayList<DriverPO>();
		try {
			poList = cd.findAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < poList.size(); i++) {
			DriverPO po = poList.get(i);
			DriverVO vo = new DriverVO(po.getNumber(), po.getName(), po.getBirthday(), po.getID(), po.getTel(),
					po.getCarunit(), po.getSex(), po.getLicensedate());
			voList.add(vo);
		}
		return voList;

	}

	@Override
	public DriverVO addDriver(long number, String name, TimePO birthday, String iD, String tel, String carunit,
			String sex, TimePO licensedate) {
		// TODO Auto-generated method stub
		voList = new ArrayList<DriverVO>();
		long id = 1111111111;
		try {
			id = cd.findlast().getNumber() + 1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		DriverVO vo = new DriverVO(id, name, birthday, iD, tel, carunit, sex, licensedate);
		voList.add(vo);
		DriverPO po = new DriverPO(id, name, birthday, iD, tel, carunit, sex, licensedate);
		System.out.println(sex);
		try {
			cd.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public boolean deleteDriver(long number) {
		// TODO Auto-generated method stub
		try {
			cd.delete(number);
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
	public boolean Upate(ArrayList<DriverVO> voList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < voList.size(); i++) {
			DriverVO vo = voList.get(i);
			DriverPO po = new DriverPO(vo.getNumber(), vo.getName(), vo.getBirthday(), vo.getID(), vo.getTel(),
					vo.getCarunit(), vo.getSex(), vo.getLicensedate());
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
