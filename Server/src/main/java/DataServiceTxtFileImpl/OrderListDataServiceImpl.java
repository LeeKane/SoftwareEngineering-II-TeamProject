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
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.listdataservice.OrderListDataService;
import po.TimePO;
import po.WarePO;
import po.list.ArrivaListPO;
import po.list.OrderListPO;
import util.City;
import util.DeliverType;
import util.ListState;
import util.ListType;

public class OrderListDataServiceImpl extends UnicastRemoteObject implements OrderListDataService {

	public OrderListDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean insert(OrderListPO po) throws RemoteException{
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
	            itemWriter.write(po.getWare().getweight()+","+po.getWare().getamount()+","+po.getWare().getvolume()+","+po.getWare().getpackag()+","+po.getWare().getname()+","+po.getWare().gettype()+","+po.getWare().getcost()+","+po.getWare().gettime().toString()+","+po.getWare().getDepartPlace().toString()+","+po.getWare().getDestination().toString());
	            itemWriter.write(":");
	            itemWriter.write(po.getLst()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getAccount()+"");
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

	public OrderListPO find(String id) throws RemoteException{

//		 TODO Auto-generated method stub
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

				WarePO ware = new WarePO(Double.parseDouble(t[0]), Integer.parseInt(t[1]), Double.parseDouble(t[2]), t[3], t[4], DeliverType.toType(t[5]),  Double.parseDouble(t[6]), TimePO.toTime(t[7]),City.toCity(t[8]),City.toCity(t[9]));
				
				po=new OrderListPO(ListType.toListType(output[1]),output[2],output[3],output[4],output[5],output[6],output[7],output[8],output[9],output[10],output[11],ware,id,ListState.toState(output[13]),output[14]);



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
	public void init() throws RemoteException{
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
	public OrderListPO findlast() throws RemoteException, IOException {
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
	public String readLastLine(File file, String charset) throws RemoteException, IOException {
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
	@Override
	public ArrayList<OrderListPO> findallOrder() throws RemoteException, IOException {
		ArrayList<OrderListPO> result=new ArrayList<OrderListPO>();
		FileReader fr=new FileReader("TxtData/orderlist.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			String t[]=output[12].split(",");

			String time[]=t[7].split("-");
			WarePO ware = new WarePO(Double.parseDouble(t[0]), Integer.parseInt(t[1]), Double.parseDouble(t[2]), t[3], t[4], DeliverType.toType(t[5]),  Double.parseDouble(t[6]), TimePO.toTime(t[7]),City.toCity(t[8]),City.toCity(t[9]));
			
			OrderListPO	po=new OrderListPO(ListType.toListType(output[1]),output[2],output[3],output[4],output[5],output[6],output[7],output[8],output[9],output[10],output[11],ware,output[0],ListState.toState(output[13]),output[14]);

			result.add(po);
			Line = br.readLine();
		}
		return result;
	}
	@Override
	public ArrayList<OrderListPO> findNoneReviewed() throws RemoteException, IOException {
		ArrayList<OrderListPO> temp=new ArrayList<OrderListPO>();
		ArrayList<OrderListPO> result=new ArrayList<OrderListPO>();
		temp=findallOrder();
		for(int i=0;i<temp.size();i++){
			if(temp.get(i).getLst().equals(ListState.SUBMITTED)){
				result.add(temp.get(i));
			}else{
				;
			}
		}
		
		
		return result;
	}



}
