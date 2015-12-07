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

import javax.swing.Box;
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

import blservice.reviewblservice.InstituteBLService;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import util.City;
import util.OrgType;
import vo.AccountVO;
import vo.InstituteVO;
import vo.StaffVO;

public class InstituteManageView extends JPanel {
	private DefaultTableModel instituteModel;
	private JTable instituteTable;
	private  InstituteBLService bl;
	private  ArrayList<InstituteVO> voList;
	private  ArrayList<InstituteVO> voUpdateList;
	private JComboBox CityCombobox;
	private JComboBox CityInCombobox;
	private JComboBox OrgCombobox;
	private JComboBox OrgInCombobox;
	private JTextField accountField;
	private JTextField IDField;
	
	private String city;
	private String org;
	private int selectedRow;
	public	InstituteManageView (InstituteBLService bl)
    {
		this.bl=bl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		voList=new ArrayList<InstituteVO>();
		voUpdateList=new ArrayList<InstituteVO>();
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
        OrgCombobox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
       
        OrgInCombobox = new JComboBox();  
        OrgInCombobox.addItem("营业厅");  
        OrgInCombobox.addItem("中转中心");  
		
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
		city="北京";
		CityInCombobox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					city=(String) CityInCombobox.getSelectedItem();
				}
			}
		});
	
		org="营业厅";
		OrgInCombobox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					org=(String) OrgInCombobox.getSelectedItem();
				}
			}
		});
		
		
		XLabel permissionLabel = new XLabel("城市：");
		XLabel accountLabel = new XLabel("机构：");
		accountField =new  JTextField();
		permissionLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
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
		
		inputPanel1.setLayout(new BoxLayout(inputPanel1, BoxLayout.X_AXIS));
		inputPanel1.add(inputPanel);
		inputPanel1.add(Box.createHorizontalGlue ());
		inputPanel1.add(addItemButton);
		
		this.add(inputPanel1);
		
	}private void initButton() {
		// TODO Auto-generated method stub
		XButton submitButton = new XButton("提交");
		submitButton.addActionListener(new ActionListener() {
//            //修改选中表格的数据
			public void actionPerformed(ActionEvent e) {
				voUpdateList=new ArrayList<InstituteVO>();
				int col = instituteModel.getColumnCount();
				int row = instituteModel.getRowCount();
				for (int i = 0; i < row; i++) {
					InstituteVO vo=null;
					    String[] inf=new String[3];
					for (int j = 0; j < col; j++) {
						inf[j]=(String) instituteModel.getValueAt(i, j);	
					}
					vo=new InstituteVO(City.toCity(inf[1]),OrgType.toOrgType(inf[2]),inf[0]);
					voUpdateList.add(vo);
					
				}
				bl.instituteUpdate(voUpdateList);
				
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
		 instituteModel = new DefaultTableModel(vData, vColumns);
//		//表格
		 instituteTable = new JTable(instituteModel){
			 private int myRow = -1;
			 TableCellEditor myEditor;  
			private static final long serialVersionUID = 1L;
//      //设置第一行第一列不可编辑
			public boolean isCellEditable(int row, int column){
				if (column == 0) {
					return false;
				}
				return true;
			}
  
		};
		
		JTableHeader tableH=instituteTable.getTableHeader();
		TableColumn tableColumn1 = instituteTable.getColumn("城市");
		 tableColumn1.setCellEditor(new DefaultCellEditor(CityCombobox));
		 
		 TableColumn tableColumn2 = instituteTable.getColumn("机构");
		 tableColumn2.setCellEditor(new DefaultCellEditor(OrgCombobox));
		 
//		 tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		 tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		 tableH.setFont(XContorlUtil.FONT_14_BOLD);
		 instituteTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 instituteTable.setShowVerticalLines(false);
		 instituteTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(instituteTable);
		instituteTable.setFillsViewportHeight(true);
		instituteTable.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                selectedRow = instituteTable.getSelectedRow(); //获得选中行索引
             }
            });
		this.add(scrollPane);
		voList=bl.findAll();
		for(int i = 0; i<voList.size();i++)
		{
			InstituteVO vo=voList.get(i);
			instituteModel.addRow(vo);
		}
		
		
	
	}
		
	protected void addItem() {
		// TODO Auto-generated method stub
		InstituteVO account = bl.addAccount(City.toCity(city),OrgType.toOrgType(org));
		accountField.setText("");
		IDField.setText("");
		instituteModel.addRow(account);
		validate();
	}
	protected void deleteItem() {
		// TODO Auto-generated method stub
		String toDeleteid=(String) instituteModel.getValueAt(selectedRow,0 );
		String cityToDelete=(String) instituteModel.getValueAt(selectedRow,1 );
		String OrgToDelete=(String) instituteModel.getValueAt(selectedRow,2 );
		bl.deleteAccount(toDeleteid);
		voUpdateList.remove(new InstituteVO(
				City.toCity(cityToDelete),
				OrgType.toOrgType(OrgToDelete),toDeleteid));
		instituteModel.removeRow(selectedRow);
		validate();
	}
}
