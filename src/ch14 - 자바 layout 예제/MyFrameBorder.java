import javax.swing.*;
import java.awt.*;

public class MyFrameBorder extends JFrame {

	MyFrameBorder(){
		setTitle("b");
	    setLayout(new BorderLayout());

		add(new JButton("Center"),BorderLayout.CENTER);
		add(new JButton("Line Start"),BorderLayout.LINE_START);//,BorderLayout.LEFT_ALIGNMENT);
		add(new JButton("Page Start"),BorderLayout.PAGE_START);
		add(new JButton("Line End"),BorderLayout.LINE_END);
		add(new JButton("page End"),BorderLayout.PAGE_END);
		
		
		pack();
		setVisible(true);
		
	}
}
