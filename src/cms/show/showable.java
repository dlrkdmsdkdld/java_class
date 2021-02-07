package cms.show;

import java.util.Scanner;

public class showable {
	Scanner scan;

  public showable() {
		scan = new Scanner(System.in);
	}

  public int showmenu() {
		System.out.println("-----menu-----");
		System.out.println("1.연락처 추가");
		System.out.println("2.상세연락처 추가");
		System.out.println("3.연락처 조회");
		System.out.println("4.연락처 목록 출력");
		System.out.println("5.연락처 그룹 추가");
		System.out.println("6.연락처 그룹 목록 출력");
		System.out.println("0.종료");
		System.out.println("--------------");
		return scan.nextInt();
	}


}



