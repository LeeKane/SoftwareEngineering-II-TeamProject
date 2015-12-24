package bl.review;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.reviewblservice.InstituteBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.reviewdataservice.InstituteDataService;
import dataservice.warehousedataservice.GarageDataSeriaService;
import po.InstitutePO;
import util.City;
import util.OrgType;
import vo.InstituteVO;

public class InstituteManager implements InstituteBLService {
	private DataFactoryService dataFactory;
	private InstituteDataService isd;
	private ArrayList<InstituteVO> voList;
    private GarageDataSeriaService gd;
    
	@Override
	public boolean instituteUpdate(ArrayList<InstituteVO> voList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < voList.size(); i++) {
			InstituteVO vo = voList.get(i);
			InstitutePO po = new InstitutePO(vo.getCity(), vo.getOrg(), vo.getId());
			// System.out.println(vo.getId()+"
			// "+vo.getPermission1().toString()+" "+vo.getUsername()+"
			// "+vo.getPassword());
			try {
				isd.update(po);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public ArrayList<InstituteVO> findAll() {
		// TODO Auto-generated method stub
		dataFactory = new DataFactory();
		isd = dataFactory.getInstituteData();
		ArrayList<InstituteVO> voList = new ArrayList<InstituteVO>();
		ArrayList<InstitutePO> poList = new ArrayList<InstitutePO>();
		try {
			poList = isd.findAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < poList.size(); i++) {
			InstitutePO po = poList.get(i);
			InstituteVO vo = new InstituteVO(po.getCity(), po.getOrg(), po.getId());
			voList.add(vo);
		}
		return voList;
	}

	@Override
	public InstituteVO addAccount(City city, OrgType org) {
		// TODO Auto-generated method stub
		voList = new ArrayList<InstituteVO>();
		String id = "";
		try {
			id = (Long.parseLong(isd.findlast(city, org).getId()) + 1) + "";
		} catch (IOException e) {
			e.printStackTrace();
		}
		InstituteVO vo = new InstituteVO(city, org, id);
		voList.add(vo);
		InstitutePO po = new InstitutePO(city, org, id);
		try {
			isd.insert(po);
			if(org==OrgType.CENTER){
				gd=DataFactory.getGarageData();
				gd.initgarage(Long.parseLong(id));
			}
				
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public boolean deleteAccount(String id) {
		// TODO Auto-generated method stub
		try {
			isd.delete(id);
			// InstitutePO po=isd.find(id);
			// InstituteVO vo=new InstituteVO(po.getCity(),po.getOrg(),id);
			// voList.remove(vo);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
