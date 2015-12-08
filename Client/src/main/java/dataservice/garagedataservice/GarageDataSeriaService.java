package dataservice.garagedataservice;

import java.io.FileNotFoundException;
import java.io.IOException;

import po.Garage;
import po.garageitem;

public interface GarageDataSeriaService  {
public void init(String address) throws FileNotFoundException, IOException;
public void insert(String address,garageitem item) throws FileNotFoundException, IOException, ClassNotFoundException;
public garageitem find(String address,long id) throws IOException, ClassNotFoundException;
public void delete(String address,long  id) throws IOException, ClassNotFoundException;
public double rate(String address ) throws ClassNotFoundException, IOException;
public void destroy(String  address) throws ClassNotFoundException, IOException;
public void show(String address ) throws ClassNotFoundException, IOException;
public void breakTxt(String address);
public Garage getGarage(String address) throws IOException, ClassNotFoundException;
}
