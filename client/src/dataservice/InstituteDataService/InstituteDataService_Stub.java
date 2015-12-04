package dataservice.InstituteDataService;

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

import po.AccountPO;
import po.InstitutePO;
import po.list.TransListPO;
import util.City;
import util.OrgType;
import util.Permission;

public class InstituteDataService_Stub implements InstituteDataService{

	@Override
	
		public void init() throws RemoteException {
			// TODO Auto-generated method stub
			try 
			   {    
			 File f5 = new File("TxtData/institute.txt");
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
	public void insert(InstitutePO po) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				File loginfile=new File("TxtData/institute.txt");
				if(po==null){
					;
				}if(po!=null){
				try {				
					   OutputStreamWriter itemWriter = new OutputStreamWriter(
						new FileOutputStream(loginfile,true),"UTF-8"); 
					    itemWriter.write(po.getId()+"");
			            itemWriter.write(":");
			            itemWriter.write(po.getCity().toString());
			            itemWriter.write(":");
			            itemWriter.write(po.getOrg().toString());
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
				System.out.println("INSERT SUCCESS");

		
		
		
	}

	@Override
	public InstitutePO find(long id) throws IOException {
		InstitutePO po=null;
		FileReader fr=new FileReader("TxtData/institute.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			if(output[0].equals(String.valueOf(id))){
				 po=new InstitutePO(City.toCity(output[1]),OrgType.toOrgType(output[2]),id);
			
				break;
		}
			else{
				Line = br.readLine();
			}
		}
		if(Line==null){
			System.out.println("ID NOT EXIST");
		}
		
		return po;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InstitutePO findlast() throws IOException {
		InstitutePO po=null;
		FileReader fr = null;
	File file = new File("TxtData/institute.txt");

		String Line = readLastLine(file, "UTF-8");

		String[] output=Line.split(":");
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
	public OrgType getOrg(String m) {
		// TODO Auto-generated method stub
		return null;
	}

}
