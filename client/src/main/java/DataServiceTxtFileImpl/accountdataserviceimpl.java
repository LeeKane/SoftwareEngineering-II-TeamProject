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

import po.AccountPO;
import util.Permission;
import dataservice.accountdataservice.AccountDataService;

public class AccountDataServiceImpl implements AccountDataService {

public AccountPO find(long id) throws IOException {
		
		AccountPO po=null;
		FileReader fr=new FileReader("TxtData/acount.txt");
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
		File loginfile=new File("TxtData/acount.txt");
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
		System.out.println("INSERT SUCCESS");

	}

	@Override
	public void delete(AccountPO po) throws IOException {
		// TODO Auto-generated method stub
		if(po==null){
			;
		}else{
long id=po.getid();
		
		File accounttempfile=new File("TxtData/accountTemp.txt");
		 OutputStreamWriter itemWriter = new OutputStreamWriter(
					new FileOutputStream(accounttempfile,true),"UTF-8"); 
		 
		 try 
		   {    
		 File f5 = new File("TxtData/accountTemp.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		FileReader fr = null;
		fr = new FileReader("TxtData/acount.txt");
		String Line=null;
		String temp=null;
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 Line=br.readLine();
		
		 while(Line!=null){
			String output[]=Line.split(":");
			
			if(Long.parseLong(output[0])!=id){
				
				itemWriter.write(Line);
				itemWriter.write("\r\n");
	      
			}if(Long.parseLong(output[0])==id){
				;
			}
			
			Line=br.readLine();
		}
		itemWriter.close();
		
		FileReader fr2 = null;
		fr2 = new FileReader("TxtData/accountTemp.txt");
		String Line2=null;
	
		BufferedReader br2 = null;
		 br2 = new BufferedReader(fr2);
		 Line2=br2.readLine();
		init();
		File financetempfile2=new File("TxtData/acount.txt");
		 OutputStreamWriter itemWriter2 = new OutputStreamWriter(
					new FileOutputStream(financetempfile2,true),"UTF-8"); 
		while(Line2!=null){
			itemWriter2.write(Line2);
			itemWriter2.write("\r\n");
			Line2=br2.readLine();
		}
		itemWriter2.close();
		 try 
		   {    
		 File f5 = new File("TxtData/accountTemp.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		
		}
		System.out.println("DELETE SUCCESS!");

	}

	@Override
	public void update(AccountPO po) throws IOException {
		// TODO Auto-generated method stub
		delete(po);
		insert(po);
		System.out.println("UPDATE SUCCESS");

	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		try 
		   {    
		 File f5 = new File("TxtData/acount.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		System.out.println("INIT SUCCESS");

	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FINISH SUCCESS");

	}

}
