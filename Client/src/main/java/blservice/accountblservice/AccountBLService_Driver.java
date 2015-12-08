package blservice.accountblservice;

import po.AccountPO;
import util.Permission;
import util.ResultMessage;

public class AccountBLService_Driver {
	public void drive(AccountBLService accountBLService){
		AccountPO result=accountBLService.accountRev(1);
//		if(result==ResultMessage.SUCCESS)
//			System.out.println("Account Succeeded!");
		
		ResultMessage rm=accountBLService.permissionUpate(1,Permission.COURIER);
		if(rm==ResultMessage.SUCCESS)
			System.out.println("Account Succeeded!");
			
		accountBLService.endAccount();
		
	}
	public static void main(String[] args) {
		AccountBLService accountBLService=new AccountBLService_Stub();
		AccountBLService_Driver driver=new AccountBLService_Driver();
		driver.drive(accountBLService);
	}

}
