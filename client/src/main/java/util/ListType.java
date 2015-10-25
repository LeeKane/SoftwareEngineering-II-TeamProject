/**
 * 单据类型，包括到达单、收款单、付款单、订单、入库单、出库单、装车转运单
 * @author raychen
 * @date 2015/10/23
 */
package util;

public enum ListType {
	ARRIVE, // 到达单
	MONEYIN, // 收款单
	MONEYOUT, // 付款单
	ORDER, // 订单
	STOCKIN, // 入库单
	STOCKOUT, // 出库单
	TRANS, // 转运单
	TOTALMONEYIN; // 总收款单

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		switch (this) {
		case ARRIVE:
			return "到达单";
		case MONEYIN:
			return "收款单";
		case MONEYOUT:
			return "付款单";
		case ORDER:
			return "订单";
		case STOCKIN:
			return "入库单";
		case STOCKOUT:
			return "出库单";
		case TRANS:
			return "转运单";
		case TOTALMONEYIN:
			return "总收款单";
		default:
			return null;
		}
	}

}
