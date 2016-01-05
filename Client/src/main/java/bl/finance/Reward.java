package bl.finance;

import java.rmi.RemoteException;

import data.datafactory.DataFactory;
import dataservice.reviewdataservice.SetRewardDataService;

public class Reward {

	private double rentOfYear = 100000.0;
	private double salaryOfMonth_finance = 4500.0;
	private double salaryOfMonth_manager = 6500.0;
	private double salaryOfMonth_hall = 3800.0;
	private double salaryOfMonth_center = 3800.0;
	private double salaryOfMonth_centerkeeper = 3000.0;
	private double salaryOfMonth_mailer = 3000.0;
	private double driverOfOnce = 100.0;
	private double commissionOfMailer = 0.1;
	private SetRewardDataService bl;

	public Reward() {
		bl = DataFactory.getSetRewardData();
		double[] nums = new double[9];
		try {
			nums = bl.findall();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rentOfYear = nums[0];
		salaryOfMonth_finance = nums[1];
		salaryOfMonth_manager = nums[2];
		salaryOfMonth_hall = nums[3];
		salaryOfMonth_center = nums[4];
		salaryOfMonth_centerkeeper = nums[5];
		salaryOfMonth_mailer = nums[6];
		driverOfOnce = nums[7];
		commissionOfMailer = nums[8];

	}

	public double getRentOfYear() {
		return rentOfYear;
	}

	public double getSalaryOfMonth_finance() {
		return salaryOfMonth_finance;
	}

	public double getSalaryOfMonth_manager() {
		return salaryOfMonth_manager;
	}

	public double getSalaryOfMonth_hall() {
		return salaryOfMonth_hall;
	}

	public double getSalaryOfMonth_center() {
		return salaryOfMonth_center;
	}

	public double getSalaryOfMonth_centerkeeper() {
		return salaryOfMonth_centerkeeper;
	}

	public double getSalaryOfMonth_mailer() {
		return salaryOfMonth_mailer;
	}

	public double getDriverOfOnce() {
		return driverOfOnce;
	}

	public double getCommissionOfMailer() {
		return commissionOfMailer;
	}
}
