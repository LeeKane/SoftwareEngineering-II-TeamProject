package blservice.accountblservice;

import blservice.inquireblservice.InquireBLService;
import blservice.inquireblservice.InquireBLService_Driver;
import blservice.inquireblservice.InquireBLService_Stub;
import util.Permission;
import util.ResultMessage;

public class AccountBLService_Driver {
	public void drive(AccountBLService accountBLService){
		ResultMessage result=accountBLService.accountRev(1);
		if(result==ResultMessage.SUCCESS)
			System.out.println("Account Succeeded!");
		
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
