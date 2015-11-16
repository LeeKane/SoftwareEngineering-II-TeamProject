package bl.inquire;

import util.ResultMessage;

public class InquireList {
	
	public ResultMessage getOneTransHistory(TransHistory history){
		return ResultMessage.SUCCESS;
	}
	
	public boolean isGetAll(){
		return true;
	}
}
