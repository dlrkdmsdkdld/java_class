package cms.contact;
import cms.group.*;
import java.util.Scanner;

public class manager {
	Scanner scan;
	public data[] carr;
	public static int index = 0;
	groupmanager gu = new groupmanager();

	public manager() {
		carr = new data[10];
		scan = new Scanner(System.in);
	}

	public void setdata() {
		String name, email;

		System.out.println("<<연락처 정보 입력>>");
		System.out.println("  -name: ");
		name = scan.nextLine();
		System.out.println("  -email: ");
		email = scan.nextLine();
		carr[index] = new data(name, email);
		gu.basicgroup();
		gu.getalldata();
		carr[index].group = gu.tempoo;
		carr[index].groupid = gu.tempo;
		System.out.println(">>" + carr[index].email + "  " + carr[index].name + "  " + carr[index].group + " 추가 성공..");
		++index;
	}

	public void showdata() {
		int i;
		System.out.println("-------------------------------");
		System.out.println("이름      이메일      그룹");
		System.out.println("-------------------------------");
		for (i = 0; i < index; i++) {
			System.out.printf("%4s %10s %5s \n", carr[i].name, carr[i].email, carr[i].group);
		}
		System.out.println("-------------------------------");
	}

	public void finddata() {
		String ak;
		int i = 0;
		System.out.println("검색 이름>> ");
		ak = scan.nextLine();
		for (i = 0; i < index; i++) {
			if (ak.equals(carr[i].name)) {
				System.out.println("-------------------------------");
				System.out.println("이름       이메일          그룹");
				System.out.println("-------------------------------");
				System.out.printf("%-4s   %-10s      %-5s \n", carr[i].name, carr[i].email, carr[i].group);
				System.out.println("-------------------------------");
				break;
			}
			if (i == index - 1 && carr[i].name != ak) {
				System.out.println("찾을수없네요");
				break;
			}
		}

	}

}

