package java;

import tools.MyStopwatch;



public class p007 {

	public static void main(String[] args) {

		int n = 10001;
		
		MyStopwatch sw = new MyStopwatch().start();

		System.out.println("The " + n + "th prime number is " + nthPrime(n));
		
		sw.stop().print();
	
	}

	public static int nthPrime(int n){
		int count = 0;
		
		for(int i=2; i != Integer.MAX_VALUE; i++){
			if(isPrime(i)){
				count++;
				//System.out.println("prime[" + count + "]: " + i);
				if(count == n)
					return i;
			}
		}
		return 0;
	}
	
	public static boolean isPrime(int n){
		for(int i = 2; i <= n / 2; i++){
			if(n % i == 0)
				return false;
		}
		return true;
	}
	
}
