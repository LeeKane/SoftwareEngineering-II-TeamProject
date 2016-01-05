/**
 * 搜索逻辑接口
 */
package blservice.inquireblservice;

import java.util.ArrayList;
import java.util.Iterator;

import po.AccountPO;
import vo.TransVO;

public interface InquireBLService {
	// 显示物流信息界面
	public Iterator<TransVO> inquire(String id);

	public void endInquire();

	public AccountPO getPo();
}
