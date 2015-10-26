package blservice.inquireblservice;

import util.ResultMessage;

public class InquireBLService_Stub implements InquireBLService{

	@Override
	public ResultMessage inquire(long orderNum) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public void endInquire() {
		// TODO Auto-generated method stub
		System.out.println("Inquire Ended!");
	}

}
