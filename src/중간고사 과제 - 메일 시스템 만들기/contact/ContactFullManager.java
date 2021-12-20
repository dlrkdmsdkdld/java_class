package cms.contact;

import java.util.ArrayList;
import java.util.Scanner;

import cms.group.group;

public class ContactFullManager {
	Scanner scan = new Scanner(System.in);
	public ArrayList<FullContact> Farr= new ArrayList<FullContact>();
	
	public ContactFullManager() {
		//carr.add(new Contact("홍길동","kdhong@kpu.co.kr","고딩친구"));//초기 데이터
	}
	public String getNewContact() {//이부분에선 이름만 입력받음
		System.out.println("<<연락처 정보입력>>");
		
		System.out.println("-이름:"); String name2=scan.nextLine();
		return name2;      
	}
	public String getNewContact2() {//이부분에선 이메일만 입력받음
		System.out.println("-이메일:"); String email2=scan.nextLine();
		return email2;

	}
	public String getNewContact4(){
		System.out.println("-주소:"); String addr=scan.nextLine();
		return addr;
	}
	public void getNewContact3(String bufferName,String bufferEmail,group group,String addr) {//사용자가 입력한 값을 모두 집어넣어 새로운 객체생성함수
		Farr.add(new FullContact(bufferName,bufferEmail,group,addr));//사용자가 입력한 데이터로 새로운 contact 객체생성
		System.out.printf(">>%s %s추가 성공...",Farr.get(Farr.size()-1).getName(),Farr.get(Farr.size()-1).getGroup());//방금추가한 마지막인덱스의 내용반환
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
				System.out.println("이름    이메일             그룹");
				System.out.println("-----------------------------");
				System.out.printf("%s %s %s",Farr.get(i).getName(),Farr.get(i).getEmail(),Farr.get(i).getGroup(),Farr.get(i).getAddr());
				System.out.println(" ");

				searchSuccess=1;//성공했으면 변수가 1로설정해서 이프문이 안돌게함
				System.out.println("-----------------------------");
				break;
			}
		}
		if(searchSuccess==0) {//성공하지못했을때 조회 이름이 등록이안되어있는거여서 프린트하게됨
			System.out.println("그런 이름을 가진 fullContact 객체는 없습니다");
		}

	}
	
}
