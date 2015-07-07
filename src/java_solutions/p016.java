package java_solutions;
import java.math.BigInteger;

import tools.MyStopwatch;


public class p016 {
	
	public static void main(String[] args){

		MyStopwatch sw = new MyStopwatch().start();

		BigInteger big = new BigInteger("2"), two = new BigInteger("2");

		for(int i=1; i<1000; i++)
			big = big.multiply(two);
			
		String str = big.toString();
		
		System.out.println(str);
		
		int num = 0;
		for(int i=0; i<str.length(); i++)
			num += Character.getNumericValue(str.charAt(i));
		
		System.out.println("What is the sum of the digits of the number 21000? " + num);
		
		sw.stop().print();
		
	}

}
