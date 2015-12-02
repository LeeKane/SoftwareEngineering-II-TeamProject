package ui.page;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import blservice.accountblservice.AccountBLService;
import ui.XButton;
import ui.XContorlUtil;
import ui.XLabel;
import vo.AccountVO;

public class LoginAcocuntMangerView extends JPanel{
	private DefaultTableModel accountModel;
	private JTable accountTable;
	private AccountBLService bl;
	private  ArrayList<AccountVO> voList;
	public	LoginAcocuntMangerView (AccountBLService bl)
    {
		this.bl=bl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		voList=new ArrayList<AccountVO>();
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

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				boolean result = bl.submit();
//				System.out.println(result);
//				if (result == true) {
//					JOptionPane.showMessageDialog(null, "提交成功！", "", JOptionPane.INFORMATION_MESSAGE);
//				} else {
//					JOptionPane.showMessageDialog(null, "提交失败！", "", JOptionPane.ERROR_MESSAGE);
//				}
				int col = accountModel.getColumnCount();
				int row = accountModel.getRowCount();
				for (int i = 0; i < col; i++) {
					System.out.print(accountModel.getColumnName(i) + "\t");
				}
				System.out.print("\r\n");
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						System.out.print(accountModel.getValueAt(i, j) + "\t");
					}
					System.out.print("\r\n");
				}
				System.out.println("------------------------------------");
			}
		});
		JPanel submitPanel = new JPanel();
		// submitPanel.setBackground(XContorlUtil.MENUITEM_BACKGROUND);


		submitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		submitPanel.add(submitButton);
		this.add(submitPanel);
	}
	private void initWareListTable() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();

		// 表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("权限");
		vColumns.add("用户名");
		vColumns.add("密码");
		
		 Vector<AccountVO> vData = new Vector<AccountVO>();
//			//模型
		 accountModel = new DefaultTableModel(vData, vColumns);
//		//表格
		 accountTable = new JTable(accountModel){
			private static final long serialVersionUID = 1L;

//			public boolean isCellEditable(int row, int column){
//				return false;
//			}
		};
		
		JTableHeader tableH=accountTable.getTableHeader();

//		 tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		 tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		 tableH.setFont(XContorlUtil.FONT_14_BOLD);
		 accountTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 accountTable.setShowVerticalLines(false);
		 accountTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(accountTable);
		accountTable.setFillsViewportHeight(true);
		this.add(scrollPane);
		voList=bl.findAll();
		for(int i = 0; i<voList.size();i++)
		{
			AccountVO vo=voList.get(i);
			accountModel.addRow(vo);
		}
		
		
	
	}
		
	

}
