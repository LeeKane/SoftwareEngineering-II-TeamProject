/**
 * 账户管理业务逻辑接口
 */
package blservice.accountblservice;

import po.AccountPO;
import util.*;

public interface AccountBLService {
	//输入职员id，显示该职员的账号信息
	public AccountPO accountRev (long id) ;
	//输入的职员id,修改该账号的权限
	public ResultMessage permissionUpate (long id, Permission permission) ;
	
	public void endAccount();
}
