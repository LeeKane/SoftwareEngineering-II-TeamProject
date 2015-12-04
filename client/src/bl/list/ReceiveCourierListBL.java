package bl.list;

import java.rmi.RemoteException;
import java.util.ArrayList;

import DataServiceTxtFileImpl.InquireDataServiceTxtImpl;
import blservice.listblservice.ReceiveCourierListBLService;
import dataimpl.datafactory.DataFactory;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.listdataservice.ReceiveCourierListDataService;
import po.InstitutePO;
import po.TimePO;
import po.TransPO;
import po.list.ReceiveCourierListPO;
import ui.XTimeChooser;
import util.City;
import util.ListState;
import util.OrgType;
import util.TransState;
import vo.list.ReceiveCourierListVO;

public class ReceiveCourierListBL implements ReceiveCourierListBLService{
	private DataFactory dataFactory;//数据工厂
	private ArrayList<ReceiveCourierListVO>ReceiveCourierListList;
	
	public ArrayList<ReceiveCourierListVO> getReceiveCourierListList() {
		return ReceiveCourierListList;
	}

	private TransPO transState;
	private InquireDataService inquireDataService;

	public ReceiveCourierListBL(){
		dataFactory = new DataFactory();
		ReceiveCourierListList=new ArrayList<ReceiveCourierListVO>();
	}
	
	@Override
	public ReceiveCourierListVO addReceiveCourierList(TimePO time, long id, String name, String cellphoneNum,
			ListState state) {
		// TODO Auto-generated method stub
		ReceiveCourierListVO rv=new ReceiveCourierListVO(time, id, name, cellphoneNum, state);
		ReceiveCourierListList.add(rv);
		return rv;
	}

	@Override
	public boolean submit() {
		// TODO Auto-generated method stub
		ReceiveCourierListDataService rd=dataFactory.getReceiveCourierData();
		if (!ReceiveCourierListList.isEmpty()){
			for(ReceiveCourierListVO rv:ReceiveCourierListList){
				ReceiveCourierListPO rp;
				TimePO time=rv.getTime();
				long id=rv.getId();
				String name=rv.getName();
				String cellphoneNum=rv.getCellphoneNum();
				ListState state=rv.getState();
				rp=new ReceiveCourierListPO(time,
					id, name, cellphoneNum, state);
				rd.insert(rp);
				
				XTimeChooser x=XTimeChooser.getInstance();
				x.getCurrentTime();
				x.getTimePO();
				//要改
				transState=new TransPO(id,TransState.SENDER_RECEIVE,x.getTimePO(),new InstitutePO(City.NANJING,OrgType.HALL,1111111111));//添加运输状态
				
				inquireDataService=new InquireDataServiceTxtImpl();
				try {
					inquireDataService.insert(transState);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			ReceiveCourierListList.clear();
			return true;
		}else
			return false;		
	}

}
