package DataServiceTxtFileImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.reviewdataservice.BeginningSetupDataService;
import po.Garage;
import po.SetupPO;
import po.TimePO;
import serverUtil.FileVisitorUtil;

public class BeginningSetupDataServiceTxtImpl extends UnicastRemoteObject implements BeginningSetupDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BeginningSetupDataServiceTxtImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(SetupPO po) throws IOException, RemoteException {
		// TODO Auto-generated method stub
		File setup = new File("TxtData/Setup/Setup.txt");
		OutputStreamWriter itemWriter = new OutputStreamWriter(new FileOutputStream(setup, true), "UTF-8");
		itemWriter.write(po.getSetTime().toString());
		itemWriter.write(":");
		itemWriter.write(po.getName());
		itemWriter.write(":");
		itemWriter.write(po.getRemark());
		itemWriter.write(":");
		itemWriter.write(Boolean.toString(po.getIsSelected()));
		itemWriter.write("\r\n");
		itemWriter.close();

		if (po.getIsSelected() == true)
			return;
		File file = new File("TxtData/Setup/" + po.getSetTime().toString());
		if (!file.exists() && !file.isDirectory()) {
			System.out.println("//不存在");
			file.mkdir();
		} else {
			return;
		}

		for (String str : FileVisitorUtil.getList("TxtData/")) {
			String pathArray[] = str.split("/");
			if (pathArray[1].equals("Setup"))
				continue;
			try {
				File f5 = new File("TxtData/Setup/" + po.getSetTime().toString() + "/" + pathArray[1]);
				FileWriter fw5 = new FileWriter(f5);
				BufferedWriter bw1 = new BufferedWriter(fw5);
				if (pathArray[1].equals("staff.txt")) {
					bw1.write("10000:1000:北京:营业厅:管理员");
					bw1.write("\r\n");
					bw1.write("10000:2000:北京:营业厅:总经理");
					bw1.write("\r\n");
					bw1.write("10000:3000:北京:营业厅:财务人员");
					bw1.write("\r\n");
					bw1.write("10000:4000:北京:营业厅:最高权限财务人员");
					bw1.write("\r\n");
				} else if (pathArray[1].equals("login.txt")) {
					bw1.write("151231:管理员:admin:admin:10000-1000");
					bw1.write("\r\n");
					bw1.write("151251:总经理:manager:123456:10000-2000");
					bw1.write("\r\n");
					bw1.write("151235:财务人员:finance:123456:10000-3000");
					bw1.write("\r\n");
				} else if (pathArray[1].equals("BAccount.txt")) {
					bw1.write("100000:默认账户:0");
				} else if (pathArray[1].equals("institute.txt")) {
					bw1.write("1250:南京:中转中心");
					bw1.write("\r\n");
					bw1.write("1100:北京:中转中心");
					bw1.write("\r\n");
					bw1.write("1210:上海:中转中心");
					bw1.write("\r\n");
					bw1.write("1200:广州:中转中心");
					bw1.write("\r\n");
					bw1.write("12510:南京:营业厅");
					bw1.write("\r\n");
					bw1.write("11010:北京:营业厅");
					bw1.write("\r\n");
					bw1.write("12110:上海:营业厅");
					bw1.write("\r\n");
					bw1.write("12010:广州:营业厅");
					bw1.write("\r\n");
					initgarage(1250, po);
					initgarage(1100, po);
					initgarage(1210, po);
					initgarage(1200, po);
				} else if (pathArray[1].equals("reward.txt")) {
					bw1.write("100000.0:4500.0:6500.0:3800.0:3700.0:3100.0:3600.0:100.0:0.1");
					bw1.write("\r\n");
				} else
					bw1.write("");
				bw1.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void swap(SetupPO po1, SetupPO po2) throws RemoteException, IOException {
		// TODO Auto-generated method stub
		System.out.println(po1.getSetTime().toString());
		for (String str : FileVisitorUtil.getList("TxtData/")) {
			String pathArray[] = str.split("/");
			String arg2 = "TxtData/Setup/" + po1.getSetTime().toString() + "/" + pathArray[1];
			File file1 = new File(str);
			File file2 = new File(arg2);
			FileVisitorUtil.nioTransferCopy(file1, file2);
		}
		System.out.println(po2.getSetTime().toString());
		for (String str : FileVisitorUtil.getList("TxtData/Setup/" + po2.getSetTime().toString() + "/")) {
			String pathArray[] = str.split("/");
			String arg1 = "TxtData/" + pathArray[3];
			File file1 = new File(str);
			File file2 = new File(arg1);
			FileVisitorUtil.nioTransferCopy(file1, file2);
		}
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			File f5 = new File("TxtData/Setup/Setup.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
			bw1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("INIT SUCCESS");
	}

	@Override
	public ArrayList<SetupPO> findAll() throws RemoteException, IOException {
		// TODO Auto-generated method stub
		ArrayList<SetupPO> result = new ArrayList<SetupPO>();
		FileReader fr = new FileReader("TxtData/Setup/Setup.txt");
		BufferedReader br = null;
		br = new BufferedReader(fr);
		String Line = br.readLine();
		while (Line != null) {
			String output[] = Line.split(":");
			System.out.println(Line);
			boolean isSelected = false;
			if (output[3].equals("true"))
				isSelected = true;
			SetupPO po = new SetupPO(TimePO.toTime(output[0]), output[1], output[2], isSelected);
			result.add(po);
			Line = br.readLine();
		}
		br.close();
		return result;
	}

	@Override
	public void delete(String time) throws RemoteException, IOException {
		// TODO Auto-generated method stub
		File accounttempfile = new File("TxtData/Setup/SetupTemp.txt");
		OutputStreamWriter itemWriter = new OutputStreamWriter(new FileOutputStream(accounttempfile, true), "UTF-8");

		try {
			File f5 = new File("TxtData/Setup/SetupTemp.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		FileReader fr = null;
		fr = new FileReader("TxtData/Setup/Setup.txt");
		String Line = null;
		String temp = null;
		BufferedReader br = null;
		br = new BufferedReader(fr);
		Line = br.readLine();

		while (Line != null) {
			String output[] = Line.split(":");

			if (!output[0].equals(time)) {

				itemWriter.write(Line);
				itemWriter.write("\r\n");

			}
			if (output[0].equals(time)) {
				;
			}

			Line = br.readLine();
		}
		itemWriter.close();

		FileReader fr2 = null;
		fr2 = new FileReader("TxtData/Setup/SetupTemp.txt");
		String Line2 = null;

		BufferedReader br2 = null;
		br2 = new BufferedReader(fr2);
		Line2 = br2.readLine();
		init();
		File financetempfile2 = new File("TxtData/Setup/Setup.txt");
		OutputStreamWriter itemWriter2 = new OutputStreamWriter(new FileOutputStream(financetempfile2, true), "UTF-8");
		while (Line2 != null) {
			itemWriter2.write(Line2);
			itemWriter2.write("\r\n");
			Line2 = br2.readLine();
		}
		itemWriter2.close();
		try {
			File f5 = new File("TxtData/Setup/SetupTemp.txt");
			FileWriter fw5 = new FileWriter(f5);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		} catch (Exception e) {
			e.printStackTrace();
		}

		File f5 = new File("TxtData/Setup/" + time);
		FileVisitorUtil.deleteFile(f5);
	}

	@Override
	public void update(SetupPO po) throws RemoteException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void initgarage(long centerid, SetupPO po) throws RemoteException {
		String address = "TxtData/Setup/" + po.getSetTime().toString() + "/" + centerid + "_plane.txt";
		String address2 = "TxtData/Setup/" + po.getSetTime().toString() + "/" + centerid + ".txt";
		String address3 = "TxtData/Setup/" + po.getSetTime().toString() + "/" + centerid + "_motor.txt";
		String address4 = "TxtData/Setup/" + po.getSetTime().toString() + "/" + centerid + "_train.txt";
		try {
			init(address4);
			init(address);
			init(address2);
			init(address3);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init(String address) throws RemoteException, IOException {
		// TODO Auto-generated method stub
		Garage g = new Garage();
		g.creat();
		File file = new File(address);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(g);
		oos.flush();
		oos.close();
		fos.close();
	}
}
