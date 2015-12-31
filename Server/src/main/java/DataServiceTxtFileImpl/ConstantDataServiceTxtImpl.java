package DataServiceTxtFileImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.reviewdataservice.ConstantDataService;
import po.ConstantPO;

public class ConstantDataServiceTxtImpl extends UnicastRemoteObject implements ConstantDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConstantDataServiceTxtImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<ConstantPO> findAllPrice() throws RemoteException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ConstantPO> result = new ArrayList<ConstantPO>();
		FileReader fr = new FileReader("TxtData/PriceConstant.txt");
		BufferedReader br = null;
		br = new BufferedReader(fr);
		String Line = br.readLine();
		while (Line != null) {
			String output[] = Line.split(":");
			ConstantPO po = new ConstantPO(output[0], Double.parseDouble(output[1]));
			result.add(po);
			Line = br.readLine();
		}
		br.close();
		return result;
	}

	@Override
	public void setPrice(ConstantPO po) throws RemoteException, IOException {
		// TODO Auto-generated method stub
		File loginfile = new File("TxtData/PriceConstant.txt");
		if (po == null) {
			;
		}
		if (po != null) {
			try {
				OutputStreamWriter itemWriter = new OutputStreamWriter(new FileOutputStream(loginfile, true), "UTF-8");

				itemWriter.write(po.getName());
				itemWriter.write(":");
				itemWriter.write(po.getValue()+"");
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

}
