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

import dataservice.CarDataService.CarDataService;
import po.CarPO;
import po.TimePO;
import util.Vehicle;

public class CarDataServiceTxtImpl implements CarDataService{

	@Override
	public void insert(CarPO po) {
		// TODO Auto-generated method stub
		File carfile=new File("TxtData/car.txt");
		if(po==null){
			;
		}if(po!=null){
		try {				
			   OutputStreamWriter itemWriter = new OutputStreamWriter(
				new FileOutputStream(carfile,true),"UTF-8"); 
			   
	            itemWriter.write(po.getVehicle().toString());
	            itemWriter.write(":");
	            itemWriter.write(po.getName());
	            itemWriter.write(":");
	            itemWriter.write(po.getEngine()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getCarNum());
	            itemWriter.write(":");
	            itemWriter.write(po.getBasenumber()+"");
	            itemWriter.write(":");
	            itemWriter.write(po.getBuytime().toString());
	            itemWriter.write(":");
	            itemWriter.write(po.getUsetime().toString());
	            itemWriter.write(":");
	            itemWriter.write("\r\n");
	            itemWriter.close();
		}
		catch (FileNotFoundException e) {
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
	public CarPO find(String name) throws IOException {
		CarPO po=null;
		FileReader fr=new FileReader("TxtData/car.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			if(output[1].equals(name)){
				 po=new CarPO(Vehicle.toVehicle(output[0]),name,Long.parseLong(output[2]),output[3],Long.parseLong(output[4]),TimePO.toTime(output[5]),TimePO.toTime(output[6]));
			
				break;
		}
			else{
				Line = br.readLine();
			}
		}
		if(Line==null){
			System.out.println("CAR NOT EXIST");
		}
		
		return po;
	}
	

	@Override
	public void delete(String name) throws IOException {
		// TODO Auto-generated method stub
	

		
		File accounttempfile=new File("TxtData/carTemp.txt");
		 OutputStreamWriter itemWriter = new OutputStreamWriter(
					new FileOutputStream(accounttempfile,true),"UTF-8"); 
		 
		 try 
		   {    
		 File f5 = new File("TxtData/carTemp.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		FileReader fr = null;
		fr = new FileReader("TxtData/car.txt");
		String Line=null;
		String temp=null;
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 Line=br.readLine();
		
		 while(Line!=null){
			String output[]=Line.split(":");
			
			if(!output[1].equals(name)){
				
				itemWriter.write(Line);
				itemWriter.write("\r\n");
	      
			}if(output[1].equals(name)){
				;
			}
			
			Line=br.readLine();
		}
		itemWriter.close();
		
		FileReader fr2 = null;
		fr2 = new FileReader("TxtData/carTemp.txt");
		String Line2=null;
	
		BufferedReader br2 = null;
		 br2 = new BufferedReader(fr2);
		 Line2=br2.readLine();
		init();
		File financetempfile2=new File("TxtData/car.txt");
		 OutputStreamWriter itemWriter2 = new OutputStreamWriter(
					new FileOutputStream(financetempfile2,true),"UTF-8"); 
		while(Line2!=null){
			itemWriter2.write(Line2);
			itemWriter2.write("\r\n");
			Line2=br2.readLine();
		}
		itemWriter2.close();
		 try 
		   {    
		 File f5 = new File("TxtData/carTemp.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		
		
		System.out.println("DELETE SUCCESS!");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try 
		   {    
		 File f5 = new File("TxtData/car.txt");
		       FileWriter fw5 = new FileWriter(f5);
		       BufferedWriter bw1 = new BufferedWriter(fw5);
		       bw1.write("");
		   }
		   catch (Exception e)
		   {
			   
		   }
		System.out.println("INIT SUCCESS");

	}
	

	@Override
	public void update(CarPO car) throws IOException {
		// TODO Auto-generated method stub
		String name=car.getName();
		delete(name);
		insert(car);
	}
}
