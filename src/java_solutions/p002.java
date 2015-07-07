package java_solutions;
import java.util.*;

import tools.MyStopwatch;


public class p002{

	public static void main(String args[]){

		MyStopwatch sw = new MyStopwatch().start();
		int sum = 0;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);

		sum = 2;
		int tempFib = 0;
		while(sum <= 4000000){
			tempFib = list.get(list.size()-1) + list.get(list.size()-2);
			list.add(tempFib);
			if(tempFib % 2 == 0)
				sum += tempFib;
		}

		System.out.println("By considering the terms in the Fibonacci sequence whose " +
			"values do not exceed four million, the sum of the even-valued terms is " +
			sum);
		sw.stop().print();

	}

}