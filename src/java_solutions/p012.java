package java_solutions;

import tools.MyStopwatch;


public class p012 {

	public static void main(String[] args) {

		final int x = 500;	// num of divisors
		
		MyStopwatch sw = new MyStopwatch().start();

		int ans = 0;
		int last = 2, triNum = 1;
		
		while(ans == 0){
			triNum += last++;
			if(hasXDivisors(triNum, x))
				ans = triNum;
		}
		
		System.out.println("The value of the first triangle number to have " +
				"over five hundred divisors is " + ans);
		
		sw.stop().print();
		
	}

	public static boolean hasXDivisors(int num, int x){
		final int half = num / 2;
		int count = 0;
		
		for(int i=2; i<=half; i++)
			if(num % i == 0)
				count++;
		
		if(count > x)
			return true;
		if(count > 100)
			System.out.printf("%15d has %3d divisors\n", num, count);
		return false;
	}
	
}
