package java;
import java.math.BigInteger;

import tools.MyStopwatch;



public class p020 {

	public static void main(String[] args) {

		MyStopwatch sw = new MyStopwatch().start();

		BigInteger factorial = new BigInteger("100"), big = new BigInteger("99");
		for(int i=99; i>0; i--){
			System.out.print("x" + big);
			factorial = factorial.multiply(big);
			big = big.subtract(BigInteger.ONE);
		}
		System.out.println();
		
		String str = factorial.toString();
		
		int total = 0;
		for(int i = 0; i < str.length(); i++)
			total += Character.getNumericValue(str.charAt(i));
		
		System.out.println("Find the sum of the digits in the number 100! " + total);
		
		sw.stop().print();
		
	}

}
