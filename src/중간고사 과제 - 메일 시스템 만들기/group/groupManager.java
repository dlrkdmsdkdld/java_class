package cms.group;

import java.util.ArrayList;
import java.util.Scanner;

public class groupManager {

	public ArrayList<group> garr=new ArrayList<group>();
	Scanner scan=new Scanner(System.in);
	String buffer;
	
	public groupManager() {
		garr.add(new group("����",1));
		garr.add(new group("��ģ��",2));
		garr.add(new group("�ߵ�ģ��",3));
		garr.add(new group("���ģ��",4));
		garr.add(new group("���Ż�",5));
		garr.add(new group("����",6));
		garr.add(new group("�븮��",7));
	}
    public void groupAdd() {
		System.out.println("<<����ó �����Է�>>");
		System.out.printf("-�׷� ID: %d",garr.size()+1);
		System.out.println("");
		System.out.println("-�̸�:"); buffer=scan.nextLine();
     	garr.add(new group(buffer,garr.size()+1));
    	System.out.printf(">> %s �׷� �߰� ����...",garr.get(garr.size()-1).getGroupName());//�������� �߰��� �ε����� �׷���� ����Ʈ
		System.out.println("");
    }
    public void groupAllshow() {
		System.out.println("-----------------------------");
		System.out.println("Group ID     Group �̸�");
		System.out.println("-----------------------------");

    	for(int i=0;i<garr.size();i++) {
    		System.out.printf("   %d          %s",garr.get(i).getId(),garr.get(i).getGroupName());
    		System.out.println();
    	}
		System.out.println("-----------------------------");

    }
}
