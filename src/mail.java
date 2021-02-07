import cms.show.*;
import cms.contact.*;
import java.util.Scanner;
import cms.group.*;


public class mail {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		showable mm = new showable();
		manager m1 = new manager();
		fullmanager fm=new fullmanager();
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
				fm.setdata();break;
			case 3:
				m1.finddata();
				break;
			case 4:
				m1.showdata();
				fm.showdata();
				break;
			case 5:
				g1.setgroup();
				break;
			case 6:
				g1.showgroup();
				break;
			case 0:
				break;
			}

		}

	}

}
