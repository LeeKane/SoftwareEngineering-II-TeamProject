package ui.page;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
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
import po.list.ArrivaListPO;
import ui.XContorlUtil;
import vo.list.ListVO;

public class ListReviewView extends JPanel {
	private DefaultTableModel listModel;
	private JTable listTable;
	
	private ListReviewBLServive lrbl;
	private  ArrayList<ListVO> voList;
	private  ArrayList<ListVO> voUpdateList;
	private int selectedRow;
	
	public ListReviewView()
	{
		lrbl=new ListReviewBL();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		voList=new ArrayList<ListVO>();
		voUpdateList=new ArrayList<ListVO>();	
		
		  initListTable(); 
		  initInfField();
	}

	private void initInfField() {
		// TODO Auto-generated method stub
		JPanel infField=new JPanel();
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
		listTable = new JTable(listModel){
			 private int myRow = -1;
			 TableCellEditor myEditor;  
			private static final long serialVersionUID = 1L;
//      //设置第一行不可编辑
			public boolean isCellEditable(int row, int column){
			if (column == 0) {
				return false;
			}
			return true;
			}
  
		};
		
		TableColumn buyTimeColumn = listTable.getColumnModel().getColumn(3);
		 buyTimeColumn.setPreferredWidth(200);
	
		 
		JTableHeader tableH=listTable.getTableHeader();
//		 tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		 tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		 tableH.setFont(XContorlUtil.FONT_14_BOLD);
		 listTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 listTable.setShowVerticalLines(false);
		 listTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(listTable);
		listTable.setFillsViewportHeight(true);
		listTable.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                selectedRow = listTable.getSelectedRow(); //获得选中行索引
             }
            });
		this.add(scrollPane);
		    ArrayList<ArrivaListPO> arriveList=lrbl.getArriveList();
		for(int i = 0; i<arriveList.size();i++)
		{
			ListVO    vo=new ListVO(arriveList.get(i).getType(),arriveList.get(i).getid(),arriveList.get(i).getLst(),arriveList.get(i).getTime());
			listModel.addRow(vo);
		}
	}
	
	
	
}
