package util;

public enum GoodState {
	INTACE, // 完好
	BROKEN, // 损坏
	MISSING;// 遗失

	public String toString() {
		switch (this) {
		case INTACE:
			return "完好";
		case BROKEN:
			return "损坏";
		case MISSING:
			return "遗失";
		default:
			return null;
		}
	}

	public static GoodState toState(String m) {
		switch (m) {
		case "完好":
			return INTACE;
		case "损坏":
			return BROKEN;
		case "遗失":
			return MISSING;
		default:
			return null;
		}

	}

}
