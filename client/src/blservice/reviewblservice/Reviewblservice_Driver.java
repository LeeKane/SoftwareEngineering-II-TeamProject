package blservice.reviewblservice;

import util.*;

public class Reviewblservice_Driver {
	public void drive(ReviewBLService Service){
		ResultMessage result;
		 result=Service.addStaff(2,"John");
		  if(result==ResultMessage.SUCCESS)
				 System.out.println("ADD SUCCESS");
		 result=Service.removeStaff(2,"John"); 
				if(result==ResultMessage.SUCCESS)
			 System.out.println("REMOVE SUCCESS");
		Service.addOrg(0, "john");
		if(result==ResultMessage.SUCCESS)
			 System.out.println("ADD SUCCESS");
		Service.removeOrg(0,"john");
		if(result==ResultMessage.SUCCESS)
			 System.out.println("REMOVE SUCCESS");
		Service.setBAccount("john");
		if(result==ResultMessage.SUCCESS)
			 System.out.println("SET SUCCESS");
		Service.endReview();
		if(result==ResultMessage.SUCCESS)
			 System.out.println("END SUCCESS");
}
	public static void main(String[] args) {
		ReviewBLService ReviewBLService=new ReviewBLService_Stub();
		Reviewblservice_Driver driver=new Reviewblservice_Driver();
		driver.drive(ReviewBLService);
	}
}
