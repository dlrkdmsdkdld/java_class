package cms.contact;
import java.util.ArrayList;
import java.util.Scanner;

import cms.group.group;

public class ContactManager {
	Scanner scan = new Scanner(System.in);
	public ArrayList<BasicContact> carr= new ArrayList<BasicContact>();
	
	public ContactManager() {
		//carr.add(new Contact("ȫ�浿","kdhong@kpu.co.kr","���ģ��"));//�ʱ� ������
	}

	

	public String getNewContact() {//�̺κп��� �̸��� �Է¹���
		System.out.println("<<����ó �����Է�>>");
		
		System.out.println("-�̸�:"); String name2=scan.nextLine();
		return name2;      
	}
	public String getNewContact2() {//�̺κп��� �̸��ϸ� �Է¹���
		System.out.println("-�̸���:"); String email2=scan.nextLine();
		return email2;

	}
	public void getNewContact3(String bufferName,String bufferEmail,group group) {//����ڰ� �Է��� ���� ��� ����־� ���ο� ��ü�����Լ�
		carr.add(new BasicContact(bufferName,bufferEmail,group));//����ڰ� �Է��� �����ͷ� ���ο� contact ��ü����
		System.out.printf(">>%s %s�߰� ����...",carr.get(carr.size()-1).getName(),carr.get(carr.size()-1).getGroup());//����߰��� �������ε����� �����ȯ
		System.out.println("");

	}
	public void showAllContact() {
	
		for(int i=0;i<carr.size();i++) {					
			System.out.printf("%s %s %s",carr.get(i).getName(),carr.get(i).getEmail(),carr.get(i).getGroup());
			System.out.println(" ");
		}

	}
	public void showoneContact(String search) {
		int searchSuccess=0;
		for(int i=0;i<carr.size();i++) {
			if( search.equals(carr.get(i).getName())) {
				System.out.println("-----------------------------");
				System.out.println("�̸�    �̸���             �׷�");
				System.out.println("-----------------------------");
				System.out.printf("%s %s %s",carr.get(i).getName(),carr.get(i).getEmail(),carr.get(i).getGroup());
				System.out.println(" ");

				searchSuccess=1;//���������� ������ 1�μ����ؼ� �������� �ȵ�����
				System.out.println("-----------------------------");
				break;
			}
		}
		if(searchSuccess==0) {//���������������� ��ȸ �̸��� ����̾ȵǾ��ִ°ſ��� ����Ʈ�ϰԵ�
			System.out.println("�׷� �̸��� ���� BasicContact ��ü�� �����ϴ�");
		}

	}
	
}
