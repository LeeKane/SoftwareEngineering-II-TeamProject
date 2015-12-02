//快递类型
package util;

public enum DeliverType {
	
	FAST, //特快专递
	STAND,//标准快递
	ECO;//经济快递
	
	public String toString() {
		switch (this) {
		case FAST:
			return "特快专递";
		case STAND:
			return "标准快递";
		case ECO:
			return "经济快递";
		default:
			return null;
		}
	}
	public static DeliverType toType(String m) {
		switch (m) {
		case "特快专递":
			return FAST ;
		case "标准快递":
			return STAND;
		case "经济快递":
			return ECO;
		default:
			return null;
		}
	}

	public double getCost() {
		// TODO Auto-generated method stub
		switch (this) {
		case FAST:
			return 18;
		case STAND:
			return 13;
		case ECO:
			return 10;
		default:
			return 17;
	}
	
	}
}
