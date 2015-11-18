package dataservice.logindataservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.rmi.RemoteException;

import po.AccountPO;
import util.*;

public class Logindataservice_Stub implements LoginDataService {

	AccountPO po=new AccountPO(151235,Permission.MANAGER,"kobe","bryant");
	
	@Override
	public AccountPO find(long id) throws IOException {
		// TODO Auto-generated method stub
		
		FileReader fr=new FileReader("TxtData/login.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		String output[]=Line.split(":");
		while(Line!=null){
			if(Long.parseLong(output[0])==id){
				AccountPO po=new AccountPO(id,Permission.MANAGER,output[2],output[3]);
				break;
		}
			else{
				Line = br.readLine();
			}
		}
		return po;
	}

	@Override
	public void insert(AccountPO po) throws RemoteException {
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
		System.out.println("INIT SUCCESS");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FINISH SUCCESS");
	}

}
