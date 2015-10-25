package dataservice.Listdataservice;

public interface Listdataservice {
	public ResultMessage modifyList(long id，ListPO po);
	public ResultMessage delrteList(long id);
	public ResultMessage addList(long id, ListPO po);
	public ResultMessage exportList(long id,);

}
