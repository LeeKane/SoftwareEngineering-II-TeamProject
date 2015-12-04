package dataservice.InstituteDataService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;

import po.InstitutePO;
import util.OrgType;

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
		
		
		
		
		
	}

	@Override
	public InstitutePO find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InstitutePO findlast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readLastLine(File file, String charset) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OrgType getOrg(String m) {
		// TODO Auto-generated method stub
		return null;
	}

}
