package ui.page;

import javax.swing.JPanel;

import DataServiceTxtFileImpl.logindataserviceimpl;
import dataservice.logindataservice.LoginDataService;
import po.AccountPO;
import ui.XLabel;

public class StaffInfView extends JPanel{
	private AccountPO po;
private LoginDataService ld=new logindataserviceimpl();
public StaffInfView(AccountPO po)
{
	this.setName("职员信息");
	
	this.po=po;
	initInfField();
}
private void initInfField() {
	// TODO Auto-generated method stub
	XLabel idLabel = new XLabel(po.getUsername()+po.getStaff().getStaffId());
	JPanel panel=new JPanel();
	panel.add(idLabel);
	this.add(panel);
}
}
