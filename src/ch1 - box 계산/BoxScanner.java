import java.util.Scanner;

public class BoxScanner {

	public static void main(String[] args) {
		double w,h,area,perimeter;
		Scanner input = new Scanner(System.in);
		
		
		w=input.nextDouble();
		h=input.nextDouble();
		area =w*h;
		perimeter = 2*(w+h);
		
				
		System.out.println("사각형의 넓이: " + area + "사각형의 둘레: " + perimeter);

	}

}
