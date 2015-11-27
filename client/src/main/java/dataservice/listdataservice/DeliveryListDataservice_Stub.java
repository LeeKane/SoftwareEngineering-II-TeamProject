package dataservice.listdataservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import po.list.DeliveryListPO;

public class DeliveryListDataservice_Stub implements DeliveryListDataService{

	@Override
	public boolean insert(DeliveryListPO po) {
		// TODO Auto-generated method stub
		File Deliveryfile=new File("TxtData/DeliveryList.txt");
		if(po==null){
			;
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
		
	}

}
