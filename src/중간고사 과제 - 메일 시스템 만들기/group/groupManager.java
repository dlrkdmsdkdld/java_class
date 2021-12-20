package cms.group;

import java.util.ArrayList;
import java.util.Scanner;

public class groupManager {

	public ArrayList<group> garr=new ArrayList<group>();
	Scanner scan=new Scanner(System.in);
	String buffer;
	
	public groupManager() {
		garr.add(new group("가족",1));
		garr.add(new group("과친구",2));
		garr.add(new group("중딩친구",3));
		garr.add(new group("고딩친구",4));
		garr.add(new group("구매사",5));
		garr.add(new group("고객사",6));
		garr.add(new group("대리점",7));
	}
    public void groupAdd() {
		System.out.println("<<연락처 정보입력>>");
		System.out.printf("-그룹 ID: %d",garr.size()+1);
		System.out.println("");
		System.out.println("-이름:"); buffer=scan.nextLine();
     	garr.add(new group(buffer,garr.size()+1));
    	System.out.printf(">> %s 그룹 추가 성공...",garr.get(garr.size()-1).getGroupName());//마지막에 추가한 인덱스의 그룹네임 프린트
		System.out.println("");
    }
    public void groupAllshow() {
		System.out.println("-----------------------------");
		System.out.println("Group ID     Group 이름");
		System.out.println("-----------------------------");

    	for(int i=0;i<garr.size();i++) {
    		System.out.printf("   %d          %s",garr.get(i).getId(),garr.get(i).getGroupName());
    		System.out.println();
    	}
		System.out.println("-----------------------------");

    }
}
