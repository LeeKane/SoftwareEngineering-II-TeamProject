//枚举所有的权限
package util;

public enum Permission {
	SENDER, //客户
	COURIER, // 快递员
	HALLCLERK, // 营业厅业务员
	CENTERCLERK, // 中转中心业务员
	WAREKEEPER, // 中转中心仓库管理人员
	COUNTER, // 财务人员
	MANAGER, // 总经理
	ADMINISTRATOR, // 管理员
	DRIVER, ICOUNTER; //司机

	public static Permission toPermission(String m){
		switch(m){
		case "快递员":
			return COURIER;
		case "营业厅业务员":
			return HALLCLERK;
		case "中转中心业务员":
			return CENTERCLERK;
		case "中转中心仓库管理人员":
			return WAREKEEPER;
		case  "财务人员":
			return  COUNTER;
		case "仅限最高权限财务人员":
			return ICOUNTER;
		case "总经理":
			return MANAGER;
		case "管理员":
			return ADMINISTRATOR;
		case "司机":
			return DRIVER;
		default:
			return null;
		}
		
		}
	
	
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
		case ICOUNTER:
			return "仅限最高权限财务人员";
		case MANAGER:
			return "总经理";
		case ADMINISTRATOR:
			return "管理员";
		case DRIVER:
			return "司机";
		default:
			return null;
		}
	}
}
