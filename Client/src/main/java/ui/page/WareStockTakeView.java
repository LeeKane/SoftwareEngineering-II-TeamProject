package ui.page;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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

	public WareStockTakeView(WareOutBLservice bl) {
		this.setName("库存盘点");
		this.bl = bl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.gd = DataFactory.getGarageData();
		this.list = new ArrayList<GarageBodyPO>();
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
		add(inputPanel, BorderLayout.NORTH);
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
			this.validate();
		}
		int num = bl.getNum(transid);
		for (int i = 0; i < outlist.size(); i++) {
			show = new WareShowVO(ListState.REVIEWED, outlist.get(i).getItem().getId(),
					outlist.get(i).getItem().getTime(), outlist.get(i).getPlace().getQu(),
					outlist.get(i).getPlace().getPai(), outlist.get(i).getPlace().getJia(),
					outlist.get(i).getPlace().getWei());
			deliveryInputModel2.addRow(show);
			this.validate();
		}
	}
}