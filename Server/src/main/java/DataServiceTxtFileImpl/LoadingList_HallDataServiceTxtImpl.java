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

import dataservice.listdataservice.LoadingList_HallDataService;
import po.TimePO;
import po.list.LoadingListPO;
import util.City;
import util.ListState;
import util.ListType;
//营业厅业务员装车管理
public class LoadingList_HallDataServiceTxtImpl extends UnicastRemoteObject implements LoadingList_HallDataService{
	protected LoadingList_HallDataServiceTxtImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(LoadingListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
		File loginfile=new File("TxtData/loadinglist_Hall.txt");
		if(po==null){
			System.out.println("LOADINGLIST NONE EXIST!");
		}else{
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(loginfile,true),"UTF-8"); 
			    itemWriter.write(po.getId()+"");
			    itemWriter.write(":");
			    itemWriter.write(po.getType()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getLoadDate()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getTransNum()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getDepartPlace()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getDestination()+"");
	            itemWriter.write(":");
	            ArrayList<Long> list=po.getWaybillNumList();
	            for(int i=0;i<list.size();i++){
	           if(i==list.size()-2)
	            itemWriter.write(list.get(i)+"-");
	            	else{
	            		 itemWriter.write(list.get(i)+"");
	            	}
	            }
	            itemWriter.write(":");
	            itemWriter.write(po.getLoadMonitor()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getLoadPerformer()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getFreight()+"");
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
		System.out.println("INSERT SUCCESS!!");
		}
	}

	@Override
	public LoadingListPO find(long id) throws RemoteException, FileNotFoundException {
		LoadingListPO po=null;
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/loadinglist_Hall.txt");
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
			if(output[0].equals(String.valueOf(id))){
				String t[]=output[2].split("-");
				String l[]=output[6].split("-");
				 ArrayList<Long> list =new  ArrayList<Long>();
				for(int i=0;i<l.length;i++){
				list.add(Long.parseLong(l[i]));	
					
				}
		 po=new LoadingListPO(id, ListType.toListType(output[1]),new TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),0,0,0), Long.parseLong(output[3]), City.toCity(output[4]),City.toCity(output[5]),list,output[7],output[8],Double.parseDouble(output[9]),ListState.toState(output[10]));
			
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
			System.out.println("LOADINGLIST NOT EXIST");
		}
		
	
		
		return po;
		// TODO Auto-generated method stub
		
	}
	@Override
	public LoadingListPO findlast() throws IOException {
		LoadingListPO po=null;
		FileReader fr = null;
	File file = new File("TxtData/loadinglist_Hall.txt");

		String Line = readLastLine(file, "UTF-8");

		String[] output=Line.split(":");
		System.out.println(output[0]);
		po=find(Long.parseLong(output[0]));
		return po;
	}

	@Override
	public String readLastLine(File file, String charset) throws IOException {
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
	public void init() {
		// TODO Auto-generated method stub
		try 
		   {    
		 File f5 = new File("TxtData/loadinglist_Hall.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
	}
	@Override
	public ArrayList<LoadingListPO> findallLoadingHall() throws IOException {
		ArrayList<LoadingListPO> result=new ArrayList<LoadingListPO>();
		FileReader fr=new FileReader("TxtData/loadinglist_Hall.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			
				String t[]=output[2].split("-");
				String l[]=output[6].split("-");
			
				 ArrayList<Long> list =new  ArrayList<Long>();
					for(int i=0;i<l.length;i++){
					list.add(Long.parseLong(l[i]));	
						
					}
				
				LoadingListPO po=new LoadingListPO(Long.parseLong(output[0]), ListType.toListType(output[1]),new TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),0,0,0), Long.parseLong(output[3]), City.toCity(output[4]),City.toCity(output[5]),list,output[7],output[8],Double.parseDouble(output[9]),ListState.toState(output[10]));
					
			result.add(po);
			Line = br.readLine();
		}
		return result;
	}

	@Override
	public ArrayList<LoadingListPO> findNoneReviewed() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<LoadingListPO> temp=new ArrayList<LoadingListPO>();
		ArrayList<LoadingListPO> result=new ArrayList<LoadingListPO>();
		temp=findallLoadingHall();
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
