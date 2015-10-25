//单位类型
package util;

public enum OrgType {
	HALL, // 营业厅
	CENTER, // 中转中心
	WAREHOUSE; // 仓库

	public String toString() {
		switch (this) {
		case HALL:
			return "营业厅";
		case CENTER:
			return "中转中心";
		case WAREHOUSE:
			return "仓库";
		default:
			return null;
		}
	} 
}
