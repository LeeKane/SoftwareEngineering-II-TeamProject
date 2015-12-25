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
import java.util.ArrayList;

import dataservice.financedataservice.BAccountManageDataService;
import po.BaccountPO;

public class BAccountDataServiceTxtImpl extends UnicastRemoteObject implements BAccountManageDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BAccountDataServiceTxtImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<BaccountPO> findAll() throws RemoteException, IOException {
		// TODO Auto-generated method stub
		ArrayList<BaccountPO> result = new ArrayList<BaccountPO>();
		
		FileReader fr = new FileReader("TxtData/BAccount.txt");
		BufferedReader br = null;
		br = new BufferedReader(fr);
		String Line = br.readLine();
		while (Line != null) {
			String output[] = Line.split(":");
			BaccountPO po=new BaccountPO(output[1], output[0], output[2]);
			result.add(po);
			Line = br.readLine();
		}
		
		return result;
	}

	@Override
	public void insert(BaccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		File Arrivalfile = new File("TxtData/BAccount.txt");
		if (po == null) {
			System.out.println("BAccount IS NOTHING");
		}
		if (po != null) {
			try {
				OutputStreamWriter itemWriter = new OutputStreamWriter(new FileOutputStream(Arrivalfile, true),
						"UTF-8");
				itemWriter.write(po.getAccount());
				itemWriter.write(":");
				itemWriter.write(po.getName());
				itemWriter.write(":");
				itemWriter.write(po.getBalance());
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
	}

	@Override
	public void delete(String id) throws IOException {
		// TODO Auto-generated method stub
		File accounttempfile = new File("TxtData/BAccountTemp.txt");
		OutputStreamWriter itemWriter = new OutputStreamWriter(new FileOutputStream(accounttempfile, true), "UTF-8");

		try {
			File f5 = new File("TxtData/BAccountTemp.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		FileReader fr = null;
		fr = new FileReader("TxtData/BAccount.txt");
		String Line = null;
		String temp = null;
		BufferedReader br = null;
		br = new BufferedReader(fr);
		Line = br.readLine();

		while (Line != null) {
			String output[] = Line.split(":");

			if (!output[0].equals(id)) {

				itemWriter.write(Line);
				itemWriter.write("\r\n");

			}
			if (output[0].equals(id)) {
				;
			}

			Line = br.readLine();
		}
		itemWriter.close();

		FileReader fr2 = null;
		fr2 = new FileReader("TxtData/BAccountTemp.txt");
		String Line2 = null;

		BufferedReader br2 = null;
		br2 = new BufferedReader(fr2);
		Line2 = br2.readLine();
		init();
		File financetempfile2 = new File("TxtData/BAccount.txt");
		OutputStreamWriter itemWriter2 = new OutputStreamWriter(new FileOutputStream(financetempfile2, true), "UTF-8");
		while (Line2 != null) {
			itemWriter2.write(Line2);
			itemWriter2.write("\r\n");
			Line2 = br2.readLine();
		}
		itemWriter2.close();
		try {
			File f5 = new File("TxtData/BAccountTemp.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("DELETE SUCCESS!");
	}

	@Override
	public BaccountPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		BaccountPO po = null;
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/BAccount.txt");
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
			if (output[0].equals(id)) {
				po=new BaccountPO(output[1], output[0], output[2]);
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
			System.out.println("BAccount NOT EXIST");
		}

		return po;
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			File f5 = new File("TxtData/BAccount.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(BaccountPO po) throws RemoteException,IOException {
		// TODO Auto-generated method stub
		System.out.println("asda"+po.getAccount());
		String id = po.getAccount();
		delete(id);
		insert(po);
	}
}
