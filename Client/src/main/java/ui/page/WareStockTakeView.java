package ui.page;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import blservice.warehouseblservice.WareOutBLservice;
import dataimpl.datafactory.DataFactory;
import dataservice.warehousedataservice.GarageDataSeriaService;
import po.AccountPO;
import po.GarageBodyPO;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import util.ListState;
import vo.WareShowVO;

public class WareStockTakeView extends JPanel {
	private static final long serialVersionUID = 1L;
	private AccountPO po;

	private WareOutBLservice bl;
	private GarageDataSeriaService gd;
	private JLabel dataField;// 修改
	private JLabel dataField2;
	private JLabel box1;
	private JLabel box2;
	private long transcenterid;
	private XTimeChooser ser;
	private DefaultTableModel deliveryInputModel2;
	private long transid;
	int qu;
	int pai;
	int jia;
	int wei;
	private ArrayList<GarageBodyPO> list;
	private ArrayList<WareShowVO> excellist1;
	
	public WareStockTakeView(WareOutBLservice bl) {
		this.setName("库存盘点");
		this.bl = bl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.gd = DataFactory.getGarageData();
		this.list = new ArrayList<GarageBodyPO>();
		this.excellist1=new ArrayList<WareShowVO>();
	
		transcenterid = Long.parseLong(bl.getPo().getStaff().getOrgid());
		// transcenterid=Long.parseLong(bl.getPo().getStaff().getOrgid());
		// 初始化快件信息输入界面
		initImportItemField();
		initTable();
		// 初始化快件列表界面

		// initTable2();
		// 初始化
		try {
			System.out.println("mohahamo");
			submit();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.validate();
	}

	private void initImportItemField() {
		// TODO Auto-generated method stub

		XLabel dataLabel = new XLabel("开始时间：");
		dataField = new JLabel();
		dataLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dataField.setPreferredSize(new Dimension(100, 26));
		ser = XTimeChooser.getInstance();
		dataField.setText(ser.getCurrentTime());
		dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		box1 = new JLabel("0时");
		box2 = new JLabel(ser.getTimePO().getHour()+"时");
		box1.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		box2.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		XLabel dataLabel2 = new XLabel("结束时间：");
		dataField2 = new JLabel();
		dataLabel2.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dataField2.setPreferredSize(new Dimension(100, 26));
		dataField2.setText(ser.getCurrentTime());
		dataField2.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);

		XButton addItemButton = new XButton("提交");
		addItemButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					submit();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		XButton addItemButton2 = new XButton("导出EXCEL");
		addItemButton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			getExcel();
			}
		});
		

		JPanel inputPanel = new JPanel();
		// inputPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(dataLabel);
		inputPanel.add(dataField);
		inputPanel.add(box1);
		inputPanel.add(dataLabel2);
		inputPanel.add(dataField2);
		inputPanel.add(box2);

		inputPanel.add(addItemButton);
		inputPanel.add(addItemButton2);
		add(inputPanel, BorderLayout.NORTH);
	}
	
	public void getExcel(){
		 HSSFWorkbook wb = new HSSFWorkbook();  
	        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
	        HSSFSheet sheet = wb.createSheet("出入库表");  
	        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
	        HSSFRow row = sheet.createRow((int) 0);  
	        // 第四步，创建单元格，并设置值表头 设置表头居中  
	        HSSFCellStyle style = wb.createCellStyle();  
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
	  
	        HSSFCell cell = row.createCell((short) 0);  
	        cell.setCellValue("单据类型");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 1);  
	        cell.setCellValue("快递编号");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 2);  
	        cell.setCellValue("入库日期");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 3);  
	        cell.setCellValue("区号");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 4);  
	        cell.setCellValue("排号");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 5);  
	        cell.setCellValue("位号");  
	        cell.setCellStyle(style);  
	        cell = row.createCell((short) 6);  
	        cell.setCellValue("架号");  
	        cell.setCellStyle(style);  
	        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
	     
	  
	        for (int i = 0; i < excellist1.size(); i++)  
	        {  
	            row = sheet.createRow((int) i + 1);  
	            WareShowVO vo = excellist1.get(i);
	            // 第四步，创建单元格，并设置值  
	            row.createCell((short) 0).setCellValue(vo.getType());  
	            row.createCell((short) 1).setCellValue(String.valueOf(vo.getId()));  
	            row.createCell((short) 2).setCellValue(vo.getTime().toString());  
	            row.createCell((short) 3).setCellValue(vo.getQu());  
	            row.createCell((short) 4).setCellValue(vo.getPai());  
	            row.createCell((short) 5).setCellValue(vo.getJia());  
	            row.createCell((short) 6).setCellValue(vo.getWei());  
	          
	        }  
	      
	        
	        // 第六步，将文件存到指定位置  
	        try  
	        {  
	        	JFileChooser jf = new JFileChooser();  
	        	jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY);  
	        	jf.showDialog(null,null);  
	        	File fi = jf.getSelectedFile();  
	        	String f = fi.getAbsolutePath()+"/Ware.xls";  
	            FileOutputStream fout = new FileOutputStream(f);  
	            wb.write(fout);  
	            fout.close();  
	        }  
	        catch (Exception e)  
	        {  
	            e.printStackTrace();  
	        }  
	    
	}
	

	private void initTable() {
		JScrollPane scrollPane2 = new JScrollPane();
		Vector<String> vColumns2 = new Vector<String>();

		vColumns2.add("出库/入库");
		vColumns2.add("快递编号");
		vColumns2.add("入库日期");
		vColumns2.add("区号");
		vColumns2.add("排号");
		vColumns2.add("位号");
		vColumns2.add("架号");

		Vector<String> vData2 = new Vector<String>();

		// //模型
		deliveryInputModel2 = new DefaultTableModel(vData2, vColumns2);
		// //表格
		JTable deliveryInputTable2 = new JTable(deliveryInputModel2) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JTableHeader tableH2 = deliveryInputTable2.getTableHeader();

		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH2.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH2.setFont(XContorlUtil.FONT_14_BOLD);
		deliveryInputTable2.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		deliveryInputTable2.setShowVerticalLines(false);
		deliveryInputTable2.setShowHorizontalLines(false);
		scrollPane2.getViewport().add(deliveryInputTable2);
		deliveryInputTable2.setFillsViewportHeight(true);
		this.add(scrollPane2);

	}

	public void deletefromGarage(long ID) throws RemoteException, ClassNotFoundException, IOException {
		String address = "TxtData/" + transcenterid + "" + ".txt";
		gd.delete(address, ID);
	}

	public void submit() throws RemoteException, ClassNotFoundException, IOException {
		TimePO start = ser.getTimePO();
		
		start.setHour(0);
		start.setMin(0);
		start.setSec(0);
		
		XTimeChooser ser1=XTimeChooser.getInstance();
		TimePO end = ser1.getTimePO();

		WareShowVO show;
		list = bl.getWareIn(start, end);

		ArrayList<GarageBodyPO> outlist = new ArrayList<GarageBodyPO>();
		outlist = bl.getWareOut(start, end);
		for (int i = 0; i < outlist.size(); i++) {
			outlist.get(i).getPlace().showplace();
		}
		for (int i = 0; i < list.size(); i++) {
			show = new WareShowVO(ListState.SUBMITTED, list.get(i).getItem().getId(), list.get(i).getItem().getTime(),
					list.get(i).getPlace().getQu(), list.get(i).getPlace().getPai(), list.get(i).getPlace().getJia(),
					list.get(i).getPlace().getWei());
			deliveryInputModel2.addRow(show);
			excellist1.add(show);
			this.validate();
		}
		int num = bl.getNum(transid);
		for (int i = 0; i < outlist.size(); i++) {
			show = new WareShowVO(ListState.REVIEWED, outlist.get(i).getItem().getId(),
					outlist.get(i).getItem().getTime(), outlist.get(i).getPlace().getQu(),
					outlist.get(i).getPlace().getPai(), outlist.get(i).getPlace().getJia(),
					outlist.get(i).getPlace().getWei());
			deliveryInputModel2.addRow(show);
			excellist1.add(show);
			this.validate();
		}
	}
}
