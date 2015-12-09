package blservice.listblservice;

import po.list.ListPO;
import util.ResultMessage;

public interface ListBLService {// 单据管理
	public ListPO getList(long id);

	// 保存相应的修改
	public ResultMessage modifyList(long id, ListPO po);

	// 删除相应的list
	public ResultMessage delrteList(long id);

	// 根据输入的信息新建list
	public ResultMessage addList(long id, ListPO po);

	// 导出相应的单据到excel
	public ResultMessage exportList(long id);

	public void endList();

}
