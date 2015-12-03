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
import java.io.RandomAccessFile;

import po.TimePO;
import po.WarePO;
import po.list.OrderListPO;
import util.DeliverType;
import util.ListState;
import util.ListType;
import dataservice.listdataservice.OrderListDataService;

public class OrderListDataServiceImpl implements OrderListDataService {

	@Override
	public boolean insert(OrderListPO po) {
		// TODO Auto-generated method stub
		File financefile=new File("TxtData/orderlist.txt");
		if(po==null){
		}else
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(financefile,true),"UTF-8"); 
			    itemWriter.write(po.getId()+"");
		        itemWriter.write(":");
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
	            itemWriter.write(po.getWare().getweight()+","+po.getWare().getamount()+","+po.getWare().getvolume()+","+po.getWare().getpackag()+","+po.getWare().getname()+","+po.getWare().gettype()+","+po.getWare().getcost()+","+po.getWare().gettime().toString());
	            itemWriter.write(":");
	            itemWriter.write(po.getLst()+"");
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
	@Override
	
	public OrderListPO find(String id) {
	
		// TODO Auto-generated method stub
		OrderListPO po=null;
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/orderlist.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
			if(output[0].equals(id)){
				String t[]=output[12].split(",");
			
				String time[]=t[7].split("-");
				WarePO ware = new WarePO(Double.parseDouble(t[0]), Integer.parseInt(t[1]), Double.parseDouble(t[2]), t[3], t[4], DeliverType.toType(t[5]),  Double.parseDouble(t[6]), new TimePO(Integer.parseInt(time[0]),Integer.parseInt(time[1]),Integer.parseInt(time[2]),Integer.parseInt(time[3]),Integer.parseInt(time[4]),Integer.parseInt(time[5])));
				 po=new OrderListPO(ListType.toListType(output[1]),output[2],output[3],output[4],output[5],output[6],output[7],output[8],output[9],output[10],output[11],ware,id,ListState.toLst(output[14]));
			
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
			System.out.println("USERNAME NOT EXIST");
		}
		
		return po;
		
		
		
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try 
		   {    
		 File f5 = new File("TxtData/orderlist.txt");
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
	public OrderListPO findlast() throws IOException {
		// TODO Auto-generated method stub
		OrderListPO po=null;
		FileReader fr = null;
	File file = new File("TxtData/orderlist.txt");
		
		String Line = readLastLine(file, "UTF-8");
		
		String[] output=Line.split(":");
		po=find(output[0]);
	
		
		
		return po;
		
		
		
	}
	@Override
	public String readLastLine(File file, String charset) throws IOException {
		// TODO Auto-generated method stub
		  if (!file.exists() || file.isDirectory() || !file.canRead()) {  
			    return null;  
			  }  
			  RandomAccessFile raf = null;  
			  try {  
			    raf = new RandomAccessFile(file, "r");  
			    long len = raf.length();  
			    if (len == 0L) {  
			      return "";  
			    } else {  
			      long pos = len - 1;  
			      while (pos > 0) {  
			        pos--;  
			        raf.seek(pos);  
			        if (raf.readByte() == '\n') {  
			          break;  
			        }  
			      }  
			      if (pos == 0) {  
			        raf.seek(0);  
			      }  
			      byte[] bytes = new byte[(int) (len - pos)];  
			      raf.read(bytes);  
			      if (charset == null) {  
			        return new String(bytes);  
			      } else {  
			        return new String(bytes, charset);  
			      }  
			    }  
			  } catch (FileNotFoundException e) {  
			  } finally {  
			    if (raf != null) {  
			      try {  
			        raf.close();  
			      } catch (Exception e2) {  
			      }  
			    }  
			  }  
			  return null;  
			}  
	


}
