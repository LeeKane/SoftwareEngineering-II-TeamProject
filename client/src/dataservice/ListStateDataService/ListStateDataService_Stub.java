package dataservice.ListStateDataService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import po.InstitutePO;
import po.TimePO;
import po.WarePO;
import po.list.ArrivaListPO;
import po.list.DeliveryListPO;
import po.list.LoadingListPO;
import po.list.MoneyInListPO;
import po.list.MoneyOutListPO;
import po.list.OrderListPO;
import po.list.WareInListPO;
import po.list.WareOutListPO;
import util.City;
import util.DeliverType;
import util.GoodState;
import util.ListState;
import util.ListType;
import util.OrgType;

public class ListStateDataService_Stub implements ListStateDataService {

	@Override
	public ArrayList<ArrivaListPO> findallArrival() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<ArrivaListPO> result=new ArrayList<ArrivaListPO>();
		FileReader fr=new FileReader("TxtData/ArrivalList.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			String t[]=output[1].split("-");
			
			ArrivaListPO po = new ArrivaListPO(ListType.toListType(output[0]),new TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),0,0,0),Long.parseLong(output[2]), City.toCity(output[3]),GoodState.toState(output[4]),ListState.toState(output[5]),Long.parseLong(output[6]));
			result.add(po);
			Line = br.readLine();
		}
		return result;
	}

	@Override
	public ArrayList<DeliveryListPO> findallDelivery() throws IOException  {
		ArrayList<DeliveryListPO> result=new ArrayList<DeliveryListPO>();
		FileReader fr=new FileReader("TxtData/DeliveryList.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
	
			
			DeliveryListPO  po=new DeliveryListPO(Long.parseLong(output[0]),TimePO.toTime(output[1]),Long.parseLong(output[2]), output[3],ListState.toState(output[4]));

			result.add(po);
			Line = br.readLine();
		}
		return result;
	}

	@Override
	public ArrayList<OrderListPO> findallOrder() throws IOException{
		ArrayList<OrderListPO> result=new ArrayList<OrderListPO>();
		FileReader fr=new FileReader("TxtData/orderlist.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			String t[]=output[12].split(",");

			String time[]=t[7].split("-");
			WarePO ware = new WarePO(Double.parseDouble(t[0]), Integer.parseInt(t[1]), Double.parseDouble(t[2]), t[3], t[4], DeliverType.toType(t[5]),  Double.parseDouble(t[6]), TimePO.toTime(t[7]),City.toCity(t[8]),City.toCity(t[9]));
			
			OrderListPO	po=new OrderListPO(ListType.toListType(output[1]),output[2],output[3],output[4],output[5],output[6],output[7],output[8],output[9],output[10],output[11],ware,output[0],ListState.toState(output[13]),output[14]);

			result.add(po);
			Line = br.readLine();
		}
		return result;
	}

	@Override
	public ArrayList<LoadingListPO> findallLoading() throws IOException {
		ArrayList<LoadingListPO> result=new ArrayList<LoadingListPO>();
		FileReader fr=new FileReader("TxtData/loadinglist.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			
				String t[]=output[2].split("-");
				String l[]=output[6].split("-");
			
				long[] list =new long[l.length];
				for(int i=0;i<l.length;i++){
				list[i]=Long.parseLong(l[i]);	
				}
				
				LoadingListPO po=new LoadingListPO(Long.parseLong(output[0]), ListType.toListType(output[1]),new TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),0,0,0), Long.parseLong(output[3]), City.toCity(output[4]),City.toCity(output[5]),list,output[7],output[8],Double.parseDouble(output[9]),ListState.toState(output[10]));
					
			result.add(po);
			Line = br.readLine();
		}
		return result;
	}

	@Override
	public ArrayList<LoadingListPO> findallHallLoading() throws IOException {
		ArrayList<LoadingListPO> result=new ArrayList<LoadingListPO>();
		FileReader fr=new FileReader("TxtData/loadinglist_Hall.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			
				String t[]=output[2].split("-");
				String l[]=output[6].split("-");
			
				long[] list =new long[l.length];
				for(int i=0;i<l.length;i++){
				list[i]=Long.parseLong(l[i]);	
					
				}
		LoadingListPO po=new LoadingListPO(Long.parseLong(output[0]), ListType.toListType(output[1]),new TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),0,0,0), Long.parseLong(output[3]), City.toCity(output[4]),City.toCity(output[5]),list,output[7],output[8],Double.parseDouble(output[9]),ListState.toState(output[10]));
			
			result.add(po);
			Line = br.readLine();
		}
		return result;
	}

	@Override
	public ArrayList<MoneyInListPO> findallMoneyIn() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MoneyOutListPO> findallMoneyOut() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WareInListPO> findallWareIn() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WareOutListPO> findallWareOut() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> findall() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Object> result=new ArrayList<Object>();
		ArrayList<ArrivaListPO> arrival=findallArrival();
		ArrayList<DeliveryListPO> delivery=findallDelivery();
		ArrayList<OrderListPO> order= findallOrder();
		ArrayList<LoadingListPO> loading=findallLoading();
		ArrayList<LoadingListPO> loadinghall=findallHallLoading();
		result.add(arrival);
		result.add(delivery);
		result.add(order);
		result.add(loading);
		result.add(loadinghall);
		return result;
	}

	@Override
	public void updateArrival(ArrivaListPO po) throws IOException {
		// TODO Auto-generated method stub
	  long id=po.getCode();
	  deleteArrival(id);
	  insertArrival(po);
			}
