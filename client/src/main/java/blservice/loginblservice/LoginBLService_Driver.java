package blservice.loginblservice;

import util.*;

public class LoginBLService_Driver {
  public void drive(LoginBLService service){
	  ResultMessage result;
	  result=service.login(12345,"abc");
	  if(result==ResultMessage.SUCCESS){
		  System.out.println("LOGIN SUCCESS");
	  }
  }
	
  public static void main(String[] args){
	  LoginBLService LoginBLService=new LoginBLService_Stub();
		LoginBLService_Driver driver=new LoginBLService_Driver();
		driver.drive(LoginBLService);
	  
  }
}
