//定义一些快递系统中的常量
package util;

import java.io.IOException;
import java.util.ArrayList;

import dataservice.datafactoryservice.DataFactoryService;
import dataservice.reviewdataservice.ConstantDataService;
import po.ConstantPO;

public class DeliverConstant {
	public DeliverConstant(DataFactoryService factory){
		ConstantDataService cds=factory.getConstant();
		try {
			ArrayList<ConstantPO> priceList=cds.findAllPrice();
			ArrayList<ConstantPO> disList=cds.findAllDis();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 价格
	public static int PRICE;

	// 北京到上海
	public static double DISTANCE_BEIJING_SHANGHAI = 1064.7;
	public static int TIME_BEIJING_SHANGHAI = 3;
	// 北京到南京
	public static double DISTANCE_BEIJING_NANJING = 900;
	public static int TIME_BEIJING_NANJING = 3;
	// 北京到广州
	public static double DISTANCE_BEIJING_GUANGZHOU = 1888.8;
	public static int TIME_BEIJING_GUANGZHOU = 4;
	// 南京到广州
	public static double DISTANCE_NANJING_GUANGZHOU = 1132;
	public static int TIME_NANJING_GUANGZHOU = 3;
	// 南京到上海
	public static double DISTANCE_NANJING_SHANGHAI = 266;
	public static int TIME_NANJING_SHANGHAI = 1;
	// 南京到北京
	public static double DISTANCE_NANJING_BEIJING = 900;
	public static int TIME_NANJING_BEIJING = 3;
	public static double DISTANCE_SHANGHAI_BEIJING = 1064.7;
	public static int TIME_SHANGHAI_BEIJING = 3;
	public static double DISTANCE_SHANGHAI_GONGZHOU = 1213;
	public static int TIME_SHANGHAI_GONGZHOU = 3;
	public static double DISTANCE_SHANGHAI_NANJING = 266;
	public static int TIME_SHANGHAI_NANJING = 1;
	public static double DISTANCE_GONGZHOU_BEIJING = 1888.8;
	public static int TIME_GONGZHOU_BEIJING = 4;
	public static double DISTANCE_GONGZHOU_SHANGHAI = 1213;
	public static int TIME_GONGZHOU_SHANGHAI = 3;
	public static double DISTANCE_GONGZHOU_NANJING = 1132;
	public static int TIME_GONGZHOU_NANJING = 3;

}
