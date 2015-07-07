package java_solutions;

import tools.MyStopwatch;

public class p006 {

	public static void main(String[] args) {

		MyStopwatch sw = new MyStopwatch().start();
		
		System.out.println("The difference between the sum of the squares of the " +
				"first one hundred natural numbers and the square of the sum is " + 
				String.valueOf(funcThree(100)));
		sw.stop().print();
		
	}

	// Returns the sum of the first x natural numbers is (1 + 2 + ... + x)
	public static int funcOne(int x){
		return (x == 1 ? 1 : x + funcOne(x-1));
	}
	
	// Returns sum of the squares of the first x natural numbers is 1^2 + 2^2 + ... + x^2
	public static int funcTwo(int x){
		return (x == 1 ? 1 : x * x + funcTwo(x-1));
	}
	
	// Returns the difference between the sum of the squares of the first ten natural numbers 
	// and the square of the sum. ex/ (1^2 + 2^2 + ... + x^2) - (1 + 2 + ... + x)^2
	public static int funcThree(int x){
		int f1 = funcOne(x);
		f1 *= f1;	// f1 = funcOne(x)^2
		return f1 - funcTwo(x);
	}
	
}