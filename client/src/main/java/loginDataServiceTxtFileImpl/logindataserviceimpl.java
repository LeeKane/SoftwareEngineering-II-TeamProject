package loginDataServiceTxtFileImpl;

import java.rmi.RemoteException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import po.WarePO;
import po.AccountPO;
import dataservice.logindataservice.LoginDataService;

public class logindataserviceimpl implements LoginDataService{

	@Override
	public AccountPO find(long id)  {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

	@Override
	public void insert(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		File loginfile=new File("TxtData/login.txt");
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(loginfile,true),"UTF-8"); 
	            itemWriter.write(po.getPermission().toString());
	            itemWriter.write(":");
	            itemWriter.write(po.getUsername().toString());
	            itemWriter.write(":");
	            itemWriter.write(po.getPassword().toString());
	            itemWriter.write("\r\n");
	            itemWriter.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
		
	

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
