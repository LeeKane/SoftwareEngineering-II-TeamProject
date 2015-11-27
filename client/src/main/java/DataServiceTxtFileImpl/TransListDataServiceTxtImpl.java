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

import dataservice.listdataservice.TransListDataService;
import po.TimePO;
import po.list.TransListPO;
import util.City;
import util.ListType;

public class TransListDataServiceTxtImpl implements TransListDataService{

	@Override
	public void insert(TransListPO po) {
		// TODO Auto-generated method stub
		File loginfile=new File("TxtData/Trans.txt");
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(loginfile,true),"UTF-8"); 
			    itemWriter.write(po.getType()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getTime()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getId()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getTransID()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getStartCity()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getEndCity()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getTransboxID()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getSupersivor()+"");
	            itemWriter.write(":");
	            long[] list=po.getOrderlist();
	            for(int i=0;i<list.length;i++){
	            	if(i!=list.length-1)
	            itemWriter.write(list[i]+"-");
	            	else{
	            		 itemWriter.write(list[i]+"");
	            	}
	            }
	            
	            itemWriter.write(":");
	            itemWriter.write(po.getYunfei()+"");
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

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try 
		   {    
		 File f5 = new File("TxtData/Trans.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
		   
	}
	}

	@Override
	public TransListPO find(long id) {
		TransListPO po=null;
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/Trans.txt");
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
			if(output[2].equals(String.valueOf(id))){
				String t[]=output[1].split("-");
				String l[]=output[8].split("-");
			
				long[] list =new long[l.length];
				for(int i=0;i<l.length;i++){
				list[i]=Long.parseLong(l[i]);	
					
				}
		 po=new TransListPO(ListType.toListType(output[0]), new TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),0,0,0), id,Long.parseLong(output[3]), City.toCity(output[4]),City.toCity(output[5]),Long.parseLong(output[6]),output[7],list,Double.parseDouble(output[9]));
			
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
			System.out.println("TRANSLIST NOT EXIST");
		}
		
	
		
		return po;
	}

}
