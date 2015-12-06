package util;

public enum ListState {
	DRAFT,//草稿态
	SUBMITTED,//提交后态
	REVIEWED;//审批后态
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		switch (this) {
		case DRAFT:
			return "DRAFT";
		case SUBMITTED:
			return "未审批";
		case REVIEWED:
			return "审批通过";
		default:
			return null;
		}
	}
	
	public static ListState toState(String str){
		switch(str){
		case "DRAFT":
			return DRAFT;
		case "SUBMITTED":
			return SUBMITTED;
		case "REVIEWED":
			return REVIEWED;
		default:
			return null;
		}	
	}
}
