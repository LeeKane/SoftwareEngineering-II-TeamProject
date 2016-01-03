package util;

public enum Entry {
	/* 租金（按年收）运费（按次计算）人员工资（按月统计）奖励（一次性） */
	RENT, // 租金
	FREIGNT, // 运费
	SALARY, // 人员工资
	REWARD, // 奖励
	COMMISSION, // 快递员提成
	DRVIER;// 司机计次
	public String toString() {
		switch (this) {

		case RENT:
			return "租金";
		case FREIGNT:
			return "运费";
		case SALARY:
			return "人员工资";
		case REWARD:
			return "奖励";
		case COMMISSION:
			return "快递员提成";
		case DRVIER:
			return "司机计次费用";
		default:
			return null;

		}
	}

	public static Entry toEntry(String m) {

		switch (m) {
		case "租金":
			return RENT;
		case "运费":
			return FREIGNT;
		case "人员工资":
			return SALARY;
		case "奖励":
			return REWARD;
		case "快递员提成":
			return COMMISSION;
		case "司机计次费用":
			return DRVIER;
		default:
			return null;

		}
	}

}
