package util;

public enum  RewardType {
	COMMISSION,//快递员提成
	COUNT,//司机计次
	SALARY;//业务员月薪
	
	public String toString() {
		switch (this) {
		case COMMISSION:
			return "快递员提成";
		case COUNT:
			return "司机计次";
		case SALARY:
			return "业务员月薪";
		default:
			return null;
		}
	}
	
	public static RewardType toRewardType(String m){
		
		switch(m){
		case "快递员提成":
			return COMMISSION;
		case "司机计次":
			return COUNT;
		case "业务员月薪":
			return SALARY;
		default:
		    return null;
		
		}	
	}
}
