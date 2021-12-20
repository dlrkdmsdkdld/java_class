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
		int bufferGroupId;//새로운 contact 객체생성할때 사용자가 입력한 값 임시저장 변수
		String bufferName,bufferEmail,bufferAddress;//새로운 contact 객체생성할때 사용자가 입력한 값 임시저장 변수
		contactManager.carr.add(new BasicContact("홍길동","kdhong@kpu.co.kr",groupManager.garr.get(3)));//초기 기본 데이터생성
		while(end==0) {
			menu.showMenu();
			choice=scan.nextInt();
			scan.nextLine();//scan 버퍼 비우기
			
			switch(choice) {
			case 1:
				bufferName=contactManager.getNewContact();//각각의 입력받은값을 임시저장하려고 새롭게 contact객체 생성 함수를 쪼갬
				bufferEmail=contactManager.getNewContact2();
				groupManager.groupAllshow();
				System.out.println("-그룹>");bufferGroupId=scan.nextInt();//사용자에게 입력받은 그룹아이디 임시저장
				contactManager.getNewContact3(bufferName,bufferEmail,groupManager.garr.get(bufferGroupId-1));
				//실제 garr인덱스는 그룹id 필드의 값보다 낮기때문에 get(bufferGroupId-1)로함 
				//ex. 그룹id 1인 그룹객체는 garr[0]에 있음
      		break;
			case 2:
				bufferName=fullContactManager.getNewContact();//각각의 입력받은값을 임시저장하려고 새롭게 contact객체 생성 함수를 쪼갬
				bufferEmail=fullContactManager.getNewContact2();
				bufferAddress = fullContactManager.getNewContact4();
				groupManager.groupAllshow();
				System.out.println("-그룹>");bufferGroupId=scan.nextInt();//사용자에게 입력받은 그룹아이디 임시저장
				fullContactManager.getNewContact3(bufferName,bufferEmail,groupManager.garr.get(bufferGroupId-1),bufferAddress);
				break;
			case 3://연락처 조회
				System.out.printf("검색 이름>> ");
				search=scan.nextLine();
				contactManager.showoneContact(search);
				fullContactManager.showoneContact(search);
				break;
			case 4:
				System.out.println("------------------------------------------");
				System.out.println("이름    이메일             그룹        주소");
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


