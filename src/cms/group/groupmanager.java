package cms.group;

import java.util.Scanner;
import cms.contact.*;



public class groupmanager {
	groupdata[] gd;
	Scanner scan;
	static int ind = 7;
	public int tempo;public String tempoo;

	public groupmanager() {
		gd = new groupdata[15];
		scan = new Scanner(System.in);
	}

	public void setgroup() {
		String tempo;
		System.out.println("<<연락처 그룹 정보 입력>>");
		System.out.println("  - 그룹 ID: 자동생성");
		System.out.println("  - 이름 : ");
		tempo = scan.nextLine();
		gd[ind] = new groupdata(ind+1, tempo);
		++ind;
	}

	public void showgroup() {
		int x;
		System.out.println("--------------------------");
		System.out.println("Group ID    Group 이름   ");
		System.out.println("--------------------------");
		for (x = 0; x < ind; x++)
			System.out.printf("%-2d         %5s \n",gd[x].groupid,gd[x].group);
		System.out.println("--------------------------");
	}

	public void getalldata() {int x;int t;
	System.out.println("--------------------------");
	System.out.println("Group ID    Group 이름   ");
	System.out.println("--------------------------");
	for(x=0;x<ind;x++)
		System.out.printf("%-2d         %5s \n",gd[x].groupid,gd[x].group);
	System.out.println("--------------------------");
    System.out.println("  -그룹>");t=scan.nextInt();
    tempo=t-1;tempoo=gd[t-1].group;
	}

	public void basicgroup() {
		int i;
		for (i = 0; i < 7; i++) {
			switch (i) {
			case 0:
				gd[i] = new groupdata(1, "가족");
				break;
			case 1:
				gd[i] = new groupdata(2, "과친구");
				break;
			case 2:
				gd[i] = new groupdata(3, "중딩친구");
				break;
			case 3:
				gd[i] = new groupdata(4, "고딩친구");
				break;
			case 4:
				gd[i] = new groupdata(5, "구매사");
				break;
			case 5:
				gd[i] = new groupdata(6, "고객사");
				break;
			case 6:
				gd[i] = new groupdata(7, "대리점");
				break;
			}
		}
	}

}
