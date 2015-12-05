package dataservice.DriverDataService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import po.CarPO;
import po.DriverPO;
import vo.CarVO;
import vo.DriverVO;

public interface DriverDataService {
public void insert(DriverPO po);
public ArrayList<DriverPO> findAll() throws IOException;
public DriverPO find(long number) throws IOException;
public  void delete(long number) throws FileNotFoundException, IOException;
public void init();
public void update(DriverPO po) throws IOException;
DriverPO findlast() throws IOException;
}
