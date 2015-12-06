package dataservice.MoneyInListDataService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import po.AccountPO;
import po.TimePO;
import po.list.MoneyInListPO;
import util.ListState;
import util.Permission;

public class MoneyInListDataService_Stub implements MoneyInListDataService{

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
	public void insert(MoneyInListPO po) {//(long id,TimePO time, double money, String name, long[] code,ListState state
		// TODO Auto-generated method stub
		File loginfile=new File("TxtData/MoneyInList.txt");
		if(po==null){
			;
		}if(po!=null){
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(loginfile,true),"UTF-8"); 
			    itemWriter.write(po.getId()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getTime().toString());
	            itemWriter.write(":");
	            itemWriter.write(po.getMoney()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getName());
	            itemWriter.write(":");
	            itemWriter.write(po.getCode()+"");
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
		System.out.println("INSERT SUCCESS");
	}

	@Override
	public MoneyInListPO find(long id) {
		// TODO Auto-generated method stub

		MoneyInListPO po=null;
		FileReader fr=new FileReader("TxtData/acount.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			String t[] = output[1].split("-");
			
			if(output[0].equals(String.valueOf(id))){
				 po=new MoneyInListPO(id,TimePO.toSpeccialTime(output[1])),Double.parseDouble(output[2]),output[3],Long);
			
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

}
