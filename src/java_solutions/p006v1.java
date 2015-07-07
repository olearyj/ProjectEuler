package java_solutions;
import java.math.BigInteger;

import tools.MyStopwatch;


public class p006v1 {

	public static void main(String[] args) {

		MyStopwatch sw = new MyStopwatch().start();
		BigInteger big = new BigInteger("100");
		
		//System.out.println(funcTwo(big) + " - " + square(funcOne(big)) + " ");
		
		System.out.println("The difference between the sum of the squares of the " +
				"first one hundred natural numbers and the square of the sum is " + 
				funcThree(big));
		
		sw.stop().print();
		
	}

	// Returns the sum of the first x natural numbers is (1 + 2 + ... + x)
	public static BigInteger funcOne(BigInteger x){
		return ( isOne(x) ? BigInteger.ONE : x.add(funcOne( subOne(x) )) );
	}
	
	// Returns sum of the squares of the first x natural numbers is 1^2 + 2^2 + ... + x^2
	public static BigInteger funcTwo(BigInteger x){
		return ( isOne(x) ? BigInteger.ONE : square(x).add( funcTwo(subOne(x)) ) );
	}
	
	// Returns the difference between the sum of the squares of the first ten natural numbers 
	// and the square of the sum. ex/ (1^2 + 2^2 + ... + x^2) - (1 + 2 + ... + x)^2
	public static BigInteger funcThree(BigInteger x){
		BigInteger f1 = funcOne(x);
		f1 = square(f1);
		return f1.subtract(funcTwo(x));
	}
	
	public static boolean isOne(BigInteger big){
		return big.equals(BigInteger.ONE);
	}
	
	public static BigInteger subOne(BigInteger big){
		return big.subtract(BigInteger.ONE);
	}
	
	public static BigInteger square(BigInteger big){
		return big.multiply(big);
	}
	
}