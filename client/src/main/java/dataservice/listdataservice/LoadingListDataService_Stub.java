package dataservice.listdataservice;

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

import po.TimePO;
import po.list.LoadingListPO;
import po.list.TransListPO;
import util.City;
import util.ListType;

public class LoadingListDataService_Stub implements LoadingListDataService{

	@Override
	public void insert(LoadingListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
		File loginfile=new File("TxtData/loadinglist.txt");
		if(po==null){
			System.out.println("LOADINGLIST NONE EXIST!");
		}else{
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(loginfile,true),"UTF-8"); 
			    itemWriter.write(po.getId()+"");
			    itemWriter.write(":");
			    itemWriter.write(po.getType()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getLoadDate()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getTransNum()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getDepartPlace()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getDestination()+"");
	            itemWriter.write(":");
	            long[] list=po.getWaybillNumList();
	            for(int i=0;i<list.length;i++){
	            	if(i!=list.length-1)
	            itemWriter.write(list[i]+"-");
	            	else{
	            		 itemWriter.write(list[i]+"");
	            	}
	            }
	            itemWriter.write(":");
	            itemWriter.write(po.getLoadMonitor()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getLoadPerformer()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getFreight()+"");
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
		System.out.println("INSERT SUCCESS!!");
		}
	}

	@Override
	public LoadingListPO find(long id) throws RemoteException, FileNotFoundException {
		LoadingListPO po=null;
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/loadinglist.txt");
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
			if(output[0].equals(String.valueOf(id))){
				String t[]=output[2].split("-");
				String l[]=output[6].split("-");
			
				long[] list =new long[l.length];
				for(int i=0;i<l.length;i++){
				list[i]=Long.parseLong(l[i]);	
					
				}
		 po=new LoadingListPO(id, ListType.toListType(output[1]),new TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),0,0,0), Long.parseLong(output[3]), City.toCity(output[4]),City.toCity(output[5]),list,output[7],output[8],Double.parseDouble(output[9]));
			
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
			System.out.println("LOADINGLIST NOT EXIST");
		}
		
	
		
		return po;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try 
		   {    
		 File f5 = new File("TxtData/loadinglist.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
	}

}
