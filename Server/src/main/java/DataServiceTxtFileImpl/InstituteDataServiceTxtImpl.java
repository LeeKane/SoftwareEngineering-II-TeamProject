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
import java.util.ArrayList;

import dataservice.reviewdataservice.InstituteDataService;
import po.InstitutePO;
import util.City;
import util.OrgType;

public class InstituteDataServiceTxtImpl implements InstituteDataService {
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
				   
				    itemWriter.write(po.getId());
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
public ArrayList<InstitutePO> findAll() throws IOException {
	// TODO Auto-generated method stub
	ArrayList<InstitutePO> result=new ArrayList<InstitutePO>();
	FileReader fr=new FileReader("TxtData/institute.txt");
	BufferedReader br = null;
	 br = new BufferedReader(fr);
	 String Line = br.readLine();
	while(Line!=null){
		String output[]=Line.split(":");
		InstitutePO po=new InstitutePO(City.toCity(output[1]),OrgType.toOrgType(output[2]),output[0]);
		result.add(po);
		Line = br.readLine();
	}
	return result;
}

@Override
public InstitutePO find(String id) throws IOException {
	InstitutePO po=null;
	FileReader fr=new FileReader("TxtData/institute.txt");
	BufferedReader br = null;
	 br = new BufferedReader(fr);
	 String Line = br.readLine();
	while(Line!=null){
		String output[]=Line.split(":");
		if(output[0].equals(id)){
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
public void delete(String id) throws IOException {
	// TODO Auto-generated method stub
	File logintempfile=new File("TxtData/instituteTemp.txt");
	 OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(logintempfile,true),"UTF-8"); 
	 
	 try 
	   {    
	 File f5 = new File("TxtData/instituteTemp.txt");
	       FileWriter fw5 = new FileWriter(f5);
	       BufferedWriter bw1 = new BufferedWriter(fw5);
	       bw1.write("");
	   }
	   catch (Exception e)
	   {
		   
	   }
	FileReader fr = null;
	fr = new FileReader("TxtData/institute.txt");
	String Line=null;
	String temp=null;
	BufferedReader br = null;
	 br = new BufferedReader(fr);
	 Line=br.readLine();
	
	 while(Line!=null){
		String output[]=Line.split(":");
		
		if(!output[0].equals(id)){
			
			itemWriter.write(Line);
			itemWriter.write("\r\n");
     
		}if(output[0].equals(id)){
			;
		}
		
		Line=br.readLine();
	}
	itemWriter.close();
	
	FileReader fr2 = null;
	fr2 = new FileReader("TxtData/instituteTemp.txt");
	String Line2=null;

	BufferedReader br2 = null;
	 br2 = new BufferedReader(fr2);
	 Line2=br2.readLine();
	init();
	File financetempfile2=new File("TxtData/institute.txt");
	 OutputStreamWriter itemWriter2 = new OutputStreamWriter(
				new FileOutputStream(financetempfile2,true),"UTF-8"); 
	while(Line2!=null){
		itemWriter2.write(Line2);
		itemWriter2.write("\r\n");
		Line2=br2.readLine();
	}
	itemWriter2.close();
	 try 
	   {    
	 File f5 = new File("TxtData/instituteTemp.txt");
	       FileWriter fw5 = new FileWriter(f5);
	       BufferedWriter bw1 = new BufferedWriter(fw5);
	       bw1.write("");
	   }
	   catch (Exception e)
	   {
		   
	   }
}

@Override
public InstitutePO findlast(City city,OrgType org) throws IOException {
	InstitutePO po=null;
	
	ArrayList<Long> list=new ArrayList<Long>();
	  File fileSrc=new File("TxtData/institute.txt");
      BufferedReader fin=new BufferedReader( new FileReader(fileSrc) );
      String line;
      if(org==OrgType.CENTER){
    	  while( (line=fin.readLine())!=null){
        	  line=line.split(":")[0];  
        	  if(line.length()==4){
        		  if(city==City.NANJING){
        			  if(line.substring(0, 3).equals("125")){
        				  list.add(Long.parseLong(line));
        			  }	  
        		  }
        		  if(city==City.BEIJING){
        			  if(line.substring(0, 3).equals("110")){
        				  list.add(Long.parseLong(line));
        			  }	  
        		  }
        		  if(city==City.GUANGZHOU){
        			  if(line.substring(0, 3).equals("120")){
        				  list.add(Long.parseLong(line));
        			  }	  
        		  }
        		  if(city==City.SHANGHAI){
        			  if(line.substring(0, 3).equals("121")){
        				  list.add(Long.parseLong(line));
        			  }	  
        		  }
        	  }       		  
          } 
	  }else{
		  while( (line=fin.readLine())!=null){
        	  line=line.split(":")[0];  
        	  if(line.length()==5){
        		  if(city==City.NANJING){
        			  if(line.substring(0, 3).equals("125")){
        				  list.add(Long.parseLong(line));
        			  }	  
        		  }
        		  if(city==City.BEIJING){
        			  if(line.substring(0, 3).equals("110")){
        				  list.add(Long.parseLong(line));
        			  }	  
        		  }
        		  if(city==City.GUANGZHOU){
        			  if(line.substring(0, 3).equals("120")){
        				  list.add(Long.parseLong(line));
        			  }	  
        		  }
        		  if(city==City.SHANGHAI){
        			  if(line.substring(0, 3).equals("121")){
        				  list.add(Long.parseLong(line));
        			  }	  
        		  }
        	  }
          }  
	  }    
      fin.close();
      
      long max=list.get(0); 
      for(long i: list){ 
    	  if(i>max) 
    	  max=i; 
      }

	po=find(max+"");
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


@Override
public void update(InstitutePO po) throws IOException {
	// TODO Auto-generated method stub
	String id=po.getId();
	delete(id);
	insert(po);
}

}
