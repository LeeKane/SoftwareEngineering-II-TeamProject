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
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.financedataservice.MoneyOutListDataService;
import po.BaccountPO;
import po.TimePO;
import po.list.MoneyOutListPO;
import util.Entry;
import util.ListState;
import util.RewardType;

public class MoneyOutListDataServiceImpl extends UnicastRemoteObject implements MoneyOutListDataService {

	protected MoneyOutListDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			File f5 = new File("TxtData/MoneyOutList.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {

		}
		System.out.println("INIT SUCCESS!");
	}

	@Override
	public void insert(MoneyOutListPO po) throws RemoteException {// long
																	// id,TimePO
																	// time,double
																	// money,String
																	// name,BaccountPO
																	// account,
		// Entry entry,String note,RewardType reward,ListState lst
		// TODO Auto-generated method stub
		File MoneyInfile = new File("TxtData/MoneyOutList.txt");
		if (po == null) {
			System.out.println("MONEYOUTLIST IS NOTHING");
		}
		if (po != null) {
			try {
				OutputStreamWriter itemWriter = new OutputStreamWriter(new FileOutputStream(MoneyInfile, true),
						"UTF-8");
				itemWriter.write(po.getId() + "");
				itemWriter.write(":");
				itemWriter.write(po.getTime() + "");
				itemWriter.write(":");
				itemWriter.write(po.getMoney() + "");
				itemWriter.write(":");
				itemWriter.write(po.getName());
				itemWriter.write(":");
				itemWriter.write(po.getAccount() + "");
				itemWriter.write(":");
				itemWriter.write(po.getEntry() + "");
				itemWriter.write(":");
				itemWriter.write(po.getNote() + "");
				itemWriter.write(":");
				itemWriter.write(po.getReward() + "");
				itemWriter.write(":");
				itemWriter.write(po.getLst() + "");
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
		System.out.println("INSERT SUCCESS!");
	}

	@Override
	public MoneyOutListPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		MoneyOutListPO po = null;
		FileReader fr = null;
		BaccountPO bapo = null;
		try {
			fr = new FileReader("TxtData/MoneyOutList.txt");
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
		while (Line != null) {
			String output[] = Line.split(":");
			String b[] = output[4].split(",");
			bapo = new BaccountPO(b[0], b[1], b[2]);
			if (output[0].equals(String.valueOf(id))) {// long id,TimePO
														// time,double
														// money,String
														// name,BaccountPO
														// account,
				// Entry entry,String note,RewardType reward,ListState lst;
				po = new MoneyOutListPO(id, TimePO.toSpeccialTime(output[1]), Double.parseDouble(output[2]), output[3],
						bapo, Entry.toEntry(output[5]), output[6], RewardType.toRewardType(output[7]),
						ListState.toState(output[8]));

				break;
			} else {
				try {
					Line = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (Line == null) {
			System.out.println("ID NOT EXIST");
		}

		return po;
	}

}
