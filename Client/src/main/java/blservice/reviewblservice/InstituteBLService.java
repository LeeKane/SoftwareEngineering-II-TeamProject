package blservice.reviewblservice;

import java.util.ArrayList;
import java.util.Iterator;

import po.AccountPO;
import util.City;
import util.OrgType;
import vo.InstituteVO;

public interface InstituteBLService {

	public boolean instituteUpdate(ArrayList<InstituteVO> vo);

	public Iterator<InstituteVO> findAll();

	public InstituteVO addAccount(City city, OrgType org);

	public boolean deleteAccount(String id);

	public AccountPO getPo();

}
