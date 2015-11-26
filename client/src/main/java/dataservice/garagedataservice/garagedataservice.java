package dataservice.garagedataservice;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GarageBodyPO;
import po.GaragePO;
import po.GaragePlacePO;
import po.garageitem;
public interface garagedataservice {
public  ArrayList<GarageBodyPO> creat();
public void insert(ArrayList<GarageBodyPO> List,garageitem item);
public void delete(ArrayList<GarageBodyPO> List,garageitem item);
public GaragePlacePO buildPlace(ArrayList<GarageBodyPO> List);
public void init(ArrayList<GarageBodyPO> List);

	
}
