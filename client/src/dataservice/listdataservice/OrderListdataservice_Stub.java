package dataservice.listdataservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import po.TimePO;
import po.WarePO;
import po.list.OrderListPO;
import util.DeliverType;
import util.ListType;

public class OrderListdataservice_Stub implements OrderListDataService {

	
	@Override
	public boolean insert(OrderListPO po) {
		File financefile=new File("TxtData/orderlist.txt");
		if(po==null){
			
		}else
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(financefile,true),"UTF-8"); 
	            itemWriter.write(po.getListtype()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getSenderName()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getSenaderAddress()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getSenderOrganization()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getSenderTphone()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getSenderCphone()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getReceiverName()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getReceiverAddress()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getReceiverOrganization()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getReceiverTphone()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getReceiverCphone()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getWare().getweight()+","+po.getWare().getamount()+","+po.getWare().getvolume()+","+po.getWare().getpackag()+","+po.getWare().getname()+","+po.getWare().gettype()+","+po.getWare().getcost()+","+po.getWare().gettime());
	            itemWriter.write(":");
	            itemWriter.write(po.getSuggesstion());
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
