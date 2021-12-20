package ch21;

import java.util.Arrays;
import java.util.Scanner;
class MyNegativeException extends Exception{
  public MyNegativeException(String message) {
	super(message);}
}

public class CH21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=0;
		while(true) {
			try {
				System.out.println(">>정수 입력");
				n=scan.nextInt();
				if(n<0) {
					throw new MyNegativeException("MyNegativeException");
				}
				else {
					System.out.println("다행히 음수가 아니군요");

				}
			}catch(MyNegativeException ex) {
				System.out.println(ex+" 발생");

			}
			
			
			
		}

	}

}
