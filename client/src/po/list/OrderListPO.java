package po.list;

import java.io.Serializable;

import po.WarePO;
import util.ListState;
import util.ListType;

public class OrderListPO implements Serializable {
	/**
	 * 序列化版本号
	 */
	private ListType listtype;//单据类型
	private String id;

	private static final long serialVersionUID = 1L;
	private String senderName;
	private String senaderAddress;
	private String senderOrganization;
	private String senderTphone;
	private String senderCphone;
	private String receiverName;
	private String receiverAddress;
	private String receiverOrganization;
	private String receiverTphone;
	private String receiverCphone;
	private WarePO ware;
	private ListState lst;
	private String account;
	/**
	 * 
	 */
	
	
	/**
	* @param senderName 寄件人姓名
	 * @param senaderAddress 寄件人住址
	 * @param senderOrganization 寄件人单位
	 * @param senaderTphone 寄件人电话
	 * @param senderCphone 寄件人手机
	 * @param receiverName 收件人姓名
	 * @param receiverAddress 收件人住址
	 * @param receiverOrganization 收件人单位
	 * @param receiverTphone 收件人电话
	 * @param receiverCphone 收件人手机
	 * @param lst 单据状态
		 */
	
	

	
	

	
	public OrderListPO(ListType listType, String senderName,
			String senaderAddress, String senderOrganization,
			String senderTphone, String senderCphone, String receiverName,
			String receiverAddress, String receiverOrganization,
			String receiverTphone, String receiverCphone, WarePO ware,String id,ListState lst,
			String account
			) {
		super();
		this.listtype = listType;
		this.senderName = senderName;
		this.senaderAddress = senaderAddress;
		this.senderOrganization = senderOrganization;
		this.senderTphone = senderTphone;
		this.senderCphone = senderCphone;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.receiverOrganization = receiverOrganization;
		this.receiverTphone = receiverTphone;
		this.receiverCphone = receiverCphone;
		this.ware = ware;
		this.id=id;
		this.lst = lst;
		this.account=account;
				
	}
	
	
	public ListType toListType(String m){
		return listtype;
		
	}
	
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public WarePO getWare() {
		return ware;
	}
	public ListType getListtype() {
		return listtype;
	}
	public void setListtype(ListType listtype) {
		this.listtype = listtype;
	}
	public void setWare(WarePO ware) {
		this.ware = ware;
	}

	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenaderAddress() {
		return senaderAddress;
	}
	public void setSenaderAddress(String senaderAddress) {
		this.senaderAddress = senaderAddress;
	}
	public String getSenderOrganization() {
		return senderOrganization;
	}
	public void setSenderOrganization(String senderOrganization) {
		this.senderOrganization = senderOrganization;
	}
	public String getSenderTphone() {
		return senderTphone;
	}
	public void setSenderTphone(String senderTphone) {
		this.senderTphone = senderTphone;
	}
	public String getSenderCphone() {
		return senderCphone;
	}
	public void setSenderCphone(String senderCphone) {
		this.senderCphone = senderCphone;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getReceiverOrganization() {
		return receiverOrganization;
	}
	public void setReceiverOrganization(String receiverOrganization) {
		this.receiverOrganization = receiverOrganization;
	}
	public String getReceiverTphone() {
		return receiverTphone;
	}
	public void setReceiverTphone(String receiverTphone) {
		this.receiverTphone = receiverTphone;
	}
	public String getReceiverCphone() {
		return receiverCphone;
	}
	public void setReceiverCphone(String receiverCphone) {
		this.receiverCphone = receiverCphone;
	}
	public ListState getLst() {
		return lst;
	}
	public void setLst(ListState lst) {
		this.lst = lst;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}
}
