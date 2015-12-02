package DataServiceTxtFileImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.rmi.RemoteException;

import po.WarePO;
import po.AccountPO;
import util.Permission;
import dataservice.logindataservice.LoginDataService;
//登录界面
public class logindataserviceimpl implements LoginDataService{

	@Override
	public AccountPO find(String username) throws IOException {
		// TODO Auto-generated method stub
		AccountPO po=null;
		FileReader fr=new FileReader("TxtData/login.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			if(output[2].equals(String.valueOf(username))){
				 po=new AccountPO(Long.parseLong(output[0]),Permission.toPermission(output[1]),output[2],output[3]);
			
				break;
		}
			else{
				Line = br.readLine();
			}
		}
		if(Line==null){
			System.out.println("USERNAME NOT EXIST");
		}
		
		return po;
	}



	@Override
	public void insert(AccountPO po) throws RemoteException {
		File loginfile=new File("TxtData/login.txt");
		if(po==null){
			;
		}if(po!=null){
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
		System.out.println("FINISH SUCCESS");
	}



	@Override
	public boolean login(String username, String password) throws IOException {
		// TODO Auto-generated method stub
	
		FileReader fr=new FileReader("TxtData/login.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			if(output[2].equals(username)&&output[3].equals(password)){
				System.out.println("login success");
				return true;
			}
			else{
				Line = br.readLine();
			}
		}
		if(Line==null){
			System.out.println("login failure");
		}
		
		return false;	
	}

	
	
	
	
}
