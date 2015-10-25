/**
 * 账户管理业务逻辑接口
 */
package blservice.accountblservice;

public class AccountBLService {
	//输入职员id，显示该职员的账号信息
	Public ResultMessage accountRev (Staff id);
	
	//输入的职员id,修改该账号的权限
	Public ResultMessage permissionUpate (Staff id,Permission permission);
}
