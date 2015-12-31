package blservice.reviewblservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataimpl.datafactory.DataFactory;
import dataservice.reviewdataservice.LogDataService;
import po.LogPO;
import po.TimePO;
import vo.LogVO;

public interface LogBLService {
	public ArrayList<LogVO> findAll();

	public static LogVO insert(TimePO time, String operation) {
		DataFactory dataFactory = new DataFactory();
		LogDataService lds = dataFactory.getLogData();
		LogVO vo = new LogVO(time, operation);
		LogPO po = new LogPO(time, operation);
		try {
			lds.insert(po);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
}
