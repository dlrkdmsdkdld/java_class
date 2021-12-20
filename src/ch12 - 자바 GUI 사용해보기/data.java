package q2;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
class MyFrame extends JFrame{
	public MyFrame() {
		setSize(600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("자바피자");
		
		setLayout(new FlowLayout());
		JPanel panel1 = new JPanel();
		
		JPanel panel2 = new JPanel();
		JLabel label = new JLabel("피자의 종류를 선택하세요");
		panel2.add(label);
		
		
		JPanel panel3 = new JPanel();
		JButton button1=new JButton("콤보피자");
		JButton button3=new JButton("포테이토피자");
		JButton button2=new JButton("불고기피자");

		panel3.add(button2);
		panel3.add(button1);
		panel3.add(button3);

		panel1.add(panel2);
		panel1.add(panel3);

		add(panel1);
		
		setVisible(true);
	
}
}
public class data {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f = new MyFrame();
			
	}

}


