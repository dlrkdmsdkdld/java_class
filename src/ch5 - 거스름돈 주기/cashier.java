import java.util.Scanner;
public class cashier {
	public static void main(String[] args) {
		System.out.printf(">> 물건 값은??:");
		Scanner sc = new Scanner(System.in);
		int pay = sc.nextInt();
		System.out.printf(">> 낸 금액은??:");
		int receipt = sc.nextInt();
		int change = receipt - pay;
		int remainder = 0;
		
		System.out.println("거스름 총액 = "+change+"원");
		
		
		if(change>=50000) {
			remainder = change / 50000;
		}
		System.out.println("- 50000원권 * "+remainder+"장 = "+remainder*50000+"원");	
		change = change - remainder*50000;
		remainder =0 ; //다음 거스름돈 계산을 위해 초기화
		
		if(change>=10000) {
			remainder = change / 10000;
		}
		System.out.println("- 10000원권 * "+remainder+"장 = "+remainder*10000+"원");	
		change = change - remainder*10000;
		remainder =0 ; //다음 거스름돈 계산을 위해 초기화
		
		if(change>=5000) {
			remainder = change / 5000;
		}
		System.out.println("- 5000원권 * "+remainder+"장 = "+remainder*5000+"원");	
		change = change - remainder*5000;
		remainder =0 ; //다음 거스름돈 계산을 위해 초기화
			
		if(change>=1000) {
			remainder = change / 1000;
		}
		System.out.println("- 1000원권 * "+remainder+"장 = "+remainder*1000+"원");	
		change = change - remainder*1000;
		remainder =0 ; //다음 거스름돈 계산을 위해 초기화

		if(change>=500) {
			remainder = change / 500;
		}
		System.out.println("- 500원 동전 * "+remainder+"개 = "+remainder*500+"원");	
		change = change - remainder*500;
		remainder =0 ; //다음 거스름돈 계산을 위해 초기화

		if(change>=100) {
			remainder = change / 100;
		}
		System.out.println("- 100원 동전 * "+remainder+"개 = "+remainder*100+"원");	
		change = change - remainder*100;
		remainder =0 ; //다음 거스름돈 계산을 위해 초기화
	
		if(change>=10) {
			remainder = change / 10;
		}
		System.out.println("- 10원 동전 * "+remainder+"개 = "+remainder*10+"원");	
		change = change - remainder*10;
		remainder =0 ; //다음 거스름돈 계산을 위해 초기화
	
		if(change>=1) {
			remainder = change / 1;
		}
		System.out.println("- 1원 동전 * "+remainder+"개 = "+remainder*1+"원");	
		change = change - remainder*1;
		remainder =0 ; //다음 거스름돈 계산을 위해 초기화
		
		
	}
}
