package java_solutions;
import java.util.*;

import tools.MyStopwatch;


public class p001{

	private static final int max = 1000;

	public static void main(String args[]){

		MyStopwatch sw = new MyStopwatch().start();
		int sum = 0;
		List<Integer> list = new ArrayList<Integer>();

		for(int i=max-1; i>0; i--){
			if(i%3==0 || i%5==0)
				list.add(i);
		}

		for(int i : list)
			sum += i;

		System.out.println("The sum of all the multiples of 3 or 5 below " +
			max + " is " + sum);
		sw.stop().print();
		
	}

}