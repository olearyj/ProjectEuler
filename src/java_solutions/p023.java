package java_solutions;

import java.util.List;

import tools.MyMath;

public class p023 {

	// All integers greater than 28123 can be written as the sum of two abundant numbers
	public static final int MAX = 28123;

	private static boolean[] abundant = new boolean[MAX+1];
	
	public static void main(String[] args){
		
		int sum = 0;
		
		fillAbundantArray();
		
		for(int i=0; i<MAX+1; i++)
			if(!sumOfTwoAbundantNums(i))
				sum += i;
		
		System.out.println("The sum of all the positive integers which cannot " +
				"be written as the sum of two abundant numbers is " + sum);
		
	}

	public static boolean sumOfTwoAbundantNums(int num){
		
		for(int i=1; i<num; i++){
			num--;
			//System.out.println("Checking if " + i + " and " + num + " are abundant");
			if(abundant[i] && abundant[num])
				return true;
		}
	
		return false;
	}
	
	public static boolean abundant(int num){
		List<Integer> properDivisors = MyMath.properDivisors(num);
		int sum = 0;
		
		for(Integer i : properDivisors)
			sum += i;
		
		return (sum > num ? true : false);
	}
	
	private static void fillAbundantArray() {
		
		for(int i = 1; i<abundant.length; i++)
			abundant[i] = abundant(i);
		
	}
	
}
