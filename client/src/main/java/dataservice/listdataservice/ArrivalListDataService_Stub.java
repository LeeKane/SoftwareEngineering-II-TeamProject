package dataservice.listdataservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import po.list.ArrivaListPO;

public class ArrivalListDataService_Stub implements ArrivalListDataService{

	@Override
	public boolean insert(ArrivaListPO po) {
		// TODO Auto-generated method stub
		File Arrivalfile=new File("TxtData/ArrivalList.txt");
		if(po==null){
			;
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

}
