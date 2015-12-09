package blservice.loginblservice;

import po.AccountPO;
import util.ResultMessage;

public interface LoginBLService {// 登录管理
	// 根据对应权限，显示相对应的界面
	public AccountPO login(String account, String password);

	public ResultMessage addAcount(AccountPO po);
}
