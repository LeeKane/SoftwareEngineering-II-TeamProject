package ui.page;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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

import blservice.financeblservice.BAccountBLService;
import blservice.reviewblservice.LogBLService;
import po.TimePO;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import vo.BaccountVO;

public class BAccountManageView extends JPanel {
	private JTextField textField;// 唯一的输入框
	private JTextField bAccountField;
	private DefaultTableModel bAccountManageModel;
	private JTable bAccountTable;
	private JTextField CityCombobox;

	private ArrayList<BaccountVO> voList;
	private ArrayList<BaccountVO> voUpdateList;
	private BAccountBLService bl;
	private String text;
	private int selectedRow;

	public BAccountManageView(BAccountBLService bl) {
		this.setName("账户管理");

		this.bl = bl;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initInputField();
		initListTable();
		initUnder();
	}

	private void initUnder() {
		// TODO Auto-generated method stub
		XButton deleteButton = new XButton("删除");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteItem();
			}
		});

		XButton submitButton = new XButton("提交");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				voUpdateList = new ArrayList<BaccountVO>();
				int col = bAccountManageModel.getColumnCount();
				int row = bAccountManageModel.getRowCount();
				for (int i = 0; i < row; i++) {
					BaccountVO vo = null;
					String[] inf = new String[3];
					for (int j = 0; j < col; j++) {
						inf[j] = (String) bAccountManageModel.getValueAt(i, j);
					}
					vo = new BaccountVO(inf[0], inf[1], inf[2]);
					System.out.println(vo.getName() + "," + vo.getAccount() + "," + vo.getBalance());
					voUpdateList.add(vo);
				}
				bl.update(voUpdateList);
				LogBLService.insert(TimePO.getNowTimePO(),
						bl.getPo().getPermission().toString() + bl.getPo().getUsername() + "提交了账户信息");
				JOptionPane.showMessageDialog(null, "提交成功！", "", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JPanel underPanel = new JPanel();
		underPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		underPanel.add(deleteButton);
		underPanel.add(submitButton);
		this.add(underPanel);
	}

	private void initListTable() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("账户");
		vColumns.add("名称");
		vColumns.add("金额");
		Vector<BaccountVO> vData = new Vector<BaccountVO>();
		// //模型
		bAccountManageModel = new DefaultTableModel(vData, vColumns);
		// //表格
		bAccountTable = new JTable(bAccountManageModel) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				if (column == 0 || column == 1)
					return true;
				return false;
			}
		};

		JTableHeader tableH = bAccountTable.getTableHeader();
		TableColumn tableColumn1 = bAccountTable.getColumn("名称");
		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		bAccountTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bAccountTable.setShowVerticalLines(false);
		bAccountTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(bAccountTable);
		bAccountTable.setFillsViewportHeight(true);
		bAccountTable.addMouseListener(new MouseAdapter() { // 鼠标事件
			public void mouseClicked(MouseEvent e) {
				selectedRow = bAccountTable.getSelectedRow(); // 获得选中行索引
			}
		});

		this.add(scrollPane);
		voList = bl.findAll();
		for (int i = 0; i < voList.size(); i++) {
			BaccountVO vo = voList.get(i);
			bAccountManageModel.addRow(vo);
		}
	}

	private void initInputField() {
		// TODO Auto-generated method stub
		XLabel idLabel = new XLabel("账户信息：");
		textField = new JTextField();
		idLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		textField.setPreferredSize(new Dimension(150, 26));

//		XButton inquireButton = new XButton("查询");
//		inquireButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					inquire();
//				} catch (NumberFormatException e) {
//					JOptionPane.showMessageDialog(null, "请正确输入", "", JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		});

		XLabel bAccountLabel = new XLabel("账户账号：");
		bAccountField = new JTextField();
		bAccountLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		bAccountField.setPreferredSize(new Dimension(150, 26));
		XLabel cityLabel = new XLabel("账户名称：");
		CityCombobox = new JTextField();
		cityLabel.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		CityCombobox.setPreferredSize(new Dimension(150, 26));
		XButton addItemButton = new XButton("添加");
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			}
		});

//		JPanel idInputPanel = new JPanel();
//		idInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//		idInputPanel.add(idLabel);
//		idInputPanel.add(textField);
//		idInputPanel.add(inquireButton);

		JPanel idInputPanel2 = new JPanel();
		idInputPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		idInputPanel2.add(bAccountLabel);
		idInputPanel2.add(bAccountField);
		idInputPanel2.add(cityLabel);
		idInputPanel2.add(CityCombobox);
		idInputPanel2.add(addItemButton);

//		this.add(idInputPanel);
		this.add(idInputPanel2);
	}

	protected void inquire() {
		// TODO Auto-generated method stub
		String id = textField.getText();
		int row = bAccountManageModel.getRowCount();
		for (int i = 0; i < row; i++) {
		}

		// if (!voList.isEmpty()) {
		// for (int i = 0; i < voList.size(); i++) {
		// TransVO vo = voList.get(i);
		// bAccountManageModel.addRow(vo);
		// }
		// } else {
		// JOptionPane.showMessageDialog(null, "无此订单信息", "",
		// JOptionPane.ERROR_MESSAGE);
		// }
		// textField.setText("");

	}

	protected void addItem() {
		// TODO Auto-generated method stub
		BaccountVO baccount = bl.addStaff(bAccountField.getText(), CityCombobox.getText());
		LogBLService.insert(TimePO.getNowTimePO(),
				bl.getPo().getPermission().toString() + bl.getPo().getUsername() + "增加了账户：" + CityCombobox.getText());
		CityCombobox.setText("");
		bAccountField.setText("");
		bAccountManageModel.addRow(baccount);
		validate();
	}

	protected void deleteItem() {
		// TODO Auto-generated method stub
		String toDeleteid = (String) bAccountManageModel.getValueAt(selectedRow, 0);
		String cityToDelete = (String) bAccountManageModel.getValueAt(selectedRow, 1);
		String OrgToDelete = (String) bAccountManageModel.getValueAt(selectedRow, 2);
		// bl.deleteStaff(toDeleteid);
		// voUpdateList.remove(new BaccountVO(cityToDelete, toDeleteid,
		// OrgToDelete));
		bAccountManageModel.removeRow(selectedRow);
		validate();
		LogBLService.insert(TimePO.getNowTimePO(),
				bl.getPo().getPermission().toString() + bl.getPo().getUsername() + "删除了账户：" + cityToDelete);
	}
}
