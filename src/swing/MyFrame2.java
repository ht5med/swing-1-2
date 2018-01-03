package swing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame2 extends JFrame {

	private JPanel jPanel;
	private JButton jButton;
	private JTextArea jTextArea;

	public MyFrame2() {
		super("My Frame");
		setLocation();
		jPanel = new JPanel();
		this.add(jPanel);
		jPanel.add(this.getLabel());
		jPanel.add(this.getButton());
		jPanel.add(this.getTextField());
//		jPanel.add(this.getTextArea());
		jPanel.add(this.getScrollPane());
		jPanel.addMouseListener(new ListenForMouse());
		this.addWindowListener(new ListenForWindow());
		
		globalSetting();
	}


	private Component getScrollPane() {
		jTextArea = new JTextArea("", 10, 30);
		jTextArea.setText("Tracking event\n");
		jTextArea.setLineWrap(true);
		jTextArea.setWrapStyleWord(true);
//		jTextArea.requestFocus();
		JScrollPane jScrollPane = new JScrollPane(jTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		return jScrollPane;
	}
	
	private Component getTextField() {
		JTextField jTextField = new JTextField("", 10);
		jTextField.requestFocus();
		jTextField.addKeyListener(new ListenForTextField());
		return jTextField;
	}

	private Component getButton() {
		jButton = new JButton("a button");
		jButton.setText("new text");
		jButton.setToolTipText("hi");
//		jButton.setBorderPainted(false);
//		jButton.setContentAreaFilled(false);
		jButton.addActionListener(new ListenForButton());
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
	
	int clickedTimes = 0;
	private class ListenForButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jButton){
				clickedTimes++;
				String text = "Button clicked "+ clickedTimes +" times\n";
				jTextArea.append(text);
				System.out.println(e.getSource());
			}
		}
	}
	private class ListenForTextField implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
			char keyChar = e.getKeyChar();
			String text = "Key hit: "+ keyChar +"\n";
			jTextArea.append(text);
		}
		@Override
		public void keyPressed(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent e) {}
	}
	private class ListenForWindow implements WindowListener{
		@Override
		public void windowOpened(WindowEvent e) {
			jTextArea.append("windowOpened\n");
		}
		@Override
		public void windowClosing(WindowEvent e) {}
		@Override
		public void windowClosed(WindowEvent e) {}
		@Override
		public void windowIconified(WindowEvent e) {
			jTextArea.append("windowIconified\n");
		}
		@Override
		public void windowDeiconified(WindowEvent e) {
			jTextArea.append("windowDeiconified\n");
		}
		@Override
		public void windowActivated(WindowEvent e) {
			jTextArea.append("windowActivated\n");
		}
		@Override
		public void windowDeactivated(WindowEvent e) {
			jTextArea.append("windowDeactivated\n");
		}
	}
	private class ListenForMouse implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			jTextArea.append("Mouse Pane pos: "+ e.getX() +" "+ e.getY() +"\n");
			jTextArea.append("Mouse Screen pos: "+ e.getXOnScreen() +" "+ e.getYOnScreen() +"\n");
			jTextArea.append("Mouse Button: "+ e.getButton() +"\n");
			jTextArea.append("Mouse Clickcount: "+ e.getClickCount() +"\n");
		}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}
}
