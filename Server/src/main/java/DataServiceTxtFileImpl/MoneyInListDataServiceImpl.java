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
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dataservice.listdataservice.MoneyInListDataService;
import dataservice.listdataservice.OrderListDataService;
import po.AccountPO;
import po.StaffPO;
import po.TimePO;
import po.list.MoneyInListPO;
import po.list.OrderListPO;
import util.City;
import util.ListState;
import util.OrgType;
import util.Permission;
import vo.InstituteVO;

public class MoneyInListDataServiceImpl extends UnicastRemoteObject implements MoneyInListDataService{

	protected MoneyInListDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try 
		   {    
		 File f5 = new File("TxtData/MoneyInList.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
	}

	@Override
	public boolean MoneyInUpdate(ArrayList<MoneyInListPO> po) throws IOException {
		// TODO Auto-generated method stub
		String toAdd=delete(po);
		System.out.println(toAdd);
		if(toAdd!=null)
			insert(po,toAdd);
		else
			insert(po);
		return true;
	}

	@Override
	public ArrayList<MoneyInListPO> findAll(AccountPO po) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<MoneyInListPO> result=new ArrayList<MoneyInListPO>();
		ArrayList<String> toDelete=delete();
		FileReader fr=new FileReader("TxtData/orderlist.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		 while(Line!=null){
			String output[]=Line.split(":");
			boolean isExist=false;
			for(String id:toDelete){
				if(output[0].equals(id)){
					isExist=true;
					break;
				}
			}
			
			if(!isExist){
				if(output[output.length-1].equals(po.getUsername())){
					Date now=Calendar.getInstance().getTime();
					TimePO time=time = new TimePO(now.getYear()+1900, now.getMonth()+1, now.getDate(), now.getHours(), now.getMinutes(), now.getSeconds());
					
					String moneyStr=output[output.length-3];
					String moneyArray[]=moneyStr.split(",");
					double money=Double.parseDouble(moneyArray[6]);
					MoneyInListPO mpo=new MoneyInListPO(time, money, po, Long.parseLong(output[0]),false);
					result.add(mpo);
				}	
			}
			
			Line = br.readLine();
		}
		 
		 
		return result;
	}

	@Override
	public ArrayList<String> delete() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<String> todelete=new ArrayList<String>();
		FileReader fr=new FileReader("TxtData/MoneyInList.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		 while(Line!=null){
			String output[]=Line.split(":");
			String idStr=output[3];
			String id[]=idStr.split(";");
			for(int i=0;i<id.length;i++){
				todelete.add(id[i]);
			}
			Line=br.readLine();
		}
		return todelete;
	}

	@Override
	public void insert(ArrayList<MoneyInListPO> list) {
		// TODO Auto-generated method stub
		File loginfile=new File("TxtData/MoneyInList.txt");
		if(list!=null){
		try {	
				MoneyInListPO po1=list.get(0);
				OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(loginfile,true),"UTF-8"); 
			   
				double total=0;
				String idStr="";
				
				for(MoneyInListPO po:list){
					total=total+po.getMoney();
					idStr=idStr+po.getId()+";";
				}
				
			    itemWriter.write(po1.getAccount().getUsername());
	            itemWriter.write(":");
	            itemWriter.write(po1.getTime().toSpecicalString());
	            itemWriter.write(":");
	            itemWriter.write(total+"");
	            itemWriter.write(":");
	            itemWriter.write(idStr);
	            itemWriter.write(":");
	            itemWriter.write("未审批");
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
	
	public void insert(ArrayList<MoneyInListPO> list,String toAdd) {
		// TODO Auto-generated method stub
		File loginfile=new File("TxtData/MoneyInList.txt");
		if(list!=null){
		try {	
				MoneyInListPO po1=list.get(0);
				OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(loginfile,true),"UTF-8"); 
			   
				double total=0;
				String idStr="";
				
				for(MoneyInListPO po:list){
					total=total+po.getMoney();
					idStr=idStr+po.getId()+";";
				}
				
				String add[]=toAdd.split(":");
				
				total+=Double.parseDouble(add[add.length-3]);
				idStr+=add[add.length-2];
				
			    itemWriter.write(po1.getAccount().getUsername());
	            itemWriter.write(":");
	            itemWriter.write(po1.getTime().toSpecicalString());
	            itemWriter.write(":");
	            itemWriter.write(total+"");
	            itemWriter.write(":");
	            itemWriter.write(idStr);
	            itemWriter.write(":");
	            itemWriter.write("未审批");
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
	public void update(ArrayList<MoneyInListPO> po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<AccountPO> findAllCourier(AccountPO po) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<AccountPO> result=new ArrayList<AccountPO>();
		FileReader fr=new FileReader("TxtData/login.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		 while(Line!=null){
			 String output[]=Line.split(":");
			 if(output[1].equals("快递员")){
				 AccountPO courierPO=new AccountPO(Long.parseLong(output[0]), Permission.toPermission(output[1]), output[2], output[3],new StaffPO("11010","1002",City.BEIJING,OrgType.HALL,Permission.COURIER));
				 result.add(courierPO);
			 }
			 Line = br.readLine();
		 }
		return result;
	}
	
	public String delete(ArrayList<MoneyInListPO> po) throws IOException{
		File accounttempfile=new File("TxtData/MoneyInListTemp.txt");
		 OutputStreamWriter itemWriter = new OutputStreamWriter(
					new FileOutputStream(accounttempfile,true),"UTF-8"); 
		 
		 try 
		   {    
		 File f5 = new File("TxtData/MoneyInListTemp.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		FileReader fr = null;
		fr = new FileReader("TxtData/MoneyInList.txt");
		String toReturn=null;
		String Line=null;
		String temp=null;
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 Line=br.readLine();
		
		 Date now=Calendar.getInstance().getTime();
		 TimePO time = new TimePO(now.getYear()+1900, now.getMonth()+1, now.getDate(), now.getHours(), now.getMinutes(), now.getSeconds());
		 
		 while(Line!=null){
			String output[]=Line.split(":");
			
			if(!(output[0].equals(po.get(0).getAccount().getUsername())&&output[1].equals(time.toSpecicalString()))){
				
				itemWriter.write(Line);
				itemWriter.write("\r\n");
	      
			}
			if(output[0].equals(po.get(0).getAccount().getUsername())&&output[1].equals(time.toSpecicalString())){
				toReturn=Line;
				break;
			}
			
			Line=br.readLine();
		}
		itemWriter.close();
		
		FileReader fr2 = null;
		fr2 = new FileReader("TxtData/MoneyInListTemp.txt");
		String Line2=null;
	
		BufferedReader br2 = null;
		 br2 = new BufferedReader(fr2);
		 Line2=br2.readLine();
		init();
		File financetempfile2=new File("TxtData/MoneyInList.txt");
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
		 File f5 = new File("TxtData/MoneyInListTemp.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		 //System.out.println(toReturn);
		 return toReturn;
		}
}
