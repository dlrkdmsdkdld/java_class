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
		n1.setAccountNumber(); BankAccount.accountNumner++;//�������� 1����
		n1.setOwner("my owner");//�� ����
		n1.setBalance(0);

		BankAccount n2 = new BankAccount();
		n2.setAccountNumber(); BankAccount.accountNumner++;
		n2.setOwner("ȫ�浿");//ȫ�浿
		n2.setBalance(0);
		int button=0;
		Scanner scan = new Scanner(System.in);
		int end=0;
		while(end==0) {
			System.out.println("Main Menu");
			System.out.println("----------------");
			System.out.println("1.�Ա�");
			System.out.println("2.���");
			System.out.println("3.�۱�");
			System.out.println("4.�ܰ� ��ȸ");
			
			System.out.println("");
			System.out.println("0.����");
			System.out.println("----------------");
			System.out.println(">>����?");
			
			
			button=scan.nextInt();

			switch(button) {
			case 1:
				int money=0;
				System.out.println("�󸶸� �Ա��Ͻðڽ��ϱ�");
				money=scan.nextInt();
				n1.deposit(money);
				System.out.println(">>"+money+"�� �Ա�, �ܰ� "+n1.getBalance()+"��");
			    break;
			case 2:
				money=0;
				System.out.println("�󸶸� ����Ͻðڽ��ϱ�");
				money=scan.nextInt();
                if(n1.getBalance()-money<0) {
                	System.out.println("��ݿ���:���̳ʽ� �ܰ� ����");
                	break;
				}	
				n1.withdraw(money);
				
				
				System.out.println(">>"+money+"�� ���, �ܰ� "+n1.getBalance()+"��");
				break;
			case 3:
				money=0;
				System.out.println("�󸶸� �۱��Ͻðڽ��ϱ�");
				money=scan.nextInt();
                if(n1.getBalance()-money<0) {
                	System.out.println("��ݿ���:���̳ʽ� �ܰ� ����");
                	break;
				}	
                n1.transfer(money, n2);
                
				
				
				System.out.println(">>"+money+"�� �۱�, �ܰ� "+n1.getBalance()+"��");
   			    break;
			case 4:
				System.out.println(">> ���� �ܰ� "+n1.getBalance()+"��");
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
