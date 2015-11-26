package dataservice.listdataservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.rmi.RemoteException;

import po.list.LoadingListPO;

public class LoadingListDataService_Stub implements LoadingListDataService{

	@Override
	public void insert(LoadingListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		File loginfile=new File("TxtData/loadinglist.txt");
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(loginfile,true),"UTF-8"); 
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
	            itemWriter.write(po.getWaybillNumList()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getLoadMonitor()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getLoadPerformer()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getFreight()+"");
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
	public void find(LoadingListPO po) throws RemoteException, FileNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try 
		   {    
		 File f5 = new File("TxtData/loadinglist.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
	}

}
