package dataservice.financedataservice;
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

import po.InstitutePO;
import po.ReceiptPO;
import po.StaffPO;
import po.TimePO;
import util.City;
import util.OrgType;
import util.Permission;
public class Financedataservice_Stub implements FinanceDataService {
	public ReceiptPO find(long id) throws RemoteException{
		ReceiptPO po=null;
		FileReader fr = null;
		
		try {
			fr = new FileReader("TxtData/finance.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = null;
		try {
			Line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(Line!=null){
			String output[]=Line.split(":");
			String d[]= output[0].split(",");
			String inst[] = output[1].split(",");
			if(d[0].equals(String.valueOf(id))){
			
				StaffPO staff2=new StaffPO(Long.parseLong(d[0]),d[1],OrgType.toOrgType(d[2]),Permission.toPermission(d[3]));
				
				InstitutePO ins = new InstitutePO(City.toCity(inst[0]),OrgType.toOrgType(inst[1]),Long.parseLong(inst[2]));
				String t[] = output[3].split("y|m|d|h|s");
				TimePO time2=new TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),Integer.parseInt(t[3]),Integer.parseInt(t[4]),Integer.parseInt(t[5]));
				
				 po = new ReceiptPO(staff2,ins,Double.parseDouble(output[2]),time2);
				
				break;
		}
			else{
				try {
					Line = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(Line==null){
			System.out.println("ID NOT EXIST");
			return null;
		}
		
		return po;
		
	}
	//在数据库中增加po记录
	public void insert(ReceiptPO po) throws RemoteException {
		File financefile=new File("TxtData/finance.txt");
		if(po==null){
			
		}else
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(financefile,true),"UTF-8"); 
	            itemWriter.write(po.getStaff().getId()+","+po.getStaff().getName()+","+po.getStaff().getOrgType()+","+po.getStaff().getPermission());
	            itemWriter.write(":");
	            itemWriter.write(po.getInstitute().getCity()+","+po.getInstitute().getOrg()+","+po.getInstitute().getId());
	            itemWriter.write(":");
	            itemWriter.write(po.getMoney()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getTime()+"");
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
	//删除一个po
	public void delete(ReceiptPO po) throws IOException{
		if(po==null){
			;
		}else{
		long id=po.getStaff().getId();
		
		File financetempfile=new File("TxtData/financeTemp.txt");
		 OutputStreamWriter itemWriter = new OutputStreamWriter(
					new FileOutputStream(financetempfile,true),"UTF-8"); 
		 
		 try 
		   {    
		 File f5 = new File("TxtData/financeTemp.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		FileReader fr = null;
		fr = new FileReader("TxtData/finance.txt");
		String Line=null;
		String temp=null;
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 Line=br.readLine();
		
		 while(Line!=null){
			String output[]=Line.split(":");
			String d[]= output[0].split(",");
			if(Long.parseLong(d[0])!=id){
				
				itemWriter.write(Line);
				itemWriter.write("\r\n");
	      
			}if(Long.parseLong(d[0])==id){
				;
			}
			
			Line=br.readLine();
		}
		itemWriter.close();
		
		FileReader fr2 = null;
		fr2 = new FileReader("TxtData/financeTemp.txt");
		String Line2=null;
	
		BufferedReader br2 = null;
		 br2 = new BufferedReader(fr2);
		 Line2=br2.readLine();
		init();
		File financetempfile2=new File("TxtData/finance.txt");
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
		 File f5 = new File("TxtData/financeTemp.txt");
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
	//更新一个po
	public void update(ReceiptPO po) throws IOException{
		delete(po);
		insert(po);
		
		System.out.println("UPDATE SUCCESS!");
	}
	//初始化持久化数据库
	public void init() throws RemoteException{
		try 
		   {    
		 File f5 = new File("TxtData/finance.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		
	}
	//结束持久化数据库
	public void finish() throws RemoteException{
		System.out.println("FINISH SUCCESS!");
	}
	
	
}
