package ui.page;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dataservice.logindataservice.LoginDataService;
import po.AccountPO;
import ui.XContorlUtil;
import ui.XLabel;

public class StaffInfView extends JPanel{
	private AccountPO po;
public StaffInfView(AccountPO po)
{
	this.setName("职员信息");
	this.po=po;
	initInfField();
}
private void initInfField() {
	// TODO Auto-generated method stub
	ImageIcon photoIcon = XContorlUtil.getImageIcon("ui/images/photo.png");
	XLabel photoLabel = new XLabel(photoIcon);
	setLayout(null);
	JLabel label = new JLabel("");
	label.setBounds(0, 150, 0, 0);
	add(label);
	photoLabel.setBounds(10, 23, 184, 152);
	add(photoLabel);
	JLabel userNameLabel = new JLabel(po.getUsername());
	userNameLabel.setFont(XContorlUtil.FONT_22_BOLD);
	userNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	userNameLabel.setBounds(10, 174, 128, 32);
	add(userNameLabel);
	
	JLabel idLabel = new JLabel(po.getStaff().getStaffId()+"");
	idLabel.setFont(XContorlUtil.FONT_12_BOLD);
	idLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	idLabel.setBounds(-15, 212, 143, 18);
	add(idLabel);
	
	JLabel label_1 = new JLabel("姓名：");
	label_1.setFont(XContorlUtil.FONT_14_BOLD);
	label_1.setBounds(283, 43, 72, 18);
	add(label_1);
	

	
	JLabel label_3 = new JLabel("机构：");
	label_3.setFont(XContorlUtil.FONT_14_BOLD);
	label_3.setBounds(283, 77, 72, 18);
	add(label_3);
	
	JLabel label_4 = new JLabel("职位：");
	label_4.setFont(XContorlUtil.FONT_14_BOLD);
	label_4.setBounds(283, 108, 72, 18);
	add(label_4);
	
	JLabel label_5 = new JLabel("所在城市：");
	label_5.setFont(XContorlUtil.FONT_14_BOLD);
	label_5.setBounds(283, 144, 105, 18);
	add(label_5);
	
	JLabel lblName = new JLabel(po.getUsername());
	lblName.setFont(XContorlUtil.FONT_14_BOLD);
	lblName.setBounds(340, 43, 72, 18);
	add(lblName);

	
	JLabel lblHall = new JLabel(po.getStaff().getOrgType().toString());
	lblHall.setFont(XContorlUtil.FONT_14_BOLD);
	lblHall.setBounds(340, 77, 72, 18);
	add(lblHall);
	
	JLabel lblMailer = new JLabel(po.getStaff().getPermission().toString());
	lblMailer.setFont(XContorlUtil.FONT_14_BOLD);
	lblMailer.setBounds(340, 108, 72, 18);
	add(lblMailer);
	
	JLabel lblBeijing = new JLabel(po.getStaff().getCity().toString());
	lblBeijing.setFont(XContorlUtil.FONT_14_BOLD);
	lblBeijing.setBounds(364, 144, 72, 18);
	add(lblBeijing);
    
	JLabel worklbl = new JLabel("通知");
	worklbl.setFont(XContorlUtil.FONT_22_BOLD);
	worklbl.setBounds(283, 222, 128, 32);
	add(worklbl);
	ImageIcon lineIcon = XContorlUtil.getImageIcon("ui/images/line1.png");
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(lineIcon);
	lblNewLabel.setBounds(283, 252, 467, 72);
	add(lblNewLabel);
}
}
