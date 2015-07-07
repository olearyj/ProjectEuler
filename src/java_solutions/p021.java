package java_solutions;

import tools.MyStopwatch;


public class p021 {

	public static void main(String[] args) {

		int max = 10000;
		
		MyStopwatch sw = new MyStopwatch().start();

		int amSum = 0;
		
		int am = -1;
		for(int i=1; i<max; i++){
			am = getAmicable(i);	// Returns -1 if isn't amicable
			if(i == 220 || i == 284)
			System.out.printf("%6d %6d\n", am, i);
			if(am != -1)
				amSum += am + i;
		}
		
		System.out.println("Evaluate the sum of all the amicable numbers " +
				"under 10000. " + amSum);
		
		sw.stop().print();
		
	}
	
	public static int d(int num){
		int n = -num, half = num/2;
		for(int i=1; i<=half; i++){
			if(num%i == 0)
				n += i + num/i;
		}
		return (n+1)/2;		// why do i need this for it to work rather than just n??
	}
	
	// If num is amicable, get it's paired number, else return -1
	public static int getAmicable(int num){
		int n = d(num), dn = d(n);

		if(num == 220 || num == 284)
		System.out.printf("%6d %6d %6d\n", num, n, dn);
		
		if(n != dn && dn == num)
			return n;
		
		return -1;
	}

}