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

import dataservice.listdataservice.TransCenterArrivalListDataService;
import po.AccountPO;
import po.TimePO;
import po.list.TranscenterArrivalListPO;
import util.City;
import util.GoodState;
import util.Permission;
//中转中心业务员中转接受

public class TransCenterArrivalListDataServiceTxtImpl implements TransCenterArrivalListDataService{

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
		TranscenterArrivalListPO po=null;
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/TransCenterArrival.txt");
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
		 po=new TranscenterArrivalListPO(Long.parseLong(output[0]), new TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),0,0,0), id,City.toCity(output[3]), GoodState.toState(output[4]));
			
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
			System.out.println("LIST NOT EXIST");
		}
		return po;
	}
	@Override
	public TranscenterArrivalListPO findlast() throws IOException {
		TranscenterArrivalListPO po=null;
		FileReader fr = null;
	File file = new File("TxtData/TransCenterArrival.txt");

		String Line = readLastLine(file, "UTF-8");

		String[] output=Line.split(":");
		po=find(Long.parseLong(output[2]));
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
	
	}
