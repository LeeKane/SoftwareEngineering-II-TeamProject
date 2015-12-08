package blservice.loginblservice;

import util.*;

public class LoginBLService_Driver {
  public void drive(LoginBLService service){
	  String result;
	  result=service.login("12345","abc");
	  if(!result.equals("用户名不存在")){
		  System.out.println("USERNAME NOT EXIST");
	  }
  }
	
  public static void main(String[] args){
	  LoginBLService LoginBLService=new LoginBLService_Stub();
		LoginBLService_Driver driver=new LoginBLService_Driver();
		driver.drive(LoginBLService);
	  
  }
}
