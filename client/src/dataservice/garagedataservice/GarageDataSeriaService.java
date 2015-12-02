package dataservice.garagedataservice;

import po.Garage;
import po.garageitem;

public interface GarageDataSeriaService {
public void init(String address);
public void insert(String address,garageitem item);
public garageitem find(String address,long id);
public void delete(String address,long  id);
public double rate(Garage g);
public void destroy(Garage g);
public void show(Garage g);
	
}
