import java.util.Scanner;

public class ch14Pg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean choice =true;
		Scanner scan=new Scanner(System.in);
		int select;
		while(choice) {
			System.out.println("-------------");
			System.out.println("<MENU>");
			System.out.println("-------------");
			System.out.println("1.FlowLayout");
			System.out.println("2.BorderLayout");
			System.out.println("3.BorderLayout");
			System.out.println("4.GridLayout");
			System.out.println("5.CardLayout");
			System.out.println("6.Absolute Layout");
			System.out.println("");
			System.out.println("0.Exit");
			System.out.println("-------------");
			System.out.println(">>");
			select=scan.nextInt();

			
			switch(select) {
			case 1:
				MyFrameFl f=new MyFrameFl();
				break;
			case 2:
				MyFrameBorder b=new MyFrameBorder();
			
				break;
			case 3:
				MyFrameBl Bl=new MyFrameBl();
				break;
			case 4:
				MyFrameGr g=new MyFrameGr();
				
				break;
			case 5:
				MyFrameCl c=new MyFrameCl();
				break;
			case 6:
				MyFrameAl a = new MyFrameAl();
				break;
			case 0:
				choice=false;
				break;
			
			}
			
			
		}
		
		

	}

}

