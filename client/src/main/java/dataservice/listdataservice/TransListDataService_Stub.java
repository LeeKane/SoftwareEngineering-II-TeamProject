package dataservice.listdataservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import po.list.TransListPO;

public class TransListDataService_Stub implements TransListDataService{

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
		// TODO Auto-generated method stub
		return null;
	}

}
