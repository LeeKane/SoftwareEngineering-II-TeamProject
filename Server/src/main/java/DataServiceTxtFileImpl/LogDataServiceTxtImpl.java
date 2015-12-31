package DataServiceTxtFileImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.reviewdataservice.LogDataService;
import po.LogPO;
import po.TimePO;

public class LogDataServiceTxtImpl extends UnicastRemoteObject implements LogDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogDataServiceTxtImpl() throws RemoteException {
		
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			File f5 = new File("TxtData/Log.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
			bw1.close();
		} catch (Exception e) {
			
		}
		System.out.println("INIT SUCCESS");
	}

	@Override
	public ArrayList<LogPO> findAll() throws RemoteException, IOException {
		// TODO Auto-generated method stub
		ArrayList<LogPO> result = new ArrayList<LogPO>();
		FileReader fr = new FileReader("TxtData/Log.txt");
		BufferedReader br = null;
		br = new BufferedReader(fr);
		String Line = br.readLine();
		while (Line != null) {
			String output[] = Line.split(":");
			LogPO po = new LogPO(TimePO.toTime(output[0]),output[1]);
			result.add(po);
			Line = br.readLine();
		}
		br.close();
		return result;
	}

}
