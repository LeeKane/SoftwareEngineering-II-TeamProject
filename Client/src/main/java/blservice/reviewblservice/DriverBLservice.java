package blservice.reviewblservice;

import java.util.ArrayList;

import po.AccountPO;
import po.TimePO;
import vo.DriverVO;

public interface DriverBLservice {
	public ArrayList<DriverVO> findAll();

	public DriverVO addDriver(long number, String name, TimePO birthday, String iD, String tel, String carunit,
			String sex, TimePO licensedate);

	public boolean deleteDriver(long number);

	public boolean Upate(ArrayList<DriverVO> vo);

	public AccountPO getPo();
}
