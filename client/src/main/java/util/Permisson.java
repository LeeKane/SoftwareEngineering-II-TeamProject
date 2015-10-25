package util;

public enum Permisson {
	SENDER, //客户
	COURIER, // 快递员
	HALLCLERK, // 营业厅业务员
	CENTERCLERK, // 中转中心业务员
	WAREKEEPER, // 中转中心仓库管理人员
	COUNTER, // 财务人员
	MANAGER, // 总经理
	ADMINISTRATOR; // 管理员

	public String toString() {
		switch (this) {
		case COURIER:
			return "快递员";
		case HALLCLERK:
			return "营业厅业务员";
		case CENTERCLERK:
			return "中转中心业务员";
		case WAREKEEPER:
			return "中转中心仓库管理人员";
		case COUNTER:
			return "财务人员";
		case MANAGER:
			return "总经理";
		case ADMINISTRATOR:
			return "管理员";
		default:
			return null;
		}
	}
}
