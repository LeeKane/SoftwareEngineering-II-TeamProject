package util;

public enum GoodState {
	INTACE, //完好
	BROKEN,//损坏
	PARTBROKEN,//部分损坏
	MISSING;//遗失
	
	public String toString(){
		switch (this) {
		case INTACE:
			return "完好";
		case BROKEN:
			return "损坏";
		case PARTBROKEN:
			return "部分损坏";
		case MISSING:
			return "遗失";
		default:
			return null;
		}
	}
}
