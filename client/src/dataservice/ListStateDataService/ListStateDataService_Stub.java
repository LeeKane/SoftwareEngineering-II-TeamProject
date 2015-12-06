package dataservice.ListStateDataService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import po.InstitutePO;
import po.TimePO;
import po.WarePO;
import po.list.ArrivaListPO;
import po.list.DeliveryListPO;
import po.list.LoadingListPO;
import po.list.MoneyInListPO;
import po.list.MoneyOutListPO;
import po.list.OrderListPO;
import po.list.WareInListPO;
import po.list.WareOutListPO;
import util.City;
import util.DeliverType;
import util.GoodState;
import util.ListState;
import util.ListType;
import util.OrgType;

public class ListStateDataService_Stub implements ListStateDataService {

	@Override
	public ArrayList<ArrivaListPO> findallArrival() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<ArrivaListPO> result=new ArrayList<ArrivaListPO>();
		FileReader fr=new FileReader("TxtData/ArrivalList.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			String t[]=output[1].split("-");
			
			ArrivaListPO po = new ArrivaListPO(ListType.toListType(output[0]),new TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),0,0,0),Long.parseLong(output[2]), City.toCity(output[3]),GoodState.toState(output[4]),ListState.toState(output[5]),Long.parseLong(output[6]));
			result.add(po);
			Line = br.readLine();
		}
		return result;
	}

	@Override
	public ArrayList<DeliveryListPO> findallDelivery() throws IOException  {
		ArrayList<DeliveryListPO> result=new ArrayList<DeliveryListPO>();
		FileReader fr=new FileReader("TxtData/DeliveryList.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
	
			
			DeliveryListPO  po=new DeliveryListPO(Long.parseLong(output[0]),TimePO.toTime(output[1]),Long.parseLong(output[2]), output[3],ListState.toState(output[4]));

			result.add(po);
			Line = br.readLine();
		}
		return result;
	}

	@Override
	public ArrayList<OrderListPO> findallOrder() throws IOException{
		ArrayList<OrderListPO> result=new ArrayList<OrderListPO>();
		FileReader fr=new FileReader("TxtData/orderlist.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			String t[]=output[12].split(",");

			String time[]=t[7].split("-");
			WarePO ware = new WarePO(Double.parseDouble(t[0]), Integer.parseInt(t[1]), Double.parseDouble(t[2]), t[3], t[4], DeliverType.toType(t[5]),  Double.parseDouble(t[6]), TimePO.toTime(t[7]),City.toCity(t[8]),City.toCity(t[9]));
			
			OrderListPO	po=new OrderListPO(ListType.toListType(output[1]),output[2],output[3],output[4],output[5],output[6],output[7],output[8],output[9],output[10],output[11],ware,output[0],ListState.toState(output[13]),output[14]);

			result.add(po);
			Line = br.readLine();
		}
		return result;
	}

	@Override
	public ArrayList<LoadingListPO> findallLoading() throws IOException {
		ArrayList<LoadingListPO> result=new ArrayList<LoadingListPO>();
		FileReader fr=new FileReader("TxtData/loadinglist.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			
				String t[]=output[2].split("-");
				String l[]=output[6].split("-");
			
				long[] list =new long[l.length];
				for(int i=0;i<l.length;i++){
				list[i]=Long.parseLong(l[i]);	
				}
				
				LoadingListPO po=new LoadingListPO(Long.parseLong(output[0]), ListType.toListType(output[1]),new TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),0,0,0), Long.parseLong(output[3]), City.toCity(output[4]),City.toCity(output[5]),list,output[7],output[8],Double.parseDouble(output[9]),ListState.toState(output[10]));
					
			result.add(po);
			Line = br.readLine();
		}
		return result;
	}

	@Override
	public ArrayList<LoadingListPO> findallHallLoading() throws IOException {
		ArrayList<LoadingListPO> result=new ArrayList<LoadingListPO>();
		FileReader fr=new FileReader("TxtData/loadinglist_Hall.txt");
		BufferedReader br = null;
		 br = new BufferedReader(fr);
		 String Line = br.readLine();
		while(Line!=null){
			String output[]=Line.split(":");
			
				String t[]=output[2].split("-");
				String l[]=output[6].split("-");
			
				long[] list =new long[l.length];
				for(int i=0;i<l.length;i++){
				list[i]=Long.parseLong(l[i]);	
					
				}
		LoadingListPO po=new LoadingListPO(Long.parseLong(output[0]), ListType.toListType(output[1]),new TimePO(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),0,0,0), Long.parseLong(output[3]), City.toCity(output[4]),City.toCity(output[5]),list,output[7],output[8],Double.parseDouble(output[9]),ListState.toState(output[10]));
			
			result.add(po);
			Line = br.readLine();
		}
		return result;
	}

	@Override
	public ArrayList<MoneyInListPO> findallMoneyIn() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MoneyOutListPO> findallMoneyOut() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WareInListPO> findallWareIn() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<WareOutListPO> findallWareOut() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> findall() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Object> result=new ArrayList<Object>();
		ArrayList<ArrivaListPO> arrival=findallArrival();
		ArrayList<DeliveryListPO> delivery=findallDelivery();
		ArrayList<OrderListPO> order= findallOrder();
		ArrayList<LoadingListPO> loading=findallLoading();
		ArrayList<LoadingListPO> loadinghall=findallHallLoading();
		result.add(arrival);
		result.add(delivery);
		result.add(order);
		result.add(loading);
		result.add(loadinghall);
		return result;
	}
	
	
	
	

}
