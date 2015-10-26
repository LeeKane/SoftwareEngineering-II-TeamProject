package blservice.listblservice;

import blservice.accountblservice.AccountBLService;
import blservice.accountblservice.AccountBLService_Driver;
import blservice.accountblservice.AccountBLService_Stub;
import po.list.ListPO;
import util.ListType;
import util.ResultMessage;

public class ListBLService_Driver {
	public void drive(ListBLService listBLService){
		ResultMessage modifylist=listBLService.modifyList(1, new ListPO(ListType.ARRIVE, 1));
		if(modifylist==ResultMessage.SUCCESS)
			System.out.println("Modifylist Succeeded!");
		
		ResultMessage delrtelist = listBLService.delrteList(1);
		if(delrtelist==ResultMessage.SUCCESS)
			System.out.println("Delrtelist Succeeded!");
		
		ResultMessage addlist = listBLService.addList(1, new ListPO(ListType.ARRIVE, 1));
		if(addlist==ResultMessage.SUCCESS)
			System.out.println("Addlist Succeeded!");
		
		ResultMessage exportlist = listBLService.exportList(1);
		if(exportlist==ResultMessage.SUCCESS)
			System.out.println("Exportlist Succeeded!");
		
		listBLService.endList();
		
	}
	
	public static void main(String[] args) {
		ListBLService listBLService=new ListBLService_Stub();
		ListBLService_Driver driver=new ListBLService_Driver();
		driver.drive(listBLService);
	}

}
