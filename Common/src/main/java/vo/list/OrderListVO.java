package vo.list;

import java.io.Serializable;
import java.util.Vector;

import po.WarePO;
import util.ListType;

public class OrderListVO extends Vector<String> implements Serializable {

	private long id;

	private ListType listtype;// 单据类型private static final long serialVersionUID
								// = 1L;
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
	private String account;

	public OrderListVO(ListType listtype, String senderName, String senaderAddress, String senderOrganization,
			String senderTphone, String senderCphone, String receiverName, String receiverAddress,
			String receiverOrganization, String receiverTphone, String receiverCphone, WarePO ware, long id,
			String account) {
		super();
		this.id = id;
		this.listtype = listtype;
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
		this.account = account;

		this.add(listtype.toString());
		this.add(senderName);
		this.add(senaderAddress);
		this.add(senderOrganization);
		this.add(senderTphone);
		this.add(senderCphone);
		this.add(receiverName);
		this.add(receiverAddress);
		this.add(receiverOrganization);
		this.add(receiverTphone);
		this.add(receiverCphone);
		// this.add(ware.getDepartPlace().toString());
		// this.add(ware.getDestination().toString());

		this.add(ware.getweight() + "");
		this.add(ware.getamount() + "");
		this.add(ware.getvolume() + "");
		this.add(ware.getpackag());
		this.add(ware.getname());
		this.add(ware.gettype().toString());
		this.add(ware.getcost() + "");
		this.add(ware.gettime().toString());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ListType getListtype() {
		return this.listtype;
	}

	public String getSenderName() {
		return this.senderName;
	}

	public String getSenaderAddress() {
		return this.senaderAddress;
	}

	public String getSenderOrganization() {
		return this.senderOrganization;
	}

	public String getSenderTphone() {
		return this.senderTphone;
	}

	public String getSenderCphone() {
		return this.senderCphone;
	}

	public String getReceiverName() {
		return this.receiverName;
	}

	public String getReceiverAddress() {
		return this.receiverAddress;
	}

	public String getReceiverOrganization() {
		return this.receiverOrganization;
	}

	public String getReceiverTphone() {
		return this.receiverTphone;
	}

	public String getReceiverCphone() {
		return this.receiverCphone;
	}

	public WarePO getWare() {
		return this.ware;
	}

	public String getAccount() {
		return account;
	}
}
