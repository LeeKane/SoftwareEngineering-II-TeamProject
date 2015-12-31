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
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.reviewdataservice.StaffDataService;
import po.StaffPO;
import util.City;
import util.OrgType;
import util.Permission;

public class StaffDataServiceTxtImpl extends UnicastRemoteObject implements StaffDataService {

	public StaffDataServiceTxtImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			File f5 = new File("TxtData/staff.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {

		}
		System.out.println("INIT SUCCESS");
	}

	@Override
	public void insert(StaffPO po) {
		File loginfile = new File("TxtData/staff.txt");
		if (po == null) {
			;
		}
		if (po != null) {
			try {
				OutputStreamWriter itemWriter = new OutputStreamWriter(new FileOutputStream(loginfile, true), "UTF-8");

				itemWriter.write(po.getOrgid());
				itemWriter.write(":");
				itemWriter.write(po.getId());
				itemWriter.write(":");
				itemWriter.write(po.getCity().toString());
				itemWriter.write(":");
				itemWriter.write(po.getOrgType().toString());
				itemWriter.write(":");
				itemWriter.write(po.getPermission().toString());
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

	@Override
	public StaffPO find(String orgid, String id) throws RemoteException, IOException {
		StaffPO po = null;
		FileReader fr = new FileReader("TxtData/staff.txt");
		BufferedReader br = null;
		br = new BufferedReader(fr);
		String Line = br.readLine();
		while (Line != null) {
			String output[] = Line.split(":");
			if (output[0].equals(orgid) && output[1].equals(id)) {
//				System.out.println(output[2]);
				po = new StaffPO(orgid, id, City.toCity(output[2]), OrgType.toOrgType(output[3]),
						Permission.toPermission(output[4]));

				break;
			} else {
				Line = br.readLine();
			}
		}
		if (Line == null) {
			System.out.println("ID NOT EXIST");
		}

		return po;
	}

	@Override
	public String readLastLine(File file, String charset) throws RemoteException, IOException {
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
	public StaffPO findlast(String orgId, String permission) throws RemoteException, IOException {
		StaffPO po = null;

		ArrayList<Long> list = new ArrayList<Long>();
		File fileSrc = new File("TxtData/staff.txt");
		BufferedReader fin = new BufferedReader(new FileReader(fileSrc));
		String line;
		while ((line = fin.readLine()) != null) {
			String array[] = line.split(":");
			if (array[0].equals(orgId)) {
				list.add(Long.parseLong(array[1]));
			}
		}

		fin.close();
		if (!list.isEmpty()) {
			long max = list.get(0);
			for (long i : list) {
				if (i > max)
					max = i;
			}

			po = find(orgId, max + "");
		}

		return po;
	}

	@Override
	public ArrayList<String> findbyOrg(City city, OrgType org) throws RemoteException, IOException {
		ArrayList<String> result = new ArrayList<String>();
		FileReader fr = new FileReader("TxtData/institute.txt");
		BufferedReader br = null;
		br = new BufferedReader(fr);
		String Line = br.readLine();
		while (Line != null) {

			String output[] = Line.split(":");
			if (city.toString().equals(output[1]) && org.toString().equals(output[2])) {
				result.add(output[0]);
			} else {
				;
			}
			Line = br.readLine();
		}
		return result;
	}

	@Override
	public void delete(String orgid, String id) throws RemoteException, IOException {
		// TODO Auto-generated method stub
		File logintempfile = new File("TxtData/staffTemp.txt");
		OutputStreamWriter itemWriter = new OutputStreamWriter(new FileOutputStream(logintempfile, true), "UTF-8");

		try {
			File f5 = new File("TxtData/staffTemp.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {

		}
		FileReader fr = null;
		fr = new FileReader("TxtData/staff.txt");
		String Line = null;
		String temp = null;
		BufferedReader br = null;
		br = new BufferedReader(fr);
		Line = br.readLine();

		while (Line != null) {
			String output[] = Line.split(":");

			if (!(output[0].equals(orgid) && output[1].equals(id))) {

				itemWriter.write(Line);
				itemWriter.write("\r\n");

			}
			if (output[0].equals(orgid) && output[1].equals(id)) {
				;
			}

			Line = br.readLine();
		}
		itemWriter.close();

		FileReader fr2 = null;
		fr2 = new FileReader("TxtData/staffTemp.txt");
		String Line2 = null;

		BufferedReader br2 = null;
		br2 = new BufferedReader(fr2);
		Line2 = br2.readLine();
		init();
		File financetempfile2 = new File("TxtData/staff.txt");
		OutputStreamWriter itemWriter2 = new OutputStreamWriter(new FileOutputStream(financetempfile2, true), "UTF-8");
		while (Line2 != null) {
			itemWriter2.write(Line2);
			itemWriter2.write("\r\n");
			Line2 = br2.readLine();
		}
		itemWriter2.close();
		try {
			File f5 = new File("TxtData/staffTemp.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {

		}
	}

	@Override
	public void update(StaffPO po) throws RemoteException, IOException {
		// TODO Auto-generated method stub
		delete(po.getOrgid(), po.getId());
		insert(po);
	}

	@Override
	public ArrayList<StaffPO> findAll() throws RemoteException, IOException {
		// TODO Auto-generated method stub
		ArrayList<StaffPO> result = new ArrayList<StaffPO>();
		FileReader fr = new FileReader("TxtData/staff.txt");
		BufferedReader br = null;
		br = new BufferedReader(fr);
		String Line = br.readLine();
		while (Line != null) {
			String output[] = Line.split(":");
			StaffPO po = new StaffPO(output[0], output[1], City.toCity(output[2]), OrgType.toOrgType(output[3]),
					Permission.toPermission(output[4]));
			result.add(po);
			Line = br.readLine();
		}
		return result;
	}
}
