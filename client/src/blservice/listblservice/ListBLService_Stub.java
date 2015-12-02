package blservice.listblservice;

import po.list.ListPO;
import util.ResultMessage;

public class ListBLService_Stub implements ListBLService{

	@Override
	public ResultMessage modifyList(long id, ListPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delrteList(long id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addList(long id, ListPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage exportList(long id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public void endList() {
		// TODO Auto-generated method stub
		System.out.println("List Ended!");
	}

	@Override
	public ListPO getList(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
