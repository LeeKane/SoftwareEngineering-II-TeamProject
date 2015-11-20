/**
 *财务数据层接口
 *@author parkdc park
 *@date  2015/10/25
 */

package dataservice.financedataservice;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.rmi.RemoteException;
import po.*;

public interface FinanceDataService {
	//按ID进行查找返回相应的FinancePO结果
	public ReceiptPO find(long id) throws RemoteException;
	//在数据库中增加po记录
	public void insert(ReceiptPO po) throws RemoteException;
	
	//删除一个po
	public void delete(ReceiptPO po) throws RemoteException, FileNotFoundException, IOException;
	//更新一个po
	public void update(ReceiptPO po) throws RemoteException, IOException;
	//初始化持久化数据库
	public void init() throws RemoteException;
	//结束持久化数据库
	public void finish() throws RemoteException;

}
