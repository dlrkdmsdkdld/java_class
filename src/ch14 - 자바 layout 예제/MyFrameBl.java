import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrameBl extends JFrame {

	public MyFrameBl() {
		setTitle("BoxLayoutTest");
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		makeButton(panel,"Button1");
		makeButton(panel,"Button2");
		makeButton(panel,"Button3");
		makeButton(panel,"B4");
		makeButton(panel,"Long Button5");

		add(panel);
		pack();
		setVisible(true);
		
	}

	private void makeButton(JPanel panel, String text) {
		// TODO Auto-generated method stub
		JButton button=new JButton(text);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(button);
		
	}
	
	
}
