package blservice.listblservice;

import util.City;
import vo.WareVO;





public interface OrdersInputBLService {
	/**
	 * 添加订单项
	 * @param weight 实际重量
	 * @param amount 数量
	 * @param volume 体积
	 * @param name 内件品名
	 * @param packag 包装类型
	 * @param type 快递类型
	 * @return 返回订单信息，包括实际重量、内件品名、快递类型、数量、体积、包装类型、总价
	 */
	public WareVO addware(double weight, int amount, double volume,String packag,String name,String type, City departPlace, City destination);
	
	/**
	 * 获得总价
	 * @return 返回总价
	 */
	public double getCost();
	
	/**
	 * 获得预估时间
	 * @return 返回预估时间
	 */
	public double getTime();
	/**
	 * 提交进货单
	 * @return 返回是否成功提交进货单
	 */
	public boolean submit();


}
