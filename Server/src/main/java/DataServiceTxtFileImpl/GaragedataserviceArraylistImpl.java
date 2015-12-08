package DataServiceTxtFileImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.garagedataservice.garagedataservice;
import po.Garage;
import po.GarageBodyPO;
import po.GaragePlacePO;
import po.garageitem;

public class GaragedataserviceArraylistImpl extends UnicastRemoteObject implements garagedataservice {
	protected GaragedataserviceArraylistImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Garage init() throws RemoteException{
		// TODO Auto-generated method stub
		Garage g=new Garage();
		g.creat();
		return g;
	}

	@Override
	public void insert(Garage g, garageitem item)throws RemoteException {
		// TODO Auto-generated method stub
		GaragePlacePO po=g.buildPlace();
		GarageBodyPO p=new GarageBodyPO(po,item);
		g.list.add(p);
		g.setTemp(g.getTemp() + 1);
	}

	

	@Override
	public double rate(Garage g) throws RemoteException{
		// TODO Auto-generated method stub
		double m=g.getpercent();
		return m;
	}

	@Override
	public void destroy(Garage g)throws RemoteException {
		// TODO Auto-generated method stub
		g.list.clear();
	}

	@Override
	public void show(Garage g) throws RemoteException{
		// TODO Auto-generated method stub
		g.show();
	}

	@Override
	public garageitem find(Garage g, long id) throws RemoteException{
		garageitem item=null;
		for(int i=0;i<g.list.size();i++){
			if(g.list.get(i).getItem().getId()==id){
			item=g.list.get(i).getItem();
			break;
			}
		}
		
		
		
		return item;
		
		
		
	}

	@Override
	public void delete(Garage g, long id)throws RemoteException {
		// TODO Auto-generated method stub
		
		for(int i=0;i<g.list.size();i++){
			if(g.list.get(i).getItem().getId()==id){
				g.list.remove(i);
				break;
			}
		}
		
			g.setTemp(g.getTemp() - 1);
	}
}
