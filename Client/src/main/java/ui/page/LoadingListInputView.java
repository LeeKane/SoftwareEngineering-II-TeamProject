package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import bl.list.OrdersInputBL;
import blservice.listblservice.OrdersInputBLService;
import blservice.transblservice.LoadingListBLService;
import po.TimePO;
import po.WarePO;
import po.list.OrderListPO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import ui.XTimeChooser;
import vo.LoadingVO;

public class LoadingListInputView extends JPanel {
	
	private LoadingListBLService bl;
	private OrdersInputBLService obl;
	private XTimeChooser ser;
	private JTextField dataField;
	private JTextField centerNumField;
	private JTextField loadMonitorField;
	private JTextField loadPerformerField;
	private JTextField idField;
	private DefaultTableModel loadingInputModel;
	private JTable loadingInputTable;
	private TimePO timePO;
	
	public LoadingListInputView(LoadingListBLService bl)
	{
		this.setName("装运管理");
		
		this.obl=new OrdersInputBL(bl.getPo());
		this.bl=bl;
	    setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
	    initImportItemField();
		
	    initIdField();
		//初始化快件列表界面
		initWareListTable();
		
		//初始化提交进货单按钮
		initSubmitButton();
		
		this.validate();
	}



	private void initSubmitButton() {
		// TODO Auto-generated method stub
		XButton submitButton = new XButton("提交");
		submitButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean result = bl.submit();
				if(result == true){
					JOptionPane.showMessageDialog(null, "提交成功！","", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "提交失败！","", JOptionPane.ERROR_MESSAGE);
				}
			}			
		});
		JPanel submitPanel = new JPanel();
		//submitPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);
		submitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		submitPanel.add(submitButton);
		this.add(submitPanel);
	}

	private void initWareListTable() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("装车日期");
		vColumns.add("汽运编号");
		vColumns.add("出发地");
		vColumns.add("到达地");
		vColumns.add("条形码号");
		vColumns.add("监装员");
		vColumns.add("押运员");
		vColumns.add("运费");
		   Vector<LoadingVO> vData = new Vector<LoadingVO>();
//			//模型
		   loadingInputModel = new DefaultTableModel(vData, vColumns);
//		//表格
		   loadingInputTable = new JTable(loadingInputModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		 JTableHeader tableH=loadingInputTable.getTableHeader();
		 TableColumn firsetColumn = loadingInputTable.getColumnModel().getColumn(0);
		 firsetColumn.setPreferredWidth(200);
		 firsetColumn.setMaxWidth(200);
		 firsetColumn.setMinWidth(200);
//		 tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		 tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		 tableH.setFont(XContorlUtil.FONT_14_BOLD);
		 loadingInputTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 loadingInputTable.setShowVerticalLines(false);
		 loadingInputTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(loadingInputTable);
		loadingInputTable.setFillsViewportHeight(true);
		this.add(scrollPane);
		

	
	}

	private void initImportItemField() {
		// TODO Auto-generated method stub
		XLabel dataLabel = new XLabel("达到日期：");
		dataField =new  JTextField();
		dataLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		dataField.setPreferredSize(new Dimension(200,26));
		ser = XTimeChooser.getInstance();
		ser.register(dataField);
		timePO=ser.getTimePO();
		dataField.setText(ser.getCurrentTime());
		dataField.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		XLabel centerNumLabel = new XLabel("中转中心汽运编号：");
		centerNumField =new  JTextField();
		centerNumLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		centerNumField.setPreferredSize(new Dimension(100,26));
		XLabel loadMonitorLabel = new XLabel("监装员：");
		loadMonitorField =new  JTextField();
		loadMonitorLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		loadMonitorField.setPreferredSize(new Dimension(70,26));
		XLabel loadPerformerLabel = new XLabel("押运员：");
		loadPerformerField =new  JTextField();
		loadPerformerLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		loadPerformerField.setPreferredSize(new Dimension(70,26));
		
		JPanel infInputPanel = new JPanel();
		infInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		infInputPanel.add(dataLabel);
		infInputPanel.add(dataField);
		infInputPanel.add(centerNumLabel);
		infInputPanel.add(centerNumField);
		infInputPanel.add(loadMonitorLabel);
		infInputPanel.add(loadMonitorField);
		infInputPanel.add(loadPerformerLabel);
		infInputPanel.add(loadPerformerField);
		this.add(infInputPanel);
	}
	private void initIdField() {
		// TODO Auto-generated method stub
		XLabel idLabel = new XLabel("订单条形码号：");
		idField =new  JTextField();
		idLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		idField.setPreferredSize(new Dimension(100,26));
		
		XButton addItemButton = new XButton("添加");
		addItemButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			}
		});
		
		JPanel  idInputPanel = new JPanel();
		JPanel  idInputPanel1 = new JPanel();
		idInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		idInputPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idInputPanel.add(idLabel);
		idInputPanel.add(idField);
		idInputPanel1.add(addItemButton);
		
		this.add(idInputPanel);
		this.add(idInputPanel1);

	}



	protected void addItem() {
		// TODO Auto-generated method stub
		try{
			if(loadMonitorField.getText().equals("")||loadPerformerField.equals("")){
				JOptionPane.showMessageDialog(null, "请输入未输入项","", JOptionPane.ERROR_MESSAGE);
			}else{
				long id=Long.parseLong(idField.getText());
				OrderListPO order=obl.find(id+"");
				if(order!=null){
					WarePO ware=order.getWare();
					LoadingVO lv=bl.addLoading(ser.getTimePO(),
							Long.parseLong(centerNumField.getText()),ware.getDepartPlace(), ware.getDestination(),
							id, loadMonitorField.getText(), loadPerformerField.getText(),
							ware.getcost());
					loadingInputModel.addRow(lv);
				}else{
					JOptionPane.showMessageDialog(null, "无此订单信息","", JOptionPane.ERROR_MESSAGE);
				}
			}	
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "请正确输入","", JOptionPane.ERROR_MESSAGE);
		}
			
		loadPerformerField.setText("");
		loadMonitorField.setText("");
		centerNumField.setText("");
		idField.setText("");
		LoadingListInputView.this.validate();
	}
	
}
