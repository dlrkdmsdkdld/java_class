package ch13;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame extends JFrame{
	public MyFrame() {
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Welcome to the Hotel java");
		
		JPanel panel1=new JPanel();
		JLabel label1 =new JLabel("We in Java Hotel welcome you...");
		panel1.add(label1);
		
		JPanel panel2=new JPanel();
		JLabel label2 =new JLabel("Your name please...");
		panel2.add(label2);
		JTextField t1=new JTextField(10);
		panel2.add(t1);

		
		JPanel panel3=new JPanel();
		JLabel label3 =new JLabel("How many nights are you going to stay?");
		panel3.add(label3);
		
		JPanel panel4=new JPanel();
		JButton b1=new JButton("1 night");
		JButton b2=new JButton("2 nights");
		JButton b3=new JButton("3 nights");
		JButton b4=new JButton("4 nights");
		JButton b5=new JButton("5 nights");
		

		panel4.add(b1);
		panel4.add(b2);
		panel4.add(b3);
		panel4.add(b4);
		panel4.add(b5);
		
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		add(panel);
		setVisible(true);

		
		
	}
}


public class ch13 {
	public static void main(String[] args) {
		MyFrame f=new MyFrame();
	}

}
