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
import java.util.ArrayList;

import dataservice.financedataservice.FinanceDataService;
import po.InstitutePO;
import po.ReceiptPO;
import po.StaffPO;
import po.TimePO;
import util.City;
import util.OrgType;
import util.Permission;
//财务人员生成收款单
public class FinanceDataServiceTxtImpl extends UnicastRemoteObject implements FinanceDataService {
	protected FinanceDataServiceTxtImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReceiptPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		StaffPO staff=null;
		InstitutePO institute=null;
		TimePO time=null;
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

	@Override
	public void insert(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		File financefile=new File("TxtData/finance.txt");
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
		System.out.println("INSERT SUCCESS!");
	}

	@Override
	public void delete(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po==null){
			;
		}else{
         long id=po.getStaff().getId();
		
		File accounttempfile=new File("TxtData/accountTemp.txt");
		 OutputStreamWriter itemWriter = null;
		try {
			itemWriter = new OutputStreamWriter(
						new FileOutputStream(accounttempfile,true),"UTF-8");
		} catch (UnsupportedEncodingException | FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		 
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
		try {
			fr = new FileReader("TxtData/acount.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String Line=null;
		String temp=null;
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 try {
			Line=br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 while(Line!=null){
			String output[]=Line.split(":");
			
			if(Long.parseLong(output[0])!=id){
				
				try {
					itemWriter.write(Line);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					itemWriter.write("\r\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      
			}if(Long.parseLong(output[0])==id){
				;
			}
			
			try {
				Line=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			itemWriter.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		FileReader fr2 = null;
		try {
			fr2 = new FileReader("TxtData/accountTemp.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String Line2=null;
	
		BufferedReader br2 = null;
		 br2 = new BufferedReader(fr2);
		 try {
			Line2=br2.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		init();
		File financetempfile2=new File("TxtData/acount.txt");
		 OutputStreamWriter itemWriter2 = null;
		try {
			itemWriter2 = new OutputStreamWriter(
						new FileOutputStream(financetempfile2,true),"UTF-8");
		} catch (UnsupportedEncodingException | FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		while(Line2!=null){
			try {
				itemWriter2.write(Line2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				itemWriter2.write("\r\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Line2=br2.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			itemWriter2.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	public void update(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		delete(po);
		insert(po);
		System.out.println("UPDATE SUCCESS!");
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
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

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FINISH SUCCESS!");
	}

	@Override
	public ArrayList<ReceiptPO> creat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(ArrayList<ReceiptPO> p, ReceiptPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(ArrayList<ReceiptPO> p, ReceiptPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy(ArrayList<ReceiptPO> p) {
		// TODO Auto-generated method stub
		
	}

}
