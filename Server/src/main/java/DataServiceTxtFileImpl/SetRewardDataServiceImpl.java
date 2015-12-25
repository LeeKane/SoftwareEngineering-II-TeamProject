package DataServiceTxtFileImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.reviewdataservice.ReviewDataService;
import dataservice.reviewdataservice.SetRewardDataService;

public class SetRewardDataServiceImpl extends UnicastRemoteObject implements SetRewardDataService {

	public SetRewardDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double[] findall() throws RemoteException {
		// TODO Auto-generated method stub
		double[] result=new double[9];
		FileReader fr = null;
		try {
			fr = new FileReader("TxtData/Reward.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Line = null;
		BufferedReader br = null;
		br = new BufferedReader(fr);
		try {
			Line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String output[] = Line.split(":");
		for(int i=0;i<output.length;i++)
		{
			result[i]=Double.parseDouble(output[i]);
		}
		return result;
	}

	@Override
	public void Set(double[] s) throws RemoteException {
		// TODO Auto-generated method stub
		String str="";
		int i=0;
		for(i=0;i<s.length-1;i++)
		{
			str+=(s[i]+":");
		}
		str+=s[i];
		StringBuffer sb=new StringBuffer();
		BufferedReader bfr=null;
		String temp="";
		try{
		         FileReader fr = new FileReader("TxtData/Reward.txt");
		         bfr=new BufferedReader(fr);
		         temp=bfr.readLine();
		         }
		catch (Exception e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 		}
		try {
			bfr.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sb.append(str);
		try{
			BufferedWriter bfw=new BufferedWriter(new FileWriter("TxtData/Reward.txt"));
			bfw.write(sb.toString());
		    bfw.close(); 
	}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	

}
