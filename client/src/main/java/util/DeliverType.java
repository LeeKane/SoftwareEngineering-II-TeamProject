//快递类型
package util;

public enum DeliverType {
	
	FAST, //特快
	STAND,//标准快递
	ECO;//经济快递
	
	public String toString() {
		switch (this) {
		case FAST:
			return "特快";
		case STAND:
			return "标准快递";
		case ECO:
			return "经济快递";
		default:
			return null;
		}
	}

}
