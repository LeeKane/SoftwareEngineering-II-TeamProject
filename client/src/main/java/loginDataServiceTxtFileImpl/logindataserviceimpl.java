package loginDataServiceTxtFileImpl;

import java.rmi.RemoteException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import po.WarePO;
import po.AccountPO;
import util.Permission;
import dataservice.logindataservice.LoginDataService;

public class logindataserviceimpl implements LoginDataService{

	@Override
	public AccountPO find(long id) throws IOException  {
		// TODO Auto-generated method stub
		AccountPO po=new AccountPO(151538,Permission.MANAGER,"jdames","bryant");
		FileReader fr=new FileReader("TxtData/login.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			if(output[0].equals(String.valueOf(id))){
				 po=new AccountPO(id,Permission.toPermission(output[1]),output[2],output[3]);
				
				
				break;
		}
			else{
				Line = br.readLine();
			}
		}
		if(Line==null){
			System.out.println("ID NOT EXIST");
		}
		
		return po;
	}

	@Override
	public void insert(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		File loginfile=new File("TxtData/login.txt");
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(loginfile,true),"UTF-8"); 
			    itemWriter.write(po.getid()+"");
	            itemWriter.write(":");
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
		try 
		   {    
		 File f5 = new File("TxtData/login.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
