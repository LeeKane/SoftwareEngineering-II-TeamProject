package dataservice.listdataservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import po.list.TranscenterArrivalListPO;

public class TransCenterArrivalListDataService_Stub implements TransCenterArrivalListDataService{

	@Override
	public void insert(TranscenterArrivalListPO po) {
		// TODO Auto-generated method stub
		File loginfile=new File("TxtData/TransCenterArrival.txt");
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(loginfile,true),"UTF-8"); 
			    itemWriter.write(po.getTranscenterID()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getArrivatime()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getTranslistID()+"");
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
		System.out.println("INSERT SUCCESS!!");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try 
		   {    
		 File f5 = new File("TxtData/TransCenterArrival.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
		   
	}

	}

	@Override
	public TranscenterArrivalListPO find(long id) {
		// TODO Auto-generated method stub
		
		
		
		
		return null;
	}



}
