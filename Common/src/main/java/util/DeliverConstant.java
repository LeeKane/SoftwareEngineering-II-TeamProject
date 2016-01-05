//定义一些快递系统中的常量
package util;

import java.io.IOException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.reviewdataservice.ConstantDataService;
import po.ConstantPO;

public class DeliverConstant {
	// 价格
	public double PRICE;

	// 北京到上海
	public double DISTANCE_BEIJING_SHANGHAI = 1064.7;
	public double TIME_BEIJING_SHANGHAI = 3;
	// 北京到南京
	public double DISTANCE_BEIJING_NANJING = 900;
	public double TIME_BEIJING_NANJING = 3;
	// 北京到广州
	public double DISTANCE_BEIJING_GUANGZHOU = 1888.8;
	public double TIME_BEIJING_GUANGZHOU = 4;
	// 南京到广州
	public double DISTANCE_NANJING_GUANGZHOU = 1132;
	public double TIME_NANJING_GUANGZHOU = 3;
	// 南京到上海
	public double DISTANCE_NANJING_SHANGHAI = 266;
	public double TIME_NANJING_SHANGHAI = 1;
	// 南京到北京
	public double DISTANCE_NANJING_BEIJING = 900;
	public double TIME_NANJING_BEIJING = 3;
	public double DISTANCE_SHANGHAI_BEIJING = 1064.7;
	public double TIME_SHANGHAI_BEIJING = 3;
	public double DISTANCE_SHANGHAI_GONGZHOU = 1213;
	public double TIME_SHANGHAI_GONGZHOU = 3;
	public double DISTANCE_SHANGHAI_NANJING = 266;
	public double TIME_SHANGHAI_NANJING = 1;
	public double DISTANCE_GONGZHOU_BEIJING = 1888.8;
	public double TIME_GONGZHOU_BEIJING = 4;
	public double DISTANCE_GONGZHOU_SHANGHAI = 1213;
	public double TIME_GONGZHOU_SHANGHAI = 3;
	public double DISTANCE_GONGZHOU_NANJING = 1132;
	public double TIME_GONGZHOU_NANJING = 3;

	public DeliverConstant() {
		ConstantDataService cds = DataFactory.getConstant();
		ArrayList<ConstantPO> disList = null;
		try {
			disList = cds.findAllDis();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (disList != null) {
			DISTANCE_BEIJING_SHANGHAI = disList.get(0).getValue();
			TIME_BEIJING_SHANGHAI = disList.get(6).getValue();
			// 北京到南京
			DISTANCE_BEIJING_NANJING = disList.get(1).getValue();
			TIME_BEIJING_NANJING = disList.get(7).getValue();
			// 北京到广州
			DISTANCE_BEIJING_GUANGZHOU = disList.get(2).getValue();
			TIME_BEIJING_GUANGZHOU = disList.get(8).getValue();
			// 南京到广州
			DISTANCE_NANJING_GUANGZHOU = disList.get(5).getValue();
			TIME_NANJING_GUANGZHOU = disList.get(11).getValue();
			// 南京到上海
			DISTANCE_NANJING_SHANGHAI = disList.get(3).getValue();
			TIME_NANJING_SHANGHAI = disList.get(9).getValue();
			// 南京到北京
			DISTANCE_NANJING_BEIJING = disList.get(1).getValue();
			TIME_NANJING_BEIJING = disList.get(7).getValue();

			DISTANCE_SHANGHAI_BEIJING = disList.get(0).getValue();
			TIME_SHANGHAI_BEIJING = disList.get(6).getValue();

			DISTANCE_SHANGHAI_GONGZHOU = disList.get(4).getValue();
			TIME_SHANGHAI_GONGZHOU = disList.get(10).getValue();

			DISTANCE_SHANGHAI_NANJING = disList.get(3).getValue();
			TIME_SHANGHAI_NANJING = disList.get(9).getValue();

			DISTANCE_GONGZHOU_BEIJING = disList.get(2).getValue();
			TIME_GONGZHOU_BEIJING = disList.get(8).getValue();

			DISTANCE_GONGZHOU_SHANGHAI = disList.get(4).getValue();
			TIME_GONGZHOU_SHANGHAI = disList.get(10).getValue();

			DISTANCE_GONGZHOU_NANJING = disList.get(5).getValue();
			TIME_GONGZHOU_NANJING = disList.get(11).getValue();
		}
	}
}
