package blservice.loginblservice;

import util.ResultMessage;

public interface  LoginBLService {//登录管理
	//根据对应权限，显示相对应的界面
	public ResultMessage login(long account,String password);

}
