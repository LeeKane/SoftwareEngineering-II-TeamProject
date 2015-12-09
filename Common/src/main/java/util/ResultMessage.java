//枚举所有的结果消息
package util;

public enum ResultMessage {
	SUCCESS, // 成功
	FAILED, // 失败
	WRONG, // 错误
	EXIST, // 已存在
	NONEXIST, // 不存在
	TOO_LONG, // 输入过长
	TOO_SHORT, // 输入过短
	UNVALID, // 含有非法字符
	NULL, // 输入为空
	ALARM, // 有警报
	NOALARM; // 无警报

	public String toString() {
		switch (this) {
		case TOO_LONG:
			return "输入过长";
		case TOO_SHORT:
			return "输入过短";
		case UNVALID:
			return "含有非法字符";
		case NULL:
			return "输入为空";
		case FAILED:
			return "失败";
		case NONEXIST:
			return "不存在";
		case EXIST:
			return "已存在";
		default:
			return null;
		}
	}
}
