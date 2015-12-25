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

import dataservice.listdataservice.TransCenterArrivalListDataService;
import po.TimePO;
import po.list.TranscenterArrivalListPO;
import util.City;
import util.GoodState;
import util.ListState;
import vo.TransShow;

public class TransCenterArrivalListDataServiceTxtImpl extends UnicastRemoteObject
		implements TransCenterArrivalListDataService {

	public TransCenterArrivalListDataServiceTxtImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert(TranscenterArrivalListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String orders=null;
		try {
			orders=findAllOrder(po.getid());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File loginfile = new File("TxtData/TransCenterArrival.txt");
		try {
			OutputStreamWriter itemWriter = new OutputStreamWriter(new FileOutputStream(loginfile, true), "UTF-8");
			itemWriter.write(po.getTranscenterID() + "");
			itemWriter.write(":");
			itemWriter.write(po.getArrivatime() + "");
			itemWriter.write(":");
			itemWriter.write(po.getid() + "");
			itemWriter.write(":");
			itemWriter.write(po.getStartCity() + "");
			itemWriter.write(":");
			itemWriter.write(po.getState() + "");
			itemWriter.write(":");
			itemWriter.write(po.getLst() + "");
			itemWriter.write(":");
			itemWriter.write(po.getCode() + "");
			itemWriter.write(":");
			itemWriter.write(orders);
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
			File f5 = new File("TxtData/TransCenterArrival.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {

		}

	}

	
	
	@Override
	public TranscenterArrivalListPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		TranscenterArrivalListPO po = null;
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/TransCenterArrival.txt");
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
				po = new TranscenterArrivalListPO(output[0],
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
			System.out.println("LIST NOT EXIST");
		}

		return po;
	}

	public long getTransid(long centerid,long id) throws RemoteException{
		long result=0;
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/TransCenterArrival.txt");
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
			if (output[0].equals(String.valueOf(centerid))) {
			String list[]=output[7].split("-");
			TimePO time=TimePO.toTime(output[1]);
			for(int i=0;i<list.length;i++){
				if(id==Long.parseLong(list[i])){
					result=Long.parseLong(output[6]);
					break;
				}
			
			}
			}
			
			try {
				Line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		if (Line == null) {
		
		}
		
		
		
		return result;
	}
	
	public ArrayList<TransShow> findtrans(long centerid) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<TransShow> po = new ArrayList<TransShow>();
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/TransCenterArrival.txt");
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
			if (output[0].equals(String.valueOf(centerid))) {
			String list[]=output[7].split("-");
			TimePO time=TimePO.toTime(output[1]);
			for(int i=0;i<list.length;i++){
				TransShow s=new TransShow(centerid,Long.parseLong(list[i]),time);
				po.add(s);
			}
			}
			
			try {
				Line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		if (Line == null) {
		
		}

		return po;
	}
	
	
	
	@Override
	public TranscenterArrivalListPO findlast() throws RemoteException, IOException {
		TranscenterArrivalListPO po = null;
		FileReader fr = null;
		File file = new File("TxtData/TransCenterArrival.txt");

		String Line = readLastLine(file, "UTF-8");
		
		System.out.println(Line+"hahsadh");
				
		if (Line.length()>10) {
			String[] output = Line.split(":");
			po = find(Long.parseLong(output[2]));
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
	public String findAllOrder(long id) throws RemoteException, IOException {
		// TODO Auto-generated method stub
		String result=null;
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/LoadingList_Hall.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = null;
		br = new BufferedReader(fr);
		String Line = null;
		try {
			Line = br.readLine();
			System.out.println(Line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (Line != null) {
			System.out.println(Line);
			String output[] = Line.split(":");
			if (output[0].equals(id+"")) {
				System.out.println(output[0]);
				result=output[6];
				System.out.println(result);
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
			System.out.println("LIST NOT EXIST");
			return null;
		}
		
		return result;
	}

}
