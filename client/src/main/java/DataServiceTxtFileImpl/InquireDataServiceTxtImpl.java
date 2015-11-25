package DataServiceTxtFileImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;

import po.InstitutePO;
import po.TimePO;
import po.TransPO;
import util.City;
import util.OrgType;
import dataservice.inquiredataservice.InquireDataService;

public class InquireDataServiceTxtImpl implements InquireDataService{

	@Override
	public TransPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		TransPO po=null;
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/inquire.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = null;
		try {
			Line = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(Line!=null){
			String output[]=Line.split(":");
			String t[] = output[2].split(",");
			String inst[] = output[3].split(",");
			if(output[0].equals(String.valueOf(id))){
				TimePO time2=new TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),Integer.parseInt(t[3]),Integer.parseInt(t[4]),Integer.parseInt(t[5]));
				InstitutePO ins = new InstitutePO(City.toCity(inst[0]),OrgType.toOrgType(inst[1]),Long.parseLong(inst[2]));
				 po=new TransPO(id,output[1],time2,ins);
			
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
			System.out.println("ID NOT EXIST");
		}
		
		return po;
	}
	

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		try 
		   {    
		 File f5 = new File("TxtData/inquire.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FINISH SUCCESS!");
	}

}
