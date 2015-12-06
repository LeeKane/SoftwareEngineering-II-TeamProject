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

import dataservice.MoneyInListDataService.MoneyInListDataService;
import po.AccountPO;
import po.TimePO;
import po.list.MoneyInListPO;
import util.ListState;
import util.Permission;

public class MoneyInListDataServiceImpl implements MoneyInListDataService{

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
		System.out.println("INIT SUCCESS");
	}

	@Override
	public void insert(MoneyInListPO po) {
		// TODO Auto-generated method stub
		File MoneyInfile=new File("TxtData/MoneyInList.txt");
		if(po==null){
			System.out.println("MONEYINLIST IS NOTHING");
		}if(po!=null){
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(MoneyInfile,true),"UTF-8"); 
			    itemWriter.write(po.getId()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getTime()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getMoney()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getName());
	            itemWriter.write(":");
	            itemWriter.write(po.getCode()+"");
	            long[] list=po.getCode();
	            for(int i=0;i<list.length;i++){
	            	if(i!=list.length-1)
	            itemWriter.write(list[i]+",");
	            	else{
	            		 itemWriter.write(list[i]+"");
	            	}
	            }
	            
	            itemWriter.write(":");
	             itemWriter.write(po.getState()+"");
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
		System.out.println("INSERT SUCCESS!");
}

	@Override
	public MoneyInListPO find(long id) {
		// TODO Auto-generated method stub
		MoneyInListPO po=null;
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/MoneyInList.txt");
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
			String c[] = output[4].split(",");
			long[] list =new long[c.length];
			for(int i=0;i<c.length;i++){
			list[i]=Long.parseLong(c[i]);	}
			if(output[0].equals(String.valueOf(id))){//(long id,TimePO time, double money, String name, long[] code,ListState state)
				 po=new MoneyInListPO(id,TimePO.toSpeccialTime(output[1]),Double.parseDouble(output[2]),output[3],list,ListState.toState(output[5]));
			
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
		}
		
		return po;
	}
	
}