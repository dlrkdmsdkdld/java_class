import java.util.Arrays;
import java.util.Scanner;

class timetable{
	int row;
	int col;
	int[][] table;
	public timetable(int r,int c) {
		row=r; col=c;
		table= new int[row][col];
		for(int i=0;i<row;i++) {
			for(int k=0;k<col;k++) {
				table[i][k]=(i+1)*(k+1);
			}	
		}
	}
	public void show() {
		for(int i=0;i<row;i++) {
			for(int k=0;k<col;k++) {
				System.out.printf("%d * %d = %d",i+1,k+1,table[i][k]);
				System.out.println("");

			}
		}
	}
}
public class second {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int r,c;
		System.out.print("row 입력 :");
		r=scan.nextInt();
		System.out.print("column 입력 :");
     	c=scan.nextInt();

		timetable n = new timetable(r,c);
		n.show();
	}

}
