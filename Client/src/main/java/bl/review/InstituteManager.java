package bl.review;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import DataServiceTxtFileImpl.InstituteDataServiceTxtImpl;
import blservice.reviewblservice.InstituteBLService;
import dataservice.reviewdataservice.InstituteDataService;
import po.AccountPO;
import po.InstitutePO;
import util.City;
import util.OrgType;
import vo.AccountVO;
import vo.InstituteVO;

public class InstituteManager implements InstituteBLService{
    private InstituteDataService isd;
    private ArrayList<InstituteVO> voList;

	@Override
	public boolean instituteUpdate(ArrayList<InstituteVO> voList) {
		// TODO Auto-generated method stub
		for(int i = 0; i<voList.size();i++){	
			InstituteVO vo=voList.get(i);
			InstitutePO po=new InstitutePO(vo.getCity(),vo.getOrg(),vo.getId());
//			System.out.println(vo.getId()+" "+vo.getPermission1().toString()+" "+vo.getUsername()+" "+vo.getPassword());
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
		isd=new InstituteDataServiceTxtImpl();
		ArrayList<InstituteVO> voList=new ArrayList<InstituteVO>();
    	ArrayList<InstitutePO> poList=new ArrayList<InstitutePO>();
    	try {
			poList=isd.findAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(int i = 0; i<poList.size();i++)
    	{
    		InstitutePO po=poList.get(i);
    		InstituteVO vo=new InstituteVO(po.getCity(),po.getOrg(),po.getId());
    		voList.add(vo);
    	}
		return voList;
	}

	@Override
	public InstituteVO addAccount(City city, OrgType org) {
		// TODO Auto-generated method stub
		voList=new  ArrayList<InstituteVO>();
		String id="";
		try {
			id=(Long.parseLong(isd.findlast(city,org).getId())+1)+"";
		} catch (IOException e) {
			e.printStackTrace();
		}
		InstituteVO vo=new InstituteVO(city,org,id);
		voList.add(vo);
		InstitutePO po=new InstitutePO(city,org,id);
		isd.insert(po);
		return vo;
	}

	@Override
	public boolean deleteAccount(String id) {
		// TODO Auto-generated method stub
		try {
			isd.delete(id);
//			InstitutePO po=isd.find(id);
//			InstituteVO vo=new InstituteVO(po.getCity(),po.getOrg(),id);
//			voList.remove(vo);
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
