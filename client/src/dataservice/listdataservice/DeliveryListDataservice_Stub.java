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

import po.TimePO;
import po.list.DeliveryListPO;
import po.list.TranscenterArrivalListPO;
import util.City;
import util.GoodState;

public class DeliveryListDataservice_Stub implements DeliveryListDataService{

	public boolean insert(DeliveryListPO po) {
		// TODO Auto-generated method stub
		File Deliveryfile=new File("TxtData/DeliveryList.txt");
		if(po==null){
		System.out.println("INSERT NOTHING");	;
		}if(po!=null){
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(Deliveryfile,true),"UTF-8"); 
			    itemWriter.write(po.getTime()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getCode()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getName());
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
		return true;

	}
	@Override
	public void delete(long code) {
		// TODO Auto-generated method stub
		System.out.println("DELETEok");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try 
		   {    
		 File f5 = new File("TxtData/DeliveryList.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   
	}
		
	}
	@Override
	public DeliveryListPO find(long code) {
		// TODO Auto-generated method stub
		DeliveryListPO po=null;
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/DeliveryList.txt");
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
			if(output[1].equals(String.valueOf(code))){
				String t[]=output[0].split("-");
		 po=new DeliveryListPO(new TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),0,0,0),code, output[2]);
			
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
			System.out.println("DELIVERYLIST NOT EXIST");
		}
		
	
		
		return po;
	}
	

}
