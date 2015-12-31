//单位类型
package util;

public enum OrgType {
	HALL, // 营业厅
	CENTER, // 中转中心
	WAREHOUSE, // 仓库
	HEAD;

	public String toString() {
		switch (this) {
		case HALL:
			return "营业厅";
		case CENTER:
			return "中转中心";
		case WAREHOUSE:
			return "仓库";
		case HEAD:
			return "总部";
		default:
			return null;
		}
	}

	public static OrgType toOrgType(String m) {
		switch (m) {
		case "营业厅":
			return HALL;
		case "中转中心":
			return CENTER;
		case "仓库":
			return WAREHOUSE;
		case "总部":
			return HEAD;
		default:
			return null;
		}

	}
}
