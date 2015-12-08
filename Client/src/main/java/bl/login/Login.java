package bl.login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import blservice.loginblservice.LoginBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.logindataservice.LoginDataService;
import po.AccountPO;
import util.ResultMessage;

public class Login implements LoginBLService{
private LoginDataService ld;
private AccountPO po;
private DataFactoryService dataFactory;

	@Override
	public AccountPO login(String account, String password)  {
		// TODO Auto-generated method stub
			dataFactory=new DataFactory();
			ld=dataFactory.getLoginData();		
		
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
        	  JOptionPane.showMessageDialog(null, "无此账号！", "", JOptionPane.ERROR_MESSAGE);
        	  return null;
          }
          else 
          {
        	  if(!password.equals(po.getPassword())){
        		  JOptionPane.showMessageDialog(null, "密码错误！", "", JOptionPane.ERROR_MESSAGE);
        		  return null;
        	  }
        	  else 
        		  return po;
          }
	}

	@Override
	public ResultMessage addAcount(AccountPO po) {
		// TODO Auto-generated method stub
		return null;
	}

}
