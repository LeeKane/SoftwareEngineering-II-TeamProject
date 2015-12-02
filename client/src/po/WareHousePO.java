package po;
import java.io.Serializable;
public class WareHousePO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double carPartition;//汽运区大小
	private double planePartition;//航运区大小
	private double trainPartition;//铁运区大小
	private double variablePartition;//机动区大小
	
	public WareHousePO(double carPartition, double planePartition, double trainPartition, double variablePartition) {
		super();
		this.carPartition = carPartition;
		this.planePartition = planePartition;
		this.trainPartition = trainPartition;
		this.variablePartition = variablePartition;
	}

	public double getCarPartition() {
		return carPartition;
	}

	public void setCarPartition(double carPartition) {
		this.carPartition = carPartition;
	}

	public double getPlanePartition() {
		return planePartition;
	}

	public void setPlanePartition(double planePartition) {
		this.planePartition = planePartition;
	}

	public double getTrainPartition() {
		return trainPartition;
	}

	public void setTrainPartition(double trainPartition) {
		this.trainPartition = trainPartition;
	}

	public double getVariablePartition() {
		return variablePartition;
	}
}
