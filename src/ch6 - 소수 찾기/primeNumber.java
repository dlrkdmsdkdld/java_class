public class primeNumber{
	static boolean isPrimeNumber(int t) {
		for(int i =2 ; i < t;i++ ) {
			if(t%i==0 ) return true;
		}
		if (t==1) return true;
		
		return false;
	}
	public static void main(String[] args){
		int[][] num = new int[10][10];
		int a=1; boolean prime;
		
		
		for(int i=0; i<10; i++) {
		  	for(int z=0;z<10;z++) {
		  		num[i][z]=(i+1)*(z+1);
		  	
		  	}
		}
		
		for(int i=0; i<10; i++) {
		  	for(int z=0;z<10;z++) {
		  		prime=isPrimeNumber(num[i][z]);
		  		if(prime==false)		  		System.out.printf("(%3d)",+num[i][z]);
		  		else System.out.printf("%5d",num[i][z]);
		  	}
	  		System.out.println(' ');

		}
}
}