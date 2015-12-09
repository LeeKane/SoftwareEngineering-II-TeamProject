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

import dataservice.inquiredataservice.InquireDataService;
import po.InstitutePO;
import po.TimePO;
import po.TransPO;
import util.City;
import util.OrgType;
import util.TransState;

public class InquireDataServiceTxtImpl extends UnicastRemoteObject implements InquireDataService {

	public InquireDataServiceTxtImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<TransPO> find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<TransPO> transHistoryPOList = new ArrayList<TransPO>();
		TransPO po = null;
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
		while (Line != null) {
			String output[] = Line.split(":");
			String t[] = output[1].split("-");
			// System.out.println(id+"ss"+output[0]);
			if (output[0].equals(String.valueOf(id))) {
				TimePO time2 = new TimePO(Integer.parseInt(t[0]), Integer.parseInt(t[1]), Integer.parseInt(t[2]),
						Integer.parseInt(t[3]), Integer.parseInt(t[4]), Integer.parseInt(t[5]));
				InstitutePO ins = new InstitutePO(City.toCity(output[2]), OrgType.toOrgType(output[3]), "1111111");// 添加机构id
				po = new TransPO(id, TransState.toTransState(output[4]), time2, ins);
				transHistoryPOList.add(po);
			}
			try {
				Line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return transHistoryPOList;
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			File f5 = new File("TxtData/inquire.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {

		}
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("FINISH SUCCESS!");
	}

	@Override
	public void insert(TransPO transPO) throws RemoteException {
		// TODO Auto-generated method stub
		File transHistoryfile = new File("TxtData/inquire.txt");
		if (transPO != null) {
			try {
				OutputStreamWriter itemWriter = new OutputStreamWriter(new FileOutputStream(transHistoryfile, true),
						"UTF-8");
				itemWriter.write(transPO.getId() + "");
				itemWriter.write(":");
				itemWriter.write(transPO.getTime().toString());
				itemWriter.write(":");
				itemWriter.write(transPO.getInstitute().getCity().toString());
				itemWriter.write(":");
				itemWriter.write(transPO.getInstitute().getOrg().toString());
				itemWriter.write(":");
				itemWriter.write(transPO.getStatement().toString() + "");
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
}
