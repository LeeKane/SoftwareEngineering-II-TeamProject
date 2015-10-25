//车辆类型
package util;

public enum Vehicle {
	CAR, // 汽车
	PLANE, // 飞机
	TRAIN; // 火车

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		switch (this) {
		case CAR:
			return "汽车";
		case PLANE:
			return "飞机";
		case TRAIN:
			return "火车";
		default:
			return null;
		}
	}
	
	
}
