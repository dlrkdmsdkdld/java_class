import java.util.Scanner;


public class BoxPlus {



		public static void main(String[] args) {
			double rate=33.8;
			double C;
			double F;
			while(true) {
			Scanner input =new Scanner(System.in);
			System.out.print("�����µ��� �Է��Ͻÿ�");
		    C=input.nextDouble();
			
			
			F=rate*C;
			System.out.printf("ȭ���µ� F=%f\n",F);

		}

	}


}

