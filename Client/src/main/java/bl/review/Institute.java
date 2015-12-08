package bl.review;

import util.City;
import util.OrgType;

public class Institute {
	City city;//城市
	OrgType org;//机构类型
	long id;//机构编号
	
	public Institute(City city, OrgType org, long id) {
		this.city = city;
		this.org = org;
		this.id = id;
	}
}
