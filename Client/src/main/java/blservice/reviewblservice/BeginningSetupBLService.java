package blservice.reviewblservice;

import java.util.ArrayList;

import po.AccountPO;
import po.TimePO;
import vo.SetupVO;

public interface BeginningSetupBLService {
	public void swapDefault(SetupVO vo1, SetupVO vo2);

	public boolean setupUpdate(ArrayList<SetupVO> vo);

	public ArrayList<SetupVO> findAll();

	public SetupVO addSetup(TimePO timePO, String name, String remark, boolean isSelected);

	public boolean deleteSetup(String time);

	public AccountPO getPo();
}
