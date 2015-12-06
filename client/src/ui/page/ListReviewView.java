package ui.page;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bl.review.ListReviewBL;
import blservice.reviewblservice.ListReviewBLServive;
import vo.CarVO;
import vo.list.ListVO;

public class ListReviewView extends JPanel {
	private DefaultTableModel listModel;
	private JTable listTable;
	
	private ListReviewBLServive lrbl;
	private  ArrayList<ListVO> voList;
	private  ArrayList<ListVO> voUpdateList;
	
	public ListReviewView()
	{
		lrbl=new ListReviewBL();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		voList=new ArrayList<ListVO>();
		voUpdateList=new ArrayList<ListVO>();	
		  initListTable(); 
	}
}
