package dataservice.WareHousedataservice;

public interface WareHousedataservice {
	public ResultMessage setPlaneShipping (ListPO list);
	public ResultMessage setTrainShipping (ListPO list);
	public ResultMessage setCarShipping (ListPO list);
	public ResultMessage geneCenterList();
	public ResultMessage wareIn();
	public ResultMessage wareOut();
	public ResultMessage getWareInfo(int timeDiff);
	public ResultMessage WareStockTake();
	public ResultMessage WareAlarm();
	public ResultMessage ModWarePartition (int type, double storage);
	public ResultMessage endWareHouse();

}
