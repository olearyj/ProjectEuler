package java;

import tools.MyStopwatch;

public class p014 {

	public static void main(String[] args){

		int max = 1000000;
		
		MyStopwatch sw = new MyStopwatch().start();

		int maxSeq = 0;

		int count, maxCount = 0;
		long num;
		for(int i=1; i<max; i++){
			count = 1;
			num = i;
			while(num != 1){
				num = collatz(num);
				count++;
			}
			if(count>maxCount){
				maxCount = count;
				maxSeq = i;
			}
			System.out.printf("i = %10d and count = %10d\n", i, count);
		}

		System.out.println("Which starting number, under one million, " +
				"produces the longest chain? " + maxSeq);
		
		sw.stop().print();
	}
	
	public static long collatz(long num){
		return (num % 2 == 0 ? num/2 : 3*num + 1);	
	}
	
}