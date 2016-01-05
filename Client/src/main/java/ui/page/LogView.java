package ui.page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;

import blservice.reviewblservice.LogBLService;
import ui.XContorlUtil;
import vo.LogVO;

public class LogView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel logModel;
	private JTable logTable;
	private LogBLService bl;
	private ArrayList<LogVO> voList;

	public LogView(LogBLService bl) {
		this.setName("日志");

		this.bl = bl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		voList = new ArrayList<LogVO>();

		// 初始化账号列表界面
		initWareListTable();

		this.validate();
	}

	private void initWareListTable() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();

		// 表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("时间");
		vColumns.add("操作");

		Vector<LogVO> vData = new Vector<LogVO>();
		// //模型
		logModel = new DefaultTableModel(vData, vColumns);
		// //表格
		logTable = new JTable(logModel) {
			private int myRow = -1;
			TableCellEditor myEditor;
			private static final long serialVersionUID = 1L;

			// //设置第一行第一列不可编辑
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JTableHeader tableH = logTable.getTableHeader();

		// tableH.setBackground(XContorlUtil.OUTLOOK_CONTAINER_COLOR);
		tableH.setForeground(XContorlUtil.DEFAULT_PAGE_TEXT_COLOR);
		tableH.setFont(XContorlUtil.FONT_14_BOLD);
		logTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		logTable.setShowVerticalLines(false);
		logTable.setShowHorizontalLines(false);
		scrollPane.getViewport().add(logTable);
		logTable.setFillsViewportHeight(true);
		this.add(scrollPane);
		Iterator<LogVO> voi= bl.findAll();
		for (;voi.hasNext();) {
			LogVO vo = voi.next();
			logModel.addRow(vo);
		}
	}
}
