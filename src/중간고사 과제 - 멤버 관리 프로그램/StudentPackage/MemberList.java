package StudentPackage;

import java.util.Scanner;

import TeamPackage.Team;

public class MemberList {
	Scanner scan = new Scanner(System.in);
	public Member[] dataList = new Member[50];
	public static int index=0;
	
	public MemberList(){
	}
	public void addStudent(int id,String name,Team team,String major) {//datalist에 학생객체생성함수
		dataList[index]=new Student(id,name,team,major);
		index ++;
	}
	public void addMentor(int id,String name,Team team,String company) {//datalist에 멘토객체생성함수
		dataList[index]=new Mentor(id,name,team,company);
		index ++;
	}
	public String addStudentName() {//이름 받는함수
		System.out.println("<학생 멤버 추가>");
		System.out.printf("- ID: %d",index+1);
		System.out.println("");
		System.out.println("- 이름: ");
        return scan.nextLine();
	}
	public String addStudentMajor() {//전공받는함수
		System.out.println("- 전공: ");
        return scan.nextLine();
	}	
	
	public String addStudentCompany() {
		System.out.println("- 회사: ");
        return scan.nextLine();
	}
	public void SearchTeamName(String teamName) {//같은 팀에 속하는 멤버찾기함수
		System.out.printf("<%s: 멤버 목록>",teamName);
		System.out.println("");
		System.out.println("------------------------");
		System.out.println("구분 ID  이름   Team  전공/회사");
		System.out.println("------------------------");

		for(int i=0;i<index;i++) {
			if(teamName.equals(dataList[i].getTeam())){
				if(dataList[i] instanceof Student) {
					System.out.printf("학생 %d  %s  %s  %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getMajor());
				    System.out.println("");}
			else if(dataList[i] instanceof Mentor) {
					System.out.printf("멘토 %d  %s  %s  %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getCompany());
					System.out.println("");
			}
			}
		}
		System.out.println("------------------------");
	
	}
	
	
	public void ShowAllStudent() {//학생목록출력함수
		System.out.println("<학생 멤버 목록>");
		System.out.println("------------------------");
		System.out.println("ID  이름   Team  전공");
		System.out.println("------------------------");
		for(int i=0;i<index;i++) {
			if(dataList[i] instanceof Student) {
		      System.out.printf("%d  %s  %s %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getMajor());
		      System.out.println("");
			}
   	}
		System.out.println("------------------------");
		
	}
	public void ShowAllMentor() {//멘토멤버 출력함수
		System.out.println("<멘토 멤버 목록>");
		System.out.println("------------------------");
		System.out.println("ID  이름   Team  회사");
		System.out.println("------------------------");
		for(int i=0;i<index;i++) {
			if(dataList[i] instanceof Mentor) {
		      System.out.printf("%d  %s  %s %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getCompany());
		      System.out.println("");
			}
			
   	}
		System.out.println("------------------------");
		
	}
	public void ShowAllMember() {//멘토멤버 출력함수
		System.out.println("<멘토 멤버 목록>");
		System.out.println("------------------------");
		System.out.println("ID  이름   Team  전공/회사");
		System.out.println("------------------------");
		for(int i=0;i<index;i++) {
		    if  (dataList[i] instanceof Student) {
			      System.out.printf("학생 %d  %s  %s %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getMajor());
			      System.out.println("");
				}
			else if(dataList[i] instanceof Mentor) {
		      System.out.printf("멘토 %d  %s  %s %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getCompany());
		      System.out.println("");
			}
			
   	}
		System.out.println("------------------------");
		
	}
	public void SearchMember(String name) {
		int end=0;
		for(int i=0; i<index;i++) {
			if(name.equals(dataList[i].getName())) {
				end=1;//찾았으므로 찾지못했다는 이프문을 돌리지 않기 위해 설정
				System.out.println("<찾은 멤버>");
				System.out.println("------------------------");
				System.out.println("구분 ID  이름   Team  전공/회사");
				System.out.println("------------------------");
				if(dataList[i] instanceof Student) {
					System.out.printf("학생  %d %s  %s %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getMajor());
				      System.out.println("");
				      break;
				}
				else if(dataList[i] instanceof Mentor) {
					System.out.printf("멘토  %d %s %s %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getCompany());
				      System.out.println("");
				      break;
				}	
				
			}
		}
		if(end==0) System.out.println("찾지못했습니다");
		
		
	}
	
}
