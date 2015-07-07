package java;

import tools.MyStopwatch;


public class p004 {

	public static void main(String[] args) {

		MyStopwatch sw = new MyStopwatch().start();
		int bigPali = 0;	// The biggest palindrome
		int ii = 0, jj = 0;
		
		int prod;	// Product
		for(int i = 999; i > 99; i--){
			for(int j = 999; j > 99; j--){
				
				prod = i * j;
				if(prod > bigPali){
					bigPali = (isPalindrome(String.valueOf(prod)) ? prod : bigPali);
					ii = i;
					jj = j;
				}
				
			}
		}
			
		System.out.println("The largest palindrome made from the product of two 3-digit numbers is " + bigPali + 
				" made by " + ii + " x " + jj);
		sw.stop().print();
		
	}

	public static boolean isPalindrome(String str){

		str = str.toUpperCase().replaceAll("[^A-Z^0-9]", "");
		int len = str.length();
		String half1, half2;

		if(len % 2 == 0){	// If the string length is even..
			// If we had an even length string such as "abccba", half1 would be "abc" and half2 would be "cba"

			half1 = str.substring( 0, len/2 );
			half2 = str.substring(len/2);

		}
		else{	// If the string length is odd..
			// If we had an odd length string such as "abcdcba", half1 would be "abc" and half2 would be "cba"

			half1 = str.substring( 0, (len-1)/2 );
			half2 = str.substring( (len+1)/2 );

		}
		
		// Reverse half1
		half1 = new StringBuffer(half1).reverse().toString();

		// If the reversed half1 is equal to half2, then the original string is a palindrome
		if(half1.equals(half2))
			return true;
		else
			return false;

	}

	
}
