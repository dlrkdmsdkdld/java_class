import java.util.Scanner;

public class BoxScanner {

	public static void main(String[] args) {
		double w,h,area,perimeter;
		Scanner input = new Scanner(System.in);
		
		
		w=input.nextDouble();
		h=input.nextDouble();
		area =w*h;
		perimeter = 2*(w+h);
		
				
		System.out.println("�簢���� ����: " + area + "�簢���� �ѷ�: " + perimeter);

	}

}
