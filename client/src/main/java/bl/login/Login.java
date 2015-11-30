package bl.login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import po.AccountPO;
import util.ResultMessage;
import DataServiceTxtFileImpl.logindataserviceimpl;
import blservice.loginblservice.LoginBLService;
import dataservice.logindataservice.LoginDataService;

public class Login implements LoginBLService{
private LoginDataService ld=new logindataserviceimpl();
private AccountPO po;
	@Override
	public String login(String account, String password)  {
		// TODO Auto-generated method stub
			try {
				po=ld.find(account);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          if(po==null)
          {
        	  return "用户名不存在";
          }
          else 
          {
        	  if(password!=po.getPassword())
        	 return "密码错误";
        	  else 
        		  return po.getPermission().toString();
          }
	}

	@Override
	public ResultMessage addAcount(AccountPO po) {
		// TODO Auto-generated method stub
		return null;
	}

}
