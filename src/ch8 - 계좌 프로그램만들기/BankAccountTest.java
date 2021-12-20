import java.util.Scanner;
class BankAccount {
	static int accountNumner = 1001;
	int accountNumber;
	String owner;
	int balance;
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber() {
		this.accountNumber = accountNumner;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	
	public void deposit(int money) {
		balance=balance + money;
	}
	public void withdraw(int money) {
		balance=balance - money;
	}
	public void transfer(int money,BankAccount other) {
		other.balance = other.balance + money;
		this.balance  = this.balance - money;

	}

}
public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount n1 = new BankAccount();
		n1.setAccountNumber(); BankAccount.accountNumner++;//전역변수 1증가
		n1.setOwner("my owner");//내 계좌
		n1.setBalance(0);

		BankAccount n2 = new BankAccount();
		n2.setAccountNumber(); BankAccount.accountNumner++;
		n2.setOwner("홍길동");//홍길동
		n2.setBalance(0);
		int button=0;
		Scanner scan = new Scanner(System.in);
		int end=0;
		while(end==0) {
			System.out.println("Main Menu");
			System.out.println("----------------");
			System.out.println("1.입금");
			System.out.println("2.출금");
			System.out.println("3.송금");
			System.out.println("4.잔고 조회");
			
			System.out.println("");
			System.out.println("0.종료");
			System.out.println("----------------");
			System.out.println(">>선택?");
			
			
			button=scan.nextInt();

			switch(button) {
			case 1:
				int money=0;
				System.out.println("얼마를 입금하시겠습니까");
				money=scan.nextInt();
				n1.deposit(money);
				System.out.println(">>"+money+"원 입금, 잔고 "+n1.getBalance()+"원");
			    break;
			case 2:
				money=0;
				System.out.println("얼마를 출금하시겠습니까");
				money=scan.nextInt();
                if(n1.getBalance()-money<0) {
                	System.out.println("출금오류:마이너스 잔고 유발");
                	break;
				}	
				n1.withdraw(money);
				
				
				System.out.println(">>"+money+"원 출금, 잔고 "+n1.getBalance()+"원");
				break;
			case 3:
				money=0;
				System.out.println("얼마를 송금하시겠습니까");
				money=scan.nextInt();
                if(n1.getBalance()-money<0) {
                	System.out.println("출금오류:마이너스 잔고 유발");
                	break;
				}	
                n1.transfer(money, n2);
                
				
				
				System.out.println(">>"+money+"원 송금, 잔고 "+n1.getBalance()+"원");
   			    break;
			case 4:
				System.out.println(">> 계좌 잔고 "+n1.getBalance()+"원");
                   break;
			case 0:
				end=1;
				break;

			}
		}
		
		
		
		
		
		//n1.deposit(10000);
		
		//n1.withdraw(8000);
		
		//n1.transfer(1000, n2);
		

	}

}
