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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import blservice.reviewblservice.BeginningSetupBLService;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XTimeChooser;
import vo.SetupVO;

public class BeginningSetupView extends JPanel {
	private DefaultTableModel setupModel;
	private JTable setupTable;
	private BeginningSetupBLService bl;
	private ArrayList<SetupVO> voList;
	private ArrayList<SetupVO> voUpdateList;
	private SetupVO lastSelected;
	private SetupVO newSelected;
	private JComboBox isBox;

	private int selectedRow;

	public BeginningSetupView(BeginningSetupBLService bl) {
		this.setName("期初建账");

		this.bl = bl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		voList = new ArrayList<SetupVO>();
		voUpdateList = new ArrayList<SetupVO>();

		// 初始化账号列表界面
		initWareListTable();

		// 初始化按钮
		initButton();

		this.validate();
	}

	private void initButton() {
		// TODO Auto-generated method stub
		XButton submitButton = new XButton("提交");
		submitButton.addActionListener(new ActionListener() {
			// //修改选中表格的数据
			public void actionPerformed(ActionEvent e) {
				submitItem();
			}
		});
		XButton newButton = new XButton("新建");
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem();
				submitItem();
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
		submitPanel.add(newButton);
		submitPanel.add(deleteButton);
		submitPanel.add(submitButton);
		this.add(submitPanel);
	}

	private void initWareListTable() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();

		// 表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("建账时间");
		vColumns.add("帐目名");
		vColumns.add("备注");
		vColumns.add("当前账目");

		Vector<SetupVO> vData = new Vector<SetupVO>();
		// //模型
		setupModel = new DefaultTableModel(vData, vColumns);
		// //表格
		setupTable = new JTable(setupModel) {
			private int myRow = -1;
			TableCellEditor myEditor;
			private static final long serialVersionUID = 1L;

			// //设置第一行第一列不可编辑
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {
					return false;
				}
				return true;
			}

		};

		JTableHeader tableH = setupTable.getTableHeader();
		TableColumn tableColumn1 = setupTable.getColumn("当前账目");
		isBox=new JComboBox();
		isBox.addItem("否");
		isBox.addItem("是");
		isBox.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableColumn1.setCellEditor(new DefaultCellEditor(isBox));

		
		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		setupTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setupTable.setShowVerticalLines(false);
		setupTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(setupTable);
		setupTable.setFillsViewportHeight(true);
		setupTable.addMouseListener(new MouseAdapter() { // 鼠标事件
			public void mouseClicked(MouseEvent e) {
				selectedRow = setupTable.getSelectedRow(); // 获得选中行索引
			}
		});
		this.add(scrollPane);
		voList = bl.findAll();
		for (int i = 0; i < voList.size(); i++) {
			SetupVO vo = voList.get(i);
			if(vo.getIsSelected()==true)
				lastSelected=vo;
			setupModel.addRow(vo);
		}
	}

	protected void addItem() {
		// TODO Auto-generated method stub
		XTimeChooser ser=XTimeChooser.getInstance();
		SetupVO setup = new SetupVO(ser.getTimePO(), ser.getTimePO().toString()+"新建的账目", "无", false);
		setupModel.addRow(setup);
		validate();
	}

	protected void deleteItem() {
		// TODO Auto-generated method stub
		String toDeleteTime = (String) setupModel.getValueAt(selectedRow, 0);
		bl.deleteSetup(toDeleteTime);
		setupModel.removeRow(selectedRow);
		validate();
	}
	
	protected void submitItem(){
		voUpdateList = new ArrayList<SetupVO>();
		int col = setupModel.getColumnCount();
		int row = setupModel.getRowCount();
		for (int i = 0; i < row; i++) {
			SetupVO vo = null;
			String[] inf = new String[4];
			for (int j = 0; j < col; j++) {
				inf[j] = (String) setupModel.getValueAt(i, j);
			}
			if(inf[3].equals("是")){
				vo = new SetupVO(TimePO.toTime(inf[0]), inf[1], inf[2], true);
				newSelected=vo;
			}
			else
				vo = new SetupVO(TimePO.toTime(inf[0]), inf[1], inf[2], false);
			voUpdateList.add(vo);
		}
		bl.setupUpdate(voUpdateList);
		bl.swapDefault(lastSelected, newSelected);
	}
}
