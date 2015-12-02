/**
 * 账户管理业务逻辑接口
 */
package blservice.accountblservice;

import java.util.ArrayList;

import po.AccountPO;
import util.Permission;
import util.ResultMessage;
import vo.AccountVO;

public interface AccountBLService {
	//输入职员id，显示该职员的账号信息
	public AccountPO accountRev (String username) ;
	//输入的职员id,修改该账号的权限
	public ResultMessage permissionUpate (long id, Permission permission) ;
	public ArrayList<AccountVO> findAll();
	public ResultMessage addAccount(long id,AccountPO po);
	public ResultMessage deleteAccount(long id);
	public void endAccount();
}