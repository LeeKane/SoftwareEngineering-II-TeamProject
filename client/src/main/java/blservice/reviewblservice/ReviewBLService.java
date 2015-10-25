package blservice.reviewblservice;

import util.ResultMessage;

public interface ReviewBLService {
	//在人员和机构管理中，增加人员信息
	public ResultMessage addStaff(int type,String name);
	
	//在人员和机构管理中，移除人员信息
	public ResultMessage removeStaff(int type,String name);
	
	//在人员和机构管理中，增加机构信息
	public ResultMessage addOrg(int type,String name);
	
	//在人员和机构管理中，删除机构信息
	public ResultMessage removeOrg(int type,String name);
	
	//在查看账户中，修改账户信息
	public ResultMessage setBAccount(String num);
	
	//在制定薪水策略中，制定薪水策略
	public ResultMessage setSalary(int type,double salary);
	
	//在审判单据中，修改单据
	public ResultMessage modList(ListPO list);
	
	//结束审查，持久化更新设计的领域对象的数据
	public ResultMessage endReview();
	

}
