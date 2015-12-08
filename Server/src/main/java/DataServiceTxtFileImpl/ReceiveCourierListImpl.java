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
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.listdataservice.ReceiveCourierListDataService;
import po.TimePO;
import po.list.ReceiveCourierListPO;
import util.ListState;

public class ReceiveCourierListImpl extends UnicastRemoteObject implements ReceiveCourierListDataService{

	public ReceiveCourierListImpl() throws RemoteException, RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(ReceiveCourierListPO po) throws RemoteException{
		// TODO Auto-generated method stub
		File ReceiveCourierListFile=new File("TxtData/ReceiveCourierList.txt");
		if(po!=null){
			try {
				OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(ReceiveCourierListFile,true),"UTF-8");
			    
				itemWriter.write(po.getId()+"");
		        itemWriter.write(":");
		        itemWriter.write(po.getTime().toString()+"");
		        itemWriter.write(":");
		        itemWriter.write(po.getName()+"");
		        itemWriter.write(":");
		        itemWriter.write(po.getCellphoneNum()+"");
		        itemWriter.write(":");
		        itemWriter.write(po.getState().toString()+"");
	            itemWriter.write("\r\n");
	            itemWriter.close();				
			} catch (UnsupportedEncodingException | FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

	@Override
	public void delete(long id) throws RemoteException, IOException{
		// TODO Auto-generated method stub
		
		File accounttempfile=new File("TxtData/Temp.txt");
		 OutputStreamWriter itemWriter = new OutputStreamWriter(
					new FileOutputStream(accounttempfile,true),"UTF-8"); 
		 
		 try 
		   {    
		 File f5 = new File("TxtData/Temp.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		FileReader fr = null;
		fr = new FileReader("TxtData/ReceiveCourierList.txt");
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
		fr2 = new FileReader("TxtData/Temp.txt");
		String Line2=null;
	
		BufferedReader br2 = null;
		 br2 = new BufferedReader(fr2);
		 Line2=br2.readLine();
		init();
		File financetempfile2=new File("TxtData/ReceiveCourierList.txt");
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
		 File f5 = new File("TxtData/Temp.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		
	}

	@Override
	public ReceiveCourierListPO find(long id) throws RemoteException, IOException {
		// TODO Auto-generated method stub
		ReceiveCourierListPO po=null;
		FileReader fr=new FileReader("TxtData/ReceiveCourierList.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			if(output[0].equals(String.valueOf(id))){
				 po=new ReceiveCourierListPO(TimePO.toTime(output[1]),id,output[2],output[3],ListState.toState(output[4]));	
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
	public void init() throws RemoteException{
		// TODO Auto-generated method stub
		try 
		   {    
		 File f5 = new File("TxtData/ReceiveCourierList.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
	}

	@Override
	public void update(ReceiveCourierListPO po) throws RemoteException, IOException {
		// TODO Auto-generated method stub
		delete(po.getId());
		insert(po);
	}

}
