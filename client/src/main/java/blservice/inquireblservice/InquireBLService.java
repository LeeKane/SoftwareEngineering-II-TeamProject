/**
 * 搜索逻辑接口
 */
package blservice.inquireblservice;

import util.ResultMessage;

public interface InquireBLService {
	//显示物流信息界面
	public ResultMessage inquire (long orderNum);
	
	public void endInquire();
}     










