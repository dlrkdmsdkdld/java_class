import java.util.Scanner;

import StudentPackage.MemberList;
import TeamPackage.Team;
import TeamPackage.TeamList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
	TeamList n1 = new TeamList();
	int menuChoice,buffer; boolean go=true;
	MemberList m1 = new MemberList();
	Menu menu=new Menu();
	String nameBuffer,majorBuffer; int teamIDBuffer;
	
	
	//default data
	m1.addStudent(1,"홍학생",n1.tarr[0],"소프트웨어");
	m1.addStudent(2,"김학생",n1.tarr[1],"게임공학");
	m1.addStudent(3,"박학생",n1.tarr[0],"컴퓨터공학");
	m1.addMentor(4,"홍멘토",n1.tarr[0],"Happy co.");
	m1.addMentor(5,"박멘토",n1.tarr[2],"(주)행복");

	
	
	while(go){
		menu.showMenu();
		menuChoice=scan.nextInt();
		switch(menuChoice) {
		case 1:
			scan.nextLine();//버퍼 비우기
			nameBuffer=m1.addStudentName();
			majorBuffer=m1.addStudentMajor();
			n1.showAllTeam();
			System.out.println("- Team ID: ");
			teamIDBuffer=scan.nextInt();
			m1.addStudent(m1.index+1, nameBuffer, n1.tarr[teamIDBuffer-1], majorBuffer);
			System.out.printf("=> %s: 학생을 추가했습니다",m1.dataList[m1.index-1].getName());
			System.out.println();
			break;
		case 2:
			m1.ShowAllStudent();
			
			break;
		case 3:
			scan.nextLine();//버퍼 비우기
			nameBuffer=m1.addStudentName();
			majorBuffer=m1.addStudentCompany();
			n1.showAllTeam();
			System.out.println("- Team ID: ");
			teamIDBuffer=scan.nextInt();
			m1.addMentor(m1.index+1, nameBuffer, n1.tarr[teamIDBuffer-1], majorBuffer);
			System.out.printf("=> %s: 멘토를 추가했습니다",m1.dataList[m1.index-1].getName());
			System.out.println();
		
			
			break;
		case 4:
			m1.ShowAllMentor();
			break;
		case 5:
			scan.nextLine();

			System.out.println("- 이름: ");
			m1.SearchMember(scan.nextLine());
			
			break;
		case 6:
			m1.ShowAllMember();
			break;
		case 7:
			nameBuffer=n1.addTeamName();
			n1.addTeam(nameBuffer);
			break;
		case 8:
			n1.showAllTeam();
			break;
		case 9:
			n1.showAllTeam();
			System.out.println("- Team ID: ");
			buffer=scan.nextInt();
			nameBuffer=n1.searchTeamName(buffer);
			m1.SearchTeamName(nameBuffer);
			break;
		case 0:
			go=false;
			break;
		
		
		
		}
	}

	}

}
