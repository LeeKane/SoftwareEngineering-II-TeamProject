//枚举所有货运状态
package util;

public enum TransState {
	COURIER_RECEIVE, //快递员已收件
	HALLCLERK_LOADING, //营业厅已装车
	CENTERCLERK_RECEIVE, //中转中心已接收
	CENTERCLERK_SHIPPING, //中转中心已装运
	HALLCLERK_RECEIVE, //营业厅已接收
	HALLCLERK_DISTRIBUTE, //正在派件
	SENDER_RECEIVE; //客户已签收
	
	public String toString(){
		switch (this) {
		case COURIER_RECEIVE:
			return "快递员已收件";
		case HALLCLERK_LOADING:
			return "营业厅已装车";
		case CENTERCLERK_RECEIVE:
			return "中转中心已接收";
		case CENTERCLERK_SHIPPING:
			return "中转中心已装运";
		case HALLCLERK_RECEIVE:
			return "营业厅已接收";
		case HALLCLERK_DISTRIBUTE:
			return "正在派件";
		case SENDER_RECEIVE:
			return "客户已签收";
		default:
			return null;
		}
	}
	
	public static TransState toTransState(String state){
		switch (state) {
		case "快递员已收件":
			return COURIER_RECEIVE;
		case "营业厅已装车":
			return HALLCLERK_LOADING;
		case "中转中心已接收":
			return CENTERCLERK_RECEIVE;
		case "中转中心已装运":
			return CENTERCLERK_SHIPPING;
		case "营业厅已接收":
			return HALLCLERK_RECEIVE;
		case "正在派件":
			return HALLCLERK_DISTRIBUTE;
		case "客户已签收":
			return SENDER_RECEIVE;
		default:
			return null;
		}		
	}
}
