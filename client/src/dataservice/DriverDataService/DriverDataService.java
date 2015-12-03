package dataservice.DriverDataService;

import java.io.FileNotFoundException;
import java.io.IOException;

import po.DriverPO;

public interface DriverDataService {
public void insert(DriverPO po);
public DriverPO find(long number) throws IOException;
public  void delete(long number) throws FileNotFoundException, IOException;
public void init();
public void update(DriverPO po) throws IOException;
}
