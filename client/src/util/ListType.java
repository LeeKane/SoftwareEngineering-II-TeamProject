package util;

public enum ListType {
	ARRIVE, // 营业厅到达单.
	MONEYIN, // 收款单
	MONEYOUT, // 付款单
	ORDER, // 订单.
	STOCKIN, // 入库单
	STOCKOUT, // 出库单
	TRANS, // 转运单
	TOTALMONEYIN,// 总收款单
    TRANSCENTERARRIVE,//中转中心到达单
    DELIVER,//派件单
    LOADING,//装车单
	LOADINGHALL;//营业厅装运单

    
 
	public String toNum()
	{
		switch (this) {
		case ARRIVE:
			return "01";
		case MONEYIN:
			return "02";
		case MONEYOUT:
			return "03";
		case ORDER:
			return "04";
		case STOCKIN:
			return "05";
		case STOCKOUT:
			return "06";
		case TRANS:
			return "07";
		case TRANSCENTERARRIVE:
			return "08";
		case DELIVER:
			return "09";
		case LOADING:
			return "11";		    
		case LOADINGHALL:
			return "12";		
		default:
			return null;
			}
	}
	
	public static ListType toStrNum(String m) {
		// TODO Auto-generated method stub
		switch (m) {
		case "01":
			return  ARRIVE;
		case "02":
			return  MONEYIN;
		case "03":
			return MONEYOUT;
		case "04":
			return ORDER;
		case "05":
			return STOCKIN;
		case "06":
			return STOCKOUT;
		case "07":
			return TRANS;
		case "08":
			return TRANSCENTERARRIVE;
		case  "09":
			return DELIVER;
		
		case "11":
			return LOADING;
		case "12":
			return LOADINGHALL;		
		default:
			return null;
		}

}
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		switch (this) {
		case ARRIVE:
			return "营业厅到达单";
		case MONEYIN:
			return "收款单";
		case MONEYOUT:
			return "付款单";
		case ORDER:
			return "寄件单";
		case STOCKIN:
			return "入库单";
		case STOCKOUT:
			return "出库单";
		case TRANS:
			return "转运单";
		case TRANSCENTERARRIVE:
			return "中转中心到达单";
		case DELIVER:
			return "派送单";
		case LOADING:
			return "装车单";
		case LOADINGHALL:
			return "营业厅装运单";	
		default:
			return null;
		}
	}
	
	public static ListType toListType(String m) {
		// TODO Auto-generated method stub
		switch (m) {
		case "营业厅到达单":
			return  ARRIVE;
		case "收款单":
			return  MONEYIN;
		case "付款单":
			return MONEYOUT;
		case "寄件单":
			return ORDER;
		case "入库单":
			return STOCKIN;
		case "出库单":
			return STOCKOUT;
		case "转运单":
			return TRANS;
		case "中转中心到达单":
			return TRANSCENTERARRIVE;
		case  "派送单":
			return DELIVER;
		
		case "装车单":
			return LOADING;
		case "营业厅装运单":
		   return LOADINGHALL;
		default:
			return null;
		}

}
}
