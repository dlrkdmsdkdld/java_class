import java.util.Scanner;
public class cashier {
	public static void main(String[] args) {
		System.out.printf(">> ���� ����??:");
		Scanner sc = new Scanner(System.in);
		int pay = sc.nextInt();
		System.out.printf(">> �� �ݾ���??:");
		int receipt = sc.nextInt();
		int change = receipt - pay;
		int remainder = 0;
		
		System.out.println("�Ž��� �Ѿ� = "+change+"��");
		
		
		if(change>=50000) {
			remainder = change / 50000;
		}
		System.out.println("- 50000���� * "+remainder+"�� = "+remainder*50000+"��");	
		change = change - remainder*50000;
		remainder =0 ; //���� �Ž����� ����� ���� �ʱ�ȭ
		
		if(change>=10000) {
			remainder = change / 10000;
		}
		System.out.println("- 10000���� * "+remainder+"�� = "+remainder*10000+"��");	
		change = change - remainder*10000;
		remainder =0 ; //���� �Ž����� ����� ���� �ʱ�ȭ
		
		if(change>=5000) {
			remainder = change / 5000;
		}
		System.out.println("- 5000���� * "+remainder+"�� = "+remainder*5000+"��");	
		change = change - remainder*5000;
		remainder =0 ; //���� �Ž����� ����� ���� �ʱ�ȭ
			
		if(change>=1000) {
			remainder = change / 1000;
		}
		System.out.println("- 1000���� * "+remainder+"�� = "+remainder*1000+"��");	
		change = change - remainder*1000;
		remainder =0 ; //���� �Ž����� ����� ���� �ʱ�ȭ

		if(change>=500) {
			remainder = change / 500;
		}
		System.out.println("- 500�� ���� * "+remainder+"�� = "+remainder*500+"��");	
		change = change - remainder*500;
		remainder =0 ; //���� �Ž����� ����� ���� �ʱ�ȭ

		if(change>=100) {
			remainder = change / 100;
		}
		System.out.println("- 100�� ���� * "+remainder+"�� = "+remainder*100+"��");	
		change = change - remainder*100;
		remainder =0 ; //���� �Ž����� ����� ���� �ʱ�ȭ
	
		if(change>=10) {
			remainder = change / 10;
		}
		System.out.println("- 10�� ���� * "+remainder+"�� = "+remainder*10+"��");	
		change = change - remainder*10;
		remainder =0 ; //���� �Ž����� ����� ���� �ʱ�ȭ
	
		if(change>=1) {
			remainder = change / 1;
		}
		System.out.println("- 1�� ���� * "+remainder+"�� = "+remainder*1+"��");	
		change = change - remainder*1;
		remainder =0 ; //���� �Ž����� ����� ���� �ʱ�ȭ
		
		
	}
}
