package dataservice.reviewdataservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogPO;

public interface LogDataService extends Remote{
	public void init() throws RemoteException;
	
	public static void insert(LogPO po) throws RemoteException {
		final String FILE_NAME = "TxtData/Log.txt";
		File loginfile = new File(FILE_NAME);
		if (po == null) {
			;
		}
		if (po != null) {
			try {
				OutputStreamWriter itemWriter = new OutputStreamWriter(new FileOutputStream(loginfile, true), "UTF-8");

				itemWriter.write(po.getTime().toString());
				itemWriter.write(":");
				itemWriter.write(po.getOperation());
				itemWriter.write("\r\n");
				itemWriter.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("INSERT SUCCESS");
	}
	
	public ArrayList<LogPO> findAll() throws RemoteException, IOException;
}
