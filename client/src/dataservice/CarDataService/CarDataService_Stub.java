package dataservice.CarDataService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import po.AccountPO;
import po.CarPO;
import util.Permission;
import util.Vehicle;

public class CarDataService_Stub implements CarDataService{

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
	public CarPO find(String name) {
		CarPO po=null;
		FileReader fr=new FileReader("TxtData/car.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			if(output[1].equals(name)){
				 po=new CarPO(Vehicle.toVehicle(output[1]),name,Long.parseLong(output[3]),output[4],Long.parseLong(output[5]),);
			
				break;
		}
			else{
				Line = br.readLine();
			}
		}
		if(Line==null){
			System.out.println("ID NOT EXIST");
		}
		
		return po;
	}
	}

	@Override
	public void delete(String carnum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CarPO car) {
		// TODO Auto-generated method stub
		
	}

}
