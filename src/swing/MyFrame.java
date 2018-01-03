package swing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame {

	private JPanel jPanel;

	public MyFrame() {
		super("My Frame");
		setLocation();
		jPanel = new JPanel();
		this.add(jPanel);
		jPanel.add(this.getLabel());
		jPanel.add(this.getButton());
		jPanel.add(this.getTextField());
//		jPanel.add(this.getTextArea());
		jPanel.add(this.getScrollPane());
		
		globalSetting();
	}


	private Component getScrollPane() {
		JTextArea jTextArea = new JTextArea("Type here", 5, 15);
		jTextArea.setText("Type type");
		jTextArea.setLineWrap(true);
		jTextArea.setWrapStyleWord(true);
//		jTextArea.requestFocus();
		JScrollPane jScrollPane = new JScrollPane(jTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		return jScrollPane;
	}
	
	private Component getTextField() {
		JTextField jTextField = new JTextField("field", 5);
		jTextField.requestFocus();
		return jTextField;
	}

	private Component getButton() {
		JButton jButton = new JButton("a button");
		jButton.setText("new text");
		jButton.setToolTipText("hi");
//		jButton.setBorderPainted(false);
//		jButton.setContentAreaFilled(false);
		return jButton;
	}

	private Component getLabel() {
		JLabel jLabel = new JLabel("Tell me something");
		jLabel.setText("other ting");
		jLabel.setToolTipText("tips");
		return jLabel;
	}

	private void globalSetting() {
		this.setSize(400, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void setLocation() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int x = (screenSize.width - this.getWidth())/2;
		int y = (screenSize.height - this.getHeight())/2;
		this.setLocation(x, y);
	}
}
