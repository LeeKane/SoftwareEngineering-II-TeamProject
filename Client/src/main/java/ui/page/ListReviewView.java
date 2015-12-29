package ui.page;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import bl.review.ListReviewBL;
import blservice.reviewblservice.ListReviewBLServive;
import po.TimePO;
import po.list.ArrivaListPO;
import po.list.DeliveryListPO;
import po.list.LoadingListPO;
import po.list.MoneyInListPO;
import po.list.MoneyOutListPO;
import po.list.OrderListPO;
import po.list.TransListPO;
import po.list.TranscenterArrivalListPO;
import po.list.WareInListPO;
import po.list.WareOutListPO;
import ui.XButton;
import ui.XContorlUtil;
import util.ListState;
import util.ListType;
import vo.list.ListVO;

public class ListReviewView extends JPanel {

	private DefaultTableModel listModel;
	private JTable listTable;
	private JComboBox stateCombobox;
	private ListReviewBLServive lrbl;
	private ArrayList<ListVO> voList;
	private ArrayList<ListVO> voUpdateList;
	private int selectedRow;

	public ListReviewView() {
		this.setName("审批单据");

		stateCombobox = new JComboBox();
		lrbl = new ListReviewBL();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		voList = new ArrayList<ListVO>();
		voUpdateList = new ArrayList<ListVO>();
		stateCombobox.addItem("未审批");
		stateCombobox.addItem("审批通过");
		stateCombobox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		initListTable();
		initInfField();
	}

