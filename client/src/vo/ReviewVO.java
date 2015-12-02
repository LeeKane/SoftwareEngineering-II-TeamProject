package vo;

import java.util.Vector;

import po.InstitutePO;
import po.StaffPO;

public class ReviewVO extends Vector<String>{
	private StaffPO staff;
	private InstitutePO institute;
	public ReviewVO(StaffPO staff, InstitutePO institute) {
		super();
		this.staff = staff;
		this.institute = institute;
		this.add(staff.toString());
		this.add(institute.toString());
	}
	public StaffPO getStaff() {
		return staff;
	}
	public InstitutePO getInstitute() {
		return institute;
	}
	
}
