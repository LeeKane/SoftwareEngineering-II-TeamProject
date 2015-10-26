package blservice.inquireblservice;

import util.ResultMessage;

public class InquireBLService_Driver {
	public void drive(InquireBLService inquireBLService){
		ResultMessage result=inquireBLService.inquire(1);
		if(result==ResultMessage.SUCCESS)
			System.out.println("Inquire Succeeded!");
			
		inquireBLService.endInquire();
	}
	
	public static void main(String[] args) {
		InquireBLService inquireBLService=new InquireBLService_Stub();
		InquireBLService_Driver driver=new InquireBLService_Driver();
		driver.drive(inquireBLService);
	}
}
