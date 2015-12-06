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
import ui.XButton;
import ui.XContorlUtil;
import util.ListState;
import util.ListType;
import util.Permission;
import vo.AccountVO;
import vo.list.ListVO;

public class ListReviewView extends JPanel {
	private DefaultTableModel listModel;
	private JTable listTable;
	private JComboBox stateCombobox;
	private ListReviewBLServive lrbl;
	private  ArrayList<ListVO> voList;
	private  ArrayList<ListVO> voUpdateList;
	private int selectedRow;
	
	public ListReviewView()
	{
		stateCombobox=new JComboBox();
		lrbl=new ListReviewBL();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		voList=new ArrayList<ListVO>();
		voUpdateList=new ArrayList<ListVO>();	
		stateCombobox.addItem("未审批");  
		stateCombobox.addItem("审批通过");    
		stateCombobox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		  initListTable(); 
		  initInfField();
	}

	private void initInfField() {
		// TODO Auto-generated method stub
		JPanel infField=new JPanel();
		XButton submitButton = new XButton("保存修改");
		submitButton.addActionListener(new ActionListener() {
//            //修改选中表格的数据
			public void actionPerformed(ActionEvent e) {
				int col = listModel.getColumnCount();
				int row = listModel.getRowCount();
				for (int i = 0; i < row; i++) {
					    ListVO vo=null;
					    String[] inf=new String[4];
					for (int j = 0; j < col; j++) {
						inf[j]=(String) listModel.getValueAt(i, j);	
					}
				    System.out.println(inf[2]);
					vo=new ListVO(ListType.toListType(inf[0]),Long.parseLong(inf[1]),ListState.toState(inf[2]),TimePO.toTime(inf[3]));
					voUpdateList.add(vo);
					
				}
				
				boolean result = lrbl.updata(voUpdateList);
				if(result == true){
					JOptionPane.showMessageDialog(null, "修改成功！","", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "修改失败！","", JOptionPane.ERROR_MESSAGE);
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
		TableColumn tableColumn = listTable.getColumn("审批状态");
		 tableColumn.setCellEditor(new DefaultCellEditor(stateCombobox)); 
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
		    ArrayList<DeliveryListPO> deliveryList=lrbl.getDeliverylList();
		for(int i = 0; i<arriveList.size();i++)
		{
			ListVO    vo=new ListVO(arriveList.get(i).getType(),arriveList.get(i).getid(),arriveList.get(i).getLst(),arriveList.get(i).getTime());
			
			listModel.addRow(vo);
		}
		for(int i = 0; i<deliveryList.size();i++)
		{
			ListVO    vo=new ListVO(deliveryList.get(i).getType(),deliveryList.get(i).getId(),deliveryList.get(i).getLst(),deliveryList.get(i).getTime());
			
			listModel.addRow(vo);
		}
	}
	
	
	
}
