package cms.show;

import java.util.Scanner;

public class showable {
	Scanner scan;

  public showable() {
		scan = new Scanner(System.in);
	}

  public int showmenu() {
		System.out.println("-----menu-----");
		System.out.println("1.����ó �߰�");
		System.out.println("2.�󼼿���ó �߰�");
		System.out.println("3.����ó ��ȸ");
		System.out.println("4.����ó ��� ���");
		System.out.println("5.����ó �׷� �߰�");
		System.out.println("6.����ó �׷� ��� ���");
		System.out.println("0.����");
		System.out.println("--------------");
		return scan.nextInt();
	}


}