public void deleteArrival(long id) throws IOException {
	
		
		File accounttempfile=new File("TxtData/ArrivalTemp.txt");
		 OutputStreamWriter itemWriter = new OutputStreamWriter(
					new FileOutputStream(accounttempfile,true),"UTF-8"); 
		 
		 try 
		   {    
		 File f5 = new File("TxtData/ArrivalTemp.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		FileReader fr = null;
		fr = new FileReader("TxtData/ArrivalList.txt");
		String Line=null;
		String temp=null;
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 Line=br.readLine();
		
		 while(Line!=null){
			String output[]=Line.split(":");
			
			if(Long.parseLong(output[2])!=id){
				
				itemWriter.write(Line);
				itemWriter.write("\r\n");
	      
			}if(Long.parseLong(output[2])==id){
				;
			}
			
			Line=br.readLine();
		}
		itemWriter.close();
		
		FileReader fr2 = null;
		fr2 = new FileReader("TxtData/ArrivalTemp.txt");
		String Line2=null;
	
		BufferedReader br2 = null;
		 br2 = new BufferedReader(fr2);
		 Line2=br2.readLine();
		init("TxtData/ArrivalList.txt");
		File financetempfile2=new File("TxtData/ArrivalList.txt");
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
		 File f5 = new File("TxtData/ArrivalTemp.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		
		
		System.out.println("DELETE SUCCESS!");
	}

	@Override
	public void insertArrival(ArrivaListPO po) {
		File Arrivalfile=new File("TxtData/ArrivalList.txt");
		if(po==null){
			System.out.println("ARRIVALLIST IS NOTHING");
		}if(po!=null){
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(Arrivalfile,true),"UTF-8"); 
			    itemWriter.write(po.getType()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getTime()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getTransid()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getStartCity()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getState()+"");
	            itemWriter.write(":");
	             itemWriter.write(po.getLst().toString());
	             itemWriter.write(":");
	            itemWriter.write(po.getCode()+"");
	            itemWriter.write(":");
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
	public void init(String Txtaddress) {
		try 
		   {    
		 File f5 = new File(Txtaddress);
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
	public void updateDelivery(DeliveryListPO po) throws IOException {
		// TODO Auto-generated method stub
		long id=po.getId();
		deleteDelivery(id);
		insertDelivery(po);
	}

	@Override
	public void deleteDelivery(long id) throws IOException {
		File accounttempfile=new File("TxtData/DeliveryTemp.txt");
		 OutputStreamWriter itemWriter = new OutputStreamWriter(
					new FileOutputStream(accounttempfile,true),"UTF-8"); 
		 
		 try 
		   {    
		 File f5 = new File("TxtData/DeliveryTemp.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		FileReader fr = null;
		fr = new FileReader("TxtData/DeliveryList.txt");
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
	      
			}if(Long.parseLong(output[2])==id){
				;
			}
			
			Line=br.readLine();
		}
		itemWriter.close();
		
		FileReader fr2 = null;
		fr2 = new FileReader("TxtData/DeliveryTemp.txt");
		String Line2=null;
	
		BufferedReader br2 = null;
		 br2 = new BufferedReader(fr2);
		 Line2=br2.readLine();
		init("TxtData/DeliveryList.txt");
		File financetempfile2=new File("TxtData/DeliveryList.txt");
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
		 File f5 = new File("TxtData/DeliveryTemp.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		
		
		System.out.println("DELETE SUCCESS!");
	}

	@Override
	public void insertDelivery(DeliveryListPO po) {
		File Deliveryfile=new File("TxtData/DeliveryList.txt");
		if(po==null){
		System.out.println("INSERT NOTHING");	;
		}if(po!=null){
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(Deliveryfile,true),"UTF-8"); 
			   itemWriter.write(po.getId()+"");
	            itemWriter.write(":");
			    itemWriter.write(po.getTime()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getCode()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getName());
	            itemWriter.write(":");
	            itemWriter.write(po.getLst().toString());
	            itemWriter.write(":");
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
		
		
		
		System.out.println("insertOK");
	}
	
	
	
	

}
