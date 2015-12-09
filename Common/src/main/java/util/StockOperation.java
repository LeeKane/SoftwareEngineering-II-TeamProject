//存储操作
package util;

public enum StockOperation {
	STOCKIN, // 入库
	STOCKOUT; // 出库

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		switch (this) {
		case STOCKIN:
			return "入库";
		case STOCKOUT:
			return "出库";
		default:
			return null;
		}
	}
}
