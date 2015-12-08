
import javax.swing.JList;

public class XList extends JList
{

	public XList()
	{
		init();
	}

	private void init()
	{
		setFont(XContorlUtil.FONT_12_BOLD);
		setForeground(XContorlUtil.DEFAULT_TEXT_COLOR);
		setBackground(XContorlUtil.LIST_BACKGROUND);
		setCellRenderer(new XListRenderer(this));
		setSelectionMode(0);
	}
}
