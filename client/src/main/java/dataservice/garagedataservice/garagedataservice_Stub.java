package dataservice.garagedataservice;

import java.util.ArrayList;

import po.GarageBodyPO;
import po.GaragePO;
import po.GaragePlacePO;
import po.garageitem;

public class garagedataservice_Stub implements garagedataservice {

	@Override
	public ArrayList<GarageBodyPO> creat() {
		// TODO Auto-generated method stub
		ArrayList<GarageBodyPO> list=new ArrayList<GarageBodyPO>();
		return list;
	}

	@Override
	public void insert(ArrayList<GarageBodyPO> List, garageitem item) {
		// TODO Auto-generated method stub
		GaragePlacePO po=buildPlace(List);
		GarageBodyPO p=new GarageBodyPO(po,item);
		List.add(p);
		
	}

	@Override
	public void delete(ArrayList<GarageBodyPO> List, garageitem item) {
		// TODO Auto-generated method stub
		List.remove(item);
	}

	@Override
	public void init(ArrayList<GarageBodyPO> List) {
		// TODO Auto-generated method stub
	List.clear();
	}

	@Override
	public GaragePlacePO buildPlace(ArrayList<GarageBodyPO> List) {
		// TODO Auto-generated method stub
		int size=List.size();
		
		GaragePlacePO place = null;
		if(size==0){
			place=new GaragePlacePO(1, 1, 1, 1);
			}
		
		
		if(size!=0){
			
			GarageBodyPO po=List.get(List.size()-1);
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

	
}
