package java_solutions;

import tools.Fibonacci;

public class p025 {

	final static int digits = 1000;
	
	public static void main(String[] args) {
		
		System.out.println("The index of the first term in the Fibonacci sequence " +
				"to contain 1000 digits is " + Fibonacci.indexOfFirstXDigits(digits));

	}

}
