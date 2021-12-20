package cms;
import java.util.ArrayList;
import java.util.Scanner;
import cms.show.*;
import cms.contact.*;
import cms.group.groupManager;

public class CMS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainMenu menu=new MainMenu();
		ContactManager contactManager = new ContactManager();
		groupManager groupManager=new groupManager();
		ContactFullManager fullContactManager = new ContactFullManager();
		Scanner scan= new Scanner(System.in);
		int end=0; int choice=0; String search;
		int bufferGroupId;//���ο� contact ��ü�����Ҷ� ����ڰ� �Է��� �� �ӽ����� ����
		String bufferName,bufferEmail,bufferAddress;//���ο� contact ��ü�����Ҷ� ����ڰ� �Է��� �� �ӽ����� ����
		contactManager.carr.add(new BasicContact("ȫ�浿","kdhong@kpu.co.kr",groupManager.garr.get(3)));//�ʱ� �⺻ �����ͻ���
		while(end==0) {
			menu.showMenu();
			choice=scan.nextInt();
			scan.nextLine();//scan ���� ����
			
			switch(choice) {
			case 1:
				bufferName=contactManager.getNewContact();//������ �Է¹������� �ӽ������Ϸ��� ���Ӱ� contact��ü ���� �Լ��� �ɰ�
				bufferEmail=contactManager.getNewContact2();
				groupManager.groupAllshow();
				System.out.println("-�׷�>");bufferGroupId=scan.nextInt();//����ڿ��� �Է¹��� �׷���̵� �ӽ�����
				contactManager.getNewContact3(bufferName,bufferEmail,groupManager.garr.get(bufferGroupId-1));
				//���� garr�ε����� �׷�id �ʵ��� ������ ���⶧���� get(bufferGroupId-1)���� 
				//ex. �׷�id 1�� �׷찴ü�� garr[0]�� ����
      		break;
			case 2:
				bufferName=fullContactManager.getNewContact();//������ �Է¹������� �ӽ������Ϸ��� ���Ӱ� contact��ü ���� �Լ��� �ɰ�
				bufferEmail=fullContactManager.getNewContact2();
				bufferAddress = fullContactManager.getNewContact4();
				groupManager.groupAllshow();
				System.out.println("-�׷�>");bufferGroupId=scan.nextInt();//����ڿ��� �Է¹��� �׷���̵� �ӽ�����
				fullContactManager.getNewContact3(bufferName,bufferEmail,groupManager.garr.get(bufferGroupId-1),bufferAddress);
				break;
			case 3://����ó ��ȸ
				System.out.printf("�˻� �̸�>> ");
				search=scan.nextLine();
				contactManager.showoneContact(search);
				fullContactManager.showoneContact(search);
				break;
			case 4:
				System.out.println("------------------------------------------");
				System.out.println("�̸�    �̸���             �׷�        �ּ�");
				System.out.println("------------------------------------------");
				contactManager.showAllContact();
				fullContactManager.showAllContact();
				System.out.println("------------------------------------------");
				break;
			case 5:
				groupManager.groupAdd();
				break;
			case 6:
				groupManager.groupAllshow();
				break;
			case 0:
				end=1;
				break;
			}
			
			
		}
		
		
	}

}


