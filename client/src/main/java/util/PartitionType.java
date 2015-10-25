package util;

public enum PartitionType {
	CAR, // 汽运区
	PLANE, // 航运区
	TRAIN, // 铁运区
	VARIABLE; //机动区

	public String toString() {
		// TODO Auto-generated method stub
		switch (this) {
		case CAR:
			return "汽运区";
		case PLANE:
			return "航运区";
		case TRAIN:
			return "铁运区";
		case VARIABLE:
			return "机动区";
		default:
			return null;
		}
	}
}
