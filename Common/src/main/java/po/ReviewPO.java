package po;

import java.io.Serializable;

public class ReviewPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StaffPO staff;
	private InstitutePO institute;

	public ReviewPO(StaffPO staff, InstitutePO institute) {
		super();
		this.staff = staff;
		this.institute = institute;
	}

	public StaffPO getStaff() {
		return staff;
	}

	public void setStaff(StaffPO staff) {
		this.staff = staff;
	}

	public InstitutePO getInstitute() {
		return institute;
	}

	public void setInstitute(InstitutePO institute) {
		this.institute = institute;
	}

}
