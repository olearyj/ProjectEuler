package java_solutions;

import tools.Prime;

public class p027 {
	
	// Given max and min numbers for a and b variables
	final static int max = 1000;
	final static int min = -1000;

	public static void main(String[] args) {
		
		int aMax = -9999, bMax = -9999, primesMax = 0;
		
		for(int a=max-1; a>min; a--){
			for(int b=max-1; b>min; b--){
				int consPrimes = consecutivePrimesCount(a, b);
				if(consPrimes > primesMax){
					aMax = a;
					bMax = b;
					primesMax = consPrimes;
					System.out.println("primes = " + primesMax);
					System.out.println("a = " + aMax + " b = " + bMax + 
							" primes = " + primesMax);
				}
			}
		}
		
		System.out.println("the product of the coefficients, a and b, for the quadratic " +
				"expression that produces the maximum number of primes for consecutive values " +
				"of n, starting with n = 0 is " + (aMax * bMax));
		System.out.println("a = " + aMax + " b = " + bMax + " primes = " + primesMax);
	
	}
	
	public static int consecutivePrimesCount(int a, int b){
		for(int i=0; i<Integer.MAX_VALUE; i++)
			if( !Prime.isPrime(funct(i, a, b)) )
				return i;
		return -1;
	}
	
	/**
	 * Computes the formula with the given parameters
	 * 
	 * @return n*n + a*n + b
	 */
	public static int funct(int n, int a, int b){
		return n * n + a * n + b;
	}

}
