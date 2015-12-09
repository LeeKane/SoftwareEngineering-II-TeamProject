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

import dataservice.listdataservice.TransListDataService;
import po.list.TransListPO;

//中转中心业务员装运管理
public class TransListDataServiceTxtImpl extends UnicastRemoteObject implements TransListDataService {

	protected TransListDataServiceTxtImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(TransListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		File loginfile = new File("TxtData/Trans.txt");
		try {
			OutputStreamWriter itemWriter = new OutputStreamWriter(new FileOutputStream(loginfile, true), "UTF-8");
			itemWriter.write(po.getType() + "");
			itemWriter.write(":");
			itemWriter.write(po.getTime() + "");
			itemWriter.write(":");
			itemWriter.write(po.getId() + "");
			itemWriter.write(":");
			itemWriter.write(po.getTransID() + "");
			itemWriter.write(":");
			itemWriter.write(po.getStartCity() + "");
			itemWriter.write(":");
			itemWriter.write(po.getEndCity() + "");
			itemWriter.write(":");
			itemWriter.write(po.getTransboxID() + "");
			itemWriter.write(":");
			itemWriter.write(po.getSupersivor() + "");
			itemWriter.write(":");
			long[] list = po.getOrderlist();
			for (int i = 0; i < list.length; i++) {
				if (i != list.length - 1)
					itemWriter.write(list[i] + "-");
				else {
					itemWriter.write(list[i] + "");
				}
			}

			itemWriter.write(":");
			itemWriter.write(po.getYunfei() + "");
			itemWriter.write(":");
			itemWriter.write(po.getLst().toString());
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
		System.out.println("INSERT SUCCESS!!");
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			File f5 = new File("TxtData/Trans.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {

		}
	}

	@Override
	public TransListPO find(long id) throws RemoteException {
		TransListPO po = null;
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/Trans.txt");
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
				String l[] = output[8].split("-");

				long[] list = new long[l.length];
				for (int i = 0; i < l.length; i++) {
					list[i] = Long.parseLong(l[i]);

				}
				//
				// po=new TransListPO(ListType.toListType(output[0]), new
				// TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),0,0,0),
				// id,Long.parseLong(output[3]),
				// City.toCity(output[4]),City.toCity(output[5]),Long.parseLong(output[6]),output[7],list,Double.parseDouble(output[9]),ListState.toState(output[10]));

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
			System.out.println("TRANSLIST NOT EXIST");
		}

		return po;
	}

	@Override
	public TransListPO findlast() throws RemoteException, IOException {
		TransListPO po = null;
		FileReader fr = null;
		File file = new File("TxtData/Trans.txt");

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

}
