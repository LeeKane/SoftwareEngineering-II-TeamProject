package dataservice.garagedataservice;

import java.io.Serializable;
import java.util.ArrayList;

import po.GarageBodyPO;
import po.GaragePlacePO;
import po.TimePO;
import po.garageitem;

public class Garage implements Serializable  {
	
	ArrayList<GarageBodyPO> list;
	
public void creat() {
		// TODO Auto-generated method stub
		ArrayList<GarageBodyPO> list=new ArrayList<GarageBodyPO>();
		
		this.list=list;
	}

	
public void insert(garageitem item) {
		// TODO Auto-generated method stub
		GaragePlacePO po=buildPlace();
		GarageBodyPO p=new GarageBodyPO(po,item);
		list.add(p);
		
	}

	
public void delete( garageitem item) {
		// TODO Auto-generated method stub
		list.remove(item);
	}

	
public void init() {
		// TODO Auto-generated method stub
	list.clear();
	}

	
public GaragePlacePO buildPlace() {
		// TODO Auto-generated method stub
		int size=list.size();
		
		GaragePlacePO place = null;
		if(size==0){
			place=new GaragePlacePO(1, 1, 1, 1);
			}
		
		
		if(size!=0){
			
			GarageBodyPO po=list.get(list.size()-1);
			GaragePlacePO preplace=po.getPlace();
			int qu=preplace.getQu();
			int pai=preplace.getPai();
			int jia=preplace.getJia();
			int wei=preplace.getWei();
		
			if(wei<5){
				wei++;
				pai=preplace.getPai();
				jia=preplace.getJia();
				qu=preplace.getQu();
			}if(wei==5){
				wei=1;
				jia=preplace.getJia();
				if(jia<5){
					jia++;
					pai=preplace.getPai();
					qu=preplace.getQu();
				}
				if(jia==5){
					jia=1;
					pai=preplace.getPai();
					if(pai<5){
						pai++;
						qu=preplace.getQu();
					}if(pai==5){
						pai=1;
						qu=preplace.getQu()+1;
					}
				}
			}
			
		place=new GaragePlacePO(qu, pai, jia, wei);
				}
		return place;
	}
	
	
	public static void main(String[] args){
		
		Garage g=new Garage();
		g.creat();
		garageitem item=new garageitem(new TimePO(1,1,1,1,1,1), 123457);
		garageitem item2=new garageitem(new TimePO(1,1,1,1,1,1), 1234527);
		 
		   g.insert(item);
		   g.insert(item2);
		   g.insert(item2);
		   g.insert(item2);
		  g.list.get(1).getPlace().showplace();
	}
	
	
	
}
