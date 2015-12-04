package vo;

import java.util.Vector;

import util.City;
import util.OrgType;

public class InstituteVO extends Vector<String> {
	private static final long serialVersionUID = 1L;
	private City city;//城市
	private OrgType org;//机构类型
	private long id;//机构编号
	
	public InstituteVO(City city, OrgType org, long id) {
		super();
		this.city = city;
		this.org = org;
		this.id = id;
		this.add(city.toString());
		this.add(org.toString());
		this.add(id+"");
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public City getCity() {
		return city;
	}

	public OrgType getOrg() {
		return org;
	}

	public long getId() {
		return id;
	}
	
	
}
