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
		System.out.println("<<����ó �׷� ���� �Է�>>");
		System.out.println("  - �׷� ID: �ڵ�����");
		System.out.println("  - �̸� : ");
		tempo = scan.nextLine();
		gd[ind] = new groupdata(ind+1, tempo);
		++ind;
	}

	public void showgroup() {
		int x;
		System.out.println("--------------------------");
		System.out.println("Group ID    Group �̸�   ");
		System.out.println("--------------------------");
		for (x = 0; x < ind; x++)
			System.out.printf("%-2d         %5s \n",gd[x].groupid,gd[x].group);
		System.out.println("--------------------------");
	}

	public void getalldata() {int x;int t;
	System.out.println("--------------------------");
	System.out.println("Group ID    Group �̸�   ");
	System.out.println("--------------------------");
	for(x=0;x<ind;x++)
		System.out.printf("%-2d         %5s \n",gd[x].groupid,gd[x].group);
	System.out.println("--------------------------");
    System.out.println("  -�׷�>");t=scan.nextInt();
    tempo=t-1;tempoo=gd[t-1].group;
	}

	public void basicgroup() {
		int i;
		for (i = 0; i < 7; i++) {
			switch (i) {
			case 0:
				gd[i] = new groupdata(1, "����");
				break;
			case 1:
				gd[i] = new groupdata(2, "��ģ��");
				break;
			case 2:
				gd[i] = new groupdata(3, "�ߵ�ģ��");
				break;
			case 3:
				gd[i] = new groupdata(4, "���ģ��");
				break;
			case 4:
				gd[i] = new groupdata(5, "���Ż�");
				break;
			case 5:
				gd[i] = new groupdata(6, "����");
				break;
			case 6:
				gd[i] = new groupdata(7, "�븮��");
				break;
			}
		}
	}

}
