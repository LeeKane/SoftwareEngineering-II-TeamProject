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

import po.TimePO;
import po.list.ArrivaListPO;
import util.City;
import util.GoodState;
import util.ListType;
import dataservice.listdataservice.ArrivalListDataService;
//营业厅业务员接受
public class ArrivalListImpl implements ArrivalListDataService{

	@Override
	public boolean insert(ArrivaListPO po) {
		// TODO Auto-generated method stub
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
		
		return true;
		
	
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try 
		   {    
		 File f5 = new File("TxtData/ArrivalList.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   
	}
	}

	@Override
	public ArrivaListPO find(long id) {
		// TODO Auto-generated method stub
		ArrivaListPO po=null;
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/ArrivalList.txt");
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
		 po=new ArrivaListPO(ListType.toListType(output[0]),new TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),0,0,0),id, City.toCity(output[3]),GoodState.toState(output[4]));
			
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
			System.out.println("ARRIVALIST NOT EXIST");
		}
		
	
		
		return po;
	}

}
