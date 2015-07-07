package java_solutions;

import tools.MyStopwatch;


public class p010 {

	public static void main(String[] args) {

		MyStopwatch sw = new MyStopwatch().start();
		
		long sum = 0;
		
		for(int i=2; i<2000000; i++)
			if(isPrime(i))
				sum += i;
			
		System.out.println("Find the sum of all the primes below two million. " + sum);
		
		sw.stop().print();

	}

	public static boolean isPrime(int n){
		for(int i = 2; i <= n / 2; i++){
			if(n % i == 0)
				return false;
		}
		//System.out.println(n);
		return true;
	}
	
}
