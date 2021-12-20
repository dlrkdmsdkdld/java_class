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
	m1.addStudent(1,"ȫ�л�",n1.tarr[0],"����Ʈ����");
	m1.addStudent(2,"���л�",n1.tarr[1],"���Ӱ���");
	m1.addStudent(3,"���л�",n1.tarr[0],"��ǻ�Ͱ���");
	m1.addMentor(4,"ȫ����",n1.tarr[0],"Happy co.");
	m1.addMentor(5,"�ڸ���",n1.tarr[2],"(��)�ູ");

	
	
	while(go){
		menu.showMenu();
		menuChoice=scan.nextInt();
		switch(menuChoice) {
		case 1:
			scan.nextLine();//���� ����
			nameBuffer=m1.addStudentName();
			majorBuffer=m1.addStudentMajor();
			n1.showAllTeam();
			System.out.println("- Team ID: ");
			teamIDBuffer=scan.nextInt();
			m1.addStudent(m1.index+1, nameBuffer, n1.tarr[teamIDBuffer-1], majorBuffer);
			System.out.printf("=> %s: �л��� �߰��߽��ϴ�",m1.dataList[m1.index-1].getName());
			System.out.println();
			break;
		case 2:
			m1.ShowAllStudent();
			
			break;
		case 3:
			scan.nextLine();//���� ����
			nameBuffer=m1.addStudentName();
			majorBuffer=m1.addStudentCompany();
			n1.showAllTeam();
			System.out.println("- Team ID: ");
			teamIDBuffer=scan.nextInt();
			m1.addMentor(m1.index+1, nameBuffer, n1.tarr[teamIDBuffer-1], majorBuffer);
			System.out.printf("=> %s: ���並 �߰��߽��ϴ�",m1.dataList[m1.index-1].getName());
			System.out.println();
		
			
			break;
		case 4:
			m1.ShowAllMentor();
			break;
		case 5:
			scan.nextLine();

			System.out.println("- �̸�: ");
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
