package blservice.listblservice;

import po.AccountPO;
import po.TimePO;
import util.ListState;
import vo.list.ReceiveCourierListVO;

public interface ReceiveCourierListBLService {

	public ReceiveCourierListVO addReceiveCourierList(TimePO time, long id, String name, String cellphoneNum,
			ListState state);

	public boolean submit();

	public AccountPO getPo();
}
