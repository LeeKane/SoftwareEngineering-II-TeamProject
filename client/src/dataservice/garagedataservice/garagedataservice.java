package dataservice.garagedataservice;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.Garage;
import po.GarageBodyPO;

import po.GaragePlacePO;
import po.garageitem;
public interface garagedataservice {

public Garage init();
public void insert(Garage g,garageitem item);
public garageitem find(Garage g,long id);
public void delete(Garage g,long  id);
public double rate(Garage g);
public void destroy(Garage g);
public void show(Garage g);

}
