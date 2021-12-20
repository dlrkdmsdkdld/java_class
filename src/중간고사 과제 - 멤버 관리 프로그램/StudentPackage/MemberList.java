package StudentPackage;

import java.util.Scanner;

import TeamPackage.Team;

public class MemberList {
	Scanner scan = new Scanner(System.in);
	public Member[] dataList = new Member[50];
	public static int index=0;
	
	public MemberList(){
	}
	public void addStudent(int id,String name,Team team,String major) {//datalist�� �л���ü�����Լ�
		dataList[index]=new Student(id,name,team,major);
		index ++;
	}
	public void addMentor(int id,String name,Team team,String company) {//datalist�� ���䰴ü�����Լ�
		dataList[index]=new Mentor(id,name,team,company);
		index ++;
	}
	public String addStudentName() {//�̸� �޴��Լ�
		System.out.println("<�л� ��� �߰�>");
		System.out.printf("- ID: %d",index+1);
		System.out.println("");
		System.out.println("- �̸�: ");
        return scan.nextLine();
	}
	public String addStudentMajor() {//�����޴��Լ�
		System.out.println("- ����: ");
        return scan.nextLine();
	}	
	
	public String addStudentCompany() {
		System.out.println("- ȸ��: ");
        return scan.nextLine();
	}
	public void SearchTeamName(String teamName) {//���� ���� ���ϴ� ���ã���Լ�
		System.out.printf("<%s: ��� ���>",teamName);
		System.out.println("");
		System.out.println("------------------------");
		System.out.println("���� ID  �̸�   Team  ����/ȸ��");
		System.out.println("------------------------");

		for(int i=0;i<index;i++) {
			if(teamName.equals(dataList[i].getTeam())){
				if(dataList[i] instanceof Student) {
					System.out.printf("�л� %d  %s  %s  %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getMajor());
				    System.out.println("");}
			else if(dataList[i] instanceof Mentor) {
					System.out.printf("���� %d  %s  %s  %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getCompany());
					System.out.println("");
			}
			}
		}
		System.out.println("------------------------");
	
	}
	
	
	public void ShowAllStudent() {//�л��������Լ�
		System.out.println("<�л� ��� ���>");
		System.out.println("------------------------");
		System.out.println("ID  �̸�   Team  ����");
		System.out.println("------------------------");
		for(int i=0;i<index;i++) {
			if(dataList[i] instanceof Student) {
		      System.out.printf("%d  %s  %s %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getMajor());
		      System.out.println("");
			}
   	}
		System.out.println("------------------------");
		
	}
	public void ShowAllMentor() {//������ ����Լ�
		System.out.println("<���� ��� ���>");
		System.out.println("------------------------");
		System.out.println("ID  �̸�   Team  ȸ��");
		System.out.println("------------------------");
		for(int i=0;i<index;i++) {
			if(dataList[i] instanceof Mentor) {
		      System.out.printf("%d  %s  %s %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getCompany());
		      System.out.println("");
			}
			
   	}
		System.out.println("------------------------");
		
	}
	public void ShowAllMember() {//������ ����Լ�
		System.out.println("<���� ��� ���>");
		System.out.println("------------------------");
		System.out.println("ID  �̸�   Team  ����/ȸ��");
		System.out.println("------------------------");
		for(int i=0;i<index;i++) {
		    if  (dataList[i] instanceof Student) {
			      System.out.printf("�л� %d  %s  %s %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getMajor());
			      System.out.println("");
				}
			else if(dataList[i] instanceof Mentor) {
		      System.out.printf("���� %d  %s  %s %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getCompany());
		      System.out.println("");
			}
			
   	}
		System.out.println("------------------------");
		
	}
	public void SearchMember(String name) {
		int end=0;
		for(int i=0; i<index;i++) {
			if(name.equals(dataList[i].getName())) {
				end=1;//ã�����Ƿ� ã�����ߴٴ� �������� ������ �ʱ� ���� ����
				System.out.println("<ã�� ���>");
				System.out.println("------------------------");
				System.out.println("���� ID  �̸�   Team  ����/ȸ��");
				System.out.println("------------------------");
				if(dataList[i] instanceof Student) {
					System.out.printf("�л�  %d %s  %s %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getMajor());
				      System.out.println("");
				      break;
				}
				else if(dataList[i] instanceof Mentor) {
					System.out.printf("����  %d %s %s %s",dataList[i].getId(),dataList[i].getName(),dataList[i].getTeam(),dataList[i].getCompany());
				      System.out.println("");
				      break;
				}	
				
			}
		}
		if(end==0) System.out.println("ã�����߽��ϴ�");
		
		
	}
	
}
