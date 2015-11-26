package dataservice.garagedataservice;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GarageBodyPO;
import po.GaragePO;
import po.GaragePlacePO;
import po.garageitem;
public interface garagedataservice {

public Garage init();
public void insert(Garage g,garageitem item);
public void delete(Garage g,garageitem item);
public double rate(Garage g);
public void destroy(Garage g);
public void show(Garage g);
}
