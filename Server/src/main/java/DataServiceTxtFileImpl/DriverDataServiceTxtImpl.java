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

import dataservice.transdataservice.DriverDataService;
import po.DriverPO;
import po.TimePO;

public class DriverDataServiceTxtImpl extends UnicastRemoteObject implements DriverDataService {
	public DriverDataServiceTxtImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		File carfile = new File("TxtData/driver.txt");
		if (po == null) {
			;
		}
		if (po != null) {
			try {
				OutputStreamWriter itemWriter = new OutputStreamWriter(new FileOutputStream(carfile, true), "UTF-8");

				itemWriter.write(po.getNumber() + "");
				itemWriter.write(":");
				itemWriter.write(po.getName());
				itemWriter.write(":");
				itemWriter.write(po.getBirthday().toString());
				itemWriter.write(":");
				itemWriter.write(po.getID());
				itemWriter.write(":");
				itemWriter.write(po.getTel());
				itemWriter.write(":");
				itemWriter.write(po.getCarunit());
				itemWriter.write(":");
				itemWriter.write(po.getSex());
				itemWriter.write(":");
				itemWriter.write(po.getLicensedate().toString());
				itemWriter.write(":");
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
	public DriverPO find(long number) throws RemoteException, IOException {
		DriverPO po = null;
		FileReader fr = new FileReader("TxtData/driver.txt");
		BufferedReader br = null;
		br = new BufferedReader(fr);
		String Line = br.readLine();
		while (Line != null) {
			String output[] = Line.split(":");
			if (Long.parseLong(output[0]) == number) {
				po = new DriverPO(number, output[1], TimePO.toTime(output[2]), output[3], output[4], output[5],
						output[6], TimePO.toTime(output[7]));

				break;
			} else {
				Line = br.readLine();
			}
		}
		if (Line == null) {
			System.out.println("CAR NOT EXIST");
		}

		return po;
	}

	@Override
	public void delete(long number) throws RemoteException, IOException {

		File accounttempfile = new File("TxtData/driverTemp.txt");
		OutputStreamWriter itemWriter = new OutputStreamWriter(new FileOutputStream(accounttempfile, true), "UTF-8");

		try {
			File f5 = new File("TxtData/driverTemp.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {

		}
		FileReader fr = null;
		fr = new FileReader("TxtData/driver.txt");
		String Line = null;
		String temp = null;
		BufferedReader br = null;
		br = new BufferedReader(fr);
		Line = br.readLine();

		while (Line != null) {
			String output[] = Line.split(":");

			if (Long.parseLong(output[0]) != number) {

				itemWriter.write(Line);
				itemWriter.write("\r\n");

			}
			if (Long.parseLong(output[0]) == number) {
				;
			}

			Line = br.readLine();
		}
		itemWriter.close();

		FileReader fr2 = null;
		fr2 = new FileReader("TxtData/driverTemp.txt");
		String Line2 = null;

		BufferedReader br2 = null;
		br2 = new BufferedReader(fr2);
		Line2 = br2.readLine();
		init();
		File financetempfile2 = new File("TxtData/driver.txt");
		OutputStreamWriter itemWriter2 = new OutputStreamWriter(new FileOutputStream(financetempfile2, true), "UTF-8");
		while (Line2 != null) {
			itemWriter2.write(Line2);
			itemWriter2.write("\r\n");
			Line2 = br2.readLine();
		}
		itemWriter2.close();
		try {
			File f5 = new File("TxtData/driverTemp.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {

		}

		System.out.println("DELETE SUCCESS!");

	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			File f5 = new File("TxtData/driver.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {

		}
		System.out.println("INIT SUCCESS");
	}

	@Override
	public void update(DriverPO po) throws RemoteException, IOException {
		// TODO Auto-generated method stub
		long number = po.getNumber();
		delete(number);
		insert(po);

	}

	@Override
	public ArrayList<DriverPO> findAll() throws RemoteException, IOException {
		// TODO Auto-generated method stub
		ArrayList<DriverPO> result = new ArrayList<DriverPO>();
		FileReader fr = new FileReader("TxtData/Driver.txt");
		BufferedReader br = null;
		br = new BufferedReader(fr);
		String Line = br.readLine();
		while (Line != null) {
			String output[] = Line.split(":");
			DriverPO po = new DriverPO(Long.valueOf(output[0]).longValue(), output[1], TimePO.toTime(output[2]),
					output[3], output[4], output[5], output[6], TimePO.toTime(output[7]));
			result.add(po);
			Line = br.readLine();
		}
		return result;
	}

	public String readLastLine(File file, String charset) throws RemoteException, IOException {
		// TODO Auto-generated method stub
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
	public DriverPO findlast() throws RemoteException, IOException {
		// TODO Auto-generated method stub
		DriverPO po = null;
		FileReader fr = null;
		File file = new File("TxtData/driver.txt");
		String Line = readLastLine(file, "UTF-8");
		String[] output = Line.split(":");
		po = find(Long.parseLong(output[0]));
		return po;

	}

}
