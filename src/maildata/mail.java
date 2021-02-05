package maildata;

import java.util.Scanner;

public class mail {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		menu mm = new menu();
		manager m1 = new manager();
		groupmanager g1 = new groupmanager();
		g1.basicgroup();
		int button = 1;

		while (button != 0) {
			button = mm.showmenu();
			switch (button) {
			case 1:
				m1.setdata();
		
				break;
			case 2:
				m1.finddata();
				break;
			case 3:
				m1.showdata();
				break;
			case 4:
				g1.setgroup();
				break;
			case 5:
				g1.showgroup();
				break;
			case 0:
				break;
			}

		}

	}

}