	private void initInfField() {
		// TODO Auto-generated method stub
		JPanel infField = new JPanel();
		voUpdateList.clear();
		XButton submitButton = new XButton("保存修改");
		submitButton.addActionListener(new ActionListener() {
			// //修改选中表格的数据
			public void actionPerformed(ActionEvent e) {
				int col = listModel.getColumnCount();
				int row = listModel.getRowCount();
				for (int i = 0; i < row; i++) {
					ListVO vo = null;
					String[] inf = new String[4];
					for (int j = 0; j < col; j++) {
						inf[j] = (String) listModel.getValueAt(i, j);
					}
					vo = new ListVO(ListType.toListType(inf[0]), Long.parseLong(inf[1]), ListState.toState(inf[2]),
							TimePO.toTime(inf[3]));
					voUpdateList.add(vo);
				}

				boolean result = lrbl.updata(voUpdateList);
				if (result == true) {
					JOptionPane.showMessageDialog(null, "修改成功！", "", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "修改失败！", "", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		infField.setLayout(new FlowLayout(FlowLayout.RIGHT));
		infField.add(submitButton);
		this.add(infField);
	}

	private void initListTable() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("订单类型");
		vColumns.add("订单编号");
		vColumns.add("审批状态");
		vColumns.add("提交时间");

		Vector<ListVO> vData = new Vector<ListVO>();
		listModel = new DefaultTableModel(vData, vColumns);
		listTable = new JTable(listModel) {
			private int myRow = -1;
			TableCellEditor myEditor;
			private static final long serialVersionUID = 1L;

			// //设置第一行不可编辑
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {
					return false;
				}
				return true;
			}

		};
		TableColumn tableColumn = listTable.getColumn("审批状态");
		tableColumn.setCellEditor(new DefaultCellEditor(stateCombobox));
		TableColumn buyTimeColumn = listTable.getColumnModel().getColumn(3);
		buyTimeColumn.setPreferredWidth(200);

		JTableHeader tableH = listTable.getTableHeader();
		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		listTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listTable.setShowVerticalLines(false);
		listTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(listTable);
		listTable.setFillsViewportHeight(true);
		listTable.addMouseListener(new MouseAdapter() { // 鼠标事件
			public void mouseClicked(MouseEvent e) {
				selectedRow = listTable.getSelectedRow(); // 获得选中行索引
			}
		});
		this.add(scrollPane);
		// 添加各个单据的数据
		ArrayList<ArrivaListPO> arriveList = lrbl.getArriveList();
		ArrayList<DeliveryListPO> deliveryList = lrbl.getDeliverylList();
		ArrayList<MoneyInListPO> moneyinList = lrbl.getMoneyinList();
		ArrayList<MoneyOutListPO> moneyoutList =new ArrayList<MoneyOutListPO>();
		moneyoutList= lrbl.getMoneyoutList();
	
		ArrayList<OrderListPO> orderList = lrbl.getOrderList();
		ArrayList<WareInListPO> wareinList = lrbl.getWareinList();
		ArrayList<WareOutListPO> wareoutList = lrbl.getWareoutList();
		ArrayList<TranscenterArrivalListPO> transcenterarrivalList = lrbl.getTranscenterarrivalList();
		ArrayList<TransListPO> transList = lrbl.getTransList();
		ArrayList<LoadingListPO> loadingList = lrbl.getLoadingList();
		ArrayList<LoadingListPO> loading_hallList = lrbl.getLoading_hallList();

		for (int i = 0; i < arriveList.size(); i++) {
			ListVO vo = new ListVO(arriveList.get(i).getType(), arriveList.get(i).getid(), arriveList.get(i).getLst(),
					arriveList.get(i).getTime());

			listModel.addRow(vo);
		}
		for (int i = 0; i < deliveryList.size(); i++) {
			ListVO vo = new ListVO(deliveryList.get(i).getType(), deliveryList.get(i).getId(),
					deliveryList.get(i).getLst(), deliveryList.get(i).getTime());

			listModel.addRow(vo);
		}
//		 for (int i = 0; i < moneyinList.size(); i++) {
//		 ListVO vo = new ListVO(ListType.MONEYIN,
//		 moneyinList.get(i).getId(),ListState.SUBMITTED,
//		 moneyinList.get(i).getTime());
//		
//		 listModel.addRow(vo);
//		 }
		 for (int i = 0; i < moneyoutList.size(); i++) {
		 ListVO vo = new ListVO(moneyoutList.get(i).getType(),
		 moneyoutList.get(i).getId(), moneyoutList.get(i).getLst(),
		 moneyoutList.get(i).getTime());
		
		 listModel.addRow(vo);
		 }
		for (int i = 0; i < orderList.size(); i++) {

			ListVO vo = new ListVO(orderList.get(i).getListtype(), Long.parseLong(orderList.get(i).getId()),
					orderList.get(i).getLst(), orderList.get(i).getTime());

			listModel.addRow(vo);
		}
		 for (int i = 0; i < wareinList.size(); i++) {
		 ListVO vo = new
		 ListVO(wareinList.get(i).getType(),wareinList.get(i).getId(),
		 wareinList.get(i).getState(),
		 wareinList.get(i).getTime());
		
		 listModel.addRow(vo);
		 }
		 for (int i = 0; i < wareoutList.size(); i++) {
		 ListVO vo = new ListVO(wareoutList.get(i).getType(),
		 wareoutList.get(i).getId(), wareoutList.get(i).getState(),
		 wareoutList.get(i).getTime());
		
		 listModel.addRow(vo);
		 }
      		 for (int i = 0; i < transcenterarrivalList.size(); i++) {
    		 ListVO vo = new ListVO(transcenterarrivalList.get(i).getType(),
   		 transcenterarrivalList.get(i).getid(),
		 transcenterarrivalList.get(i).getLst(),
		 transcenterarrivalList.get(i).getArrivatime());
		
		 listModel.addRow(vo);
		 }
		// for (int i = 0; i < transList.size(); i++) {
		// ListVO vo = new ListVO(transList.get(i).getType(),
		// transList.get(i).getId(), transList.get(i).getLst(),
		// transList.get(i).getTime());
		//
		// listModel.addRow(vo);
		// }
		for (int i = 0; i < loading_hallList.size(); i++) {
			ListVO vo = new ListVO(loading_hallList.get(i).getType(), loading_hallList.get(i).getId(),
					loading_hallList.get(i).getLst(), loading_hallList.get(i).getLoadDate());

			listModel.addRow(vo);
		}
		for (int i = 0; i < loadingList.size(); i++) {
			ListVO vo = new ListVO(loadingList.get(i).getType(), loadingList.get(i).getId(),
					loadingList.get(i).getLst(), loadingList.get(i).getLoadDate());

			listModel.addRow(vo);
		}
		// 添加结束
	}

}
