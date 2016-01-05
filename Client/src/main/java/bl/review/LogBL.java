package bl.review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import blservice.reviewblservice.LogBLService;
import data.datafactory.DataFactory;
import dataservice.reviewdataservice.LogDataService;
import po.LogPO;
import vo.LogVO;

public class LogBL implements LogBLService {
	private LogDataService ld;
	private ArrayList<LogVO> voList;

	public LogBL() {
		ld = DataFactory.getLogData();
	}

	@Override
	public Iterator<LogVO> findAll() {
		// TODO Auto-generated method stub
		voList = new ArrayList<LogVO>();
		ArrayList<LogPO> poList = new ArrayList<LogPO>();
		try {
			poList = ld.findAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (LogPO po : poList) {
			LogVO vo = new LogVO(po.getTime(), po.getOperation());
			voList.add(vo);
		}

		return voList.iterator();
	}
}
