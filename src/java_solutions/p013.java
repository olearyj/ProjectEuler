package java_solutions;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

import tools.MyStopwatch;



public class p013 {
	
	public static void main(String[] args){
		
		String[] strArray = new String[100];
		BigInteger sum;
		
		MyStopwatch sw = new MyStopwatch().start();

		populateStringArray(strArray);
		
		sum = sumBigInts(strArray);
		
		System.out.println("The first ten digits of the sum of the " +
				"following one-hundred 50-digit numbers is " + sum);
		
		sw.stop().print();
		
	}
	
	public static BigInteger sumBigInts(String[] strArray){
		BigInteger sum = BigInteger.ZERO;
		
		for(int i=0; i<strArray.length; i++)
			sum = sum.add(new BigInteger(strArray[i]));
		
		return sum;		
	}
	
	public static void populateStringArray(String[] strArray){
		try {
			Scanner sc = new Scanner(new File("p013.txt"));
			for(int i = 0; sc.hasNext(); i++)
				strArray[i] = sc.nextLine();
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
}
