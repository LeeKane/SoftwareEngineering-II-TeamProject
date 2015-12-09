package ui.outlookpanel;

import javax.swing.JLabel;

public class XOutlookLabel extends JLabel {
	private String command;

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public XOutlookLabel(String command) {
		this.command = command;
	}
}
