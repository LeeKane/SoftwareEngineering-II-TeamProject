package util;

import java.io.IOException;
import java.util.ArrayList;

import dataservice.datafactoryservice.DataFactoryService;
import dataservice.reviewdataservice.ConstantDataService;
import po.ConstantPO;

public class DeliverPrice {
	public double costOfFAST = 18.0;
	public double costOfSTAND = 13.0;
	public double costOfECO = 10.0;

	public DeliverPrice(DataFactoryService factory) {
		ConstantDataService cds = factory.getConstant();
		ArrayList<ConstantPO> disList = null;
		try {
			disList = cds.findAllPrice();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (disList != null) {
			costOfFAST = disList.get(0).getValue();
			costOfSTAND = disList.get(1).getValue();
			costOfECO = disList.get(2).getValue();
		}
	}

}
