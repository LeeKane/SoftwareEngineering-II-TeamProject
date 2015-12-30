package blservice.reviewblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.reviewdataservice.LogDataService;
import po.LogPO;
import po.TimePO;
import vo.LogVO;

public interface LogBLService {
	public ArrayList<LogVO> findAll();
	
	public static LogVO addAccount(TimePO time, String operation) {
		LogVO vo=new LogVO(time,operation);
		LogPO po=new LogPO(time,operation);
		try {
			LogDataService.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
}
