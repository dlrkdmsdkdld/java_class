package cms.contact;
import cms.group.*;
import java.util.Scanner;

public class fullmanager {
	Scanner scan;
	public data[] carrr;
	public static int index = 0;
	groupmanager gu = new groupmanager();

	public fullmanager() {
		carrr = new fulldata[10];
		scan = new Scanner(System.in);
	}

	public void setdata() {
		String name, email,address;

		System.out.println("<<����ó ���� �Է�>>");
		System.out.println("  -name: ");
		name = scan.nextLine();
		System.out.println("  -email: ");
		email = scan.nextLine();
		System.out.println("  -address: ");
		address=scan.nextLine();
		carrr[index] = new fulldata(name, email,address);
		gu.basicgroup();
		gu.getalldata();
		carrr[index].group = gu.tempoo;
		carrr[index].groupid = gu.tempo;
		System.out.println(">>" + carrr[index].email + "  " + carrr[index].name + "  " + carrr[index].group + " �߰� ����..");
		++index;
	}

	public void showdata() {
		int i;
		System.out.println("--�� ����ó ���--");
		System.out.println("�̸�      �̸���      �׷�       �ּ�");
		System.out.println("-------------------------------");
		for (i = 0; i < index; i++) {
			System.out.printf("%4s %10s %5s %8s\n", carrr[i].name, carrr[i].email, carrr[i].group,((fulldata) carrr[i]).backaddress());
		}
		System.out.println("-------------------------------");
	}

}


