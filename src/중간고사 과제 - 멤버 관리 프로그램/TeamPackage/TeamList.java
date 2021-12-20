package TeamPackage;
import java.util.Scanner;

public class TeamList {

	public Team[] tarr = new Team[10];
    int teamNum=4;
	Scanner scan=new Scanner(System.in);
	
	public TeamList() {
		tarr[0]= new Team(1,"아침이다");
		tarr[1]= new Team(2,"점심먹고");
		tarr[2]= new Team(3,"놀다가자");
		tarr[3]= new Team(4,"꿈꾼다");
	}
	public String addTeamName() {
		System.out.println("<Team 추가>");
		System.out.printf("- ID:%d ",teamNum+1);
		System.out.println("");
		System.out.println("-타이틀: ");
		return scan.nextLine();
	}
	
	public void addTeam(String TeamName) {
		tarr[teamNum]=new Team(teamNum+1,TeamName);
		System.out.printf(">>%s: Team을 추가하였습니다.",tarr[teamNum].getName());
		System.out.println("");
		teamNum++;
    }
	public void searchID(int i) {
		System.out.println("<찾은 TEAM>");
		System.out.println("-----------------");
		System.out.println("ID  Team 이름");
		System.out.println("-----------------");
        System.out.printf(" %d  %s", tarr[i-1].getId(),tarr[i-1].getName());
		System.out.println("");
		System.out.println("-----------------");
  }
	public String searchTeamName(int i) {
	 return tarr[i-1].getName(); 
	}
	public void showAllTeam() {
		System.out.println("-----------------");
		System.out.println("ID  Team 이름");
		System.out.println("-----------------");
        for(int i=0;i<teamNum;i++) {
            System.out.printf(" %d  %s", tarr[i].getId(),tarr[i].getName());
    		System.out.println("");
        }
		System.out.println("-----------------");
	}
}
