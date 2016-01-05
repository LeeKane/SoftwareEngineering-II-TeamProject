package blservice.reviewblservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import data.datafactory.DataFactory;
import dataservice.reviewdataservice.LogDataService;
import po.LogPO;
import po.TimePO;
import vo.LogVO;

public interface LogBLService {
	public Iterator<LogVO> findAll();

	public static LogVO insert(TimePO time, String operation) {
		LogDataService lds = DataFactory.getLogData();
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
