package cms.contact;

import java.util.ArrayList;
import java.util.Scanner;

import cms.group.group;

public class ContactFullManager {
	Scanner scan = new Scanner(System.in);
	public ArrayList<FullContact> Farr= new ArrayList<FullContact>();
	
	public ContactFullManager() {
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
	public String getNewContact4(){
		System.out.println("-�ּ�:"); String addr=scan.nextLine();
		return addr;
	}
	public void getNewContact3(String bufferName,String bufferEmail,group group,String addr) {//����ڰ� �Է��� ���� ��� ����־� ���ο� ��ü�����Լ�
		Farr.add(new FullContact(bufferName,bufferEmail,group,addr));//����ڰ� �Է��� �����ͷ� ���ο� contact ��ü����
		System.out.printf(">>%s %s�߰� ����...",Farr.get(Farr.size()-1).getName(),Farr.get(Farr.size()-1).getGroup());//����߰��� �������ε����� �����ȯ
		System.out.println("");

	}
	public void showAllContact() {
	
		for(int i=0;i<Farr.size();i++) {					
			System.out.printf("%s %s %s %s",Farr.get(i).getName(),Farr.get(i).getEmail(),Farr.get(i).getGroup(),Farr.get(i).getAddr());
			System.out.println(" ");
		}

	}
	public void showoneContact(String search) {
		int searchSuccess=0;
		for(int i=0;i<Farr.size();i++) {
			if( search.equals(Farr.get(i).getName())) {
				System.out.println("-----------------------------");
				System.out.println("�̸�    �̸���             �׷�");
				System.out.println("-----------------------------");
				System.out.printf("%s %s %s",Farr.get(i).getName(),Farr.get(i).getEmail(),Farr.get(i).getGroup(),Farr.get(i).getAddr());
				System.out.println(" ");

				searchSuccess=1;//���������� ������ 1�μ����ؼ� �������� �ȵ�����
				System.out.println("-----------------------------");
				break;
			}
		}
		if(searchSuccess==0) {//���������������� ��ȸ �̸��� ����̾ȵǾ��ִ°ſ��� ����Ʈ�ϰԵ�
			System.out.println("�׷� �̸��� ���� fullContact ��ü�� �����ϴ�");
		}

	}
	
}
