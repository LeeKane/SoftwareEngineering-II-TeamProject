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

import dataservice.listdataservice.ArrivalListDataService;
import po.TimePO;
import po.list.ArrivaListPO;
import util.City;
import util.GoodState;
import util.ListState;
import util.ListType;

//营业厅业务员接受
public class ArrivalListImpl extends UnicastRemoteObject implements ArrivalListDataService {

	public ArrivalListImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean insert(ArrivaListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		File Arrivalfile = new File("TxtData/ArrivalList.txt");
		if (po == null) {
			System.out.println("ARRIVALLIST IS NOTHING");
		}
		if (po != null) {
			try {
				OutputStreamWriter itemWriter = new OutputStreamWriter(new FileOutputStream(Arrivalfile, true),
						"UTF-8");
				itemWriter.write(po.getType() + "");
				itemWriter.write(":");
				itemWriter.write(po.getTime() + "");
				itemWriter.write(":");
				itemWriter.write(po.getid() + "");
				itemWriter.write(":");
				itemWriter.write(po.getStartCity() + "");
				itemWriter.write(":");
				itemWriter.write(po.getState() + "");
				itemWriter.write(":");
				itemWriter.write(po.getLst().toString());
				itemWriter.write(":");
				itemWriter.write(po.getCode() + "");
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

		return true;

	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			File f5 = new File("TxtData/ArrivalList.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {

		}
	}

	@Override
	public ArrivaListPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		ArrivaListPO po = null;
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/ArrivalList.txt");
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
			if (output[2].equals(String.valueOf(id))) {
				String t[] = output[1].split("-");

				po = new ArrivaListPO(ListType.toListType(output[0]),
						new TimePO(Integer.parseInt(t[0]), Integer.parseInt(t[1]), Integer.parseInt(t[2]), 0, 0, 0), id,
						City.toCity(output[3]), GoodState.toState(output[4]), ListState.toState(output[5]),
						Long.parseLong(output[6]));

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
			System.out.println("ARRIVALIST NOT EXIST");
		}

		return po;
	}

	@Override
	public ArrivaListPO findlast() throws RemoteException, IOException {
		ArrivaListPO po = null;
		FileReader fr = null;
		File file = new File("TxtData/ArrivalList.txt");
		String Line = readLastLine(file, "UTF-8");
		String[] output = Line.split(":");
		po = find(Long.parseLong(output[2]));
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
	public ArrayList<ArrivaListPO> findNoneReviewd() throws RemoteException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ArrivaListPO> temp = new ArrayList<ArrivaListPO>();
		ArrayList<ArrivaListPO> result = new ArrayList<ArrivaListPO>();
		temp = findallArrival();
		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).getLst().equals(ListState.SUBMITTED)) {
				result.add(temp.get(i));
			} else {
				;
			}
		}

		return result;
	}

	@Override
	public ArrayList<ArrivaListPO> findallArrival() throws RemoteException, IOException {
		ArrayList<ArrivaListPO> result = new ArrayList<ArrivaListPO>();
		FileReader fr = new FileReader("TxtData/ArrivalList.txt");
		BufferedReader br = null;
		br = new BufferedReader(fr);
		String Line = br.readLine();
		while (Line != null) {
			String output[] = Line.split(":");
			String t[] = output[1].split("-");
			ArrivaListPO po = new ArrivaListPO(ListType.toListType(output[0]),
					new TimePO(Integer.parseInt(t[0]), Integer.parseInt(t[1]), Integer.parseInt(t[2]), 0, 0, 0),
					Long.parseLong(output[2]), City.toCity(output[3]), GoodState.toState(output[4]),
					ListState.toState(output[5]), Long.parseLong(output[6]));

			result.add(po);
			Line = br.readLine();
		}
		return result;
	}

}
