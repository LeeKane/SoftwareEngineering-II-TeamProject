package DataServiceTxtFileImpl;

import po.GarageBodyPO;
import po.GaragePlacePO;
import po.garageitem;
import dataservice.garagedataservice.Garage;
import dataservice.garagedataservice.garagedataservice;

public class GaragedataserviceArraylistImpl implements garagedataservice {
	@Override
	public Garage init() {
		// TODO Auto-generated method stub
		Garage g=new Garage();
		g.creat();
		return g;
	}

	@Override
	public void insert(Garage g, garageitem item) {
		// TODO Auto-generated method stub
		GaragePlacePO po=g.buildPlace();
		GarageBodyPO p=new GarageBodyPO(po,item);
		g.list.add(p);
		g.setTemp(g.getTemp() + 1);
	}

	@Override
	public void delete(Garage g, garageitem item) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<g.list.size();i++){
			if(g.list.get(i).getItem()==item){
				g.list.remove(i);
			}
		}
		
		
		g.setTemp(g.getTemp() - 1);
	}

	@Override
	public double rate(Garage g) {
		// TODO Auto-generated method stub
		double m=g.getpercent();
		return m;
	}

	@Override
	public void destroy(Garage g) {
		// TODO Auto-generated method stub
		g.list.clear();
	}

	@Override
	public void show(Garage g) {
		// TODO Auto-generated method stub
		for(int i=0;i<g.list.size();i++){
			  g.list.get(i).getPlace().showplace();
		}
	}
}
