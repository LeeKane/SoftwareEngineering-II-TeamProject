package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import blservice.accountblservice.AccountBLService;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import util.Permission;
import vo.AccountVO;

public class InstituteManageView extends JPanel {
	private DefaultTableModel accountModel;
	private JTable accountTable;
	private AccountBLService bl;
	private  ArrayList<AccountVO> voList;
	private  ArrayList<AccountVO> voUpdateList;
	private JComboBox CityCombobox;
	private JComboBox CityInCombobox;
	private JComboBox OrgCombobox;
	private JComboBox OrgInCombobox;
	private JTextField accountField;
	private JTextField IDField;
	
	private String City;
	private String Org;
	private int selectedRow;
	public	InstituteManageView (AccountBLService bl)
    {
		this.bl=bl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		voList=new ArrayList<AccountVO>();
		voUpdateList=new ArrayList<AccountVO>();
		CityCombobox = new JComboBox();  
		CityCombobox.addItem("北京");  
		CityCombobox.addItem("上海");  
		CityCombobox.addItem("南京");  
		CityCombobox.addItem("广州");  
		
		CityCombobox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		CityInCombobox = new JComboBox();  
		CityInCombobox.addItem("北京");  
		CityInCombobox.addItem("上海");  
		CityInCombobox.addItem("南京");  
		CityInCombobox.addItem("广州");  
	
		CityInCombobox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		OrgCombobox = new JComboBox();  
		OrgCombobox.addItem("营业厅");  
		OrgCombobox.addItem("中转中心");  
		OrgCombobox.addItem("仓库");  
        OrgCombobox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
       
        OrgInCombobox = new JComboBox();  
        OrgInCombobox.addItem("营业厅");  
        OrgInCombobox.addItem("中转中心");  
        OrgInCombobox.addItem("仓库");  
		
        OrgInCombobox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		
		
		
		
		
		
		initInputField();
		// 初始化账号列表界面
	initWareListTable(); 

	// 初始化按钮
	initButton();

	this.validate();
    }
	private void initInputField() {
		// TODO Auto-generated method stub
		City="北京";
		CityInCombobox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					City=(String) CityInCombobox.getSelectedItem();
				}
			}
		});
	
		Org="营业厅";
		OrgInCombobox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					Org=(String) OrgInCombobox.getSelectedItem();
				}
			}
		});
		
		
		XLabel permissionLabel = new XLabel("城市：");
		XLabel accountLabel = new XLabel("机构：");
		accountField =new  JTextField();
		accountLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		accountField.setPreferredSize(new Dimension(100,26));
	
		IDField =new  JTextField();
		
		IDField.setPreferredSize(new Dimension(100,26));

		
		XButton addItemButton = new XButton("添加");
		addItemButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			}
		});


		
		JPanel inputPanel = new JPanel();
		JPanel inputPanel1= new JPanel();
		//inputPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(permissionLabel);
		inputPanel.add(CityInCombobox);
		
		inputPanel.add(accountLabel);
		inputPanel.add(OrgInCombobox);
		
	
		inputPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		inputPanel1.add(addItemButton);
		
		this.add(inputPanel);
		this.add(inputPanel1);
		
	}private void initButton() {
		// TODO Auto-generated method stub
		XButton submitButton = new XButton("修改");
		submitButton.addActionListener(new ActionListener() {
//            //修改选中表格的数据
			public void actionPerformed(ActionEvent e) {
				int col = accountModel.getColumnCount();
				int row = accountModel.getRowCount();
				for (int i = 0; i < row; i++) {
					    AccountVO vo=null;
					    String[] inf=new String[4];
					for (int j = 0; j < col; j++) {
						inf[j]=(String) accountModel.getValueAt(i, j);	
					}
					vo=new AccountVO(Long.parseLong(inf[0]),Permission.toPermission(inf[1]),inf[2],inf[3]);
					voUpdateList.add(vo);
					
				}
				bl.permissionUpate(voUpdateList);
				
			}
		});
			   
		XButton deleteButton = new XButton("删除");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	           deleteItem();			
			}
		});
		
		
		JPanel submitPanel = new JPanel();
		submitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		submitPanel.add(deleteButton);
		submitPanel.add(submitButton);
		this.add(submitPanel);
	}

	private void initWareListTable() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();

		// 表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("ID");
		vColumns.add("城市");
		vColumns.add("机构");
	
		
		 Vector<AccountVO> vData = new Vector<AccountVO>();
//			//模型
		 accountModel = new DefaultTableModel(vData, vColumns);
//		//表格
		 accountTable = new JTable(accountModel){
			 private int myRow = -1;
			 TableCellEditor myEditor;  
			private static final long serialVersionUID = 1L;
//      //设置第一行第一列不可编辑
			public boolean isCellEditable(int row, int column){
			if (column == 0) {
				return false;
			}
			if(row==0)
			{
				return false;
			}
			return true;
			}
  
		};
		
		JTableHeader tableH=accountTable.getTableHeader();
		TableColumn tableColumn = accountTable.getColumn("城市");
		 tableColumn.setCellEditor(new DefaultCellEditor(CityCombobox));  
//		 tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		 tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		 tableH.setFont(XContorlUtil.FONT_14_BOLD);
		 accountTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 accountTable.setShowVerticalLines(false);
		 accountTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(accountTable);
		accountTable.setFillsViewportHeight(true);
		accountTable.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                selectedRow = accountTable.getSelectedRow(); //获得选中行索引
             }
            });
		this.add(scrollPane);
		voList=bl.findAll();
		for(int i = 0; i<voList.size();i++)
		{
			AccountVO vo=voList.get(i);
			accountModel.addRow(vo);
		}
		
		
	
	}
		
	protected void addItem() {
		// TODO Auto-generated method stub
		AccountVO account = bl.addAccount(Permission.toPermission(City),accountField.getText(),IDField.getText());
		accountField.setText("");
		IDField.setText("");
		accountModel.addRow(account);
		InstituteManageView.this.validate();
	}
	protected void deleteItem() {
		// TODO Auto-generated method stub
		long id=Long.parseLong((String) accountModel.getValueAt(selectedRow,0 ));
		bl.deleteAccount(id);
		accountModel.removeRow(selectedRow);
		InstituteManageView.this.validate();
	}
}
