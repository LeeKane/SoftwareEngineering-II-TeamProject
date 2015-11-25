package dataimpl.listDataServiceTxtFileImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import po.WarePO;
import dataservice.listdataservice.OrderListDataService;

public class OrdersDataServiceTxtFileImpl implements OrderListDataService{

	public boolean insert(WarePO po)
	{
		File itemFile = new File("TxtData/ware.txt");
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(itemFile,true),"UTF-8"); 
	            itemWriter.write(Double.toString(po.getweight()));
	            itemWriter.write(":");
	            itemWriter.write(po.getamount());
	            itemWriter.write(":");
	            itemWriter.write(Double.toString(po.getvolume()));
	            itemWriter.write(":");
	            itemWriter.write(po.getpackag());
	            itemWriter.write(":");
	            itemWriter.write(po.getname());
	            itemWriter.write(":");
	            itemWriter.write(po.gettype().toString());
	            itemWriter.write(":");
	            itemWriter.write(Double.toString(po.getcost()));
	            itemWriter.write(":");
	            itemWriter.write(po.gettime().toString());
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
	    return true;
	}
	}
  
