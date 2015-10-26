package blservice.reviewblservice;

import po.InstitutePO;
import po.StaffPO;
import po.list.ListPO;
import util.City;
import util.OrgType;
import util.Permission;
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
