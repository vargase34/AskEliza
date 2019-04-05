package eliza;

import javax.swing.JFrame;

public class GUI extends JFrame{
	public GUI() {
		ElizaJPanel jp = new ElizaJPanel();
		add(jp);
		setSize(1500,900);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
