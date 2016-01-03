package vo;

import java.io.Serializable;
import java.util.Vector;

public class ConstantVO extends Vector<String> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double value;

	public ConstantVO(String name, double value) {
		super();
		this.name = name;
		this.value = value;

		this.add(name);
		this.add(value + "");
	}

	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
	}
}
