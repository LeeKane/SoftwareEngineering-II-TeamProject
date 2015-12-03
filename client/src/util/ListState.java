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
			return "SUBMITTED";
		case REVIEWED:
			return "REVIEWED";
		default:
			return null;
		}
	}
	
	public static ListState toLst(String m){
		
		switch (m) {
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