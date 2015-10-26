package blservice.reviewblservice;

import po.list.ListPO;
import util.ResultMessage;

public class ReviewBLService_Stub implements ReviewBLService {

	@Override  
	public ResultMessage addStaff(int type, String name) {
	// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage removeStaff(int type, String name) {
		// TODO Auto-generated method stub
		return 		ResultMessage.SUCCESS;

	}

	@Override
	public ResultMessage addOrg(int type, String name) {
		// TODO Auto-generated method stub
		return 		ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage removeOrg(int type, String name) {
		// TODO Auto-generated method stub
		return 		ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setBAccount(String num) {
		// TODO Auto-generated method stub
		return 		ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setSalary(int type, double salary) {
		// TODO Auto-generated method stub
		return 		ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modList(ListPO list) {
		// TODO Auto-generated method stub
		return 		ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage endReview() {
		// TODO Auto-generated method stub
		return 		ResultMessage.SUCCESS;
	}

}
