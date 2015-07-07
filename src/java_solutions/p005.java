package java_solutions;

import tools.MyStopwatch;


public class p005 {
	
	// GIVEN: 2520 is the smallest number that can be divided by 
	// each of the numbers from 1 to 10 without any remainder.
	public static int start = 2520;
	
	public static void main(String[] args) {

		MyStopwatch sw = new MyStopwatch().start();
		int num = 0;
		
		for(int i=start; i != Integer.MAX_VALUE; i++){
		
			if(EDby1to20(i)){
				num = i;
				i = Integer.MAX_VALUE - 1;	// Get out of the loop
			}
			
		}
		
		
		System.out.println("The smallest positive number that is evenly divisible " +
				"by all of the numbers from 1 to 20 is " + num);
		sw.stop().print();
		
	}

	// Sees if the num is evenly divisible by numbers 1-20
	public static boolean EDby1to20(int num){
		
		for(int i=1; i<=20; i++)
			if(num % i != 0)
				return false;
		
		return true;
		
	}
	
}
