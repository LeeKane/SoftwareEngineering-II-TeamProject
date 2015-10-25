package dataservice.Reviewdataservice;

public interface Reviewdataservice {
	public ResultMessage addStaff(int type,String name);
	public ResultMessage removeStaff(int type,String name);
	public ResultMessage addOrg(int type,String name);
	public ResultMessage removeOrg(int type,String name);
	public ResultMessage setBAccount(string num);
	public ResultMessage setSalary(int type,double salary);
	public ResultMessage modList(ListPO list);
	public ResultMessage endReview();

}
